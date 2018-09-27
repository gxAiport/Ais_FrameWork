package com.airport.ais.service.aodb;

import com.airport.ais.enums.aodb.SectorCode;
import com.airport.ais.models.aodb.basic.FlightRoute;
import com.airport.ais.models.aodb.flight.BasicFlight;
import com.airport.ais.service.IAodbService;

/**
 * 
 * 
 * FileName      IBasicFlightService.java
 * @Description  TODO  基础航班的Service接口 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年7月4日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年7月4日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public interface IBasicFlightService<E extends BasicFlight> extends IAodbService<Integer, E> {
	
	/**
	 * 从航班的航线确认航班的领域类型
	 * @param flight
	 * @return 
	 */
	
	SectorCode confirmSectorByRoute(E flight);	

	/**
	 * 根据航班更新航线库
	 * @param flight
	 */
	FlightRoute updateFlightRoute(E flight);
}
