/**
 * 
 */
package com.airport.ais.report.generater.column;

import java.util.List;
import java.util.Map;

import com.airport.ais.dao.parameter.GroupField;
import com.airport.ais.dao.parameter.PlanCountColumnField;
import com.airport.ais.dao.parameter.ReportField;
import com.airport.ais.report.service.IPlanCountService;




/**
 * 
 * 
 * FileName      PlanCountColumnGenerater.java
 * @Description  TODO 计算字段处理器。
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月8日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月8日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public class PlanCountColumnGenerater<K> implements IColumnGenerater {

	/**
	 *  报表的List
	 */
	private List<Map<String,Object>> reportList;
	
	
	private IPlanCountService<K> planCountService;


	/**
	 * 
	 * @Description: 处理化类，将需要处理的报表，赋值给类
	 * @param reportList报表的List
	 */
	public void setInitVars(List<Map<String, Object>> reportList) {
		this.reportList = reportList;
		
	}

	@Override
	public void writeReportList(ReportField field) throws Exception {
		if (field instanceof PlanCountColumnField) {
			/**
			 * 如果是计划架次字段，赋值各查询的变量
			 */
			PlanCountColumnField planCountColumnField = (PlanCountColumnField) field;
			GroupField  routeField = planCountColumnField.getRowField();
			String rowKey = routeField.getAlias();
			for (Map<String, Object> map:reportList){
				Object kind= map.get(rowKey);
				/**
				 * 将行字段的表达式和值作为查询条件，比如ROUTEHX ='SHA-LZH-SHA'
				 */
				map.put(planCountColumnField.getAlias(), planCountService.count(kind,planCountColumnField));
			}			
		}else{
			throw new Exception("处理出错，计划架次统计字段处理器不能处理其他的列字段");
		}
		
		
		
	}

}
