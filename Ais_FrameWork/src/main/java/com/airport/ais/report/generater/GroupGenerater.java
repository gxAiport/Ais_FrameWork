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
 * @Description  TODO 以GroupField对aggregationResult进行处理
 * 每一个Map<Strin,Object>应有一条记录，String为GroupFiled的Alias,Object为result的数据。
 * @author       ZhangYu    Company:    LZAirport
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月8日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月8日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Component
public class GroupGenerater  {
	
	
	/**
	 *   聚合查询回来的结果List
	 */
	private  List<Map<String, Object>> aggregationResult;
	
	
	/**
	 * Group字段的列表
	 */
	private List<GroupField> fields;


	/**
	 *  存有所有Group可能值的Map
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
	 * @Description: 根据aggregationResult与GroupField列表，查找每个对应的GroupField所有有可能的数据集合
	 * 例如：
	 * 02-01   1500    Dep      True
	 * 02-01   1500    Dep      FALSE
	 * 02-01   1500    ARR      True
	 * 02-01   1500    ARR      FALSE
	 * 02-02   1500    Dep      True
	 * 02-02   1500    Dep      FALSE
	 * 02-02   1500    ARR      True
	 * 02-02   1500    ARR      FALSE
	 * 处理结果
	 * [ 日期{02-01}、 进出(Dep,Arr}、 正常(True,False}]
	 * @return对应的GroupField所有有可能的数据集合
	 */
	public Map<String,List<Object>> getAvailableGroupValues(){
		Map<String,List<Object>> result = new HashMap<String, List<Object>>();
		
		for(GroupField field:fields){
			/**
			 * 建立Group列表对应的fList，用来存放查询的Group所有可能的数据集合
			 */
			List<Object> fList = new ArrayList<Object>(); 
			for (Map<String, Object>aggregationMap:aggregationResult){
				/**
				 * 循环查询结果，将fields的Ailas为Key不重复的放入fList中
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
			 * String是GroupFiled的Ailas属性值，List<Object>是所有有可能的数据集合
			 */
			result.put(field.getAlias(), fList);
		}
		groupMap = result;
		return result;
	}
	
	
	/**
	 * 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
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
	 * @Description: 根据getGroupMap对应的结果，返回初步Report
	 * @return  只含有行数据的报表List
	 *  * 日期     航空公司   吞吐量      进出港      正常标志
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
	 * 处理结果
	 * 日期
	 * 02-01    CA
	 * 02-02    CA
	 * 02-01    MU
	 * 02-02    MU
	 */
	public List<Map<String,Object>> getReportList(){
		
		/**
		 * 将行所对应的有可能的数据全部写入报表List中,生成报表
		 */
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		composeGroup(result,null,0);
	
		return result;
	}
	

}
