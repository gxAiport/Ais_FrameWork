package com.airport.ais.models.aodb.flight;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import com.airport.ais.enums.aodb.BaggageMakeupPositionRole;
import com.airport.ais.enums.aodb.BaggageReclaimCarouselRole;
import com.airport.ais.enums.aodb.CheckinRole;
import com.airport.ais.enums.aodb.CheckinTypeCode;
import com.airport.ais.enums.aodb.FlightDirection;
import com.airport.ais.enums.aodb.GateRole;
import com.airport.ais.models.IntIdEntity;
import com.airport.ais.models.aodb.basic.AircraftSubtype;
import com.airport.ais.models.aodb.basic.Airline;
import com.airport.ais.models.aodb.basic.Airport;
import com.airport.ais.models.aodb.basic.FlightClassification;
import com.airport.ais.models.aodb.basic.FlightNature;
import com.airport.ais.models.aodb.basic.FlightServiceType;
import com.airport.ais.models.aodb.basic.FlightRoute;
import com.airport.ais.models.aodb.basic.Runway;
import com.airport.ais.models.aodb.basic.Sector;
import com.airport.ais.models.aodb.basic.Stand;
import com.airport.ais.models.aodb.basic.Terminal;




/**
 * 
 * FileName      BasicFlight.java
 * @Description  TODO 航班实体类的基类，航班所包含所有数据的集合
 * 基类有两种内部类：
 * 一、整理归纳相似数据的集合，此类为航班实体的一部分，用@Embedded注解，用Static关键字，为静态类，框架不会生成额外的表。
 *  1、BasicFlight.FlightIdentification 
 *  2、BasicFlight.AircraftData
 *  3、BasicFlight.FlightData
 *  4、BasicFlight.RouteData
 *  5、BasicFlight.OperationalTimes
 *  6、BasicFlight.FlightData.LinkedFlight
 *  二、与航班相关的实体表，一般是一对多，用@OneToMany注解，生成额外的实体表
 *  1、BasicFlight.FlightData.ShareFlight
 *  2、BasicFlight.RouteData.StopFlight
 *
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月17日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月17日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@SuppressWarnings("serial")
@MappedSuperclass
public  abstract class BasicFlight extends IntIdEntity {
	
	/**
	 * @Description  航班标识信息的静态类，能唯一标识一个航班
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
	
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String    FLIGHTNUMBER     = "flightNumber";
		public static final  String    FLIGHTDIRECTION  = "flightDirection";
		public static final  String    AIRLINE          = "airline";
		/**
		 * 航班号
		 */
		@Column(length=8)
		protected String flightNumber;
		/**
		 * 进出港标识
		 */
		@Column(length=10)
		@Enumerated(EnumType.STRING)
		protected FlightDirection flightDirection;
		/**
		 * 航空公司
		 */
		@ManyToOne
		protected Airline airline;
		
		public String getFlightNumber() {
			return flightNumber;
		}
		
		public void setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
		}
		
		public FlightDirection getFlightDirection() {
			return flightDirection;
		}
		
		public void setFlightDirection(FlightDirection flightDirection) {
			this.flightDirection = flightDirection;
		}
		
		public Airline getAirline() {
			return airline;
		}
		
		public void setAirline(Airline airline) {
			this.airline = airline;
		}
		
		
	
	/**
	 * @Description  飞机数据的静态类，与飞机数据相关的数据集合
	 * -------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	 */
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String AIRCRAFTSUBTYPE = "aircraftSubtype";
		
		/**
		 * 机型
		 */
		@ManyToOne
		protected AircraftSubtype aircraftSubtype;

		public AircraftSubtype getAircraftSubtype() {
			return aircraftSubtype;
		}

		public void setAircraftSubtype(AircraftSubtype aircraftSubtype) {
			this.aircraftSubtype = aircraftSubtype;
		}
		
		
	
	/**
	 * @Description  航班数据的静态类，与航班相关的数据
	 * ---------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String  JOINFLIGHTNUMBER           = "joinFlightNumber";
		public static final  String  FLIGHTCLASSIFICATION       = "flightClassification";
		public static final  String  FLIGHTNATURE               = "flightNature";
		public static final  String  FLIGHTSERVICETYPE          = "flightServiceType";
		public static final  String  DEPARTUREAIRPORT           = "departureAirport";
		public static final  String  ARRIVALAIRPORT             = "arrivalAirport";
		public static final  String  ISOPERATESOVERNIGHT        = "isOperatesOvernight";
		public static final  String  ISBEFOREFLIGHT             = "isBeforeFlight";
		public static final  String  ISGENERALAVIATIONFLIGHT    = "isGeneralAviationFlight";
		public static final  String  ISTRANSFERFLIGHT           = "isTransferFlight";
		public static final  String  LINKEDFLIGHT               = "linkedFlight";
		public static final  String  SHAREFLIGHTS               = "shareFlights";
		public static final  String  SECTOR                     = "sector";
		
		/**
		 *  拼接航班号
		 */
		@Column(length=17)
		protected String joinFlightNumber;
		/**
		 * 航班分类，例如 W/Z
		 */
		@ManyToOne
		protected FlightClassification flightClassification;
		/**
		 * 航班性质，例如PAX 
		 */
		@ManyToOne
		protected FlightNature flightNature;
		/**
		 * 航班服务性质，例如J
		 */
		@ManyToOne
		protected FlightServiceType flightServiceType;
		
		/**
		 * 领域，例如国内国外
		 */
		@ManyToOne
		protected Sector sector;
		
		/**
		 * 出港机场
		 */
		@ManyToOne
		protected Airport departureAirport;
		/**
		 * 到达机场
		 */
		@ManyToOne
		protected Airport arrivalAirport;
		
		/**
		 * 航后服务标志
		 */
		protected Boolean isOperatesOvernight;
		/**
		 * 航前服务标志
		 */
		protected Boolean isBeforeFlight;
		/**
		 * 通航航班标志
		 */
		protected Boolean isGeneralAviationFlight;
		/**
		 *  中转航班标志
		 */
		protected Boolean isTransferFlight;
		


		public String getJoinFlightNumber() {
			return joinFlightNumber;
		}

		public void setJoinFlightNumber(String joinFlightNumber) {
			this.joinFlightNumber = joinFlightNumber;
		}

		public FlightClassification getFlightClassification() {
			return flightClassification;
		}

		public void setFlightClassification(FlightClassification flightClassification) {
			this.flightClassification = flightClassification;
		}

		public FlightNature getFlightNature() {
			return flightNature;
		}

		public void setFlightNature(FlightNature flightNature) {
			this.flightNature = flightNature;
		}

		public FlightServiceType getFlightServiceType() {
			return flightServiceType;
		}

		public void setFlightServiceType(FlightServiceType flightServiceType) {
			this.flightServiceType = flightServiceType;
		}

		public Airport getDepartureAirport() {
			return departureAirport;
		}

		public void setDepartureAirport(Airport departureAirport) {
			this.departureAirport = departureAirport;
		}

		public Airport getArrivalAirport() {
			return arrivalAirport;
		}

		public void setArrivalAirport(Airport arrivalAirport) {
			this.arrivalAirport = arrivalAirport;
		}

	
		
		public Boolean getIsOperatesOvernight() {
			return isOperatesOvernight;
		}

		public void setIsOperatesOvernight(Boolean isOperatesOvernight) {
			this.isOperatesOvernight = isOperatesOvernight;
		}

		public Boolean getIsBeforeFlight() {
			return isBeforeFlight;
		}

		public void setIsBeforeFlight(Boolean isBeforeFlight) {
			this.isBeforeFlight = isBeforeFlight;
		}

		public Boolean getIsGeneralAviationFlight() {
			return isGeneralAviationFlight;
		}

		public void setIsGeneralAviationFlight(Boolean isGeneralAviationFlight) {
			this.isGeneralAviationFlight = isGeneralAviationFlight;
		}

		public Boolean getIsTransferFlight() {
			return isTransferFlight;
		}

		public void setIsTransferFlight(Boolean isTransferFlight) {
			this.isTransferFlight = isTransferFlight;
		}
		
		public Sector getSector() {
			return sector;
		}

		public void setSector(Sector sector) {
			this.sector = sector;
		}

		
		/**
		 * 共享航班集合的返回方法，添加集合用Add方法
		 * @return
		 */
		public abstract Set<? extends  com.airport.ais.models.aodb.flight.BasicFlight.ShareFlight> getShareFlights();

		/**
		 * 设置共享航班
		 * @param shareFlights
		 */
		public abstract void setShareFlights(Set<? extends  com.airport.ais.models.aodb.flight.BasicFlight.ShareFlight>  shareFlights);
		/**
		 * 
		 * TypeName      BasicFlight.FlightData.ShareFlight
		 * @Description  共享航班实体类的基类
		 * 
		 */
		@MappedSuperclass
		public static class ShareFlight extends IntIdEntity {
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			public static final  String SHAREFLIGHTNUMBER = "shareFlightNumber";
			public static final  String SHAREAIRLINE      = "shareAirline";

			/**
			 * 共享航班号
			 */
			@Column(length=8)
			protected String shareFlightNumber;
			/**
			 * 共享航空公司
			 */
			@ManyToOne
			protected Airline shareAirline;
			
			public String getShareFlightNumber() {
				return shareFlightNumber;
			}
			
			public void setShareFlightNumber(String shareFlightNumber) {
				this.shareFlightNumber = shareFlightNumber;
			}
			
			public Airline getShareAirline() {
				return shareAirline;
			}
			
			public void setShareAirline(Airline shareAirline) {
				this.shareAirline = shareAirline;
			}

		}
		
		/**
		 * 
		 * 
		 * TypeName      BasicFlight.LinkedFlight
		 * @Description  连接航班的静态基类 
		 */
		@MappedSuperclass
		public  static class LinkedFlight implements Serializable{
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			public static final  String  LINKEDFLIGHTNUMBER      = "linkedFlightNumber";
			public static final  String  LINKEDFLIGHTDIRECTION   = "linkedFlightDirection";
			
			
			 /**
			  * 连接航班号
			  */
			 @Column(length=8)
			 protected String linkedFlightNumber;
			 /**
			  * 进出港标识
			  */
			 @Column(length=10)
			 @Enumerated(EnumType.STRING)
			 protected FlightDirection linkedFlightDirection;
			 
			 public String getLinkedFlightNumber() {
				 return linkedFlightNumber;
			 }
			 
			 public void setLinkedFlightNumber(String linkedFlightNumber) {
				 this.linkedFlightNumber = linkedFlightNumber;
			 }
			 
			 public FlightDirection getLinkedFlightDirection() {
				 return linkedFlightDirection;
			 }
			 
			 public void setLinkedFlightDirection(FlightDirection linkedFlightDirection) {
				 this.linkedFlightDirection = linkedFlightDirection;
			 }
			
			 
		}
		
	
	
	/**
	 * @Description  机场数据的静态类，与机场相关的数据集合
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
		
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String LOCALAIRPOT                 =  "localAirpot";
		public static final  String TERMINAL                    =  "terminal";
		public static final  String STAND                       =  "stand";
		public static final  String RUNWAY                      =  "runway";
		public static final  String BAGGAGEMAKEUPPOSITIONS      =  "baggageMakeupPositions";
		public static final  String BAGGAGERECLAIMCAROUSELS     =  "baggageReclaimCarousels";
		public static final  String CHECKINS                    =  "checkins";
		public static final  String GATES                       =  "gates";
		/**
		 *  本地机场
		 */
		@ManyToOne
		protected Airport localAirpot; 
		/**
		 * 航站楼
		 */
		@ManyToOne
		protected Terminal terminal;
		/**
		 * 停机位
		 */
		@ManyToOne
		protected Stand stand;
		/**
		 * 跑道
		 */
		@ManyToOne
		protected Runway runway;
		
		
	    public Airport getLocalAirpot() {
			return localAirpot;
		}

		public void setLocalAirpot(Airport localAirpot) {
			this.localAirpot = localAirpot;
		}

		public Terminal getTerminal() {
			return terminal;
		}

		public void setTerminal(Terminal terminal) {
			this.terminal = terminal;
		}

		public Stand getStand() {
			return stand;
		}

		public void setStand(Stand stand) {
			this.stand = stand;
		}

		public Runway getRunway() {
			return runway;
		}

		public void setRunway(Runway runway) {
			this.runway = runway;
		}
		
		/**
		 * 行李装载转盘集合的返回方法，添加集合用Add的方法
		 * @return
		 */
		public abstract Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.BaggageMakeupPosition> getBaggageMakeupPositions();

		/**
		 * 设置行李分拣转盘的方法
		 * @param baggageMakeupPositions
		 */
		public abstract void setBaggageMakeupPositions(Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.BaggageMakeupPosition> baggageMakeupPositions);
		
		/**
		 * 行李认领转盘集合的返回方法，添加集合用Add的方法
		 * @return
		 */
		public abstract Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.BaggageReclaimCarousel> getBaggageReclaimCarousels();
		
		/**
		 * 设置行李提取转盘的方法
		 * @param baggageReclaimCarousels
		 */
		public abstract void setBaggageReclaimCarousels(Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.BaggageReclaimCarousel> baggageReclaimCarousels);
		/**
		 * 值机柜台集合的返回方法，添加集合用Add的方法
		 * @return
		 */
		public abstract Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.Checkin> getCheckins();
		
		/**
		 * 设置值机柜台的方法
		 * @param 
		 */
		public abstract void setCheckins(Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.Checkin> checkins);
		
		
		/**
		 * 登机口集合的返回方法，添加集合用Add的方法
		 * @return
		 */
		public abstract Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.Gate> getGates();
		
		/**
		 * 设置登机口的方法
		 * @param gates
		 */
		public abstract void setGates(Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.Gate> gates);
		
		/**
		  * TypeName      BasicFlight.AirportData.BaggageMakeupPosition
		  * @Description  行李装载转盘实体类的基类 
		  */
		 @MappedSuperclass
		 public static class BaggageMakeupPosition extends IntIdEntity {
			 
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			public static final  String BAGGAGEMAKEUPPOSITIONID   = "baggageMakeupPositionID";
			public static final  String BAGGAGEMAKEUPPOSITIONROLE = "baggageMakeupPositionRole";
				
			 /**
			  * 行李装载转盘编号
			  */
			 @Column(length=4)
			 protected String  baggageMakeupPositionID;
			 /**
			  *  行李转载转盘规则
			  */
			 @Column(length=10)
			 @Enumerated(EnumType.STRING)
			 protected BaggageMakeupPositionRole baggageMakeupPositionRole;
			 
			 public String getBaggageMakeupPositionID() {
				 return baggageMakeupPositionID;
			 }
			 
			 public void setBaggageMakeupPositionID(String baggageMakeupPositionID) {
				 this.baggageMakeupPositionID = baggageMakeupPositionID;
			 }
			 
			 public BaggageMakeupPositionRole getBaggageMakeupPositionRole() {
				 return baggageMakeupPositionRole;
			 }
			 
			 public void setBaggageMakeupPositionRole(BaggageMakeupPositionRole baggageMakeupPositionRole) {
				 this.baggageMakeupPositionRole = baggageMakeupPositionRole;
			 }
			 
			 
		 }
		 /**
		  * TypeName      BasicFlight.AirportData.BaggageReclaimCarousel
		  * @Description  行李认领转盘实体类的基类
		  */
		 @MappedSuperclass
		 public  static class BaggageReclaimCarousel extends IntIdEntity {
			 
			 /**
			  * 各个数据字段名,用来调用点用字段名
			  */	
			public static final  String BAGGAGERECLAIMCAROUSELID   = "baggageReclaimCarouselID";
			public static final  String BAGGAGERECLAIMCAROUSELROLE = "baggageReclaimCarouselRole";
			 /**
			  *  行李认领转盘编号
			  */
			 @Column(length=4)
			 protected String baggageReclaimCarouselID;
			 /**
			  * 行李认领转盘规则
			  */
			 @Column(length=10)
			 @Enumerated(EnumType.STRING)
			 protected BaggageReclaimCarouselRole baggageReclaimCarouselRole;

			 public String getBaggageReclaimCarouselID() {
				return baggageReclaimCarouselID;
			 }

			 public void setBaggageReclaimCarouselID(String baggageReclaimCarouselID) {
				 this.baggageReclaimCarouselID = baggageReclaimCarouselID;
			 }

			 public BaggageReclaimCarouselRole getBaggageReclaimCarouselRole() {
				 return baggageReclaimCarouselRole;
			 }

			 public void setBaggageReclaimCarouselRole(BaggageReclaimCarouselRole baggageReclaimCarouselRole) {
				 this.baggageReclaimCarouselRole = baggageReclaimCarouselRole;
			 }
		 }
		 
		 /**
		  * TypeName      BasicFlight.AirportData.Checkin
		  * @Description  值机实体类的基类
		  */
		 @MappedSuperclass
		 public static class Checkin extends IntIdEntity{
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			public static final  String CHECKINDESKRANGE = "checkinDeskRange";
			public static final  String CHECKINROLE      = "checkinRole";
			public static final  String CHECKINTYPECODE  = "checkinTypeCode";
			
			 /**
			  *  值机柜台编号范围，例如15-17
			  */
			 @Column(length=20)
			 protected String checkinDeskRange;
			 /**
			  *  值机规则
			  */
			 @Column(length=10)
			 @Enumerated(EnumType.STRING)
			 protected CheckinRole checkinRole;  
			 /**
			  *  值机类型代码
			  */
			 @Column(length=1)
			 @Enumerated(EnumType.STRING)
			 protected CheckinTypeCode checkinTypeCode;
			 
			 public String getCheckinDeskRange() {
				 return checkinDeskRange;
			 }
			
			 public void setCheckinDeskRange(String checkinDeskRange) {
				 this.checkinDeskRange = checkinDeskRange;
			 }
			
			 public CheckinRole getCheckinRole() {
				 return checkinRole;
			 }
			
			 public void setCheckinRole(CheckinRole checkinRole) {
				 this.checkinRole = checkinRole;
			 }
			
			 public CheckinTypeCode getCheckinTypeCode() {
				 return checkinTypeCode;
			 }
			
			 public void setCheckinTypeCode(CheckinTypeCode checkinTypeCode) {
				 this.checkinTypeCode = checkinTypeCode;
			 }
			 
			 
		 }
		 
		 /**
		  * TypeName      BasicFlight.AirportData.Gate
		  * @Description  登机口实体类的基类 
		  */
		 @MappedSuperclass
		 public static class Gate extends IntIdEntity{
			 /**
			  * 各个数据字段名,用来调用点用字段名
			  */	
 			 public static final  String  GATENUMBER  = "gateNumber"; 
 			 public static final  String  GATEROLE    = "gateRole"; 
			 /**
			  *   登机口 
			  */
			 @Column(length=4)
			 protected String gateNumber;
			 /**
			  *   登机口规则
			  */
			 @Column(length=10)
			 @Enumerated(EnumType.STRING)
			 protected GateRole gateRole;
			 
			 public String getGateNumber() {
				 return gateNumber;
			 }
			
			 public void setGateNumber(String gateNumber) {
				 this.gateNumber = gateNumber;
			 }
			
			 public GateRole getGateRole() {
				 return gateRole;
			 }
			
			 public void setGateRole(GateRole gateRole) {
				 this.gateRole = gateRole;
			 }
			 
			 
		 }
	
	
	/**
	 * @Description  航线数据的静态类，与航线数据相关的数据集合
	 * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String DEPARTUREAIRROUTEDISTANCE            = "departureAirRouteDistance";
		public static final  String ARRIVALAIRROUTEDISTANCE              = "arrivalAirRouteDistance";
		public static final  String FIRSTSTATION                         = "firstStation";
		public static final  String DESTINATIONSTATION                   = "destinationStation";
		public static final  String FIRSTSTATIONSCHEDULEDAIRBORNETIME    = "firstStationScheduledAirborneTime";
		public static final  String DESTINATIONSTATIONSCHEDULEDLANDTIME  = "destinationStationScheduledLandTime";
		public static final  String AIRROUTE                             = "airRoute";
		public static final  String FLIGHTROUTE                          = "flightRoute";
		public static final  String STOPFLIGHTS                          = "stopFlights";
		
		/**
		 *  航路
		 */
		@Column(length=64)
		protected String  airRoute;
		/**
		 * 航线的距离
		 */
		protected Integer airRouteDistance;
		
		
		/**
		 * 起始机场
		 */
		@ManyToOne
		protected Airport firstStation;
		/**
		 * 最终机场
		 */
		@ManyToOne
		protected Airport destinationStation;
		/**
		 * 起始机场计划起飞时间
		 */
		@Column(length=6)
		protected String firstStationScheduledAirborneTime;	
		/**
		 * 终端机场计划落地时间
		 */
		@Column(length=6)
		protected String destinationStationScheduledLandTime;
		/**
		 * 对应的航线
		 */
		@ManyToOne
		protected FlightRoute flightRoute;
		
		

		/**
		 * @return the airRoute
		 */
		public String getAirRoute() {
			return airRoute;
		}

		/**
		 * @param airRoute the airRoute to set
		 */
		public void setAirRoute(String airRoute) {
			this.airRoute = airRoute;
		}

		/**
		 * @return the airRouteDistance
		 */
		public Integer getAirRouteDistance() {
			return airRouteDistance;
		}

		/**
		 * @param airRouteDistance the airRouteDistance to set
		 */
		public void setAirRouteDistance(Integer airRouteDistance) {
			this.airRouteDistance = airRouteDistance;
		}

		/**
		 * @return the firstStation
		 */
		public Airport getFirstStation() {
			return firstStation;
		}

		/**
		 * @param firstStation the firstStation to set
		 */
		public void setFirstStation(Airport firstStation) {
			this.firstStation = firstStation;
		}

		/**
		 * @return the destinationStation
		 */
		public Airport getDestinationStation() {
			return destinationStation;
		}

		/**
		 * @param destinationStation the destinationStation to set
		 */
		public void setDestinationStation(Airport destinationStation) {
			this.destinationStation = destinationStation;
		}

		/**
		 * @return the firstStationScheduledAirborneTime
		 */
		public String getFirstStationScheduledAirborneTime() {
			return firstStationScheduledAirborneTime;
		}

		/**
		 * @param firstStationScheduledAirborneTime the firstStationScheduledAirborneTime to set
		 */
		public void setFirstStationScheduledAirborneTime(String firstStationScheduledAirborneTime) {
			this.firstStationScheduledAirborneTime = firstStationScheduledAirborneTime;
		}

		/**
		 * @return the destinationStationScheduledLandTime
		 */
		public String getDestinationStationScheduledLandTime() {
			return destinationStationScheduledLandTime;
		}

		/**
		 * @param destinationStationScheduledLandTime the destinationStationScheduledLandTime to set
		 */
		public void setDestinationStationScheduledLandTime(String destinationStationScheduledLandTime) {
			this.destinationStationScheduledLandTime = destinationStationScheduledLandTime;
		}

		/**
		 * @return the flightRoute
		 */
		public FlightRoute getFlightRoute() {
			return flightRoute;
		}

		/**
		 * @param flightRoute the flightRoute to set
		 */
		public void setFlightRoute(FlightRoute flightRoute) {
			this.flightRoute = flightRoute;
		}

		/**
		 * 经停航班集合的返回方法，添加集合用Add方法
		 * @return
		 */
		public abstract Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.StopFlight> getStopFlights();

		/*
		 * 经停航班集合的设置
		 */
		public abstract void  setStopFlights(Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.StopFlight> stops);
		
		/**
		 * TypeName      BasicFlight.RouteData.StopFlight
		 * @Description  航班经停点的实体类基类
		 */
		@MappedSuperclass
		public static class StopFlight extends IntIdEntity {
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			public static final  String  STOPAIRPORT           = "stopAirport";
			public static final  String  SCHEDULEDLANDTIME     = "scheduledLandTime";
			public static final  String  SCHEDULEDAIRBORNETIME = "scheduledAirborneTime";
			public static final  String  ORDERCODE             = "orderCode";
			/**
			 * 经停航班
			 */
			@ManyToOne
			private Airport stopAirport;
			/**
			 *  计划落地的时间
			 */
			@Column(length=6)
			private String scheduledLandTime;
			/**
			 * 计划起飞的时间
			 */
			@Column(length=6)
			private String scheduledAirborneTime;
			/**
			 * 序号
			 */
			private Integer orderCode;

			public Airport getStopAirport() {
				return stopAirport;
			}

			public void setStopAirport(Airport stopAirport) {
				this.stopAirport = stopAirport;
			}

			public String getScheduledLandTime() {
				return scheduledLandTime;
			}

			public void setScheduledLandTime(String scheduledLandTime) {
				this.scheduledLandTime = scheduledLandTime;
			}

			public String getScheduledAirborneTime() {
				return scheduledAirborneTime;
			}

			public void setScheduledAirborneTime(String scheduledAirborneTime) {
				this.scheduledAirborneTime = scheduledAirborneTime;
			}

			public Integer getOrderCode() {
				return orderCode;
			}

			public void setOrderCode(Integer orderCode) {
				this.orderCode = orderCode;
			}
		}

		
	/**
	 * @Description  航班时间相关的静态类，所有操作时间的集合
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	 */
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final   String  ESTIMATEDFLIGHTDURATION =  "estimatedFlightDuration";
		
		/**
		 * 预计飞行时间
		 */
		@Column(length=6)
		protected String estimatedFlightDuration;

		public String getEstimatedFlightDuration() {
			return estimatedFlightDuration;
		}

		public void setEstimatedFlightDuration(String estimatedFlightDuration) {
			
			this.estimatedFlightDuration = estimatedFlightDuration;
		}		
		
		
    /**
     * 返回航线的中文		
     * @return
     */
	public String getChineseRoute(){
		String route = "";
		if (firstStation != null){
			route = firstStation.getChineseName();
		}
		
		for(StopFlight stop:getStopFlights()){
			if (stop.getStopAirport() != null){
				route += "-"+stop.getStopAirport().getChineseName();
			}
		}
		
		if (destinationStation != null){
			route += "-" + destinationStation.getChineseName();
		}
		return route;
	}
	
	public String getiATARoute(){
		String route = "";
		if (firstStation != null){
			route = firstStation.getIATACode();
		}
		
		for(StopFlight stop:getStopFlights()){
			if (stop.getStopAirport() != null){
				route += "-"+stop.getStopAirport().getIATACode();
			}
		}
		
		if (destinationStation != null){
			route += "-" + destinationStation.getIATACode();
		}
		return route;
	}
	
	public String getShortRoute(){
		String route = "";
		if (firstStation != null){
			route = firstStation.getShortName();
		}
		
		for(StopFlight stop:getStopFlights()){
			if (stop.getStopAirport() != null){
				route += "-"+stop.getStopAirport().getShortName();
			}
		}
		
		if (destinationStation != null){
			route += "-" + destinationStation.getShortName();
		}
		return route;
	}

	
}
