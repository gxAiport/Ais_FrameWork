package com.airport.ais.models.aodb.flight;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import org.springframework.format.annotation.DateTimeFormat;
import com.airport.ais.enums.aodb.GateBoardingStatus;
import com.airport.ais.enums.aodb.PassagerCardLevel;
import com.airport.ais.models.IntIdEntity;
import com.airport.ais.models.aodb.basic.Airport;
import com.airport.ais.models.aodb.basic.Aircraft;
import com.airport.ais.models.aodb.basic.CAACDelayCategory;
import com.airport.ais.models.aodb.basic.CAACDelayCode;
import com.airport.ais.models.aodb.basic.Carrier;
import com.airport.ais.models.aodb.basic.FlightCode;
import com.airport.ais.models.aodb.basic.FlightStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * FileName      Flight.java
 * @Description  运营航班的基类继承 BasicFlight,添加运营航班所需的数据字段。
 * 1、对静态数据集合类继承以便进一步的扩充字段
 * 2、添加一个静态数据集合类Load
 * 3、添加两个实体表
 * 3.1 Flight.Load.LoadFlight
 * 3.2 Flight.Load.Passenger
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
public  abstract class Flight extends BasicFlight {
	
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	

	
	/**
	 * @Description  航班标识信息的静态类，能唯一标识一个航班
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
		public static final  String    SCHEDULEDDATETIME     =    "scheduledDateTime";
		public static final  String    FLIGHTREPEATCOUNT     =    "flightRepeatCount";		
		/**
		 * 执行日期
		 */
		protected Date scheduledDateTime;
		
		/**
		 *  航班重复次数，一般指返场
		 */
		protected Integer flightRepeatCount;
		
		
		@DateTimeFormat(pattern="yyyy-MM-dd")  
		@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  
		public Date getScheduledDateTime() {
			return scheduledDateTime;
		}

		public void setScheduledDateTime(Date scheduledDateTime) {
			this.scheduledDateTime = scheduledDateTime;
		}
		
		public Integer getFlightRepeatCount() {
			return flightRepeatCount;
		}
		
		public void setFlightRepeatCount(Integer flightRepeatCount) {
			this.flightRepeatCount = flightRepeatCount;
		}
		
	
	
	
	/**
	 * @Description  飞机数据的静态类，与飞机数据相关的数据集合
	 * -------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	 */
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String 	AIRCRAFT                   = "aircraft";
		public static final  String 	CARRIER                    = "carrier";
		public static final  String     SETTLEMENTWEIGHT           = "settlementWeight";	
		public static final  String     SETTLEMENTLOAD             = "settlementPayload";		
		public static final  String     MAXIMUMPAYLOAD             = "maximumPayload";
		public static final  String     MAXIMUMPASSENGERCAPACITY   = "maximumPassengerCapacity";
		public static final  String     AVAILABLEPAYLOAD           = "availablePayload";
		public static final  String     AVAILABLEPASSENGERCAPACITY = "availablePassengerCapacity";

		
		/**
		 * 飞机
		 */
		@ManyToOne
		protected Aircraft aircraft;
		/**
		 * 承运人
		 */
		@ManyToOne
		protected Carrier carrier;
		/**
		 * 飞机的重量,用于结算系统
		 */
		protected Integer settlementWeight;
		/**
		 * 结算业载，用于结算
		 */
		protected Integer settlementPayload;
		
		/**
		 * 最大业载，用于统计系统
		 */
		protected Integer maximumPayload;
		/**
		 * 最大座位数，用于统计系统
		 */
		protected Integer  maximumPassengerCapacity;
		/**
		 * 可用业载，用于统计系统
		 */
		protected Integer availablePayload;
		/**
		 * 可用座位数，用于统计系统
		 */
		protected Integer availablePassengerCapacity;
		
		public Aircraft getAircraft() {
			return aircraft;
		}
		
		public void setAircraft(Aircraft aircraft) {
			this.aircraft = aircraft;
		}
		
		public Carrier getCarrier() {
			return carrier;
		}
		
		public void setCarrier(Carrier carrier) {
			this.carrier = carrier;
		}

