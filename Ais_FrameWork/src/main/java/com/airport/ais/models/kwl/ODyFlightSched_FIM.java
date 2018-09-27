package com.airport.ais.models.kwl;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ODyFlightSched_FIMS database table.
 * 
 */
@Entity
@Table(name="ODyFlightSched_FIMS")
@NamedQuery(name="ODyFlightSched_FIM.findAll", query="SELECT o FROM ODyFlightSched_FIM o")
public class ODyFlightSched_FIM implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String OPERATIONDATE = "operationDate";
	
	@Id
	@Column(name="ID")
	private int id;

	@Column(name="ABNORMAL_CAUSE_CN")
	private String abnormalCauseCn;

	@Column(name="ABNORMAL_CAUSE_EN")
	private String abnormalCauseEn;

	@Column(name="AC_REG_NO")
	private String acRegNo;

	@Column(name="AIRCRAFT_TYPE_IATA")
	private String aircraftTypeIata;

	@Column(name="AIRLINE_IATA")
	private String airlineIata;

	@Column(name="AIRPORT1")
	private String airport1;

	@Column(name="AIRPORT2")
	private String airport2;

	@Column(name="AIRPORT3")
	private String airport3;

	@Column(name="AIRPORT4")
	private String airport4;

	@Column(name="AIRPORT5")
	private String airport5;

	@Column(name="AIRPORT6")
	private String airport6;

	@Column(name="AIRPORT7")
	private String airport7;

	@Column(name="AorD")
	private String aorD;

	@Column(name="ATA")
	private Timestamp ata;

	@Column(name="ATD")
	private Timestamp atd;

	@Column(name="BOARDING_STATUS")
	private String boardingStatus;

	@Column(name="CODE_SHARE1")
	private String codeShare1;

	@Column(name="CODE_SHARE2")
	private String codeShare2;

	@Column(name="CODE_SHARE3")
	private String codeShare3;

	@Column(name="CODE_SHARE4")
	private String codeShare4;

	@Column(name="DELAY_CODE")
	private String delayCode;

	@Column(name="DEST_AIRPORT_IATA")
	private String destAirportIata;

	@Column(name="DorI")
	private String dorI;

	@Column(name="DorI1")
	private String dorI1;

	@Column(name="DorI2")
	private String dorI2;

	@Column(name="DorI3")
	private String dorI3;

	@Column(name="DorI4")
	private String dorI4;

	@Column(name="DorI5")
	private String dorI5;

	@Column(name="DorI6")
	private String dorI6;

	@Column(name="ENTER_CORRIDOR_TIME")
	private Timestamp enterCorridorTime;

	@Column(name="ETA")
	private Timestamp eta;

	@Column(name="ETD")
	private Timestamp etd;

	@Column(name="FLG_VIP")
	private String flgVip;

	@Column(name="FLIGHT_NO")
	private String flightNo;

	@Column(name="NEXT_FLIGHT")
	private String nextFlight;

	@Column(name="OPERATION_DATE")
	private Timestamp operationDate;

	@Column(name="ORIGIN_AIRPORT_IATA")
	private String originAirportIata;

	@Column(name="PREVIOUS_FLIGHT")
	private String previousFlight;

	@Column(name="RECENT_ABNORMAL_STATUS")
	private String recentAbnormalStatus;

	@Column(name="REPORTED_ABNORMAL")
	private String reportedAbnormal;

	@Column(name="SERVICE_CLASS")
	private String serviceClass;

	@Column(name="STA")
	private Timestamp sta;

	@Column(name="STA2")
	private Timestamp sta2;

	@Column(name="STA3")
	private Timestamp sta3;

	@Column(name="STA4")
	private Timestamp sta4;

	@Column(name="STA5")
	private Timestamp sta5;

	@Column(name="STA6")
	private Timestamp sta6;

	@Column(name="STA7")
	private Timestamp sta7;

	@Column(name="STD")
	private Timestamp std;

	@Column(name="STD1")
	private Timestamp std1;

	@Column(name="STD2")
	private Timestamp std2;

	@Column(name="STD3")
	private Timestamp std3;

	@Column(name="STD4")
	private Timestamp std4;

	@Column(name="STD5")
	private Timestamp std5;

	@Column(name="STD6")
	private Timestamp std6;

	@Column(name="TASK_CODE")
	private String taskCode;

	@Column(name="TERMINAL_NO")
	private String terminalNo;

	public ODyFlightSched_FIM() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbnormalCauseCn() {
		return this.abnormalCauseCn;
	}

	public void setAbnormalCauseCn(String abnormalCauseCn) {
		this.abnormalCauseCn = abnormalCauseCn;
	}

	public String getAbnormalCauseEn() {
		return this.abnormalCauseEn;
	}

	public void setAbnormalCauseEn(String abnormalCauseEn) {
		this.abnormalCauseEn = abnormalCauseEn;
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

	public String getAirport1() {
		return this.airport1;
	}

	public void setAirport1(String airport1) {
		this.airport1 = airport1;
	}

	public String getAirport2() {
		return this.airport2;
	}

	public void setAirport2(String airport2) {
		this.airport2 = airport2;
	}

	public String getAirport3() {
		return this.airport3;
	}

	public void setAirport3(String airport3) {
		this.airport3 = airport3;
	}

	public String getAirport4() {
		return this.airport4;
	}

	public void setAirport4(String airport4) {
		this.airport4 = airport4;
	}

	public String getAirport5() {
		return this.airport5;
	}

	public void setAirport5(String airport5) {
		this.airport5 = airport5;
	}

	public String getAirport6() {
		return this.airport6;
	}

	public void setAirport6(String airport6) {
		this.airport6 = airport6;
	}

	public String getAirport7() {
		return this.airport7;
	}

	public void setAirport7(String airport7) {
		this.airport7 = airport7;
	}

	public String getAorD() {
		return this.aorD;
	}

	public void setAorD(String aorD) {
		this.aorD = aorD;
	}

	public Timestamp getAta() {
		return this.ata;
	}

	public void setAta(Timestamp ata) {
		this.ata = ata;
	}

	public Timestamp getAtd() {
		return this.atd;
	}

	public void setAtd(Timestamp atd) {
		this.atd = atd;
	}

	public String getBoardingStatus() {
		return this.boardingStatus;
	}

	public void setBoardingStatus(String boardingStatus) {
		this.boardingStatus = boardingStatus;
	}

	public String getCodeShare1() {
		return this.codeShare1;
	}

	public void setCodeShare1(String codeShare1) {
		this.codeShare1 = codeShare1;
	}

	public String getCodeShare2() {
		return this.codeShare2;
	}

	public void setCodeShare2(String codeShare2) {
		this.codeShare2 = codeShare2;
	}

	public String getCodeShare3() {
		return this.codeShare3;
	}

	public void setCodeShare3(String codeShare3) {
		this.codeShare3 = codeShare3;
	}

	public String getCodeShare4() {
		return this.codeShare4;
	}

	public void setCodeShare4(String codeShare4) {
		this.codeShare4 = codeShare4;
	}

	public String getDelayCode() {
		return this.delayCode;
	}

	public void setDelayCode(String delayCode) {
		this.delayCode = delayCode;
	}

	public String getDestAirportIata() {
		return this.destAirportIata;
	}

	public void setDestAirportIata(String destAirportIata) {
		this.destAirportIata = destAirportIata;
	}

	public String getDorI() {
		return this.dorI;
	}

	public void setDorI(String dorI) {
		this.dorI = dorI;
	}

	public String getDorI1() {
		return this.dorI1;
	}

	public void setDorI1(String dorI1) {
		this.dorI1 = dorI1;
	}

	public String getDorI2() {
		return this.dorI2;
	}

	public void setDorI2(String dorI2) {
		this.dorI2 = dorI2;
	}

	public String getDorI3() {
		return this.dorI3;
	}

	public void setDorI3(String dorI3) {
		this.dorI3 = dorI3;
	}

	public String getDorI4() {
		return this.dorI4;
	}

	public void setDorI4(String dorI4) {
		this.dorI4 = dorI4;
	}

	public String getDorI5() {
		return this.dorI5;
	}

	public void setDorI5(String dorI5) {
		this.dorI5 = dorI5;
	}

	public String getDorI6() {
		return this.dorI6;
	}

	public void setDorI6(String dorI6) {
		this.dorI6 = dorI6;
	}

	public Timestamp getEnterCorridorTime() {
		return this.enterCorridorTime;
	}

	public void setEnterCorridorTime(Timestamp enterCorridorTime) {
		this.enterCorridorTime = enterCorridorTime;
	}

	public Timestamp getEta() {
		return this.eta;
	}

	public void setEta(Timestamp eta) {
		this.eta = eta;
	}

	public Timestamp getEtd() {
		return this.etd;
	}

	public void setEtd(Timestamp etd) {
		this.etd = etd;
	}

	public String getFlgVip() {
		return this.flgVip;
	}

	public void setFlgVip(String flgVip) {
		this.flgVip = flgVip;
	}

	public String getFlightNo() {
		return this.flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getNextFlight() {
		return this.nextFlight;
	}

	public void setNextFlight(String nextFlight) {
		this.nextFlight = nextFlight;
	}

	public Timestamp getOperationDate() {
		return this.operationDate;
	}

	public void setOperationDate(Timestamp operationDate) {
		this.operationDate = operationDate;
	}

	public String getOriginAirportIata() {
		return this.originAirportIata;
	}

	public void setOriginAirportIata(String originAirportIata) {
		this.originAirportIata = originAirportIata;
	}

	public String getPreviousFlight() {
		return this.previousFlight;
	}

	public void setPreviousFlight(String previousFlight) {
		this.previousFlight = previousFlight;
	}

	public String getRecentAbnormalStatus() {
		return this.recentAbnormalStatus;
	}

	public void setRecentAbnormalStatus(String recentAbnormalStatus) {
		this.recentAbnormalStatus = recentAbnormalStatus;
	}

	public String getReportedAbnormal() {
		return this.reportedAbnormal;
	}

	public void setReportedAbnormal(String reportedAbnormal) {
		this.reportedAbnormal = reportedAbnormal;
	}

	public String getServiceClass() {
		return this.serviceClass;
	}

	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	public Timestamp getSta() {
		return this.sta;
	}

	public void setSta(Timestamp sta) {
		this.sta = sta;
	}

	public Timestamp getSta2() {
		return this.sta2;
	}

	public void setSta2(Timestamp sta2) {
		this.sta2 = sta2;
	}

	public Timestamp getSta3() {
		return this.sta3;
	}

	public void setSta3(Timestamp sta3) {
		this.sta3 = sta3;
	}

	public Timestamp getSta4() {
		return this.sta4;
	}

	public void setSta4(Timestamp sta4) {
		this.sta4 = sta4;
	}

	public Timestamp getSta5() {
		return this.sta5;
	}

	public void setSta5(Timestamp sta5) {
		this.sta5 = sta5;
	}

	public Timestamp getSta6() {
		return this.sta6;
	}

	public void setSta6(Timestamp sta6) {
		this.sta6 = sta6;
	}

	public Timestamp getSta7() {
		return this.sta7;
	}

	public void setSta7(Timestamp sta7) {
		this.sta7 = sta7;
	}

	public Timestamp getStd() {
		return this.std;
	}

	public void setStd(Timestamp std) {
		this.std = std;
	}

	public Timestamp getStd1() {
		return this.std1;
	}

	public void setStd1(Timestamp std1) {
		this.std1 = std1;
	}

	public Timestamp getStd2() {
		return this.std2;
	}

	public void setStd2(Timestamp std2) {
		this.std2 = std2;
	}

	public Timestamp getStd3() {
		return this.std3;
	}

	public void setStd3(Timestamp std3) {
		this.std3 = std3;
	}

	public Timestamp getStd4() {
		return this.std4;
	}

	public void setStd4(Timestamp std4) {
		this.std4 = std4;
	}

	public Timestamp getStd5() {
		return this.std5;
	}

	public void setStd5(Timestamp std5) {
		this.std5 = std5;
	}

	public Timestamp getStd6() {
		return this.std6;
	}

	public void setStd6(Timestamp std6) {
		this.std6 = std6;
	}

	public String getTaskCode() {
		return this.taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getTerminalNo() {
		return this.terminalNo;
	}

	public void setTerminalNo(String terminalNo) {
		this.terminalNo = terminalNo;
	}

}