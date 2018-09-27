package com.airport.ais.models.nng;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SA.V_CHARGE_GXJT_INFO")
@NamedQuery(name="AommsCharge.findAll", query="SELECT v FROM AommsCharge v")
public class AommsCharge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final  String  FLIGHTNO               =   "flightNo";
	public static final  String  AORD                   =   "aord";
	public static final  String  OPERATIONDATE          =   "operationDate";	

	@Id
	@Column(name="ID")
	private BigDecimal id;

	@Column(name="FLIGHT_NO")
	private String flightNo;
	
	private String aord;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="OPERATION_DATE")
	private Date operationDate;
	
	@Column(name="CHARGE_NAME")
	private String chargeName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_TIME")
	private Date startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_TIME")
	private Date endTime;

	@Column(name="NUMBER_OF_TIMES")
	private Integer number_of_times;

	
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
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

	public Integer getNumber_of_times() {
		return number_of_times;
	}

	public void setNumber_of_times(Integer number_of_times) {
		this.number_of_times = number_of_times;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getAord() {
		return aord;
	}

	public void setAord(String aord) {
		this.aord = aord;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public String getChargeName() {
		return chargeName;
	}

	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
	
	
	
	
}
