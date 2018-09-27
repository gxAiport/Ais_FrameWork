package com.airport.ais.models.kwl;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the AOMMS_DCS_LEG_INFO database table.
 * 
 */
@Entity
@Table(name="AOMMS_DCS_LEG_INFO")
@NamedQuery(name="AommsDcsLegInfo.findAll", query="SELECT a FROM AommsDcsLegInfo a")
public class AommsDcsLegInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String OPERATIONDATE = "operationDate";

	@Column(name="ADULT_NUM")
	private int adultNum;

	@Column(name="AorD")
	private String aorD;

	@Column(name="BABY_NUM")
	private int babyNum;

	@Column(name="BAGGAGE_NUM")
	private int baggageNum;

	@Column(name="BAGGAGE_WEIGHT")
	private BigDecimal baggageWeight;

	@Column(name="BIG_BAGGAGE_NUM")
	private int bigBaggageNum;

	@Column(name="BIG_BAGGAGE_WEIGHT")
	private BigDecimal bigBaggageWeight;

	@Column(name="CARGO_WEIGHT")
	private BigDecimal cargoWeight;

	@Column(name="CHG_ADULT_NUM")
	private int chgAdultNum;

	@Column(name="CHG_BABY_NUM")
	private int chgBabyNum;

	@Column(name="CHG_BAGGAGE_NUM")
	private int chgBaggageNum;

	@Column(name="CHG_BAGGAGE_WEIGHT")
	private BigDecimal chgBaggageWeight;

	@Column(name="CHG_CARGO_WEIGHT")
	private BigDecimal chgCargoWeight;

	@Column(name="CHG_CHILD_NUM")
	private int chgChildNum;

	@Column(name="CHG_MAIL_WEIGHT")
	private BigDecimal chgMailWeight;

	@Column(name="CHILD_NUM")
	private int childNum;

	@Column(name="FLIGHT_LEG")
	private String flightLeg;

	@Column(name="FLIGHT_LEG_ORD")
	private int flightLegOrd;

	@Column(name="FLIGHT_NO")
	private String flightNo;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="MAIL_WEIGHT")
	private BigDecimal mailWeight;

	@Column(name="PASS_ADULT_NUM")
	private int passAdultNum;

	@Column(name="PASS_BABY_NUM")
	private int passBabyNum;

	@Column(name="PASS_CHILD_NUM")
	private int passChildNum;

	public AommsDcsLegInfo() {
	}

	public int getAdultNum() {
		return this.adultNum;
	}

	public void setAdultNum(int adultNum) {
		this.adultNum = adultNum;
	}

	public String getAorD() {
		return this.aorD;
	}

	public void setAorD(String aorD) {
		this.aorD = aorD;
	}

	public int getBabyNum() {
		return this.babyNum;
	}

	public void setBabyNum(int babyNum) {
		this.babyNum = babyNum;
	}

	public int getBaggageNum() {
		return this.baggageNum;
	}

	public void setBaggageNum(int baggageNum) {
		this.baggageNum = baggageNum;
	}

	public BigDecimal getBaggageWeight() {
		return this.baggageWeight;
	}

	public void setBaggageWeight(BigDecimal baggageWeight) {
		this.baggageWeight = baggageWeight;
	}

	public int getBigBaggageNum() {
		return this.bigBaggageNum;
	}

	public void setBigBaggageNum(int bigBaggageNum) {
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

	public int getChgAdultNum() {
		return this.chgAdultNum;
	}

	public void setChgAdultNum(int chgAdultNum) {
		this.chgAdultNum = chgAdultNum;
	}

	public int getChgBabyNum() {
		return this.chgBabyNum;
	}

	public void setChgBabyNum(int chgBabyNum) {
		this.chgBabyNum = chgBabyNum;
	}

	public int getChgBaggageNum() {
		return this.chgBaggageNum;
	}

	public void setChgBaggageNum(int chgBaggageNum) {
		this.chgBaggageNum = chgBaggageNum;
	}

	public BigDecimal getChgBaggageWeight() {
		return this.chgBaggageWeight;
	}

	public void setChgBaggageWeight(BigDecimal chgBaggageWeight) {
		this.chgBaggageWeight = chgBaggageWeight;
	}

	public BigDecimal getChgCargoWeight() {
		return this.chgCargoWeight;
	}

	public void setChgCargoWeight(BigDecimal chgCargoWeight) {
		this.chgCargoWeight = chgCargoWeight;
	}

	public int getChgChildNum() {
		return this.chgChildNum;
	}

	public void setChgChildNum(int chgChildNum) {
		this.chgChildNum = chgChildNum;
	}

	public BigDecimal getChgMailWeight() {
		return this.chgMailWeight;
	}

	public void setChgMailWeight(BigDecimal chgMailWeight) {
		this.chgMailWeight = chgMailWeight;
	}

	public int getChildNum() {
		return this.childNum;
	}

	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}

	public String getFlightLeg() {
		return this.flightLeg;
	}

	public void setFlightLeg(String flightLeg) {
		this.flightLeg = flightLeg;
	}

	public int getFlightLegOrd() {
		return this.flightLegOrd;
	}

	public void setFlightLegOrd(int flightLegOrd) {
		this.flightLegOrd = flightLegOrd;
	}

	public String getFlightNo() {
		return this.flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getMailWeight() {
		return this.mailWeight;
	}

	public void setMailWeight(BigDecimal mailWeight) {
		this.mailWeight = mailWeight;
	}

	public int getPassAdultNum() {
		return this.passAdultNum;
	}

	public void setPassAdultNum(int passAdultNum) {
		this.passAdultNum = passAdultNum;
	}

	public int getPassBabyNum() {
		return this.passBabyNum;
	}

	public void setPassBabyNum(int passBabyNum) {
		this.passBabyNum = passBabyNum;
	}

	public int getPassChildNum() {
		return this.passChildNum;
	}

	public void setPassChildNum(int passChildNum) {
		this.passChildNum = passChildNum;
	}

}