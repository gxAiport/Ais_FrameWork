package com.airport.ais.service.aodb.impl;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;

import com.airport.ais.enums.aodb.SectorCode;
import com.airport.ais.models.aodb.basic.Airport;
import com.airport.ais.models.aodb.basic.FlightRoute;
import com.airport.ais.models.aodb.flight.BasicFlight;
import com.airport.ais.models.aodb.flight.BasicFlight.StopFlight;
import com.airport.ais.service.IAodbService;
import com.airport.ais.service.aodb.IBasicFlightService;
import com.airport.ais.service.impl.AodbService;

/**
 * 
 * 
 * FileName      BasicFlightService.java
 * @Description  TODO 基础航班Service的实现方法
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年7月4日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年7月4日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public abstract class BasicFlightService<E extends BasicFlight> extends 
	AodbService<Integer, E> implements IBasicFlightService<E> {

    private final int SECTOR_D = 0;
	
	private final int SECTOR_I = 1;
	
	private final int SECTOR_R = 2;
	
	@EJB
	protected IAodbService<String, FlightRoute> routeService; 
	
	
	@Override
	public SectorCode confirmSectorByRoute(E flight) {
		int[] sectorCount = new int[3];
		
		Set<Airport> airports = new HashSet<Airport>();
		airports.add(flight.getFirstStation());
		for (StopFlight stop:flight.getStopFlights()){
			airports.add(stop.getStopAirport());
		}
		airports.add(flight.getDestinationStation());
		
		for(Airport airport:airports){
			if (airport != null && airport.getSector() != null){
				switch (airport.getSector().getSectorCode()) {
				case D:
					sectorCount[SECTOR_D]++;
					break;
				case I:
					sectorCount[SECTOR_I]++;
					break;
				case R:
					sectorCount[SECTOR_R]++;
					break;
				default:
					break;
				}
			}
		}
		
		/*
		 * 如果有经停点
		 */
		if (flight.getIsTransferFlight()){
			
			if (sectorCount[SECTOR_I] ==0 && sectorCount[SECTOR_R] ==0){
				/*
				 *    如果没有国际和地区机场 
				 */
				return SectorCode.D;
			}else if (sectorCount[SECTOR_D] >=2){
				/*
				 * 如果国内机场数量大于2
				 */
				return SectorCode.M;
			}else if (sectorCount[SECTOR_I] ==0){
				/*
				 * 如果没有国际机场
				 */
				return SectorCode.R;
			}else {
				/*
				 * 有国际场
				 */
				return SectorCode.I;
			}
		} else {
			if (sectorCount[SECTOR_I] !=0){
				return SectorCode.I;
			}else if (sectorCount[SECTOR_R] !=0){
				return SectorCode.R;
			}else {
				return SectorCode.D;
			}
		}		
	}

	@Override
	public FlightRoute updateFlightRoute(E flight) {
		
		FlightRoute route = routeService.findByFieldSingle(FlightRoute.IATAROUTE, 
				flight.getiATARoute(), FlightRoute.class);
		/*
		 *  补全航线
		 */
		if (route == null){
			route = new FlightRoute();
			route.setChineseRoute(flight.getChineseRoute());
			route.setIATARoute(flight.getiATARoute());
			route.setShortRoute(flight.getShortRoute());
			route.setSector(flight.getSector());
			route = routeService.update(route);
		}
		return route;
	}
	
	
	
}
