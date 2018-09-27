
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
 * @Description  TODO 聚合字段的处理器，用于处理返回的聚合字段。
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月8日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月8日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Component
public class AggregationColumnGenerater implements IColumnGenerater  {
	
    /**
	 *   聚合查询回来的结果List
	 */
	private  List<Map<String, Object>> aggregationResult;
	
	/**
	 *  存有所有Group可能值的Map
	 */
	private  Map<String,List<Object>> groupMap;
	
	/**
	 * 报表List
	 */
	private List<Map<String,Object>> reportList;
	
	/**
	 * Group字段的列表
	 */
	private List<GroupField> groupFields;
	
	
	/**
	 *  代表行字段的Aials
	 */
	private String rowKey;


	/**
	 * 
	 * @Description: 初始化类，将聚合查询回来的结果List，Group字段的列表、报表List赋值给处理器
	 * @param aggregationResult 聚合查询回来的结果List
	 * @param groupMap 存有所有Group可能值得Map
	 * @param reportList 报表List
	 * @param groupFields Group字段的列表
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
	 * @Description: 比较Key的值，比较方法：ailas_Key与Key前部分相同，后面只多一个分隔符.
	 * 如果PAX与PAX.DEP相比，结果为True，其他为假
	 * @param ailas_Key  需要处理的Key比如：PAX
	 * @param key Map中含有的Key 比如：PaX.DEP
	 * @return 真或者假
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
	 * @Description: 合成数据，规则：将Key与ailas_Key前部分相同，后面只多一个分隔符的数据合成
	 * 比如： PAX.DEP 1500 PAX.ARR 2000 PAX 则合成3500 
	 * @param map 报表List的行Map
	 * @param ailas_Key 需要处理的Key比如：PAX
	 */
	private void composeValue(Map<String, Object> map,String ailas_Key){
		Double value=0.0;
		for(String key:map.keySet()){
			if (compareKey(ailas_Key, key)){
				/**
				 * 循环整个Map行,如果符合Key的规则，进行合成
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
	 * @Description: 用笛卡尔乘积进行数据的合成
	 * @param map  报表List的行
	 * @param layer  层数
	 * @param startLayer  开始层数
	 * @param ailas_Key 合成的Key 比如PAX
	 */
	private void descartesCompose(Map<String, Object> map,int layer,int startLayer ,String ailas_Key){
		if (layer < groupMap.size()-startLayer){
			/**
			 * 如果大于1层,取得对应的Group列的所有有可能的数据，递归调用合成
			 */
			List<Object> keyList = groupMap.get(groupFields.get(layer).getAlias());
			for(Object obj:keyList){
				descartesCompose(map, layer+1, startLayer,ailas_Key+"."+obj);
			}
		}else if (layer == groupMap.size()-startLayer){
			/**
			 * 如果是最后一层，取得对应的Group列的所有有可能的数据，进行数据合成
			 */
			List<Object> keyList = groupMap.get(groupFields.get(layer).getAlias());
			for(Object obj:keyList){
				composeValue(map, ailas_Key+"."+obj);
			}
		}else if (startLayer == groupMap.size()){
			/**
			 * 如果开始层数是最后一层，直接进行合成
			 */
			composeValue(map, ailas_Key);
		}
	}
	
	
	
	@Override
	public void writeReportList(ReportField field){
		
		for(Map<String, Object> reportMap:reportList){
			//取得行的数据
			Object rowKeyValue = reportMap.get(rowKey);
			for (Map<String, Object> aggregationMap:aggregationResult){
				/**
				 * 查找聚合数据结果，如果等于当前的行数据将当前的数据放入，规则如下
				 * 日期        吞吐量      进出港      正常标志
				 * 02-01   1500    Dep      True
				 * 02-01   1500    Dep      FALSE
				 * 02-01   1500    ARR      True
				 * 02-01   1500    ARR      FALSE
				 * 放入的结果为
				 * 日期    吞吐量.DEP.TRUE 吞吐量.ARR.TRUE 吞吐量.DEP.FALSE 吞吐量.ARR.FALSE
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
			 * 进行笛卡尔的数据合成,规则如下：
			 * 原数据
			 * 日期    吞吐量.DEP.TRUE 吞吐量.ARR.TRUE 吞吐量.DEP.FALSE 吞吐量.ARR.FALSE
			 * 02-01  1500        1500               1500             1500        
			 * 合成后的数据 
			 * 日期     吞吐量   吞吐量.DEP 吞吐量.ARR 吞吐量.DEP.TRUE 吞吐量.ARR.TRUE 吞吐量.DEP.FALSE 吞吐量.ARR.FALSE
			 * 02-01  6000  3000        3000          1500        1500               1500             1500        
			 * 从2开始，需要将行去除
			 * 
			 * 
			 */
			
			for (int i=2;i<=groupMap.size();i++){
				descartesCompose(reportMap,1,i,field.getAlias());
			}
			
		}
		
		
		
	}
	

}
