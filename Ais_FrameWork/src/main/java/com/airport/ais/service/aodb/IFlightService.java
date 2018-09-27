package com.airport.ais.service.aodb;

import java.util.Date;

import com.airport.ais.enums.aodb.FlightDirection;
import com.airport.ais.models.aodb.flight.Flight;


/**
 * 
 * 
 * FileName      FlightService.java
 * @Description  TODO ��Ӫ����Ļ���Service 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��7��4��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��7��4��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public interface IFlightService<E extends Flight> extends IBasicFlightService<E> {
	
	/**
	 * ���ݺ���ı�ʶ��λ����
	 * @param identification  ����ı�ʶ
	 * @param oneToMany       һ�Զ��ʶ
	 * @param manyToOne       ���һ��ʶ
	 * @return
	 */
	public  E findByFlightIdentification(String flightNumber,FlightDirection direction,Date date,int repeatCount,String carrierICAOCode,
			String oneToMany,String manyToOne,Class<E> clazz);
	
	

	/**
	 * ��ȫ����ĺ���
	 * @param flight
	 * @throws Exception 
	 */
	E completionRoute(E flight) throws Exception;	

}
