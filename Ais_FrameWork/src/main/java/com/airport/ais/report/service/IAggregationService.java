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
 * @Description  TODO �ۺϱ��ʽ�������Ľӿ�
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��8��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��8��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */



public interface IAggregationService {

	/**
	 * @Description: ����ReportField,���ɶ�Ӧ�Ĳ�ѯ����
	 * @param fields       �����ֶ�
	 * @param startDate    ��ʼʱ��
	 * @param endDate      ����ʱ��
	 * @param diffYear     ���²�
	 * @return             ������Ҫ��QuerCondistion������
	 */
	public QueryCondition interpreter(List<ReportField> fields, Date startDate, Date endDate, 
			int diffYear,Object[] expresstion,String order);

	

}