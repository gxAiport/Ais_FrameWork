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
 * @Description  TODO ͼ��Service�Ľӿ�
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��8��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��8��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
public interface IChartService {

	/**
	 * 
	 * @Description: ����ǰ�˴��������������������ת����ϵͳ���Դ����Condistions������
	 * @param limitCondistions ǰ�δ�����������������
	 * @return ϵͳ���Դ����Object������
	 */
	public Object[] convert(List<LimitCondistion> limitCondistions);

}