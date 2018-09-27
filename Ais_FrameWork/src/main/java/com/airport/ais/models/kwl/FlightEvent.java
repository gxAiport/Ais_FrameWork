package com.airport.ais.models.kwl;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the FlightEvent database table.
 * 
 */
@Entity
@NamedQuery(name="FlightEvent.findAll", query="SELECT f FROM FlightEvent f")
public class FlightEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FlightEventPK id;

	@Column(name="Airways_2Code")
	private String airways_2Code;

	@Column(name="Airways_CN")
	private String airways_CN;

	@Column(name="Altered_3Code")
	private String altered_3Code;

	@Column(name="Altered_4Code")
	private String altered_4Code;

	@Column(name="Altered_Cname")
	private String altered_Cname;

	@Column(name="Altered_Ename")
	private String altered_Ename;

	@Column(name="Altered_Status")
	private boolean altered_Status;

	@Column(name="Boarding_Gate_New")
	private String boarding_Gate_New;

	@Column(name="Boarding_Gate_Old")
	private String boarding_Gate_Old;

	@Column(name="CaptainName")
	private String captainName;

	@Column(name="CaptainStandard")
	private String captainStandard;

	@Column(name="CheckIn_No")
	private String checkIn_No;

	@Column(name="Code_Share1")
	private String code_Share1;

	@Column(name="Code_Share2")
	private String code_Share2;

	@Column(name="Code_Share3")
	private String code_Share3;

	@Column(name="con_c_status")
	private String conCStatus;

	@Column(name="Destination_3Code")
	private String destination_3Code;

	@Column(name="Destination_4Code")
	private String destination_4Code;

	@Column(name="Destination_Cname")
	private String destination_Cname;

	@Column(name="Destination_Ename")
	private String destination_Ename;

	@Column(name="Dinning_Room")
	private String dinning_Room;

	@Column(name="ExecDate")
	private Timestamp execDate;

	@Column(name="Flag_Domestic")
	private boolean flag_Domestic;

	@Column(name="FlagOnly")
	private String flagOnly;

	@Column(name="FlightHeight")
	private String flightHeight;

	@Column(name="FlightLink")
	private String flightLink;

	@Column(name="FlightLinkNo")
	private String flightLinkNo;

	@Column(name="FlightPath")
	private String flightPath;

	@Column(name="GoStatus_Cn")
	private String goStatus_Cn;

	@Column(name="GoStatus_En")
	private String goStatus_En;

	@Column(name="InFactArrTime")
	private Timestamp inFactArrTime;

	@Column(name="InFactTakeTime")
	private Timestamp inFactTakeTime;

	@Column(name="InformationDesk")
	private String informationDesk;

	@Column(name="IntendingArrTime")
	private Timestamp intendingArrTime;

	@Column(name="IntendingTakeTime")
	private Timestamp intendingTakeTime;

	@Column(name="IrregularReason_CN")
	private String irregularReason_CN;

	@Column(name="IrregularReason_EN")
	private String irregularReason_EN;

	@Column(name="IrregularStatus")
	private int irregularStatus;

	@Column(name="LuggageRack")
	private String luggageRack;

	@Column(name="MergedAirways2Code")
	private String mergedAirways2Code;

	@Column(name="MergedAirwaysCN")
	private String mergedAirwaysCN;

	@Column(name="MergedFlightNo")
	private String mergedFlightNo;

	@Column(name="Origin_3Code")
	private String origin_3Code;

	@Column(name="Origin_4Code")
	private String origin_4Code;

	@Column(name="Origin_Cname")
	private String origin_Cname;

	@Column(name="Origin_Ename")
	private String origin_Ename;

	@Column(name="Packing_Place")
	private String packing_Place;

	@Column(name="pdp_r_status")
	private String pdpRStatus;

	@Column(name="PlaneNO")
	private String planeNO;

	@Column(name="PlaneType")
	private String planeType;

	@Column(name="Property_Cn")
	private String property_Cn;

	@Column(name="Property_En")
	private String property_En;

	@Column(name="Remark")
	private String remark;

	@Column(name="SafeChannels")
	private String safeChannels;

	@Column(name="SharedFlightAirways2Code")
	private String sharedFlightAirways2Code;

	@Column(name="SharedFlightAirwaysCN")
	private String sharedFlightAirwaysCN;

	@Column(name="SharedFlightNo")
	private String sharedFlightNo;

	@Column(name="T1_InfactTakeTime")
	private Timestamp t1_InfactTakeTime;

	@Column(name="T1_IntendingTakeTime")
	private Timestamp t1_IntendingTakeTime;

	@Column(name="T2_InFactTakeTime")
	private Timestamp t2_InFactTakeTime;

	@Column(name="T2_IntendingTakeTime")
	private Timestamp t2_IntendingTakeTime;

	@Column(name="TimeDiff")
	private Timestamp timeDiff;

	@Column(name="Transfer1_3Code")
	private String transfer1_3Code;

	@Column(name="Transfer1_4Code")
	private String transfer1_4Code;

	@Column(name="Transfer1_CName")
	private String transfer1_CName;

	@Column(name="Transfer1_EName")
	private String transfer1_EName;

	@Column(name="Transfer2_3Code")
	private String transfer2_3Code;

	@Column(name="Transfer2_4Code")
	private String transfer2_4Code;

	@Column(name="Transfer2_CName")
	private String transfer2_CName;

	@Column(name="Transfer2_EName")
	private String transfer2_EName;

	@Column(name="VipInfor")
	private String vipInfor;

	public FlightEvent() {
	}

	public FlightEventPK getId() {
		return this.id;
	}

	public void setId(FlightEventPK id) {
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

	public String getAltered_3Code() {
		return this.altered_3Code;
	}

	public void setAltered_3Code(String altered_3Code) {
		this.altered_3Code = altered_3Code;
	}

	public String getAltered_4Code() {
		return this.altered_4Code;
	}

	public void setAltered_4Code(String altered_4Code) {
		this.altered_4Code = altered_4Code;
	}

	public String getAltered_Cname() {
		return this.altered_Cname;
	}

	public void setAltered_Cname(String altered_Cname) {
		this.altered_Cname = altered_Cname;
	}

	public String getAltered_Ename() {
		return this.altered_Ename;
	}

	public void setAltered_Ename(String altered_Ename) {
		this.altered_Ename = altered_Ename;
	}

	public boolean getAltered_Status() {
		return this.altered_Status;
	}

	public void setAltered_Status(boolean altered_Status) {
		this.altered_Status = altered_Status;
	}

	public String getBoarding_Gate_New() {
		return this.boarding_Gate_New;
	}

	public void setBoarding_Gate_New(String boarding_Gate_New) {
		this.boarding_Gate_New = boarding_Gate_New;
	}

	public String getBoarding_Gate_Old() {
		return this.boarding_Gate_Old;
	}

	public void setBoarding_Gate_Old(String boarding_Gate_Old) {
		this.boarding_Gate_Old = boarding_Gate_Old;
	}

	public String getCaptainName() {
		return this.captainName;
	}

	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}

	public String getCaptainStandard() {
		return this.captainStandard;
	}

	public void setCaptainStandard(String captainStandard) {
		this.captainStandard = captainStandard;
	}

	public String getCheckIn_No() {
		return this.checkIn_No;
	}

	public void setCheckIn_No(String checkIn_No) {
		this.checkIn_No = checkIn_No;
	}

	public String getCode_Share1() {
		return this.code_Share1;
	}

	public void setCode_Share1(String code_Share1) {
		this.code_Share1 = code_Share1;
	}

	public String getCode_Share2() {
		return this.code_Share2;
	}

	public void setCode_Share2(String code_Share2) {
		this.code_Share2 = code_Share2;
	}

	public String getCode_Share3() {
		return this.code_Share3;
	}

	public void setCode_Share3(String code_Share3) {
		this.code_Share3 = code_Share3;
	}

	public String getConCStatus() {
		return this.conCStatus;
	}

	public void setConCStatus(String conCStatus) {
		this.conCStatus = conCStatus;
	}

	public String getDestination_3Code() {
		return this.destination_3Code;
	}

	public void setDestination_3Code(String destination_3Code) {
		this.destination_3Code = destination_3Code;
	}

	public String getDestination_4Code() {
		return this.destination_4Code;
	}

	public void setDestination_4Code(String destination_4Code) {
		this.destination_4Code = destination_4Code;
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

	public String getDinning_Room() {
		return this.dinning_Room;
	}

	public void setDinning_Room(String dinning_Room) {
		this.dinning_Room = dinning_Room;
	}

	public Timestamp getExecDate() {
		return this.execDate;
	}

	public void setExecDate(Timestamp execDate) {
		this.execDate = execDate;
	}

	public boolean getFlag_Domestic() {
		return this.flag_Domestic;
	}

	public void setFlag_Domestic(boolean flag_Domestic) {
		this.flag_Domestic = flag_Domestic;
	}

	public String getFlagOnly() {
		return this.flagOnly;
	}

	public void setFlagOnly(String flagOnly) {
		this.flagOnly = flagOnly;
	}

	public String getFlightHeight() {
		return this.flightHeight;
	}

	public void setFlightHeight(String flightHeight) {
		this.flightHeight = flightHeight;
	}

	public String getFlightLink() {
		return this.flightLink;
	}

	public void setFlightLink(String flightLink) {
		this.flightLink = flightLink;
	}

	public String getFlightLinkNo() {
		return this.flightLinkNo;
	}

	public void setFlightLinkNo(String flightLinkNo) {
		this.flightLinkNo = flightLinkNo;
	}

	public String getFlightPath() {
		return this.flightPath;
	}

	public void setFlightPath(String flightPath) {
		this.flightPath = flightPath;
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

	public Timestamp getInFactArrTime() {
		return this.inFactArrTime;
	}

	public void setInFactArrTime(Timestamp inFactArrTime) {
		this.inFactArrTime = inFactArrTime;
	}

	public Timestamp getInFactTakeTime() {
		return this.inFactTakeTime;
	}

	public void setInFactTakeTime(Timestamp inFactTakeTime) {
		this.inFactTakeTime = inFactTakeTime;
	}

	public String getInformationDesk() {
		return this.informationDesk;
	}

	public void setInformationDesk(String informationDesk) {
		this.informationDesk = informationDesk;
	}

	public Timestamp getIntendingArrTime() {
		return this.intendingArrTime;
	}

	public void setIntendingArrTime(Timestamp intendingArrTime) {
		this.intendingArrTime = intendingArrTime;
	}

	public Timestamp getIntendingTakeTime() {
		return this.intendingTakeTime;
	}

	public void setIntendingTakeTime(Timestamp intendingTakeTime) {
		this.intendingTakeTime = intendingTakeTime;
	}

	public String getIrregularReason_CN() {
		return this.irregularReason_CN;
	}

	public void setIrregularReason_CN(String irregularReason_CN) {
		this.irregularReason_CN = irregularReason_CN;
	}

	public String getIrregularReason_EN() {
		return this.irregularReason_EN;
	}

	public void setIrregularReason_EN(String irregularReason_EN) {
		this.irregularReason_EN = irregularReason_EN;
	}

	public int getIrregularStatus() {
		return this.irregularStatus;
	}

	public void setIrregularStatus(int irregularStatus) {
		this.irregularStatus = irregularStatus;
	}

	public String getLuggageRack() {
		return this.luggageRack;
	}

	public void setLuggageRack(String luggageRack) {
		this.luggageRack = luggageRack;
	}

	public String getMergedAirways2Code() {
		return this.mergedAirways2Code;
	}

	public void setMergedAirways2Code(String mergedAirways2Code) {
		this.mergedAirways2Code = mergedAirways2Code;
	}

	public String getMergedAirwaysCN() {
		return this.mergedAirwaysCN;
	}

	public void setMergedAirwaysCN(String mergedAirwaysCN) {
		this.mergedAirwaysCN = mergedAirwaysCN;
	}

	public String getMergedFlightNo() {
		return this.mergedFlightNo;
	}

	public void setMergedFlightNo(String mergedFlightNo) {
		this.mergedFlightNo = mergedFlightNo;
	}

	public String getOrigin_3Code() {
		return this.origin_3Code;
	}

	public void setOrigin_3Code(String origin_3Code) {
		this.origin_3Code = origin_3Code;
	}

	public String getOrigin_4Code() {
		return this.origin_4Code;
	}

	public void setOrigin_4Code(String origin_4Code) {
		this.origin_4Code = origin_4Code;
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

	public String getPdpRStatus() {
		return this.pdpRStatus;
	}

	public void setPdpRStatus(String pdpRStatus) {
		this.pdpRStatus = pdpRStatus;
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

	public String getProperty_En() {
		return this.property_En;
	}

	public void setProperty_En(String property_En) {
		this.property_En = property_En;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSafeChannels() {
		return this.safeChannels;
	}

	public void setSafeChannels(String safeChannels) {
		this.safeChannels = safeChannels;
	}

	public String getSharedFlightAirways2Code() {
		return this.sharedFlightAirways2Code;
	}

	public void setSharedFlightAirways2Code(String sharedFlightAirways2Code) {
		this.sharedFlightAirways2Code = sharedFlightAirways2Code;
	}

	public String getSharedFlightAirwaysCN() {
		return this.sharedFlightAirwaysCN;
	}

	public void setSharedFlightAirwaysCN(String sharedFlightAirwaysCN) {
		this.sharedFlightAirwaysCN = sharedFlightAirwaysCN;
	}

	public String getSharedFlightNo() {
		return this.sharedFlightNo;
	}

	public void setSharedFlightNo(String sharedFlightNo) {
		this.sharedFlightNo = sharedFlightNo;
	}

	public Timestamp getT1_InfactTakeTime() {
		return this.t1_InfactTakeTime;
	}

	public void setT1_InfactTakeTime(Timestamp t1_InfactTakeTime) {
		this.t1_InfactTakeTime = t1_InfactTakeTime;
	}

	public Timestamp getT1_IntendingTakeTime() {
		return this.t1_IntendingTakeTime;
	}

	public void setT1_IntendingTakeTime(Timestamp t1_IntendingTakeTime) {
		this.t1_IntendingTakeTime = t1_IntendingTakeTime;
	}

	public Timestamp getT2_InFactTakeTime() {
		return this.t2_InFactTakeTime;
	}

	public void setT2_InFactTakeTime(Timestamp t2_InFactTakeTime) {
		this.t2_InFactTakeTime = t2_InFactTakeTime;
	}

	public Timestamp getT2_IntendingTakeTime() {
		return this.t2_IntendingTakeTime;
	}

	public void setT2_IntendingTakeTime(Timestamp t2_IntendingTakeTime) {
		this.t2_IntendingTakeTime = t2_IntendingTakeTime;
	}

	public Timestamp getTimeDiff() {
		return this.timeDiff;
	}

	public void setTimeDiff(Timestamp timeDiff) {
		this.timeDiff = timeDiff;
	}

	public String getTransfer1_3Code() {
		return this.transfer1_3Code;
	}

	public void setTransfer1_3Code(String transfer1_3Code) {
		this.transfer1_3Code = transfer1_3Code;
	}

	public String getTransfer1_4Code() {
		return this.transfer1_4Code;
	}

	public void setTransfer1_4Code(String transfer1_4Code) {
		this.transfer1_4Code = transfer1_4Code;
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

	public String getTransfer2_3Code() {
		return this.transfer2_3Code;
	}

	public void setTransfer2_3Code(String transfer2_3Code) {
		this.transfer2_3Code = transfer2_3Code;
	}

	public String getTransfer2_4Code() {
		return this.transfer2_4Code;
	}

	public void setTransfer2_4Code(String transfer2_4Code) {
		this.transfer2_4Code = transfer2_4Code;
	}

	public String getTransfer2_CName() {
		return this.transfer2_CName;
	}

	public void setTransfer2_CName(String transfer2_CName) {
		this.transfer2_CName = transfer2_CName;
	}

	public String getTransfer2_EName() {
		return this.transfer2_EName;
	}

	public void setTransfer2_EName(String transfer2_EName) {
		this.transfer2_EName = transfer2_EName;
	}

	public String getVipInfor() {
		return this.vipInfor;
	}

	public void setVipInfor(String vipInfor) {
		this.vipInfor = vipInfor;
	}
	
	

}