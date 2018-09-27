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
 * @Description  TODO ��������Service��ʵ�ַ���
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��7��4��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��7��4��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
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
		 * ����о�ͣ��
		 */
		if (flight.getIsTransferFlight()){
			
			if (sectorCount[SECTOR_I] ==0 && sectorCount[SECTOR_R] ==0){
				/*
				 *    ���û�й��ʺ͵������� 
				 */
				return SectorCode.D;
			}else if (sectorCount[SECTOR_D] >=2){
				/*
				 * ������ڻ�����������2
				 */
				return SectorCode.M;
			}else if (sectorCount[SECTOR_I] ==0){
				/*
				 * ���û�й��ʻ���
				 */
				return SectorCode.R;
			}else {
				/*
				 * �й��ʳ�
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
		 *  ��ȫ����
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
