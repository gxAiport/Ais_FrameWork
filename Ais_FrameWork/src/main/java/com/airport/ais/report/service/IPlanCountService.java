package com.airport.ais.report.service;

import com.airport.ais.dao.parameter.PlanCountColumnField;

/**
 * 
 * 
 * FileName      planCountService.java
 * @Description  TODO 计划统计的Serviced的接口
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月8日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月8日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public interface IPlanCountService<K> {

	/**
	 * 统计计划数据的方法
	 * @param startDate
	 * @param endDate
	 * @param field
	 * @return
	 * @throws Exception
	 */
	
	public K count(Object kind,PlanCountColumnField field) throws Exception;
}
