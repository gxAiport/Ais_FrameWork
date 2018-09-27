package com.airport.ais.service.aodb;

import java.util.Date;

import com.airport.ais.enums.aodb.FlightDirection;
import com.airport.ais.models.aodb.flight.Flight;


/**
 * 
 * 
 * FileName      FlightService.java
 * @Description  TODO 运营航班的基础Service 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年7月4日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年7月4日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public interface IFlightService<E extends Flight> extends IBasicFlightService<E> {
	
	/**
	 * 根据航班的标识定位航班
	 * @param identification  航班的标识
	 * @param oneToMany       一对多标识
	 * @param manyToOne       多对一标识
	 * @return
	 */
	public  E findByFlightIdentification(String flightNumber,FlightDirection direction,Date date,int repeatCount,String carrierICAOCode,
			String oneToMany,String manyToOne,Class<E> clazz);
	
	

	/**
	 * 补全航班的航线
	 * @param flight
	 * @throws Exception 
	 */
	E completionRoute(E flight) throws Exception;	

}
