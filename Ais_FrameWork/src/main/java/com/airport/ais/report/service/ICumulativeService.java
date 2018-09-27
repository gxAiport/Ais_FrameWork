package com.airport.ais.report.service;

import java.util.Date;

import com.airport.ais.dao.parameter.CumulativeColumnField;

/**
 * 
 * 
 * FileName      ICumulativeService.java
 * @Description  TODO  �ۼƵ�Serviced�Ľӿ�
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��8��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��8��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public interface ICumulativeService<K> {

	/**
	 * 
	 * @Description: �ۼƵ�ָ�����ڵ����ÿ�������
	 * @param date ָ������
	 * @return ���ÿ�������
	 * @throws Exception
	 */
	public K cumulativeMonth(Date date,CumulativeColumnField field) throws Exception;
	
	/**
	 * 
	 * @Description: �ۼƵ�ָ�����ڵ����ÿ�������
	 * @param date ָ������
	 * @return ���ÿ�������
	 * @throws Exception
	 */
	public K cumulativeYear(Date date,CumulativeColumnField field) throws Exception ;
	
}
