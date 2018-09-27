/**
 * 
 */
package com.airport.ais.report.service;

import java.util.Date;
import java.util.List;

import com.airport.ais.dao.parameter.QueryCondition;
import com.airport.ais.dao.parameter.ReportField;


/**
 * 
 * 
 * FileName      IAggregationService.java
 * @Description  TODO 聚合表达式解析器的接口
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月8日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月8日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */



public interface IAggregationService {

	/**
	 * @Description: 解析ReportField,生成对应的查询条件
	 * @param fields       报表字段
	 * @param startDate    开始时间
	 * @param endDate      结束时间
	 * @param diffYear     年月差
	 * @return             汇总需要的QuerCondistion的条件
	 */
	public QueryCondition interpreter(List<ReportField> fields, Date startDate, Date endDate, 
			int diffYear,Object[] expresstion,String order);

	

}