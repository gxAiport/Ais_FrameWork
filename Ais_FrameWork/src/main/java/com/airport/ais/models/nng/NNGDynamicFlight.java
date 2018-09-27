package com.airport.ais.models.nng;

/**
 * 
 * 
 * FileName      nngDynamicFlight.java
 * @Description  TODO  南宁的航班动态实体类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年7月28日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年7月28日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

import java.io.Serializable;
import javax.persistence.*;


/**
 * 
 * 
 * FileName      NNGDynamicFlight.java
 * @Description  TODO 南宁航班动态实体类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年7月28日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年7月28日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="AirDisplay")
public class NNGDynamicFlight implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final  String  ID                   = "id";
	public static final  String  AIRTYPE              = "airType"; 
	public static final  String  ARRTIMEEST           = "arrtimeest";
	public static final  String  ATA5                 = "ata5";
	public static final  String  ATD0                 = "atd0";
	public static final  String  BAGGAGECODE          = "baggagecode";
	public static final  String  CARRIERIATACODE      = "carrierIATACode";
	public static final  String  CARRIERIATACODE_C    = "carrierIATACode_C";
	public static final  String  CHECKINAREA          = "checkinarea";
	public static final  String  DECS                 = "deCs";
	public static final  String  DEYS                 = "deYs";
	public static final  String  ETA5                 = "eta5";
	public static final  String  ETD0                 = "etd0";
	public static final  String  FLIGHTNO             = "flightno";
	public static final  String  FLIGHTREPEATCOUNT    = "flightrepeatcount";
	public static final  String  GATENUMBER           = "gatenumber";
	public static final  String  GJBZ                 = "gjBz";
	public static final  String  HBJCBZ               = "hbJcbz";
	public static final  String  NAT                  = "nat";
	public static final  String  OIRGINC              = "oirginC";
	public static final  String  NATC                 = "natC";
	public static final  String  OIRGINY              = "oirginY";
	public static final  String  OPERC                = "operC";
	public static final  String  OPERE                = "operE";
	public static final  String  PLANENO              = "planeno";
	public static final  String  RQ                   = "rq";
	public static final  String  STARTTIMEEST         = "starttimeest"; 
	public static final  String  STATE1               = "state1";
	public static final  String  TERMINALCODE         = "terminalcode";
	public static final  String  VIACS1               = "viaCs1";
	public static final  String  VIACS2               = "viaCs2";
	public static final  String  VIAYS1               = "viaYs1";
	public static final  String  VIAYS2               = "viaYs2";
	
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;

	@Column(name="AIR_TYPE")
	private String airType;

	@Column(name="ARRTIMEEST")
	private String arrtimeest;

	@Column(name="ATA5")
	private String ata5;

	@Column(name="ATD0")
	private String atd0;

	@Column(name="BAGGAGECODE")
	private String baggagecode;

	@Column(name="CarrierIATACode")
	private String carrierIATACode;

	@Column(name="CarrierIATACode_C")
	private String carrierIATACode_C;

	@Column(name="CHECKINAREA")
	private String checkinarea;

	@Column(name="DE_CS")
	private String deCs;

	@Column(name="DE_YS")
	private String deYs;

	@Column(name="ETA5")
	private String eta5;

	@Column(name="ETD0")
	private String etd0;

	@Column(name="FLIGHTNO")
	private String flightno;

	@Column(name="FLIGHTREPEATCOUNT")
	private String flightrepeatcount;

	@Column(name="GATENUMBER")
	private String gatenumber;

	@Column(name="GJ_BZ")
	private String gjBz;

	@Column(name="HB_JCBZ")
	private String hbJcbz;

	@Column(name="NAT")
	private String nat;

	@Column(name="NAT_C")
	private String natC;

	@Column(name="OIRGIN_C")
	private String oirginC;

	@Column(name="OIRGIN_Y")
	private String oirginY;

	@Column(name="OPER_C")
	private String operC;

	@Column(name="OPER_E")
	private String operE;

	@Column(name="PLANENO")
	private String planeno;

	@Column(name="RQ")
	private String rq;

	@Column(name="STARTTIMEEST")
	private String starttimeest;

	@Column(name="STATE1")
	private String state1;

	@Column(name="TERMINALCODE")
	private String terminalcode;

	@Column(name="VIA_CS1")
	private String viaCs1;

	@Column(name="VIA_CS2")
	private String viaCs2;

	@Column(name="VIA_YS1")
	private String viaYs1;

	@Column(name="VIA_YS2")
	private String viaYs2;

	public NNGDynamicFlight() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAirType() {
		return this.airType;
	}

	public void setAirType(String airType) {
		this.airType = airType;
	}

	public String getArrtimeest() {
		return this.arrtimeest;
	}

	public void setArrtimeest(String arrtimeest) {
		this.arrtimeest = arrtimeest;
	}

	public String getAta5() {
		return this.ata5;
	}

	public void setAta5(String ata5) {
		this.ata5 = ata5;
	}

	public String getAtd0() {
		return this.atd0;
	}

	public void setAtd0(String atd0) {
		this.atd0 = atd0;
	}

	public String getBaggagecode() {
		return this.baggagecode;
	}

	public void setBaggagecode(String baggagecode) {
		this.baggagecode = baggagecode;
	}

	public String getCarrierIATACode() {
		return this.carrierIATACode;
	}

	public void setCarrierIATACode(String carrierIATACode) {
		this.carrierIATACode = carrierIATACode;
	}

	public String getCarrierIATACode_C() {
		return this.carrierIATACode_C;
	}

	public void setCarrierIATACode_C(String carrierIATACode_C) {
		this.carrierIATACode_C = carrierIATACode_C;
	}

	public String getCheckinarea() {
		return this.checkinarea;
	}

	public void setCheckinarea(String checkinarea) {
		this.checkinarea = checkinarea;
	}

	public String getDeCs() {
		return this.deCs;
	}

	public void setDeCs(String deCs) {
		this.deCs = deCs;
	}

	public String getDeYs() {
		return this.deYs;
	}

	public void setDeYs(String deYs) {
		this.deYs = deYs;
	}

	public String getEta5() {
		return this.eta5;
	}

	public void setEta5(String eta5) {
		this.eta5 = eta5;
	}

	public String getEtd0() {
		return this.etd0;
	}

	public void setEtd0(String etd0) {
		this.etd0 = etd0;
	}

	public String getFlightno() {
		return this.flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	public String getFlightrepeatcount() {
		return this.flightrepeatcount;
	}

	public void setFlightrepeatcount(String flightrepeatcount) {
		this.flightrepeatcount = flightrepeatcount;
	}

	public String getGatenumber() {
		return this.gatenumber;
	}

	public void setGatenumber(String gatenumber) {
		this.gatenumber = gatenumber;
	}

	public String getGjBz() {
		return this.gjBz;
	}

	public void setGjBz(String gjBz) {
		this.gjBz = gjBz;
	}

	public String getHbJcbz() {
		return this.hbJcbz;
	}

	public void setHbJcbz(String hbJcbz) {
		this.hbJcbz = hbJcbz;
	}

	public String getNat() {
		return this.nat;
	}

	public void setNat(String nat) {
		this.nat = nat;
	}

	public String getNatC() {
		return this.natC;
	}

	public void setNatC(String natC) {
		this.natC = natC;
	}

	public String getOirginC() {
		return this.oirginC;
	}

	public void setOirginC(String oirginC) {
		this.oirginC = oirginC;
	}

	public String getOirginY() {
		return this.oirginY;
	}

	public void setOirginY(String oirginY) {
		this.oirginY = oirginY;
	}

	public String getOperC() {
		return this.operC;
	}

	public void setOperC(String operC) {
		this.operC = operC;
	}

	public String getOperE() {
		return this.operE;
	}

	public void setOperE(String operE) {
		this.operE = operE;
	}

	public String getPlaneno() {
		return this.planeno;
	}

	public void setPlaneno(String planeno) {
		this.planeno = planeno;
	}

	public String getRq() {
		return this.rq;
	}

	public void setRq(String rq) {
		this.rq = rq;
	}

	public String getStarttimeest() {
		return this.starttimeest;
	}

	public void setStarttimeest(String starttimeest) {
		this.starttimeest = starttimeest;
	}

	public String getState1() {
		return this.state1;
	}

	public void setState1(String state1) {
		this.state1 = state1;
	}

	public String getTerminalcode() {
		return this.terminalcode;
	}

	public void setTerminalcode(String terminalcode) {
		this.terminalcode = terminalcode;
	}

	public String getViaCs1() {
		return this.viaCs1;
	}

	public void setViaCs1(String viaCs1) {
		this.viaCs1 = viaCs1;
	}

	public String getViaCs2() {
		return this.viaCs2;
	}

	public void setViaCs2(String viaCs2) {
		this.viaCs2 = viaCs2;
	}

	public String getViaYs1() {
		return this.viaYs1;
	}

	public void setViaYs1(String viaYs1) {
		this.viaYs1 = viaYs1;
	}

	public String getViaYs2() {
		return this.viaYs2;
	}

	public void setViaYs2(String viaYs2) {
		this.viaYs2 = viaYs2;
	}

}