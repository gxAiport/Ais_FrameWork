/**
 * 
 */
package com.airport.ais.report.service;

import java.util.List;

import com.airport.ais.report.parameter.LimitCondistion;



/**
 * 
 * 
 * FileName      IChartService.java
 * @Description  TODO 图表Service的接口
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月8日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月8日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
public interface IChartService {

	/**
	 * 
	 * @Description: 根据前端传来的条件限制数组进行转换成系统可以处理的Condistions的数组
	 * @param limitCondistions 前段传来的条件限制数组
	 * @return 系统可以处理的Object的数组
	 */
	public Object[] convert(List<LimitCondistion> limitCondistions);

}