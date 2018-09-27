package com.airport.ais.models.aodb.flight;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.airport.ais.enums.aodb.OperationalDay;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.airport.ais.enums.aodb.FlightSeason;

/**
 * 
 * FileName      SeasonFlight.java
 * @Description  TODO 航季航班实体类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月19日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月19日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */


@Entity
@Table(name="Season_Flight")
public class SeasonFlight extends BasicFlight {

	private static final long serialVersionUID = 1L;
	
	
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public final  static   String		DAYSOFOPERATION     = "daysOfOperation";
		public final  static   String		SEASON              = "season";
		public final  static   String		FLIGHTFIRSTDATETIME = "flightFirstDateTime";
		public final  static   String		FLIGHTLASTDATETIME  = "flightLastDateTime";
		
		
		public final static String[] searchParams = {FLIGHTDIRECTION,SECTOR,LOCALAIRPOT,AIRLINE,FLIGHTNUMBER,
				FLIGHTCLASSIFICATION,DEPARTUREAIRPORT,ARRIVALAIRPORT,LOCALAIRPOT};
		
		
		/**
		 *  航班执行频率集合
		 */

		@Enumerated(EnumType.STRING)
		@ElementCollection(fetch=FetchType.EAGER)
		@Column(length=12)
		protected Set<OperationalDay> daysOfOperation;
		/**
		 * 航季
		 */
		@Column(length=15)
		@Enumerated(EnumType.STRING)
		protected FlightSeason season;
		/**
		 * 航季开始时间
		 */
		protected Date flightFirstDateTime;
		/**
		 * 航季结束时间
		 */
		protected Date flightLastDateTime;
		
		public Set<OperationalDay> getDaysOfOperation() {
			if (daysOfOperation == null){
				daysOfOperation = new HashSet<OperationalDay>();
			}
			return this.daysOfOperation;
		}
		
		@DateTimeFormat(pattern="yyyy-MM-dd")  
		@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  
		public Date getFlightFirstDateTime() {
			return flightFirstDateTime;
		}
		
		public void setFlightFirstDateTime(Date flightFirstDateTime) {
			this.flightFirstDateTime = flightFirstDateTime;
		}
		
		@DateTimeFormat(pattern="yyyy-MM-dd")  
		@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  
		public Date getFlightLastDateTime() {
			return flightLastDateTime;
		}
		
		public void setFlightLastDateTime(Date flightLastDateTime) {
			this.flightLastDateTime = flightLastDateTime;
		}
		
		public FlightSeason getSeason() {
			return season;
		}


		public void setSeason(FlightSeason season) {
			this.season = season;
		}		
		

