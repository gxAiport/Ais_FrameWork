package com.airport.ais.service.aodb;

import javax.ejb.Remote;

import com.airport.ais.models.aodb.flight.Flight;
import com.airport.ais.models.aodb.flight.SeasonFlight;

/**
 * 
 * 
 * FileName      ISeasonFlightService.java
 * @Description  TODO 季度航班的Service接口
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年8月16日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年8月16日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Remote
public interface ISeasonFlightService extends IBasicFlightService<SeasonFlight> {
	
	/**
	 * 根据动态航班创建季度航班数据
	 * @param dynamicFlight
	 * @throws Exception 
	 */
	void createSeasonByDynamic(Flight flight) throws Exception;
	
	
}