		public Integer getSettlementWeight() {
			return settlementWeight;
		}

		public void setSettlementWeight(Integer settlementWeight) {
			this.settlementWeight = settlementWeight;
		}

		public Integer getSettlementPayload() {
			return settlementPayload;
		}

		public void setSettlementPayload(Integer settlementPayload) {
			this.settlementPayload = settlementPayload;
		}

		public Integer getMaximumPayload() {
			return maximumPayload;
		}

		public void setMaximumPayload(Integer maximumPayload) {
			this.maximumPayload = maximumPayload;
		}

		public Integer getMaximumPassengerCapacity() {
			return maximumPassengerCapacity;
		}

		public void setMaximumPassengerCapacity(Integer maximumPassengerCapacity) {
			this.maximumPassengerCapacity = maximumPassengerCapacity;
		}

		public Integer getAvailablePayload() {
			return availablePayload;
		}

		public void setAvailablePayload(Integer availablePayload) {
			this.availablePayload = availablePayload;
		}

		public Integer getAvailablePassengerCapacity() {
			return availablePassengerCapacity;
		}

		public void setAvailablePassengerCapacity(Integer availablePassengerCapacity) {
			this.availablePassengerCapacity = availablePassengerCapacity;
		}		
		
	
	/**
	 * @Description  航班数据的静态类，与航班相关的数据
	 *---------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String  FLIGHTSTATUS                =   "flightStatus";
		public static final  String  DIVERTAIRPORT               =   "divertAirport";
		public static final  String  ISRETURNFLIGHT              =   "isReturnFlight";
		public static final  String  HASVIPS                     =   "hasVIPs";
		public static final  String  FLIGHTCODE                  =   "flightCode";
		public static final  String  CAACDELAYCATEGORY           =   "caacDelayCategory";
		public static final  String  CAACDELAYCODE               =   "caacDelayCode";
		public static final  String  CAACDELAYDURATION           =   "caacDelayDuration";
		public static final  String  CAACDELAYAIRPORTORIGINATED  =   "caacDelayAirportOriginated";

		
		/**
		 * 航班状态
		 */
		@ManyToOne
		protected FlightStatus flightStatus;
		/**
		 * 备降机场
		 */
		@ManyToOne
		protected Airport divertAirport;
		/**
		 * 航班航班标识
		 */
		protected Boolean isReturnFlight;
		/**
		 * 是否有VIP
		 */
		protected Boolean hasVIPs;
		/**
		 * 航班代码
		 */
		@ManyToOne
		protected FlightCode flightCode;
		/**
		 * 延误类别
		 */
		@ManyToOne
	    protected CAACDelayCategory caacDelayCategory;
	    /**
	     * 延误代码
	     */
		@ManyToOne
	    protected CAACDelayCode caacDelayCode;
	    /**
	     * 延误时间
	     */
		@Column(length=6)
	    protected String caacDelayDuration;
	    /**
	     * 是否是始发延误原因
	     */
	    protected Boolean caacDelayAirportOriginated;
		/**
		 * 连接航班
		 */
		@Embedded
		protected LinkedFlight linkedFlight;
		
		public FlightStatus getFlightStatus() {
			return flightStatus;
		}

		public void setFlightStatus(FlightStatus flightStatus) {
			this.flightStatus = flightStatus;
		}
		
		public Airport getDivertAirport() {
			return divertAirport;
		}
		
		public void setDivertAirport(Airport divertAirport) {
			this.divertAirport = divertAirport;
		}
		
		public Boolean getIsReturnFlight() {
			return isReturnFlight;
		}
		
		public void setIsReturnFlight(Boolean isReturnFlight) {
			this.isReturnFlight = isReturnFlight;
		}
		
		public Boolean getHasVIPs() {
			return hasVIPs;
		}
		
		public void setHasVIPs(Boolean hasVIPs) {
			this.hasVIPs = hasVIPs;
		}
		
		public FlightCode getFlightCode() {
			return flightCode;
		}
		
		public void setFlightCode(FlightCode flightCode) {
			this.flightCode = flightCode;
		}

		public LinkedFlight getLinkedFlight() {
			return linkedFlight;
		}
		
