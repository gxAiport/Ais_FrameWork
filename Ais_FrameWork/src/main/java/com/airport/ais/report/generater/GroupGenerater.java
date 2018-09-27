/**
 * 
 */
package com.airport.ais.report.generater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.airport.ais.dao.parameter.GroupField;

/**
 * 
 * 
 * FileName      GroupGenerater.java
 * @Description  TODO ��GroupField��aggregationResult���д���
 * ÿһ��Map<Strin,Object>Ӧ��һ����¼��StringΪGroupFiled��Alias,ObjectΪresult�����ݡ�
 * @author       ZhangYu    Company:    LZAirport
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��8��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��8��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Component
public class GroupGenerater  {
	
	
	/**
	 *   �ۺϲ�ѯ�����Ľ��List
	 */
	private  List<Map<String, Object>> aggregationResult;
	
	
	/**
	 * Group�ֶε��б�
	 */
	private List<GroupField> fields;


	/**
	 *  ��������Group����ֵ��Map
	 */
	private Map<String, List<Object>> groupMap;
	
	private int colNum;
	
	
	public void setInitVars(List<Map<String, Object>> aggregationResult, List<GroupField> fields,int colNum) {
		this.aggregationResult = aggregationResult;
		this.fields = fields;
		this.colNum = colNum;
	}

	
	/**
	 * 
	 * @Description: ����aggregationResult��GroupField�б�����ÿ����Ӧ��GroupField�����п��ܵ����ݼ���
	 * ���磺
	 * 02-01   1500    Dep      True
	 * 02-01   1500    Dep      FALSE
	 * 02-01   1500    ARR      True
	 * 02-01   1500    ARR      FALSE
	 * 02-02   1500    Dep      True
	 * 02-02   1500    Dep      FALSE
	 * 02-02   1500    ARR      True
	 * 02-02   1500    ARR      FALSE
	 * ������
	 * [ ����{02-01}�� ����(Dep,Arr}�� ����(True,False}]
	 * @return��Ӧ��GroupField�����п��ܵ����ݼ���
	 */
	public Map<String,List<Object>> getAvailableGroupValues(){
		Map<String,List<Object>> result = new HashMap<String, List<Object>>();
		
		for(GroupField field:fields){
			/**
			 * ����Group�б��Ӧ��fList��������Ų�ѯ��Group���п��ܵ����ݼ���
			 */
			List<Object> fList = new ArrayList<Object>(); 
			for (Map<String, Object>aggregationMap:aggregationResult){
				/**
				 * ѭ����ѯ�������fields��AilasΪKey���ظ��ķ���fList��
				 */
				boolean found = false;
				for (Object obj:fList){
					if (obj != null&&aggregationMap.get(field.getAlias())!=null
							&& obj.equals(aggregationMap.get(field.getAlias()))){
						found = true;
						break;
					}
				}
				if (!found){
					fList.add(aggregationMap.get(field.getAlias()));
				}
				
			}
			/**
			 * String��GroupFiled��Ailas����ֵ��List<Object>�������п��ܵ����ݼ���
			 */
			result.put(field.getAlias(), fList);
		}
		groupMap = result;
		return result;
	}
	
	
	/**
	 * 
	 * @Description: TODO(������һ�仰�����������������)
	 * @param result
	 * @param map
	 * @param row_objs
	 * @param key
	 * @param layer
	 */
	private void composeGroup(List<Map<String,Object>> result,Map<String,Object> map,int layer){
		
		String key = fields.get(layer).getAlias();
		List<Object> objs = groupMap.get(key);
		
		if (objs != null){
			if (layer ==  colNum){
				for(Object obj:objs){
					if (obj!=null){
						Map<String,Object> layer_map = new HashMap<String, Object>();
						if (map != null){
							layer_map.putAll(map);
						}
						layer_map.put(key, obj);
						result.add(layer_map);					
					}
				}
			} else {
				
				for(Object obj:objs){
					Map<String,Object> layer_map = new HashMap<String, Object>();
					if (map != null){
						layer_map.putAll(map);
					}
					if (obj!=null){
						layer_map.put(key, obj);
						composeGroup(result, layer_map,layer+1);					
					}
				}
				
			}
		}
		
		
	}
	
	
	
	/**
	 * 
	 * @Description: ����getGroupMap��Ӧ�Ľ�������س���Report
	 * @return  ֻ���������ݵı���List
	 *  * ����     ���չ�˾   ������      ������      ������־
	 * 02-01      CA        1500    Dep      True
	 * 02-01      CA        1500    Dep      FALSE
	 * 02-01      CA        1500    ARR      True
	 * 02-01      CA        1500    ARR      FALSE
	 * 02-02      CA        1500    Dep      True
	 * 02-02      CA        1500    Dep      FALSE
	 * 02-02      CA        1500    ARR      True
	 * 02-02      CA        1500    ARR      FALSE
	 * 02-01      MU        1500    Dep      True
	 * 02-01      MU        1500    Dep      FALSE
	 * 02-01      MU        1500    ARR      True
	 * 02-01      MU        1500    ARR      FALSE
	 * 02-02      MU        1500    Dep      True
	 * 02-02      MU        1500    Dep      FALSE
	 * 02-02      MU        1500    ARR      True
	 * 02-02      MU        1500    ARR      FALSE
	 * ������
	 * ����
	 * 02-01    CA
	 * 02-02    CA
	 * 02-01    MU
	 * 02-02    MU
	 */
	public List<Map<String,Object>> getReportList(){
		
		/**
		 * ��������Ӧ���п��ܵ�����ȫ��д�뱨��List��,���ɱ���
		 */
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		composeGroup(result,null,0);
	
		return result;
	}
	

}
