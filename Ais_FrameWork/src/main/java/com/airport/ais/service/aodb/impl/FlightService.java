package com.airport.ais.service.aodb.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;

import org.apache.commons.beanutils.BeanUtils;

import com.airport.ais.dao.parameter.QueryCondition;
import com.airport.ais.enums.aodb.FlightDirection;
import com.airport.ais.enums.aodb.OperationalDay;
import com.airport.ais.models.aodb.flight.BasicFlight.StopFlight;
import com.airport.ais.models.aodb.flight.Flight;
import com.airport.ais.models.aodb.flight.SeasonFlight;
import com.airport.ais.service.IAodbService;
import com.airport.ais.service.aodb.IFlightService;
import com.airport.ais.utils.DateTimeUtil;
import com.airport.ais.utils.ObjectMethodUtil;

/**
 * 
 * 
 * FileName      FlightService.java
 * @Description  TODO 运营航班的Service接口的实现类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年7月4日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年7月4日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public abstract class FlightService<E extends Flight> extends BasicFlightService<E> implements IFlightService<E> {
	
	
	
	@EJB
	protected IAodbService<Integer, SeasonFlight> seasonFlightService;

	@Override
	public E findByFlightIdentification(String flightNumber, FlightDirection direction, Date date, int repeatCount,
			String carrierICAOCode, String oneToMany, String manyToOne, Class<E> clazz) {
		QueryCondition condition = new QueryCondition();
		condition.setExpression(new Object[]{Flight.FLIGHTNUMBER,"=",flightNumber,"AND",Flight.FLIGHTDIRECTION,"=",direction,"AND",
				Flight.SCHEDULEDDATETIME,"=",date,"AND",Flight.FLIGHTREPEATCOUNT,"=", repeatCount});
		condition.setFetchManyToOne(manyToOne);
		condition.setFetchOneToMany(oneToMany);
		return findByConditionSingle(condition,clazz);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E completionRoute(E flight) throws Exception{
		if (flight.getFlightRoute() == null){
			/*
			 * 查找与此航班对应的的季度航线
			 */
			QueryCondition condition = new QueryCondition();
			condition.setExpression(new Object[]{SeasonFlight.FLIGHTNUMBER,"=",flight.getFlightNumber(),"AND",
					SeasonFlight.FLIGHTDIRECTION,"=",flight.getFlightDirection(),"AND",SeasonFlight.LOCALAIRPOT,"=",flight.getLocalAirpot(),"AND",
					SeasonFlight.FLIGHTFIRSTDATETIME,"<=",flight.getScheduledDateTime(),"AND",SeasonFlight.FLIGHTLASTDATETIME,">=",flight.getScheduledDateTime()});
			condition.setFetchOneToMany("ALL");
			List<SeasonFlight> seasonFlights = seasonFlightService.findByConditionAll(condition, SeasonFlight.class);
			OperationalDay day = DateTimeUtil.getOperationalDay(flight.getScheduledDateTime());
			for (SeasonFlight seasonFlight:seasonFlights){
				if (seasonFlight.getDaysOfOperation().contains(day)){
					/*
					 * 如果找到
					 */
					flight.setFirstStation(seasonFlight.getFirstStation());
					flight.setDestinationStation(seasonFlight.getDestinationStation());
					flight.setFirstStationScheduledAirborneTime(seasonFlight.getScheduledAirborneDateTime());
					flight.setDestinationStationScheduledLandTime(seasonFlight.getDestinationStationScheduledLandTime());
					flight.setFlightRoute(seasonFlight.getFlightRoute());
					flight.setIsTransferFlight(seasonFlight.getIsTransferFlight());
					flight.setSector(seasonFlight.getSector());
					flight.getStopFlights().clear();
					Set<StopFlight> stops = new HashSet<StopFlight>();
					Class<StopFlight> stopClazz = (Class<StopFlight>) ObjectMethodUtil.getFieldGenericType(flight, Flight.STOPFLIGHTS, 0);
					for (SeasonFlight.StopFlight seasonStop:seasonFlight.getStopFlights()){
						StopFlight stop = stopClazz.newInstance();
						BeanUtils.copyProperties(stop, seasonStop);
						stop.setId(0);
						stops.add(stop);
					}
					flight.setStopFlights(stops);
					break;
				}
			}
		}
		return flight;
	}


	
	
}