		public void setLinkedFlight(LinkedFlight linkedFlight) {
			this.linkedFlight = linkedFlight;
		}
			
		    
		public CAACDelayCategory getCaacDelayCategory() {
				
			return caacDelayCategory;
		}
			
		public void setCaacDelayCategory(CAACDelayCategory caacDelayCategory) {
			this.caacDelayCategory = caacDelayCategory;
		}
			
		public CAACDelayCode getCaacDelayCode() {
			return caacDelayCode;
		}
			
		public void setCaacDelayCode(CAACDelayCode caacDelayCode) {
			this.caacDelayCode = caacDelayCode;
		}
			
		public String getCaacDelayDuration() {
			return caacDelayDuration;
		}
			
		public void setCaacDelayDuration(String caacDelayDuration) {
			this.caacDelayDuration = caacDelayDuration;
		}
			
		public Boolean getCaacDelayAirportOriginated() {
			return caacDelayAirportOriginated;
		}
			
		public void setCaacDelayAirportOriginated(Boolean caacDelayAirportOriginated) {
			this.caacDelayAirportOriginated = caacDelayAirportOriginated;
		}
		/**
		 * 
		 * TypeName      Flight.FlightData.LinkedFlight
		 * @Description  继承 BasicFlight.FlightData.LinkedFlight
		 * 增加字段: 
		 */
		public static class LinkedFlight extends BasicFlight.LinkedFlight{
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			public static final  String    LINKEDSCHEDULEDDATETIME =  "linkedscheduledDateTime";
			 
			
			/**
			 *  连接航班日期
			 */
			protected Date linkedscheduledDateTime;

			public Date getLinkedscheduledDateTime() {
				return linkedscheduledDateTime;
			}

			public void setLinkedscheduledDateTime(Date linkedscheduledDateTime) {
				this.linkedscheduledDateTime = linkedscheduledDateTime;
			}
			
		}
		
		
	
	/**
	 * @Description  航班时间相关的静态类，所有操作时间的集合
	 * 注：备降时间也更新在正常起降时间中
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	 */
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */
		public static final  String EXECDATETIME                    = "execDateTime";
		public static final  String ACTUALOFFBLOCKSDATETIME         = "actualOffBlocksDateTime";
		public static final  String ACTUALONBLOCKSDATETIME          = "actualOnBlocksDateTime";
		public static final  String SCHEDULEDDEPARTUREDATETIME      = "scheduledDepartureDateTime";
		public static final  String ESTIMATEDDEPARTUREDATETIME      = "estimatedDepartureDateTime";
		public static final  String ACTUALAIRBORNEDATETIME          = "actualAirborneDateTime";
		public static final  String SCHEDULEDARRIVALDATETIME        = "scheduledArrivalDateTime";
		public static final  String ESTIMATEDARRIVALDATETIME        = "estimatedArrivalDateTime";
		public static final  String ACTUALLANDDATETIME              = "actualLandDateTime";
		
		
		
		
		/**
		 * 实际停到停机位的时间
		 */
		protected Date actualOffBlocksDateTime;
		/**
		 * 实际停到停机位的时间
		 */
		protected Date actualOnBlocksDateTime;
		
		/**
		 *  计划出发的时间
		 */
		protected Date scheduledDepartureDateTime;
		/**
		 * 预计出发的时间
		 */
		protected Date estimatedDepartureDateTime;
		/**
		 * 实际起飞的时间
		 */
		protected Date actualAirborneDateTime;
		/**
		 *  计划到达的时间
		 */
		protected Date scheduledArrivalDateTime;
		/**
		 * 预计到达的时间
		 */
		protected Date estimatedArrivalDateTime;
		/**
		 * 实际落地的时间
		 */
		protected Date actualLandDateTime;
		
		/**
		 * 执行日期
		 */
		protected Date execDateTime;
		
		@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  	
		public Date getActualOffBlocksDateTime() {
			return actualOffBlocksDateTime;
		}
		
		public void setActualOffBlocksDateTime(Date actualOffBlocksDateTime) {
			this.actualOffBlocksDateTime = actualOffBlocksDateTime;
		}
		
