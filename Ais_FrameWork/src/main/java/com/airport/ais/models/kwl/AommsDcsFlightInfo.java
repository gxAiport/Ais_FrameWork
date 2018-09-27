package com.airport.ais.models.kwl;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the AOMMS_DCS_FLIGHT_INFO database table.
 * 
 */
@Entity
@Table(name="AOMMS_DCS_FLIGHT_INFO")
@NamedQuery(name="AommsDcsFlightInfo.findAll", query="SELECT a FROM AommsDcsFlightInfo a")
public class AommsDcsFlightInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static final String OPERATIONDATE = "operationDate";
	
	@Column(name="AC_REG_NO")
	private String acRegNo;

	@Column(name="AIRCRAFT_TYPE_IATA")
	private String aircraftTypeIata;

	@Column(name="AIRLINE_IATA")
	private String airlineIata;

	@Column(name="AorD")
	private String aorD;

	@Column(name="AV_PAYLOAD")
	private BigDecimal avPayload;

	@Column(name="AV_SEAT")
	private BigDecimal avSeat;

	@Column(name="DEP_ARR_TIME")
	private String depArrTime;

	@Column(name="DorI")
	private String dorI;

	@Column(name="FLIGHT_NO")
	private String flightNo;

	@Column(name="FLIGHT_ROUTE")
	private String flightRoute;

	@Column(name="FLIGHT_ROUTE_SO")
	private String flightRouteSo;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="INPUT_TIME")
	private String inputTime;

	@Column(name="MX_PAYLOAD")
	private BigDecimal mxPayload;

	@Column(name="MX_SEAT")
	private BigDecimal mxSeat;

	@Column(name="OPERATION_DATE")
	private String operationDate;

	@Column(name="TASK_CODE")
	private String taskCode;

	public AommsDcsFlightInfo() {
	}

	public String getAcRegNo() {
		return this.acRegNo;
	}

	public void setAcRegNo(String acRegNo) {
		this.acRegNo = acRegNo;
	}

	public String getAircraftTypeIata() {
		return this.aircraftTypeIata;
	}

	public void setAircraftTypeIata(String aircraftTypeIata) {
		this.aircraftTypeIata = aircraftTypeIata;
	}

	public String getAirlineIata() {
		return this.airlineIata;
	}

	public void setAirlineIata(String airlineIata) {
		this.airlineIata = airlineIata;
	}

	public String getAorD() {
		return this.aorD;
	}

	public void setAorD(String aorD) {
		this.aorD = aorD;
	}

	public BigDecimal getAvPayload() {
		return this.avPayload;
	}

	public void setAvPayload(BigDecimal avPayload) {
		this.avPayload = avPayload;
	}

	public BigDecimal getAvSeat() {
		return this.avSeat;
	}

	public void setAvSeat(BigDecimal avSeat) {
		this.avSeat = avSeat;
	}

	public String getDepArrTime() {
		return this.depArrTime;
	}

	public void setDepArrTime(String depArrTime) {
		this.depArrTime = depArrTime;
	}

	public String getDorI() {
		return this.dorI;
	}

	public void setDorI(String dorI) {
		this.dorI = dorI;
	}

	public String getFlightNo() {
		return this.flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightRoute() {
		return this.flightRoute;
	}

	public void setFlightRoute(String flightRoute) {
		this.flightRoute = flightRoute;
	}

	public String getFlightRouteSo() {
		return this.flightRouteSo;
	}

	public void setFlightRouteSo(String flightRouteSo) {
		this.flightRouteSo = flightRouteSo;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInputTime() {
		return this.inputTime;
	}

	public void setInputTime(String inputTime) {
		this.inputTime = inputTime;
	}

	public BigDecimal getMxPayload() {
		return this.mxPayload;
	}

	public void setMxPayload(BigDecimal mxPayload) {
		this.mxPayload = mxPayload;
	}

	public BigDecimal getMxSeat() {
		return this.mxSeat;
	}

	public void setMxSeat(BigDecimal mxSeat) {
		this.mxSeat = mxSeat;
	}

	public String getOperationDate() {
		return this.operationDate;
	}

	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}

	public String getTaskCode() {
		return this.taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

}