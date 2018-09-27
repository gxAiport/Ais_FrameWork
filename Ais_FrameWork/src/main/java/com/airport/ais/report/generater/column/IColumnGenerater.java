/**
 * 
 */
package com.airport.ais.report.generater.column;

import com.airport.ais.dao.parameter.ReportField;

/**
 * FileName      IColumnGenerater.java
 * @Description  ���ֶεĴ���Ľӿ�
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2016��2��23�� 
 * @ModificationHistory
 * Date         Author     Version   Discription
 * <p>---------------------------------------------
 * <p>2016��2��23��      Yu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
public interface IColumnGenerater {
	
	
	
	/**
	 * @Description: ���ݶ�Ӧ���ֶι��򣬶Ա���ReportList���и�ֵ
	 * @param field ��Ӧ���ֶ�
	 * @throws Exception 
	 */
	public void writeReportList(ReportField field) throws Exception;

}