		@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  	
		public Date getActualOnBlocksDateTime() {
			return actualOnBlocksDateTime;
		}
		
		public void setActualOnBlocksDateTime(Date actualOnBlocksDateTime) {
			this.actualOnBlocksDateTime = actualOnBlocksDateTime;
		}
		
		
		@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  	
		public Date getActualAirborneDateTime() {
			return actualAirborneDateTime;
		}
		
		public void setActualAirborneDateTime(Date actualAirborneDateTime) {
			this.actualAirborneDateTime = actualAirborneDateTime;
		}
		
		
		
		@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  	
		public Date getActualLandDateTime() {
			return actualLandDateTime;
		}
		
		public void setActualLandDateTime(Date actualLandDateTime) {
			this.actualLandDateTime = actualLandDateTime;
		}

		@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  	
		public Date getScheduledDepartureDateTime() {
			return scheduledDepartureDateTime;
		}

		public void setScheduledDepartureDateTime(Date scheduledDepartureDateTime) {
			this.scheduledDepartureDateTime = scheduledDepartureDateTime;
		}

		@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  	
		public Date getEstimatedDepartureDateTime() {
			return estimatedDepartureDateTime;
		}

		public void setEstimatedDepartureDateTime(Date estimatedDepartureDateTime) {
			this.estimatedDepartureDateTime = estimatedDepartureDateTime;
		}

		@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  	
		public Date getScheduledArrivalDateTime() {
			return scheduledArrivalDateTime;
		}

		public void setScheduledArrivalDateTime(Date scheduledArrivalDateTime) {
			this.scheduledArrivalDateTime = scheduledArrivalDateTime;
		}

		@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  	
		public Date getEstimatedArrivalDateTime() {
			return estimatedArrivalDateTime;
		}
	
		public void setEstimatedArrivalDateTime(Date estimatedArrivalDateTime) {
			this.estimatedArrivalDateTime = estimatedArrivalDateTime;
		}
		
		@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  	
		public Date getExecDateTime() {
			return execDateTime;
		}

		public void setExecDateTime(Date execDateTime) {
			this.execDateTime = execDateTime;
		}




	/**
	 * @Description  机场数据的静态类，与机场相关的数据集合
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
		
		
		public static final  String ENSUERSERVCES               =  "ensuerServces";
		public static final  String CHARGE                      =  "charges";

		/**
		  * TypeName      Flight.AirportData.BaggageMakeupPosition
		  * @Description  继承BasicFlight.AirportData.BaggageMakeupPosition
		  */
		 @MappedSuperclass
		 public  static class BaggageMakeupPosition  extends BasicFlight.BaggageMakeupPosition {
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			 public static final String  BAGGAGEMAKEUPOPENDATETIME  = "baggageMakeupOpenDateTime";
			 public static final String  BAGGAGEMAKEUPCLOSEDATETIME = "baggageMakeupCloseDateTime";
			 /**
			  * 开启时间
			  */
			 protected Date baggageMakeupOpenDateTime;
			 /**
			  * 关闭时间
			  */
			 protected Date baggageMakeupCloseDateTime;
			 
			 public Date getBaggageMakeupOpenDateTime() {
				 return baggageMakeupOpenDateTime;
			 }
			 
			 public void setBaggageMakeupOpenDateTime(Date baggageMakeupOpenDateTime) {
				 this.baggageMakeupOpenDateTime = baggageMakeupOpenDateTime;
			 }
			 
			 public Date getBaggageMakeupCloseDateTime() {
				 return baggageMakeupCloseDateTime;
			 }
			 
			 public void setBaggageMakeupCloseDateTime(Date baggageMakeupCloseDateTime) {
				 this.baggageMakeupCloseDateTime = baggageMakeupCloseDateTime;
			 }
			 
			 
		 }
		 /**
		  * 
		  * TypeName      Flight.AirportData.BaggageReclaimCarousel
		  * @Description  继承BasicFlight.AirportData.BaggageReclaimCarousel
		  */
		 @MappedSuperclass
		 public static class BaggageReclaimCarousel extends BasicFlight.BaggageReclaimCarousel{
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			 public static final String  BAGGAGERECLAIMOPENDATETIME  = "baggageReclaimOpenDateTime";
			 public static final String  BAGGAGERECLAIMCLOSEDATETIME = "baggageReclaimCloseDateTime";
			 public static final String  FIRSTBAGDATETIME            = "firstBagDateTime";
			 public static final String  LASTBAGDATETIME             = "lastBagDateTime";
			 public static final String  EXITDOORNUMBER              = "exitDoorNumber";
			 
