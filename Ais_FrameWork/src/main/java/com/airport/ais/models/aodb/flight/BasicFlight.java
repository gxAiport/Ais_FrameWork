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
 * @Description  TODO ����ʵ����Ļ��࣬�����������������ݵļ���
 * �����������ڲ��ࣺ
 * һ����������������ݵļ��ϣ�����Ϊ����ʵ���һ���֣���@Embeddedע�⣬��Static�ؼ��֣�Ϊ��̬�࣬��ܲ������ɶ���ı�
 *  1��BasicFlight.FlightIdentification 
 *  2��BasicFlight.AircraftData
 *  3��BasicFlight.FlightData
 *  4��BasicFlight.RouteData
 *  5��BasicFlight.OperationalTimes
 *  6��BasicFlight.FlightData.LinkedFlight
 *  �����뺽����ص�ʵ���һ����һ�Զ࣬��@OneToManyע�⣬���ɶ����ʵ���
 *  1��BasicFlight.FlightData.ShareFlight
 *  2��BasicFlight.RouteData.StopFlight
 *
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��17��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��17��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@SuppressWarnings("serial")
@MappedSuperclass
public  abstract class BasicFlight extends IntIdEntity {
	
	/**
	 * @Description  �����ʶ��Ϣ�ľ�̬�࣬��Ψһ��ʶһ������
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
	
		/**
		 * ���������ֶ���,�������õ����ֶ���
		 */	
		public static final  String    FLIGHTNUMBER     = "flightNumber";
		public static final  String    FLIGHTDIRECTION  = "flightDirection";
		public static final  String    AIRLINE          = "airline";
		/**
		 * �����
		 */
		@Column(length=8)
		protected String flightNumber;
		/**
		 * �����۱�ʶ
		 */
		@Column(length=10)
		@Enumerated(EnumType.STRING)
		protected FlightDirection flightDirection;
		/**
		 * ���չ�˾
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
	 * @Description  �ɻ����ݵľ�̬�࣬��ɻ�������ص����ݼ���
	 * -------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	 */
		/**
		 * ���������ֶ���,�������õ����ֶ���
		 */	
		public static final  String AIRCRAFTSUBTYPE = "aircraftSubtype";
		
		/**
		 * ����
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
	 * @Description  �������ݵľ�̬�࣬�뺽����ص�����
	 * ---------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
		/**
		 * ���������ֶ���,�������õ����ֶ���
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
		 *  ƴ�Ӻ����
		 */
		@Column(length=17)
		protected String joinFlightNumber;
		/**
		 * ������࣬���� W/Z
		 */
		@ManyToOne
		protected FlightClassification flightClassification;
		/**
		 * �������ʣ�����PAX 
		 */
		@ManyToOne
		protected FlightNature flightNature;
		/**
		 * ����������ʣ�����J
		 */
		@ManyToOne
		protected FlightServiceType flightServiceType;
		
		/**
		 * ����������ڹ���
		 */
		@ManyToOne
		protected Sector sector;
		
		/**
		 * ���ۻ���
		 */
		@ManyToOne
		protected Airport departureAirport;
		/**
		 * �������
		 */
		@ManyToOne
		protected Airport arrivalAirport;
		
		/**
		 * ��������־
		 */
		protected Boolean isOperatesOvernight;
		/**
		 * ��ǰ�����־
		 */
		protected Boolean isBeforeFlight;
		/**
		 * ͨ�������־
		 */
		protected Boolean isGeneralAviationFlight;
		/**
		 *  ��ת�����־
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
		 * �����༯�ϵķ��ط�������Ӽ�����Add����
		 * @return
		 */
		public abstract Set<? extends  com.airport.ais.models.aodb.flight.BasicFlight.ShareFlight> getShareFlights();

		/**
		 * ���ù�����
		 * @param shareFlights
		 */
		public abstract void setShareFlights(Set<? extends  com.airport.ais.models.aodb.flight.BasicFlight.ShareFlight>  shareFlights);
		/**
		 * 
		 * TypeName      BasicFlight.FlightData.ShareFlight
		 * @Description  ������ʵ����Ļ���
		 * 
		 */
		@MappedSuperclass
		public static class ShareFlight extends IntIdEntity {
			/**
			 * ���������ֶ���,�������õ����ֶ���
			 */	
			public static final  String SHAREFLIGHTNUMBER = "shareFlightNumber";
			public static final  String SHAREAIRLINE      = "shareAirline";