	/**
	 * @Description  机场数据的静态类，与机场相关的数据集合
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
		
		




		/**
		 * 航季行李装载转盘集合
		 */
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.BaggageMakeupPosition> baggageMakeupPositions;
		/**
		 * 航季行李认领转盘集合
		 */
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.BaggageReclaimCarousel> baggageReclaimCarousels;
		/**
		 * 航季值机柜台集合
		 */
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.Checkin> checkins;
		/**
		 * 航季登机口集合
		 */
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.Gate> gates;
		
		
		@Override
		public Set<com.airport.ais.models.aodb.flight.SeasonFlight.BaggageMakeupPosition> getBaggageMakeupPositions() {
			if (baggageMakeupPositions == null){
				baggageMakeupPositions = new HashSet<SeasonFlight.BaggageMakeupPosition>();
			}
			return baggageMakeupPositions;
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void setBaggageMakeupPositions(Set baggageMakeupPositions) {
			this.baggageMakeupPositions = baggageMakeupPositions;
		}	
		
		@Override
		public Set<com.airport.ais.models.aodb.flight.SeasonFlight.BaggageReclaimCarousel> getBaggageReclaimCarousels() {
			if (baggageReclaimCarousels == null){
				baggageReclaimCarousels = new HashSet<SeasonFlight.BaggageReclaimCarousel>();
			}
			return baggageReclaimCarousels;
		}
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void setBaggageReclaimCarousels(Set baggageReclaimCarousels) {
			this.baggageReclaimCarousels = baggageReclaimCarousels;
		}	

		@Override
		public Set<com.airport.ais.models.aodb.flight.SeasonFlight.Checkin> getCheckins() {
			if (checkins == null){
				checkins = new HashSet<SeasonFlight.Checkin>();
			}
			return checkins;
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void setCheckins(Set checkins) {
			this.checkins = checkins;
		}
		
		
		
		@Override
		public Set<com.airport.ais.models.aodb.flight.SeasonFlight.Gate> getGates() {
			if (gates == null){
				gates = new HashSet<SeasonFlight.Gate>();
			}
			return gates;
		} 	    

		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void setGates(Set gates) {
			this.gates = gates;
		}	
		
		/**
		 * TypeName      SeasonFlight.AirportData.BaggageMakeupPosition 
		 * @Description  继承BasicFlight.AirportData.BaggageMakeupPosition，航季行李装载转盘的实体表
		 */
		@Entity
		@Table(name="Season_BaggageMakeupPosition")
		 public  class BaggageMakeupPosition extends BasicFlight.BaggageMakeupPosition{

			private static final long serialVersionUID = 1L;
		 }

		/**
		 * TypeName      SeasonFlight.AirportData.BaggageReclaimCarousel 
		 * @Description  继承BasicFlight.AirportData.BaggageReclaimCarousel，航季行李转盘认领的实体表
		 */
		 @Entity
		 @Table(name="Season_BaggageReclaimCarousel")
		 public  class BaggageReclaimCarousel extends BasicFlight.BaggageReclaimCarousel{

			private static final long serialVersionUID = 1L;
		 }
	 
		 /**
		 * TypeName      SeasonFlight.AirportData.Checkin 
		 * @Description  继承BasicFlight.AirportData.Checkin 航季值机柜台的实体表
		 */		 
		 @Entity
		 @Table(name="Season_Checkin")
		 public class Checkin extends BasicFlight.Checkin{

			private static final long serialVersionUID = 1L;
		 }

		/**
		 * TypeName      SeasonFlight.AirportData.Gate 
		 * @Description  继承BasicFlight.AirportData.Gate  航季登机口的实体表
		 */
		 @Entity
		 @Table(name="Season_Gate")
		 public class Gate extends BasicFlight.Gate{

			private static final long serialVersionUID = 1L;
			 
		 }
		 
		 
	   /**
		* @Description  航班数据的静态类，与航班相关的数据
		*---------------------------------------------------------------------------------------------------------------------------------------------------------------
		*/
		 
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.ShareFlight> shareFlights;
		
		@Override
		public Set<com.airport.ais.models.aodb.flight.SeasonFlight.ShareFlight> getShareFlights() {
			if (shareFlights == null){
				shareFlights = new HashSet<SeasonFlight.ShareFlight>();
			}
			return this.shareFlights;
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void setShareFlights(Set shareFlights) {
			this.shareFlights = shareFlights;
		}					
		
		@Entity
		@Table(name="Season_ShareFlight")
		public class ShareFlight extends BasicFlight.ShareFlight{
			
			private static final long serialVersionUID = 1L;
			
		}

		/**
		 * @Description  航线数据的静态类，与航线数据相关的数据集合
		 * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
		 */
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.StopFlight> stopFlights;
		
		@Override
		public Set<com.airport.ais.models.aodb.flight.SeasonFlight.StopFlight> getStopFlights() {
			if (stopFlights == null){
				stopFlights = new HashSet<SeasonFlight.StopFlight>();
			}
			return stopFlights;
		}
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void setStopFlights(Set stops) {
			this.stopFlights = stops;
		}		
		
		@Entity
		@Table(name="Season_StopFlight")
		public static class StopFlight extends BasicFlight.StopFlight{
			private static final long serialVersionUID = 1L;
			
		}



		
	/**
	 * @Description  航班时间相关的静态类，所有操作时间的集合
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	 */
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String SCHEDULEDOFFBLOCKSDATETIME      = "scheduledOffBlocksDateTime";
		public static final  String SCHEDULEDONBLOCKSDATETIME       = "scheduledOnBlocksDateTime";
		public static final  String SCHEDULEDWHEELSUPDATETIME       = "scheduledwheelsUpDateTime";
		public static final  String SCHEDULEDWHEELSDOWNDATETIME     = "scheduledwheelsDownDateTime";
		public static final  String SCHEDULEDAIRBORNEDATETIME       = "scheduledAirborneDateTime";
		public static final  String SCHEDULEDLANDDATETIME           = "scheduledLandDateTime";
		/**
		 * 计划离港时间
		 */
		@Column(length=6)
		protected String scheduledOffBlocksDateTime;
		/**
		 * 计划到港时间
		 */
		@Column(length=6)
		protected String scheduledOnBlocksDateTime;
		/**
		 * 计划上轮档时间
		 */
		@Column(length=6)
		protected String scheduledwheelsUpDateTime;
		/**
		 *  计划下轮档时间
		 */
		@Column(length=6)
		protected String scheduledwheelsDownDateTime;
		/**
		 *  计划起飞的时间
		 */
		@Column(length=6)
		protected String scheduledAirborneDateTime;
		/**
		 *  计划落地的时间
		 */
		@Column(length=6)
		protected String scheduledLandDateTime;
		
		public String getScheduledOffBlocksDateTime() {
			return scheduledOffBlocksDateTime;
		}
		
		public void setScheduledOffBlocksDateTime(String scheduledOffBlocksDateTime) {
			this.scheduledOffBlocksDateTime = scheduledOffBlocksDateTime;
		}
		
		public String getScheduledOnBlocksDateTime() {
			return scheduledOnBlocksDateTime;
		}
		
		public void setScheduledOnBlocksDateTime(String scheduledOnBlocksDateTime) {
			this.scheduledOnBlocksDateTime = scheduledOnBlocksDateTime;
		}
		
		public String getScheduledwheelsUpDateTime() {
			return scheduledwheelsUpDateTime;
		}
		
		public void setScheduledwheelsUpDateTime(String scheduledwheelsUpDateTime) {
			this.scheduledwheelsUpDateTime = scheduledwheelsUpDateTime;
		}
		
		public String getScheduledwheelsDownDateTime() {
			return scheduledwheelsDownDateTime;
		}
		
		public void setScheduledwheelsDownDateTime(String scheduledwheelsDownDateTime) {
			this.scheduledwheelsDownDateTime = scheduledwheelsDownDateTime;
		}
		
		public String getScheduledAirborneDateTime() {
			return scheduledAirborneDateTime;
		}
		
		public void setScheduledAirborneDateTime(String scheduledAirborneDateTime) {
			this.scheduledAirborneDateTime = scheduledAirborneDateTime;
		}
		
		public String getScheduledLandDateTime() {
			return scheduledLandDateTime;
		}
		
		public void setScheduledLandDateTime(String scheduledLandDateTime) {
			this.scheduledLandDateTime = scheduledLandDateTime;
		}

	
	
		
	
}