			 /**
			  * 开启时间
			  */
			 protected Date baggageReclaimOpenDateTime;
			 /**
			  * 关闭时间
			  */
			 protected Date baggageReclaimCloseDateTime;
			 /**
			  * 开启时间
			  */
			 protected Date firstBagDateTime;
			 /**
			  * 关闭时间
			  */
			 protected Date lastBagDateTime;
			 /**
			  * 出口标识
			  */
			 @Column(length=4)
			 protected String exitDoorNumber;
			 
			 public Date getBaggageReclaimOpenDateTime() {
				 return baggageReclaimOpenDateTime;
			 }
			 
			 public void setBaggageReclaimOpenDateTime(Date baggageReclaimOpenDateTime) {
				 this.baggageReclaimOpenDateTime = baggageReclaimOpenDateTime;
			 }
			 
			 public Date getBaggageReclaimCloseDateTime() {
				 return baggageReclaimCloseDateTime;
			 }
			 
			 public void setBaggageReclaimCloseDateTime(Date baggageReclaimCloseDateTime) {
				 this.baggageReclaimCloseDateTime = baggageReclaimCloseDateTime;
			 }
			 
			 public Date getFirstBagDateTime() {
				 return firstBagDateTime;
			 }
			 
			 public void setFirstBagDateTime(Date firstBagDateTime) {
				 this.firstBagDateTime = firstBagDateTime;
			 }
			 
			 public Date getLastBagDateTime() {
				 return lastBagDateTime;
			 }
			 
			 public void setLastBagDateTime(Date lastBagDateTime) {
				 this.lastBagDateTime = lastBagDateTime;
			 }
			 
			 public String getExitDoorNumber() {
				 return exitDoorNumber;
			 }
			 
			 public void setExitDoorNumber(String exitDoorNumber) {
				 this.exitDoorNumber = exitDoorNumber;
			 }
			 
			 
		 }
		 /**
		  * TypeName      Flight.AirportData.Checkin
		  * @Description  继承BasicFlight.AirportData.Checkin
		  */
		 @MappedSuperclass
		 public static class Checkin extends BasicFlight.Checkin{
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			 public static final String  CHECKINOPENDATETIME  = "checkinOpenDateTime";
			 public static final String  CHECKINCLOSEDATETIME = "checkinCloseDateTime";
			 
			 /**
			  *  值机开始时间
			  */
			 protected Date checkinOpenDateTime; 
			 /**
			  *  值机结束时间
			  */
			 protected Date checkinCloseDateTime;
			 
			 public Date getCheckinOpenDateTime() {
				 return checkinOpenDateTime;
			 }
			 
			 public void setCheckinOpenDateTime(Date checkinOpenDateTime) {
				 this.checkinOpenDateTime = checkinOpenDateTime;
			 }
			 
			 public Date getCheckinCloseDateTime() {
				 return checkinCloseDateTime;
			 }
			 
			 public void setCheckinCloseDateTime(Date checkinCloseDateTime) {
				 this.checkinCloseDateTime = checkinCloseDateTime;
			 }
			 
			 
		 }
		 /**
		  * TypeName      Flight.AirportData.Checkin
		  * @Description  继承BasicFlight.AirportData.Checkin
		  */
		 @MappedSuperclass
		 public static class Gate extends BasicFlight.Gate{
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			 public static final String   GATEOPENDATETIME   = "gateOpenDateTime";
			 public static final String   GATECLOSEDATETIME  = "gateCloseDateTime";
			 public static final String   GATEBOARDINGSTATUS = "gateBoardingStatus";
			 
			 /**
			  * 登机开放的时间
			  */
			 protected Date gateOpenDateTime;
			 /**
			  * 登机结束的时间
			  */
			 protected Date gateCloseDateTime;
			 /**
			  * 登机状态
			  */
			 @Enumerated(EnumType.STRING)
			 protected GateBoardingStatus gateBoardingStatus;
			 
