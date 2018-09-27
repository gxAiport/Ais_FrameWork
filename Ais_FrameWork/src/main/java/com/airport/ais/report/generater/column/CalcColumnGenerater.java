/**
 * 
 */
package com.airport.ais.report.generater.column;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.airport.ais.dao.parameter.CalcColumnField;
import com.airport.ais.dao.parameter.GroupField;
import com.airport.ais.dao.parameter.ReportField;
import com.airport.ais.report.parameter.CalcExpression;



/**
 * FileName      CalcColumnGenerater.java
 * @Description  TODO  计算列字段的处理器
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月8日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月8日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Component
public class CalcColumnGenerater implements IColumnGenerater {
	
	/**
	 * 存有所有Group可能值的Map
	 */
	private  Map<String,List<Object>> groupMap;
	
	/**
	 *  报表List
	 */
	private List<Map<String,Object>> reportList;
	
	/**
	 * Group字段的列表
	 */
	private List<GroupField> groupFields;
	
	/**
	 *  计算字段
	 */
	private CalcColumnField calcField;
	
	/**
	 * 计算表达式的类
	 */
	@Resource
	private CalcExpression calcExpression;
	
	public void setInitVars(Map<String, List<Object>> groupMap,List<Map<String, Object>> reportList, List<GroupField> groupFields) {
		this.groupMap = groupMap;
		this.reportList = reportList;
		this.groupFields = groupFields;
	}
	
	/**	
	 * @Description: 根据Map的数据计算值
	 * @param map 报表列表的行
	 * @param key 需要计算的Key 比如 Pax
	 * @param suffix 后缀 比如.Dep.True
	 * @throws Exception 
	 */
	private void calcValue(Map<String, Object> map, String key, String suffix) throws Exception {
			Number value = calcExpression.calcExpression(calcField.getExpression(), suffix, map);
			/**
			 * 将数据放入Map中
			 */
			map.put(key+suffix, value);
	}
	
	
	/**
	 * 
	 * @Description: 用笛卡尔乘积进行数据进行计算
	 * @param map  报表List的行
	 * @param layer 层数
	 * @param startlayer 开始层数
	 * @param key 合成的Key 比如PAX
	 * @param suffix 后缀 比如.Dep.True
	 * @throws Exception
	 */
	private void descartesCalc(Map<String, Object> map,int layer,int startlayer ,String key,String suffix) throws Exception{
		if (layer < groupMap.size()-startlayer){
			/**
			 * 如果大于1层,取得对应的Group列的所有有可能的数据，递归计算
			 */
			List<Object> keyList = groupMap.get(groupFields.get(layer).getAlias());
			for(Object obj:keyList){
				if (obj != null){
					descartesCalc(map, layer+1, startlayer,key,suffix+"."+obj);
				}
			}
		}else if (layer == groupMap.size()-startlayer){
			/**
			 * 如果是最后一层，取得对应的Group列的所有有可能的数据，进行数据计算
			 */
			List<Object> keyList = groupMap.get(groupFields.get(layer).getAlias());
			for(Object obj:keyList){
				if (obj != null){
					calcValue(map, key,suffix+"."+obj);
				}
			}
		}else if (startlayer == groupMap.size()){
			/**
			 * 如果开始层数是最后一层，直接进行计算
			 */
			calcValue(map, key,suffix);
		}
	}

	
	/**
	 *  计算规则：
	 * 日期       客座率  架次 客座率.DEP 架次.DEP 客座率.ARR 架次.ARR  
	 * 02-01  500    10    250       5       250       5
	 * 计算后 
	 * 日期       客座率  架次 客座率.DEP 架次.DEP 客座率.ARR 架次.ARR 平均客座率 平均客座率.DEP 平均客座率.ARR   
	 * 02-01  500    10    250       5       250       5         0.5         0.5            0.5
	 */
	@Override
	public void writeReportList(ReportField field) throws Exception {
		this.calcField = (CalcColumnField)field;
		for (Map<String,Object>map:reportList){
			for (int i=1;i<=groupMap.size();i++){
				descartesCalc(map,1,i,field.getAlias(),"");
			}
		}
		

	}

}
