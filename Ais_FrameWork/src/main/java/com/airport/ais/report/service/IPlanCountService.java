package com.airport.ais.report.service;

import com.airport.ais.dao.parameter.PlanCountColumnField;

/**
 * 
 * 
 * FileName      planCountService.java
 * @Description  TODO �ƻ�ͳ�Ƶ�Serviced�Ľӿ�
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��8��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��8��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public interface IPlanCountService<K> {

	/**
	 * ͳ�Ƽƻ����ݵķ���
	 * @param startDate
	 * @param endDate
	 * @param field
	 * @return
	 * @throws Exception
	 */
	
	public K count(Object kind,PlanCountColumnField field) throws Exception;
}