			 public Date getGateOpenDateTime() {
				 return gateOpenDateTime;
			 }
			 
			 public void setGateOpenDateTime(Date gateOpenDateTime) {
				 this.gateOpenDateTime = gateOpenDateTime;
			 }
			 
			 public Date getGateCloseDateTime() {
				 return gateCloseDateTime;
			 }
			 
			 public void setGateCloseDateTime(Date gateCloseDateTime) {
				 this.gateCloseDateTime = gateCloseDateTime;
			 }
			 
			 public GateBoardingStatus getGateBoardingStatus() {
				 return gateBoardingStatus;
			 }
			 
			 public void setGateBoardingStatus(GateBoardingStatus gateBoardingStatus) {
				 this.gateBoardingStatus = gateBoardingStatus;
			 }
			 
			 
		 }
	

	/**
	 * @Description  航班载量的静态类，与载量相关的所有数据的集合
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	 */
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String    PASSENGERLOADFACTOR     = "passengerLoadFactor";
		public static final  String    PASSENGERTONKILOMETERS  = "passengerTonkilometers";
		public static final  String    CARGOTONKILOMETERS      = "cargoTonkilometers";
		public static final  String    MAILTONKILOMETERS       = "mailTonkilometers";
		public static final  String    LOADS                   = "loads";
		public static final  String    PASSENGERS              = "passengers";
	
		
		/**
		 * 航班客座率
		 */
		protected Double passengerLoadFactor;
		/**
		 * 旅客周转量
		 */
		protected Integer passengerTonkilometers;
		/**
		 * 货物周转量
		 */
		protected Integer cargoTonkilometers;
		/**
		 * 邮件周转量
		 */
		protected Integer mailTonkilometers;
		
		
		
		
		public Double getPassengerLoadFactor() {
			return passengerLoadFactor;
		}

		public void setPassengerLoadFactor(Double passengerLoadFactor) {
			this.passengerLoadFactor = passengerLoadFactor;
		}

		public Integer getPassengerTonkilometers() {
			return passengerTonkilometers;
		}

		public void setPassengerTonkilometers(Integer passengerTonkilometers) {
			this.passengerTonkilometers = passengerTonkilometers;
		}

		public Integer getCargoTonkilometers() {
			return cargoTonkilometers;
		}

		public void setCargoTonkilometers(Integer cargoTonkilometers) {
			this.cargoTonkilometers = cargoTonkilometers;
		}

		public Integer getMailTonkilometers() {
			return mailTonkilometers;
		}

		public void setMailTonkilometers(Integer mailTonkilometers) {
			this.mailTonkilometers = mailTonkilometers;
		}

		/**
		 * 载量集合的返回方法，添加用ADD方法
		 * @return
		 */
		public  abstract Set<? extends com.airport.ais.models.aodb.flight.Flight.LoadFlight> getLoads(); 

		/**
		 * 设置载量的方法
		 * @param loadFlights
		 */
		public  abstract void setLoads(Set<? extends com.airport.ais.models.aodb.flight.Flight.LoadFlight> loads); 

		/**
		 * 旅客集合的放回方法，添加用ADD方法
		 * @return
		 */
		public  abstract Set<? extends com.airport.ais.models.aodb.flight.Flight.Passenger>  getPassengers();
		
		/**
		 * 设置旅客集合的方法
		 * @param passengers
		 */
		public  abstract void setPassengers(Set<? extends com.airport.ais.models.aodb.flight.Flight.Passenger> passengers); 
		

		/**
		 * TypeName      Flight.Load.LoadFlight
		 * @Description  航班载量的实体类
		 */
		
		@MappedSuperclass
		public abstract static class LoadFlight extends IntIdEntity {
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */				
			public static final String   FLIGHT               = "flight";
			public static final String   LOADDEPARTUREAIRPORT = "loadDepartureAirport";
			public static final String   LOADARRIVALAIRPORT   = "loadArrivalAirport";
			public static final String   ADULT                = "adult";
			public static final String   CHD                  = "chd";
			public static final String   INF                  = "inf";
			public static final String   CARGO                = "cargo";
			public static final String   MAIL                 = "mail";
			public static final String   BAGGAGE              = "baggage";
			
