package com.airport.ais.service.aodb;

import javax.ejb.Remote;

import com.airport.ais.models.aodb.flight.DynamicFlight;

/**
 * 
 * 
 * FileName      DynamicFlightService.java
 * @Description  TODO ���ද̬��Service�ӿ� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��7��4��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��7��4��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Remote
public interface IDynamicFlightService extends IFlightService<DynamicFlight> {
	
	
}