			/**
			 * �������
			 */
			@Column(length=8)
			protected String shareFlightNumber;
			/**
			 * �����չ�˾
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
		 * @Description  ���Ӻ���ľ�̬���� 
		 */
		@MappedSuperclass
		public  static class LinkedFlight implements Serializable{
			/**
			 * ���������ֶ���,�������õ����ֶ���
			 */	
			public static final  String  LINKEDFLIGHTNUMBER      = "linkedFlightNumber";
			public static final  String  LINKEDFLIGHTDIRECTION   = "linkedFlightDirection";
			
			
			 /**
			  * ���Ӻ����
			  */
			 @Column(length=8)
			 protected String linkedFlightNumber;
			 /**
			  * �����۱�ʶ
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
	 * @Description  �������ݵľ�̬�࣬�������ص����ݼ���
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
		
		/**
		 * ���������ֶ���,�������õ����ֶ���
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
		 *  ���ػ���
		 */
		@ManyToOne
		protected Airport localAirpot; 
		/**
		 * ��վ¥
		 */
		@ManyToOne
		protected Terminal terminal;
		/**
		 * ͣ��λ
		 */
		@ManyToOne
		protected Stand stand;
		/**
		 * �ܵ�
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
		 * ����װ��ת�̼��ϵķ��ط�������Ӽ�����Add�ķ���
		 * @return
		 */
		public abstract Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.BaggageMakeupPosition> getBaggageMakeupPositions();

		/**
		 * ��������ּ�ת�̵ķ���
		 * @param baggageMakeupPositions
		 */
		public abstract void setBaggageMakeupPositions(Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.BaggageMakeupPosition> baggageMakeupPositions);
		
		/**
		 * ��������ת�̼��ϵķ��ط�������Ӽ�����Add�ķ���
		 * @return
		 */
		public abstract Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.BaggageReclaimCarousel> getBaggageReclaimCarousels();
		
		/**
		 * ����������ȡת�̵ķ���
		 * @param baggageReclaimCarousels
		 */
		public abstract void setBaggageReclaimCarousels(Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.BaggageReclaimCarousel> baggageReclaimCarousels);
		/**
		 * ֵ����̨���ϵķ��ط�������Ӽ�����Add�ķ���
		 * @return
		 */
		public abstract Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.Checkin> getCheckins();
		
		/**
		 * ����ֵ����̨�ķ���
		 * @param 
		 */
		public abstract void setCheckins(Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.Checkin> checkins);
		
		
		/**
		 * �ǻ��ڼ��ϵķ��ط�������Ӽ�����Add�ķ���
		 * @return
		 */
		public abstract Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.Gate> getGates();
		
		/**
		 * ���õǻ��ڵķ���
		 * @param gates
		 */
		public abstract void setGates(Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.Gate> gates);
		
		/**
		  * TypeName      BasicFlight.AirportData.BaggageMakeupPosition
		  * @Description  ����װ��ת��ʵ����Ļ��� 
		  */
		 @MappedSuperclass
		 public static class BaggageMakeupPosition extends IntIdEntity {
			 
			/**
			 * ���������ֶ���,�������õ����ֶ���
			 */	
			public static final  String BAGGAGEMAKEUPPOSITIONID   = "baggageMakeupPositionID";
			public static final  String BAGGAGEMAKEUPPOSITIONROLE = "baggageMakeupPositionRole";
				
			 /**
			  * ����װ��ת�̱��
			  */
			 @Column(length=4)
			 protected String  baggageMakeupPositionID;
			 /**
			  *  ����ת��ת�̹���
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
		  * @Description  ��������ת��ʵ����Ļ���
		  */
		 @MappedSuperclass
		 public  static class BaggageReclaimCarousel extends IntIdEntity {
			 
