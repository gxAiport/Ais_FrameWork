/**
 * 
 */
package com.airport.ais.report.generater.column;

import com.airport.ais.dao.parameter.ReportField;

/**
 * FileName      IColumnGenerater.java
 * @Description  列字段的处理的接口
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2016年2月23日 
 * @ModificationHistory
 * Date         Author     Version   Discription
 * <p>---------------------------------------------
 * <p>2016年2月23日      Yu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
public interface IColumnGenerater {
	
	
	
	/**
	 * @Description: 根据对应的字段规则，对报表ReportList进行赋值
	 * @param field 对应的字段
	 * @throws Exception 
	 */
	public void writeReportList(ReportField field) throws Exception;

}