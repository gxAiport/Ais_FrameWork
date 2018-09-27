package com.airport.ais.models.nng;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the H_AOMMS_DCS_LEG_INFO database table.
 * 
 */
@Entity
@Table(name="SA.AOMMS_DCS_LEG_INFO")
@NamedQuery(name="AommsDcsLegInfo.findAll", query="SELECT h FROM AommsDcsLegInfo h")
public class AommsDcsLegInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final  String  FLIGHTNO      =   "flightNo";
	public static final  String  AORD          =   "aord";
	public static final  String  OPERATIONDATE =   "operationDate";

	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="FLIGHT_NO")
	private String flightNo;
	
	
	@Column(name="REPEAT_COUNT")
	private BigDecimal repeatCount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="OPERATION_DATE")
	private Date operationDate;
	
	private String aord;

	@Column(name="FLIGHT_LEG_ORD")
	private BigDecimal flightLegOrd;

	
	@Column(name="FLIGHT_LEG")
	private String flightLeg;

	@Column(name="ADULT_NUM")
	private BigDecimal adultNum;

	
	@Column(name="BABY_NUM")
	private BigDecimal babyNum;

	@Column(name="BAGGAGE_NUM")
	private BigDecimal baggageNum;

	@Column(name="BAGGAGE_WEIGHT")
	private BigDecimal baggageWeight;

	@Column(name="BIG_BAGGAGE_NUM")
	private BigDecimal bigBaggageNum;

	@Column(name="BIG_BAGGAGE_WEIGHT")
	private BigDecimal bigBaggageWeight;

	@Column(name="CARGO_WEIGHT")
	private BigDecimal cargoWeight;

	@Column(name="CHG_ADULT_NUM")
	private BigDecimal chgAdultNum;

	@Column(name="CHG_BABY_NUM")
	private BigDecimal chgBabyNum;

	@Column(name="CHG_BAGGAGE_NUM")
	private BigDecimal chgBaggageNum;

	@Column(name="CHG_BAGGAGE_WEIGHT")
	private BigDecimal chgBaggageWeight;

	@Column(name="CHG_BIG_BAGGAGE_NUM")
	private BigDecimal chgBigBaggageNum;

	@Column(name="CHG_BIG_BAGGAGE_WEIGHT")
	private BigDecimal chgBigBaggageWeight;

	@Column(name="CHG_CARGO_WEIGHT")
	private BigDecimal chgCargoWeight;

	@Column(name="CHG_CHILD_NUM")
	private BigDecimal chgChildNum;

	@Column(name="CHG_MAIL_WEIGHT")
	private BigDecimal chgMailWeight;

	@Column(name="CHG_PASS_ADULT_NUM")
	private BigDecimal chgPassAdultNum;

	@Column(name="CHG_PASS_BABY_NUM")
	private BigDecimal chgPassBabyNum;

	@Column(name="CHG_PASS_CHILD_NUM")
	private BigDecimal chgPassChildNum;

	@Column(name="CHILD_NUM")
	private BigDecimal childNum;

	@Column(name="MAIL_WEIGHT")
	private BigDecimal mailWeight;

	@Column(name="PASS_ADULT_NUM")
	private BigDecimal passAdultNum;

	@Column(name="PASS_BABY_NUM")
	private BigDecimal passBabyNum;

	@Column(name="PASS_CHILD_NUM")
	private BigDecimal passChildNum;

	

	public AommsDcsLegInfo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAdultNum() {
		return this.adultNum;
	}

	public void setAdultNum(BigDecimal adultNum) {
		this.adultNum = adultNum;
	}

	public String getAord() {
		return this.aord;
	}

	public void setAord(String aord) {
		this.aord = aord;
	}

	public BigDecimal getBabyNum() {
		return this.babyNum;
	}

	public void setBabyNum(BigDecimal babyNum) {
		this.babyNum = babyNum;
	}

	public BigDecimal getBaggageNum() {
		return this.baggageNum;
	}

	public void setBaggageNum(BigDecimal baggageNum) {
		this.baggageNum = baggageNum;
	}

	public BigDecimal getBaggageWeight() {
		return this.baggageWeight;
	}

	public void setBaggageWeight(BigDecimal baggageWeight) {
		this.baggageWeight = baggageWeight;
	}

	public BigDecimal getBigBaggageNum() {
		return this.bigBaggageNum;
	}

	public void setBigBaggageNum(BigDecimal bigBaggageNum) {
		this.bigBaggageNum = bigBaggageNum;
	}

	public BigDecimal getBigBaggageWeight() {
		return this.bigBaggageWeight;
	}

	public void setBigBaggageWeight(BigDecimal bigBaggageWeight) {
		this.bigBaggageWeight = bigBaggageWeight;
	}

	public BigDecimal getCargoWeight() {
		return this.cargoWeight;
	}

	public void setCargoWeight(BigDecimal cargoWeight) {
		this.cargoWeight = cargoWeight;
	}

	public BigDecimal getChgAdultNum() {
		return this.chgAdultNum;
	}

	public void setChgAdultNum(BigDecimal chgAdultNum) {
		this.chgAdultNum = chgAdultNum;
	}

	public BigDecimal getChgBabyNum() {
		return this.chgBabyNum;
	}

	public void setChgBabyNum(BigDecimal chgBabyNum) {
		this.chgBabyNum = chgBabyNum;
	}

	public BigDecimal getChgBaggageNum() {
		return this.chgBaggageNum;
	}

	public void setChgBaggageNum(BigDecimal chgBaggageNum) {
		this.chgBaggageNum = chgBaggageNum;
	}

	public BigDecimal getChgBaggageWeight() {
		return this.chgBaggageWeight;
	}

	public void setChgBaggageWeight(BigDecimal chgBaggageWeight) {
		this.chgBaggageWeight = chgBaggageWeight;
	}

	public BigDecimal getChgBigBaggageNum() {
		return this.chgBigBaggageNum;
	}

	public void setChgBigBaggageNum(BigDecimal chgBigBaggageNum) {
		this.chgBigBaggageNum = chgBigBaggageNum;
	}

	public BigDecimal getChgBigBaggageWeight() {
		return this.chgBigBaggageWeight;
	}

	public void setChgBigBaggageWeight(BigDecimal chgBigBaggageWeight) {
		this.chgBigBaggageWeight = chgBigBaggageWeight;
	}

	public BigDecimal getChgCargoWeight() {
		return this.chgCargoWeight;
	}

	public void setChgCargoWeight(BigDecimal chgCargoWeight) {
		this.chgCargoWeight = chgCargoWeight;
	}

	public BigDecimal getChgChildNum() {
		return this.chgChildNum;
	}

	public void setChgChildNum(BigDecimal chgChildNum) {
		this.chgChildNum = chgChildNum;
	}

	public BigDecimal getChgMailWeight() {
		return this.chgMailWeight;
	}

	public void setChgMailWeight(BigDecimal chgMailWeight) {
		this.chgMailWeight = chgMailWeight;
	}

	public BigDecimal getChgPassAdultNum() {
		return this.chgPassAdultNum;
	}

	public void setChgPassAdultNum(BigDecimal chgPassAdultNum) {
		this.chgPassAdultNum = chgPassAdultNum;
	}

	public BigDecimal getChgPassBabyNum() {
		return this.chgPassBabyNum;
	}

	public void setChgPassBabyNum(BigDecimal chgPassBabyNum) {
		this.chgPassBabyNum = chgPassBabyNum;
	}

	public BigDecimal getChgPassChildNum() {
		return this.chgPassChildNum;
	}

	public void setChgPassChildNum(BigDecimal chgPassChildNum) {
		this.chgPassChildNum = chgPassChildNum;
	}

	public BigDecimal getChildNum() {
		return this.childNum;
	}

	public void setChildNum(BigDecimal childNum) {
		this.childNum = childNum;
	}

	public String getFlightLeg() {
		return this.flightLeg;
	}

	public void setFlightLeg(String flightLeg) {
		this.flightLeg = flightLeg;
	}

	public BigDecimal getFlightLegOrd() {
		return this.flightLegOrd;
	}

	public void setFlightLegOrd(BigDecimal flightLegOrd) {
		this.flightLegOrd = flightLegOrd;
	}

	public String getFlightNo() {
		return this.flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public BigDecimal getMailWeight() {
		return this.mailWeight;
	}

	public void setMailWeight(BigDecimal mailWeight) {
		this.mailWeight = mailWeight;
	}

	public Date getOperationDate() {
		return this.operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public BigDecimal getPassAdultNum() {
		return this.passAdultNum;
	}

	public void setPassAdultNum(BigDecimal passAdultNum) {
		this.passAdultNum = passAdultNum;
	}

	public BigDecimal getPassBabyNum() {
		return this.passBabyNum;
	}

	public void setPassBabyNum(BigDecimal passBabyNum) {
		this.passBabyNum = passBabyNum;
	}

	public BigDecimal getPassChildNum() {
		return this.passChildNum;
	}

	public void setPassChildNum(BigDecimal passChildNum) {
		this.passChildNum = passChildNum;
	}

	public BigDecimal getRepeatCount() {
		return this.repeatCount;
	}

	public void setRepeatCount(BigDecimal repeatCount) {
		this.repeatCount = repeatCount;
	}

}