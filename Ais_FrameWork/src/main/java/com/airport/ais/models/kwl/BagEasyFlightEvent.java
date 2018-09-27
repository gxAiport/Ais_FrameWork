package com.airport.ais.models.kwl;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the BagEasyFlightEvent database table.
 * 
 */
@Entity
@NamedQuery(name="BagEasyFlightEvent.findAll", query="SELECT b FROM BagEasyFlightEvent b")
public class BagEasyFlightEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="Airways_2Code")
	private String airways_2Code;

	@Column(name="Airways_CN")
	private String airways_CN;

	@Column(name="ATA")
	private String ata;

	@Column(name="ATD")
	private String atd;

	private String bagimagename;

	private String carousel;

	@Column(name="Code_Share")
	private String code_Share;

	@Column(name="Destination_Cname")
	private String destination_Cname;

	@Column(name="Destination_Ename")
	private String destination_Ename;

	@Column(name="ETA")
	private String eta;

	@Column(name="ETD")
	private String etd;

	@Column(name="ExecDate")
	private Timestamp execDate;

	@Column(name="Flag_Domestic")
	private String flag_Domestic;

	@Column(name="Flag_InOut")
	private String flag_InOut;

	@Column(name="FlightNo")
	private String flightNo;

	@Column(name="FlightNo1")
	private String flightNo1;

	@Column(name="GoStatus_Cn")
	private String goStatus_Cn;

	@Column(name="GoStatus_En")
	private String goStatus_En;

	private String gxstatus;

	private String gxtime;

	@Column(name="HD")
	private String hd;


	@Column(name="InFactArrTime")
	private String inFactArrTime;

	@Column(name="InFactTakeTime")
	private String inFactTakeTime;

	@Column(name="IntendingArrTime")
	private String intendingArrTime;

	@Column(name="IntendingTakeTime")
	private String intendingTakeTime;

	@Column(name="IORD")
	private String iord;

	private String isautoupdate;

	private String isshow;

	private Timestamp jstime;

	private Timestamp kstime;

	@Column(name="Origin_Cname")
	private String origin_Cname;

	@Column(name="Origin_Ename")
	private String origin_Ename;

	@Column(name="Packing_Place")
	private String packing_Place;

	@Column(name="PlaneNO")
	private String planeNO;

	@Column(name="PlaneType")
	private String planeType;

	@Column(name="Property_Cn")
	private String property_Cn;

	private String remark;

	@Column(name="Transfer1_CName")
	private String transfer1_CName;

	@Column(name="Transfer1_EName")
	private String transfer1_EName;

	private String xlstatus;

	public BagEasyFlightEvent() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirways_2Code() {
		return this.airways_2Code;
	}

	public void setAirways_2Code(String airways_2Code) {
		this.airways_2Code = airways_2Code;
	}

	public String getAirways_CN() {
		return this.airways_CN;
	}

	public void setAirways_CN(String airways_CN) {
		this.airways_CN = airways_CN;
	}

	public String getAta() {
		return this.ata;
	}

	public void setAta(String ata) {
		this.ata = ata;
	}

	public String getAtd() {
		return this.atd;
	}

	public void setAtd(String atd) {
		this.atd = atd;
	}

	public String getBagimagename() {
		return this.bagimagename;
	}

	public void setBagimagename(String bagimagename) {
		this.bagimagename = bagimagename;
	}

	public String getCarousel() {
		return this.carousel;
	}

	public void setCarousel(String carousel) {
		this.carousel = carousel;
	}

	public String getCode_Share() {
		return this.code_Share;
	}

	public void setCode_Share(String code_Share) {
		this.code_Share = code_Share;
	}

	public String getDestination_Cname() {
		return this.destination_Cname;
	}

	public void setDestination_Cname(String destination_Cname) {
		this.destination_Cname = destination_Cname;
	}

	public String getDestination_Ename() {
		return this.destination_Ename;
	}

	public void setDestination_Ename(String destination_Ename) {
		this.destination_Ename = destination_Ename;
	}

	public String getEta() {
		return this.eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getEtd() {
		return this.etd;
	}

	public void setEtd(String etd) {
		this.etd = etd;
	}

	public Timestamp getExecDate() {
		return this.execDate;
	}

	public void setExecDate(Timestamp execDate) {
		this.execDate = execDate;
	}

	public String getFlag_Domestic() {
		return this.flag_Domestic;
	}

	public void setFlag_Domestic(String flag_Domestic) {
		this.flag_Domestic = flag_Domestic;
	}

	public String getFlag_InOut() {
		return this.flag_InOut;
	}

	public void setFlag_InOut(String flag_InOut) {
		this.flag_InOut = flag_InOut;
	}

	public String getFlightNo() {
		return this.flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightNo1() {
		return this.flightNo1;
	}

	public void setFlightNo1(String flightNo1) {
		this.flightNo1 = flightNo1;
	}

	public String getGoStatus_Cn() {
		return this.goStatus_Cn;
	}

	public void setGoStatus_Cn(String goStatus_Cn) {
		this.goStatus_Cn = goStatus_Cn;
	}

	public String getGoStatus_En() {
		return this.goStatus_En;
	}

	public void setGoStatus_En(String goStatus_En) {
		this.goStatus_En = goStatus_En;
	}

	public String getGxstatus() {
		return this.gxstatus;
	}

	public void setGxstatus(String gxstatus) {
		this.gxstatus = gxstatus;
	}

	public String getGxtime() {
		return this.gxtime;
	}

	public void setGxtime(String gxtime) {
		this.gxtime = gxtime;
	}

	public String getHd() {
		return this.hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}


	public String getInFactArrTime() {
		return this.inFactArrTime;
	}

	public void setInFactArrTime(String inFactArrTime) {
		this.inFactArrTime = inFactArrTime;
	}

	public String getInFactTakeTime() {
		return this.inFactTakeTime;
	}

	public void setInFactTakeTime(String inFactTakeTime) {
		this.inFactTakeTime = inFactTakeTime;
	}

	public String getIntendingArrTime() {
		return this.intendingArrTime;
	}

	public void setIntendingArrTime(String intendingArrTime) {
		this.intendingArrTime = intendingArrTime;
	}

	public String getIntendingTakeTime() {
		return this.intendingTakeTime;
	}

	public void setIntendingTakeTime(String intendingTakeTime) {
		this.intendingTakeTime = intendingTakeTime;
	}

	public String getIord() {
		return this.iord;
	}

	public void setIord(String iord) {
		this.iord = iord;
	}

	public String getIsautoupdate() {
		return this.isautoupdate;
	}

	public void setIsautoupdate(String isautoupdate) {
		this.isautoupdate = isautoupdate;
	}

	public String getIsshow() {
		return this.isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	public Timestamp getJstime() {
		return this.jstime;
	}

	public void setJstime(Timestamp jstime) {
		this.jstime = jstime;
	}

	public Timestamp getKstime() {
		return this.kstime;
	}

	public void setKstime(Timestamp kstime) {
		this.kstime = kstime;
	}

	public String getOrigin_Cname() {
		return this.origin_Cname;
	}

	public void setOrigin_Cname(String origin_Cname) {
		this.origin_Cname = origin_Cname;
	}

	public String getOrigin_Ename() {
		return this.origin_Ename;
	}

	public void setOrigin_Ename(String origin_Ename) {
		this.origin_Ename = origin_Ename;
	}

	public String getPacking_Place() {
		return this.packing_Place;
	}

	public void setPacking_Place(String packing_Place) {
		this.packing_Place = packing_Place;
	}

	public String getPlaneNO() {
		return this.planeNO;
	}

	public void setPlaneNO(String planeNO) {
		this.planeNO = planeNO;
	}

	public String getPlaneType() {
		return this.planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	public String getProperty_Cn() {
		return this.property_Cn;
	}

	public void setProperty_Cn(String property_Cn) {
		this.property_Cn = property_Cn;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTransfer1_CName() {
		return this.transfer1_CName;
	}

	public void setTransfer1_CName(String transfer1_CName) {
		this.transfer1_CName = transfer1_CName;
	}

	public String getTransfer1_EName() {
		return this.transfer1_EName;
	}

	public void setTransfer1_EName(String transfer1_EName) {
		this.transfer1_EName = transfer1_EName;
	}

	public String getXlstatus() {
		return this.xlstatus;
	}

	public void setXlstatus(String xlstatus) {
		this.xlstatus = xlstatus;
	}

}