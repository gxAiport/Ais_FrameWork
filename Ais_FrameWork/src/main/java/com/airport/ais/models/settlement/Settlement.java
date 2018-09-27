package com.airport.ais.models.settlement;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.airport.ais.enums.aodb.FlightDirection;
import com.airport.ais.enums.aodb.SectorCode;
import com.airport.ais.models.IntIdEntity;
import com.airport.ais.models.aodb.basic.Aircraft;
import com.airport.ais.models.aodb.basic.AircraftSubtype;
import com.airport.ais.models.aodb.basic.Airline;
import com.airport.ais.models.aodb.basic.Airport;
import com.airport.ais.models.aodb.basic.Carrier;
import com.airport.ais.models.aodb.basic.FlightClassification;
import com.airport.ais.models.aodb.flight.HistoryFlight;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 
 * FileName      Settlement.java
 * @Description  TODO ��������
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2016��11��7�� 
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2016��11��7��      Administrator    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Entity
public class Settlement extends IntIdEntity implements Serializable {

	/**  
	 * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)   
	 */   
	private static final long serialVersionUID = 1L;
	
	    
	/**
	 * ���������ֶ���,����ֱ�ӵ����ֶ���
	 */
	public static String FLIGHT               = "flight";
	public static String FLIGHTDIRECTION      = "flightDirection";
	public static String FLIGHTCLASSIFICATION = "flightClassification";
	public static String AIRCRAFTSUBTYPE      = "aircraftSubtype";
	public static String AIRLINE              = "airline";
	public static String CARRIER              = "carrier";
	public static String SECTOR               = "sector";
	public static String SETTLEMENTITEM       = "settlementItem";
	public static String SETTLEMENTCATEGORY   = "settlementCategory";
	public static String FLIGHTNUMBER         = "flightNumber";
	public static String AIRCRAFT             = "aircraft";
	public static String ROUTECODE            = "routeCode";
	public static String ROUTECN              = "routeCN";
	public static String CRAFTSELLEMENT       = "craftSellement";
	public static String STARTTIME            = "startTime";
	public static String ENDTIME              = "endTime";
	public static String SETTLEMENTDATE       = "settlementDate";
	public static String TAKEOFFLANDTIME      = "takeoffLandTime";
	public static String CREATETIME           = "createTime";
	
	/**
	 * ��������
	 */
	@ManyToOne
	@JoinColumn(name="historyFlight_id") 
	protected HistoryFlight flight;
	
	/**
	 * ��������
	 */
	@ManyToOne
	@JoinColumn(name="localAirport")
	protected Airport localAirport;
	
	/**
	 * �����۱�ʶ
	 */
	@Column(length=10)
	@Enumerated(EnumType.STRING)
	protected FlightDirection flightDirection;

	/**
	 * ��������
	 */
	
	@ManyToOne
	@JoinColumn(name="classification")
	protected FlightClassification classification;
	
	/**
	 * ����
	 */
	@ManyToOne 
	@JoinColumn(name="aircraftSubtype")
	private AircraftSubtype aircraftSubtype;
	
	/**
	 * �ɻ�������,���ڽ���ϵͳ
	 */
	protected Integer settlementWeight;
	/**
	 * ����ҵ�أ����ڽ���
	 */
	protected Integer settlementPayload;
	
	@ManyToOne
	@JoinColumn(name="airlineICAOCode")
	protected Airline airline;

	@ManyToOne 
	@JoinColumn(name="carrierCode")
	protected Carrier carrier;
	
	/**
	 * ��������
	 */
	protected SectorCode legSector;

	/**
	 * ��������
	 */
	protected SectorCode routeSector;
	
	@ManyToOne
	private SettlementItem settlementItem;
	
	@ManyToOne
	private SettlementCategory settlementCategory;
	
    /**
     * �����
     */
	@Column(length=8)
	private  String flightNumber;
	
	/**
	 * �ɻ�
	 */
	@ManyToOne
	@JoinColumn(name="craftRegistration")
	private  Aircraft aircraft;
	
	/**
	 *  ���ߴ���
	 */
	@Column(length=32)
	private  String routeCode;
	
	/**
	 *  ���ߴ�������
	 */
	@Column(length=128)
	private  String routeCodeCN;
	
	/**
	 * ���δ���
	 */
	@Column(length=32)
	private  String legCode;
	
	/**
	 *  �������� 
	 */
	@Column(length=64)
	private String  legCodeCn;
	
	/**
	 *  ҵ�غ����ȫ���ֶ�
	 */
	@Column(length=15)
	private  String craftSellement;
	
	/**
	 *   ��ʼʱ�� 
	 */
	private Date startTime;

