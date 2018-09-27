package com.airport.ais.service.aodb;

import com.airport.ais.enums.aodb.SectorCode;
import com.airport.ais.models.aodb.basic.FlightRoute;
import com.airport.ais.models.aodb.flight.BasicFlight;
import com.airport.ais.service.IAodbService;

/**
 * 
 * 
 * FileName      IBasicFlightService.java
 * @Description  TODO  ���������Service�ӿ� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��7��4��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��7��4��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public interface IBasicFlightService<E extends BasicFlight> extends IAodbService<Integer, E> {
	
	/**
	 * �Ӻ���ĺ���ȷ�Ϻ������������
	 * @param flight
	 * @return 
	 */
	
	SectorCode confirmSectorByRoute(E flight);	

	/**
	 * ���ݺ�����º��߿�
	 * @param flight
	 */
	FlightRoute updateFlightRoute(E flight);
}
