package com.airport.ais.report.service;

import java.util.Date;

import com.airport.ais.dao.parameter.CumulativeColumnField;

/**
 * 
 * 
 * FileName      ICumulativeService.java
 * @Description  TODO  累计的Serviced的接口
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月8日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月8日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public interface ICumulativeService<K> {

	/**
	 * 
	 * @Description: 累计到指定日期的月旅客吞吐量
	 * @param date 指定日期
	 * @return 月旅客吞吐量
	 * @throws Exception
	 */
	public K cumulativeMonth(Date date,CumulativeColumnField field) throws Exception;
	
	/**
	 * 
	 * @Description: 累计到指定日期的年旅客吞吐量
	 * @param date 指定日期
	 * @return 月旅客吞吐量
	 * @throws Exception
	 */
	public K cumulativeYear(Date date,CumulativeColumnField field) throws Exception ;
	
}