	/**
	 *   ����ʱ��
	 */
	private Date endTime;
	
	/**
	 *  �ۿ�
	 */
	private int discount;
	
	/**
	 *  ����
	 */
	private Double number;
	
	/**
	 *  ����
	 */
	private Double price;
	
	/**
	 *  ���
	 */
	private Double auomnt;
	
	/**
	 * ��������
	 */
	private Date settlementDate;
	
	/**
	 * ��ʱ��
	 */
	private Date takeoffLandTime;
	
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	
	/**
	 *   Transient��ע���ֶ�������ǰ�˿�ܽ��н�����ʾ����������Ϊ�����ֶ�
	 */
	@Transient
	public String settlementItemName;
	
	@Transient
	public String settlementCategoryName;
	
	@Transient
	public String legSectorName;
	
	@Transient
	public String routeSectorName;

	
	
	public Airport getLocalAirport() {
		return localAirport;
	}

	public void setLocalAirport(Airport localAirport) {
		this.localAirport = localAirport;
	}

	public FlightDirection getFlightDirection() {
		return flightDirection;
	}

	public void setFlightDirection(FlightDirection flightDirection) {
		this.flightDirection = flightDirection;
	}

	public FlightClassification getClassification() {
		return classification;
	}

	public void setClassification(FlightClassification classification) {
		this.classification = classification;
	}

	public AircraftSubtype getAircraftSubtype() {
		return aircraftSubtype;
	}

	public void setAircraftSubtype(AircraftSubtype aircraftSubtype) {
		this.aircraftSubtype = aircraftSubtype;
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

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public SectorCode getLegSector() {
		return legSector;
	}

	public void setLegSector(SectorCode legSector) {
		this.legSector = legSector;
	}

	public SectorCode getRouteSector() {
		return routeSector;
	}

	public void setRouteSector(SectorCode routeSector) {
		this.routeSector = routeSector;
	}
	
	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public SettlementItem getSettlementItem() {
		return settlementItem;
	}

	public void setSettlementItem(SettlementItem settlementItem) {
		this.settlementItem = settlementItem;
	}

	public SettlementCategory getSettlementCategory() {
		return settlementCategory;
	}

	public void setSettlementCategory(SettlementCategory settlementCategory) {
		this.settlementCategory = settlementCategory;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	
	public String getRouteCode() {
		return routeCode;
	}

	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}

	public String getRouteCodeCN() {
		return routeCodeCN;
	}

	public void setRouteCodeCN(String routeCodeCN) {
		this.routeCodeCN = routeCodeCN;
	}

	public String getLegCode() {
		return legCode;
	}

	public void setLegCode(String legCode) {
		this.legCode = legCode;
	}

	public String getLegCodeCn() {
		return legCodeCn;
	}

	public void setLegCodeCn(String legCodeCn) {
		this.legCodeCn = legCodeCn;
	}

	public String getCraftSellement() {
		return craftSellement;
	}

	public void setCraftSellement(String craftSellement) {
		this.craftSellement = craftSellement;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAuomnt() {
		return auomnt;
	}

	public void setAuomnt(Double auomnt) {
		this.auomnt = auomnt;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  
	public Date getTakeoffLandTime() {
		return takeoffLandTime;
	}
	public void setTakeoffLandTime(Date takeoffLandTime) {
		this.takeoffLandTime = takeoffLandTime;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public HistoryFlight getFlight() {
		return flight;
	}

	public void setFlight(HistoryFlight flight) {
		this.flight = flight;
	}


	/*
	 * ---------------------------------------------------------------------------------------	
	 */
	
	public void setSettlementItemName(String settlementItemName) {
		this.settlementItemName = settlementItemName;
	}

	public String getSettlementItemName() {
		if (settlementItem != null){
			return settlementItem.getName();
		}else{
			return null;
		}
	}

	public String getSettlementCategoryName() {
		if (settlementCategory != null){
			return settlementCategory.getName();
		}else{
			return null;
		}
	}

	public void setSettlementCategoryName(String settlementCategoryName) {
		this.settlementCategoryName = settlementCategoryName;
	}

	public String getLegSectorName() {
		if (legSector != null){
			return SectorCode.getCn(legSector);
		}else{
			return null;
		}
	}

	public void setLegSectorName(String legSectorName) {
		this.legSectorName = legSectorName;
	}

	public String getRouteSectorName() {
		if (routeSector != null){
			return SectorCode.getCn(routeSector);
		}else{
			return null;
		}
	}

	public void setRouteSectorName(String routeSectorName) {
		this.routeSectorName = routeSectorName;
	}
	

}
