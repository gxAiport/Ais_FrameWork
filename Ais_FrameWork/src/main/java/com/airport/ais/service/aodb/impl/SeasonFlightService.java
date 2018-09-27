package com.airport.ais.service.aodb.impl;

import javax.ejb.Stateless;

import org.apache.commons.beanutils.BeanUtils;

import com.airport.ais.enums.aodb.FlightSeason;
import com.airport.ais.enums.aodb.OperationalDay;
import com.airport.ais.models.aodb.flight.BasicFlight;
import com.airport.ais.models.aodb.flight.Flight;
import com.airport.ais.models.aodb.flight.SeasonFlight;
import com.airport.ais.models.aodb.flight.SeasonFlight.StopFlight;
import com.airport.ais.service.aodb.ISeasonFlightService;
import com.airport.ais.utils.DateTimeUtil;
import com.airport.ais.utils.ObjectMethodUtil;


/**
 * 
 * 
 * FileName      SeasonFlightService.java
 * @Description  TODO 季度航班的Service实现类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年8月16日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年8月16日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Stateless
public class SeasonFlightService extends BasicFlightService<SeasonFlight> implements ISeasonFlightService {

	/**
	 * 需要赋值的字段
	 */
	 private final static  String[] fields = new String[]{BasicFlight.FLIGHTNUMBER,BasicFlight.FLIGHTDIRECTION,BasicFlight.AIRCRAFTSUBTYPE,BasicFlight.AIRLINE,
			 BasicFlight.DEPARTUREAIRPORT,BasicFlight.ARRIVALAIRPORT,BasicFlight.LOCALAIRPOT,BasicFlight.FIRSTSTATION,BasicFlight.DESTINATIONSTATION,BasicFlight.SECTOR,
			 BasicFlight.FLIGHTCLASSIFICATION,BasicFlight.FLIGHTSERVICETYPE,BasicFlight.ISTRANSFERFLIGHT}; 
	
	
	@Override
	public void createSeasonByDynamic(Flight flight) throws Exception {
		SeasonFlight seasonFlight = new SeasonFlight();
		/*
		 * 赋值基本数据项
		 */
		ObjectMethodUtil.compareAndCopyFields(seasonFlight, flight, fields, fields);
		/*
		 * 赋值经停断
		 */
		for (BasicFlight.StopFlight stop:flight.getStopFlights()){
			StopFlight seasonStop = new StopFlight();
			BeanUtils.copyProperties(seasonStop, stop);
			seasonFlight.getStopFlights().add(seasonStop);
		}
		/*
		 * 设置航线
		 */
		seasonFlight.setFlightRoute(updateFlightRoute(seasonFlight));
		/**
		 * 设置进离港时间
		 */
		if (flight.getScheduledDepartureDateTime() != null){
			seasonFlight.setScheduledAirborneDateTime(DateTimeUtil.DateToStr(flight.getScheduledDepartureDateTime()).substring(11));
		}
		if (flight.getScheduledArrivalDateTime() != null){
			seasonFlight.setScheduledLandDateTime(DateTimeUtil.DateToStr(flight.getScheduledDepartureDateTime()).substring(11));
		}
		/*
		 * 默认每天一班
		 */
		for(OperationalDay day:OperationalDay.values()){
			seasonFlight.getDaysOfOperation().add(day);
		}
		
		if (flight.getScheduledDateTime() != null){
			int year = Integer.parseInt(DateTimeUtil.dateToYYYYMMDD(flight.getScheduledDateTime()).substring(0, 4));
			if (flight.getScheduledDateTime().compareTo(DateTimeUtil.getMonthDayofWeek(year, 3, OperationalDay.SUNDAY))  <0){
				/*
				 * 说明是去年的冬春航季
				 */
				seasonFlight.setSeason(FlightSeason.WINTER_SPRING);
				seasonFlight.setFlightFirstDateTime(DateTimeUtil.getMonthDayofWeek(year-1, 10, OperationalDay.SUNDAY));
				seasonFlight.setFlightLastDateTime(DateTimeUtil.getMonthDayofWeek(year, 3, OperationalDay.SATURDAY));
			}else if (flight.getScheduledDateTime().compareTo(DateTimeUtil.getMonthDayofWeek(year, 10, OperationalDay.SATURDAY)) <=0){
				/**
				 * 说明是今年的夏春航季
				 */
				seasonFlight.setSeason(FlightSeason.SUMMER_AUTUMN);
				seasonFlight.setFlightFirstDateTime(DateTimeUtil.getMonthDayofWeek(year, 3, OperationalDay.SUNDAY));
				seasonFlight.setFlightLastDateTime(DateTimeUtil.getMonthDayofWeek(year, 10, OperationalDay.SATURDAY));
				
			}else {
				/**
				 * 说明是今年的冬春航迹
				 */
				seasonFlight.setSeason(FlightSeason.WINTER_SPRING);
				seasonFlight.setFlightFirstDateTime(DateTimeUtil.getMonthDayofWeek(year, 10, OperationalDay.SUNDAY));
				seasonFlight.setFlightLastDateTime(DateTimeUtil.getMonthDayofWeek(year+1, 3, OperationalDay.SATURDAY));
			}
		}
		
		update(seasonFlight);
		
		
	}

	

}