			/**
			 * 起始机场
			 */
			@ManyToOne
			protected Airport loadDepartureAirport; 
			/**
			 * 落地机场
			 */
			@ManyToOne
			protected Airport loadArrivalAirport;
			/**
			 *  成人
			 */
			protected Integer adult;
			/**
			 * 儿童
			 */
			protected Integer chd;
			/**
			 * 婴儿
			 */
			protected Integer inf;
			/**
			 * 货物
			 */
			protected Integer cargo;
			/**
			 * 邮件
			 */
			protected Integer mail;
			/**
			 * 行李
			 */
			protected Integer baggage;
			
			
			public abstract  Flight getFlight();

			public abstract void setFlight(Flight flight);
			
			public Airport getLoadDepartureAirport() {
				return loadDepartureAirport;
			}
			
			public void setLoadDepartureAirport(Airport loadDepartureAirport) {
				this.loadDepartureAirport = loadDepartureAirport;
			}
			
			public Airport getLoadArrivalAirport() {
				return loadArrivalAirport;
			}
			
			public void setLoadArrivalAirport(Airport loadArrivalAirport) {
				this.loadArrivalAirport = loadArrivalAirport;
			}
			
			public Integer getAdult() {
				return adult;
			}
			
			public void setAdult(Integer adult) {
				this.adult = adult;
			}
			
			public Integer getChd() {
				return chd;
			}
			
			public void setChd(Integer chd) {
				this.chd = chd;
			}
			
			public Integer getInf() {
				return inf;
			}
			
			public void setInf(Integer inf) {
				this.inf = inf;
			}
			
			public Integer getCargo() {
				return cargo;
			}
			
			public void setCargo(Integer cargo) {
				this.cargo = cargo;
			}
			
			public Integer getMail() {
				return mail;
			}
			
			public void setMail(Integer mail) {
				this.mail = mail;
			}
			
			public Integer getBaggage() {
				return baggage;
			}
			
			public void setBaggage(Integer baggage) {
				this.baggage = baggage;
			}

			
			
			
		}
		/**
		 * TypeName      Flight.Load.Passenger
		 * @Description  旅客名单的实体类
		 */
		@MappedSuperclass
		public static class Passenger extends IntIdEntity{
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */				
			public static final String   NAME         = "name";
			public static final String   TICKETNO     = "ticketNo";
			public static final String   CARDNUMBER   = "cardNumber";
			public static final String   CLASSLEVEL   = "classLevel";
			public static final String   CARDLEVEL    = "cardLevel";
			public static final String   COST         = "cost";
					
			
			
			/**
			 * 姓名
			 */
			@Column(length=32)
			protected String name;
			/**
			 * 票号
			 */
			@Column(length=32)
			protected String ticketNumber;
			/**
			 * 卡号
			 */
			@Column(length=32)
			protected String cardNumber;
			/**
			 * 舱位等级
			 */
			@Column(length=1)
			protected String classLevel;
			
			@Column(length=10)
			@Enumerated(EnumType.STRING)
			protected PassagerCardLevel cardLevel;
			/**
			 * 费用
			 */
			protected Integer cost;
			
			public String getName() {
				return name;
			}
			
			public void setName(String name) {
				this.name = name;
			}
			
			public String getTicketNumber() {
				return ticketNumber;
			}
			
			public void setTicketNumber(String ticketNumber) {
				this.ticketNumber = ticketNumber;
			}
			
			public String getCardNumber() {
				return cardNumber;
			}
			
			public void setCardNumber(String cardNumber) {
				this.cardNumber = cardNumber;
			}
			
			public String getClassLevel() {
				return classLevel;
			}
			
			public void setClassLevel(String classLevel) {
				this.classLevel = classLevel;
			}
			
			public PassagerCardLevel getCardLevel() {
				return cardLevel;
			}
			
			public void setCardLevel(PassagerCardLevel cardLevel) {
				this.cardLevel = cardLevel;
			}
			
