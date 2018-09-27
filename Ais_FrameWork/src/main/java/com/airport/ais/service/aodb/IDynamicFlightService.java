package com.airport.ais.service.aodb;

import javax.ejb.Remote;

import com.airport.ais.models.aodb.flight.DynamicFlight;

/**
 * 
 * 
 * FileName      DynamicFlightService.java
 * @Description  TODO 航班动态的Service接口 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年7月4日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年7月4日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Remote
public interface IDynamicFlightService extends IFlightService<DynamicFlight> {
	
	
}
