
package com.airport.ais.report.generater.column;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.airport.ais.dao.parameter.GroupField;
import com.airport.ais.dao.parameter.ReportField;



/**
 * 
 * 
 * FileName      AggregationColumnGenerater.java
 * @Description  TODO �ۺ��ֶεĴ����������ڴ����صľۺ��ֶΡ�
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��8��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��8��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Component
public class AggregationColumnGenerater implements IColumnGenerater  {
	
    /**
	 *   �ۺϲ�ѯ�����Ľ��List
	 */
	private  List<Map<String, Object>> aggregationResult;
	
	/**
	 *  ��������Group����ֵ��Map
	 */
	private  Map<String,List<Object>> groupMap;
	
	/**
	 * ����List
	 */
	private List<Map<String,Object>> reportList;
	
	/**
	 * Group�ֶε��б�
	 */
	private List<GroupField> groupFields;
	
	
	/**
	 *  �������ֶε�Aials
	 */
	private String rowKey;


	/**
	 * 
	 * @Description: ��ʼ���࣬���ۺϲ�ѯ�����Ľ��List��Group�ֶε��б�����List��ֵ��������
	 * @param aggregationResult �ۺϲ�ѯ�����Ľ��List
	 * @param groupMap ��������Group����ֵ��Map
	 * @param reportList ����List
	 * @param groupFields Group�ֶε��б�
	 */
	public void setInitVars(List<Map<String, Object>> aggregationResult, Map<String, List<Object>> groupMap,
			List<Map<String, Object>> reportList,List<GroupField> groupFields) {
		this.aggregationResult = aggregationResult;
		this.groupMap = groupMap;
		this.groupFields = groupFields;
		this.reportList = reportList;
		this.rowKey  = groupFields.get(0).getAlias();
	}
	
	
	
	/**
	 * 
	 * @Description: �Ƚ�Key��ֵ���ȽϷ�����ailas_Key��Keyǰ������ͬ������ֻ��һ���ָ���.
	 * ���PAX��PAX.DEP��ȣ����ΪTrue������Ϊ��
	 * @param ailas_Key  ��Ҫ�����Key���磺PAX
	 * @param key Map�к��е�Key ���磺PaX.DEP
	 * @return ����߼�
	 */
	private boolean compareKey(String ailas_Key,String key){
		if (key.split("\\.").length == ailas_Key.split("\\.").length+1 
			&&key.indexOf(ailas_Key,0) != -1){
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * 
	 * @Description: �ϳ����ݣ����򣺽�Key��ailas_Keyǰ������ͬ������ֻ��һ���ָ��������ݺϳ�
	 * ���磺 PAX.DEP 1500 PAX.ARR 2000 PAX ��ϳ�3500 
	 * @param map ����List����Map
	 * @param ailas_Key ��Ҫ�����Key���磺PAX
	 */
	private void composeValue(Map<String, Object> map,String ailas_Key){
		Double value=0.0;
		for(String key:map.keySet()){
			if (compareKey(ailas_Key, key)){
				/**
				 * ѭ������Map��,�������Key�Ĺ��򣬽��кϳ�
				 */
				if (map.get(key) instanceof Number){
					value += ((Number) map.get(key)).doubleValue();
				}
				
			}
		}
		map.put(ailas_Key, Double.parseDouble(new DecimalFormat("#.00").format(value)));
	}
	
	/**
	 * 
	 * @Description: �õѿ����˻��������ݵĺϳ�
	 * @param map  ����List����
	 * @param layer  ����
	 * @param startLayer  ��ʼ����
	 * @param ailas_Key �ϳɵ�Key ����PAX
	 */
	private void descartesCompose(Map<String, Object> map,int layer,int startLayer ,String ailas_Key){
		if (layer < groupMap.size()-startLayer){
			/**
			 * �������1��,ȡ�ö�Ӧ��Group�е������п��ܵ����ݣ��ݹ���úϳ�
			 */
			List<Object> keyList = groupMap.get(groupFields.get(layer).getAlias());
			for(Object obj:keyList){
				descartesCompose(map, layer+1, startLayer,ailas_Key+"."+obj);
			}
		}else if (layer == groupMap.size()-startLayer){
			/**
			 * ��������һ�㣬ȡ�ö�Ӧ��Group�е������п��ܵ����ݣ��������ݺϳ�
			 */
			List<Object> keyList = groupMap.get(groupFields.get(layer).getAlias());
			for(Object obj:keyList){
				composeValue(map, ailas_Key+"."+obj);
			}
		}else if (startLayer == groupMap.size()){
			/**
			 * �����ʼ���������һ�㣬ֱ�ӽ��кϳ�
			 */
			composeValue(map, ailas_Key);
		}
	}
	
	
	
	@Override
	public void writeReportList(ReportField field){
		
		for(Map<String, Object> reportMap:reportList){
			//ȡ���е�����
			Object rowKeyValue = reportMap.get(rowKey);
			for (Map<String, Object> aggregationMap:aggregationResult){
				/**
				 * ���Ҿۺ����ݽ����������ڵ�ǰ�������ݽ���ǰ�����ݷ��룬��������
				 * ����        ������      ������      ������־
				 * 02-01   1500    Dep      True
				 * 02-01   1500    Dep      FALSE
				 * 02-01   1500    ARR      True
				 * 02-01   1500    ARR      FALSE
				 * ����Ľ��Ϊ
				 * ����    ������.DEP.TRUE ������.ARR.TRUE ������.DEP.FALSE ������.ARR.FALSE
				 * 02-01  1500        1500               1500             1500        
				 */
				if (aggregationMap.get(rowKey)!=null&&aggregationMap.get(rowKey).equals(rowKeyValue)){
					
					String ailas_Key = field.getAlias();
					for(GroupField groupField:groupFields){
						String key = groupField.getAlias();
						if (aggregationMap.get(key)==null){
							break;
						}
						if (!key.equals(rowKey)){
							ailas_Key +="."+aggregationMap.get(key);
						}
					}
					reportMap.put(ailas_Key, aggregationMap.get(field.getAlias()));
				}
			}
			/**
			 * ���еѿ��������ݺϳ�,�������£�
			 * ԭ����
			 * ����    ������.DEP.TRUE ������.ARR.TRUE ������.DEP.FALSE ������.ARR.FALSE
			 * 02-01  1500        1500               1500             1500        
			 * �ϳɺ������ 
			 * ����     ������   ������.DEP ������.ARR ������.DEP.TRUE ������.ARR.TRUE ������.DEP.FALSE ������.ARR.FALSE
			 * 02-01  6000  3000        3000          1500        1500               1500             1500        
			 * ��2��ʼ����Ҫ����ȥ��
			 * 
			 * 
			 */
			
			for (int i=2;i<=groupMap.size();i++){
				descartesCompose(reportMap,1,i,field.getAlias());
			}
			
		}
		
		
		
	}
	

}