			public Integer getCost() {
				return cost;
			}
			
			public void setCost(Integer cost) {
				this.cost = cost;
			}
			
			
		}
		
		
		/**
		 * 
		 * FileName      Charge.java
		 * @Description  TODO  收入细则项
		 * @author       ZhangYu    Company:    LZAirport
		 * @version      V0.9a CreateDate: 2018年2月19日
		 * @ModificationHistory
		 * Date         Author     Version   Description
		 * <p>---------------------------------------------
		 * <p>2018年2月19日      ZhangYu    1.0        1.0
		 * <p>Why & What is modified: <修改原因描述>
		 */
		@MappedSuperclass
		public  static  class Charge extends IntIdEntity{
			
			public static final  String   CHARGENAME    = "chargeName";
			public static final  String   STARTTIME     = "startTime";
			public static final  String   ENDTIME       = "endTime";
			public static final  String   NUMBEROFTIMES = "numberOfTimes";
			public static final  String   FLIGHT        = "flight";
			
			protected String chargeName;
			
			protected Date   startTime;
			
			protected Date   endTime;
			
			protected Integer numberOfTimes;

			public String getChargeName() {
				return chargeName;
			}

			public void setChargeName(String chargeName) {
				this.chargeName = chargeName;
			}

			public Date getStartTime() {
				return startTime;
			}

			public void setStartTime(Date startTime) {
				this.startTime = startTime;
			}

			public Date getEndTime() {
				return endTime;
			}

			public void setEndTime(Date endTime) {
				this.endTime = endTime;
			}

			public Integer getNumberOfTimes() {
				return numberOfTimes;
			}

			public void setNumberOfTimes(Integer numberOfTimes) {
				this.numberOfTimes = numberOfTimes;
			}
			
		}
		
		
	
		/**
		 * 
		 * FileName      Flight.java
		 * @Description  TODO  保障服务的内部类
		 * @author       ZhangYu    Company:    LZAirport
		 * @version      V0.9a CreateDate: 2017年9月28日
		 * @ModificationHistory
		 * Date         Author     Version   Description
		 * <p>---------------------------------------------
		 * <p>2017年9月28日      ZhangYu    1.0        1.0
		 * <p>Why & What is modified: <修改原因描述>
		 */


		@MappedSuperclass
		public  static abstract class EnsureService extends IntIdEntity{
			
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			public static final  String ENSURECODE      = "ensureCode";
			public static final  String ENSURENAME      = "ensureName";
			public static final  String PLANSTARTTIME   = "planStartTime";
			public static final  String PLANENDTIME     = "planEndTime";
			public static final  String ACTUALSTARTTIME = "actualStartTime";
			public static final  String ACTUALENDTIME   = "actualEndTime";
			public static final  String FLIGHT          = "flight";
			
			@Column(length=10)
			private String ensureCode;
			
			@Column(length=32)
			private String ensureName;
			
			private Date planStartTime;
			
			private Date planEndTime;
			
			private Date actualStartTime;
			
			private Date actualEndTime;

			
			public abstract  Flight getFlight();

			public abstract void setFlight(Flight flight);
			
			
			
			public String getEnsureCode() {
				return ensureCode;
			}

			public void setEnsureCode(String ensureCode) {
				this.ensureCode = ensureCode;
			}

			public String getEnsureName() {
				return ensureName;
			}

			public void setEnsureName(String ensureName) {
				this.ensureName = ensureName;
			}

			public Date getPlanStartTime() {
				return planStartTime;
			}

			public void setPlanStartTime(Date planStartTime) {
				this.planStartTime = planStartTime;
			}

			public Date getPlanEndTime() {
				return planEndTime;
			}

			public void setPlanEndTime(Date planEndTime) {
				this.planEndTime = planEndTime;
			}

			public Date getActualStartTime() {
				return actualStartTime;
			}

			public void setActualStartTime(Date actualStartTime) {
				this.actualStartTime = actualStartTime;
			}

			public Date getActualEndTime() {
				return actualEndTime;
			}

			public void setActualEndTime(Date actualEndTime) {
				this.actualEndTime = actualEndTime;
			}
		}	
	
	
}
