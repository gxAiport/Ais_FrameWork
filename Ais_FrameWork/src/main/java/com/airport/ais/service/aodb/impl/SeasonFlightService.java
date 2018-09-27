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
 * @Description  TODO ���Ⱥ����Serviceʵ���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��8��16��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��8��16��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Stateless
public class SeasonFlightService extends BasicFlightService<SeasonFlight> implements ISeasonFlightService {

	/**
	 * ��Ҫ��ֵ���ֶ�
	 */
	 private final static  String[] fields = new String[]{BasicFlight.FLIGHTNUMBER,BasicFlight.FLIGHTDIRECTION,BasicFlight.AIRCRAFTSUBTYPE,BasicFlight.AIRLINE,
			 BasicFlight.DEPARTUREAIRPORT,BasicFlight.ARRIVALAIRPORT,BasicFlight.LOCALAIRPOT,BasicFlight.FIRSTSTATION,BasicFlight.DESTINATIONSTATION,BasicFlight.SECTOR,
			 BasicFlight.FLIGHTCLASSIFICATION,BasicFlight.FLIGHTSERVICETYPE,BasicFlight.ISTRANSFERFLIGHT}; 
	
	
	@Override
	public void createSeasonByDynamic(Flight flight) throws Exception {
		SeasonFlight seasonFlight = new SeasonFlight();
		/*
		 * ��ֵ����������
		 */
		ObjectMethodUtil.compareAndCopyFields(seasonFlight, flight, fields, fields);
		/*
		 * ��ֵ��ͣ��
		 */
		for (BasicFlight.StopFlight stop:flight.getStopFlights()){
			StopFlight seasonStop = new StopFlight();
			BeanUtils.copyProperties(seasonStop, stop);
			seasonFlight.getStopFlights().add(seasonStop);
		}
		/*
		 * ���ú���
		 */
		seasonFlight.setFlightRoute(updateFlightRoute(seasonFlight));
		/**
		 * ���ý����ʱ��
		 */
		if (flight.getScheduledDepartureDateTime() != null){
			seasonFlight.setScheduledAirborneDateTime(DateTimeUtil.DateToStr(flight.getScheduledDepartureDateTime()).substring(11));
		}
		if (flight.getScheduledArrivalDateTime() != null){
			seasonFlight.setScheduledLandDateTime(DateTimeUtil.DateToStr(flight.getScheduledDepartureDateTime()).substring(11));
		}
		/*
		 * Ĭ��ÿ��һ��
		 */
		for(OperationalDay day:OperationalDay.values()){
			seasonFlight.getDaysOfOperation().add(day);
		}
		
		if (flight.getScheduledDateTime() != null){
			int year = Integer.parseInt(DateTimeUtil.dateToYYYYMMDD(flight.getScheduledDateTime()).substring(0, 4));
			if (flight.getScheduledDateTime().compareTo(DateTimeUtil.getMonthDayofWeek(year, 3, OperationalDay.SUNDAY))  <0){
				/*
				 * ˵����ȥ��Ķ�������
				 */
				seasonFlight.setSeason(FlightSeason.WINTER_SPRING);
				seasonFlight.setFlightFirstDateTime(DateTimeUtil.getMonthDayofWeek(year-1, 10, OperationalDay.SUNDAY));
				seasonFlight.setFlightLastDateTime(DateTimeUtil.getMonthDayofWeek(year, 3, OperationalDay.SATURDAY));
			}else if (flight.getScheduledDateTime().compareTo(DateTimeUtil.getMonthDayofWeek(year, 10, OperationalDay.SATURDAY)) <=0){
				/**
				 * ˵���ǽ�����Ĵ�����
				 */
				seasonFlight.setSeason(FlightSeason.SUMMER_AUTUMN);
				seasonFlight.setFlightFirstDateTime(DateTimeUtil.getMonthDayofWeek(year, 3, OperationalDay.SUNDAY));
				seasonFlight.setFlightLastDateTime(DateTimeUtil.getMonthDayofWeek(year, 10, OperationalDay.SATURDAY));
				
			}else {
				/**
				 * ˵���ǽ���Ķ�������
				 */
				seasonFlight.setSeason(FlightSeason.WINTER_SPRING);
				seasonFlight.setFlightFirstDateTime(DateTimeUtil.getMonthDayofWeek(year, 10, OperationalDay.SUNDAY));
				seasonFlight.setFlightLastDateTime(DateTimeUtil.getMonthDayofWeek(year+1, 3, OperationalDay.SATURDAY));
			}
		}
		
		update(seasonFlight);
		
		
	}

	

}