			 /**
			  * ���������ֶ���,�������õ����ֶ���
			  */	
			public static final  String BAGGAGERECLAIMCAROUSELID   = "baggageReclaimCarouselID";
			public static final  String BAGGAGERECLAIMCAROUSELROLE = "baggageReclaimCarouselRole";
			 /**
			  *  ��������ת�̱��
			  */
			 @Column(length=4)
			 protected String baggageReclaimCarouselID;
			 /**
			  * ��������ת�̹���
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
		  * @Description  ֵ��ʵ����Ļ���
		  */
		 @MappedSuperclass
		 public static class Checkin extends IntIdEntity{
			/**
			 * ���������ֶ���,�������õ����ֶ���
			 */	
			public static final  String CHECKINDESKRANGE = "checkinDeskRange";
			public static final  String CHECKINROLE      = "checkinRole";
			public static final  String CHECKINTYPECODE  = "checkinTypeCode";
			
			 /**
			  *  ֵ����̨��ŷ�Χ������15-17
			  */
			 @Column(length=20)
			 protected String checkinDeskRange;
			 /**
			  *  ֵ������
			  */
			 @Column(length=10)
			 @Enumerated(EnumType.STRING)
			 protected CheckinRole checkinRole;  
			 /**
			  *  ֵ�����ʹ���
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
		  * @Description  �ǻ���ʵ����Ļ��� 
		  */
		 @MappedSuperclass
		 public static class Gate extends IntIdEntity{
			 /**
			  * ���������ֶ���,�������õ����ֶ���
			  */	
 			 public static final  String  GATENUMBER  = "gateNumber"; 
 			 public static final  String  GATEROLE    = "gateRole"; 
			 /**
			  *   �ǻ��� 
			  */
			 @Column(length=4)
			 protected String gateNumber;
			 /**
			  *   �ǻ��ڹ���
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
	 * @Description  �������ݵľ�̬�࣬�뺽��������ص����ݼ���
	 * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
		/**
		 * ���������ֶ���,�������õ����ֶ���
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
		 *  ��·
		 */
		@Column(length=64)
		protected String  airRoute;
		/**
		 * ���ߵľ���
		 */
		protected Integer airRouteDistance;
		
		
		/**
		 * ��ʼ����
		 */
		@ManyToOne
		protected Airport firstStation;
		/**
		 * ���ջ���
		 */
		@ManyToOne
		protected Airport destinationStation;
		/**
		 * ��ʼ�����ƻ����ʱ��
		 */
		@Column(length=6)
		protected String firstStationScheduledAirborneTime;	
		/**
		 * �ն˻����ƻ����ʱ��
		 */
		@Column(length=6)
		protected String destinationStationScheduledLandTime;
		/**
		 * ��Ӧ�ĺ���
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
		 * ��ͣ���༯�ϵķ��ط�������Ӽ�����Add����
		 * @return
		 */
		public abstract Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.StopFlight> getStopFlights();

		/*
		 * ��ͣ���༯�ϵ�����
		 */
		public abstract void  setStopFlights(Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.StopFlight> stops);
		
		/**
		 * TypeName      BasicFlight.RouteData.StopFlight
		 * @Description  ���ྭͣ���ʵ�������
		 */
		@MappedSuperclass
		public static class StopFlight extends IntIdEntity {
			/**
			 * ���������ֶ���,�������õ����ֶ���
			 */	
			public static final  String  STOPAIRPORT           = "stopAirport";
			public static final  String  SCHEDULEDLANDTIME     = "scheduledLandTime";
			public static final  String  SCHEDULEDAIRBORNETIME = "scheduledAirborneTime";
			public static final  String  ORDERCODE             = "orderCode";
			/**
			 * ��ͣ����
			 */
			@ManyToOne
			private Airport stopAirport;
			/**
			 *  �ƻ���ص�ʱ��
			 */
			@Column(length=6)
			private String scheduledLandTime;
			/**
			 * �ƻ���ɵ�ʱ��
			 */
			@Column(length=6)
			private String scheduledAirborneTime;
			/**
			 * ���
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
	 * @Description  ����ʱ����صľ�̬�࣬���в���ʱ��ļ���
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	 */
		/**
		 * ���������ֶ���,�������õ����ֶ���
		 */	
		public static final   String  ESTIMATEDFLIGHTDURATION =  "estimatedFlightDuration";
		
		/**
		 * Ԥ�Ʒ���ʱ��
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
     * ���غ��ߵ�����		
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
