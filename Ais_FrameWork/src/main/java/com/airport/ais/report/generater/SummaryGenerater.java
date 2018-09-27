/**
 * 
 */
package com.airport.ais.report.generater;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.airport.ais.dao.parameter.SummaryField;
import com.airport.ais.enums.SummaryType;



/**
 * 
 * 
 * FileName      SummaryGenerater.java
 * @Description  TODO 字段的汇总处理器 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月8日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月8日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Component
public class SummaryGenerater {
	
	
	
	private Double calcExpression(Map<String,Double> calcMap,SummaryField field){
		
		return calcMap.get(field.getExpression()[0])/calcMap.get(field.getExpression()[1])*100;
		
	}
	
	
	
	/**
	 * 
	 * @Description: 计算reportList中fields标明字段的小结
	 * @param reportList  报表数据
	 * @param fields 需要计算的字段
	 * @return 返回各字段的小结
	 */
	public Map<String,Object> calcSummary(List<Map<String,Object>> reportList,SummaryField[] fields){

		Map<String,Object> result = new HashMap<String, Object>();
		Map<String,Double> calcMap = new HashMap<String, Double>();
		
		if (fields == null){
			/**
			 * 如果字段为空，返回空数据
			 */
			return result;
		}
		/**
		 *   初始化各小结字段 
		 */
		for(SummaryField field:fields){
			if (!SummaryType.None.equals(field.getSummaryType())){
				calcMap.put(field.getDataIndex(), 0.0);
			}
		}
		
		
		/**
		 * 累加各字段数据
		 */
		for(Map<String,Object> map:reportList){
			for(SummaryField field:fields){
				if (!SummaryType.None.equals(field.getSummaryType())){
					if (map.get(field.getDataIndex()) != null){
						Double calcNum= calcMap.get(field.getDataIndex()) +
								Double.parseDouble(map.get(field.getDataIndex()).toString());
						calcMap.put(field.getDataIndex(), calcNum);
					}
				}
			}
		}
		
		
		/**
		 * 根据各字段小结类型导入进最后的Map中
		 */
		for(SummaryField field:fields){
			Double calcNum = null;
			if (SummaryType.Avg.equals(field.getSummaryType())){
				calcNum = calcMap.get(field.getDataIndex()) / reportList.size();
			}else if (SummaryType.Sum.equals(field.getSummaryType())){
				calcNum = calcMap.get(field.getDataIndex());
			}else if (SummaryType.Calc.equals(field.getSummaryType())){
				calcNum = calcExpression(calcMap,field);
			}
			result.put(field.getDataIndex(), new DecimalFormat("#.00").format(calcNum));
		}
		
		return  result;
	}

}
