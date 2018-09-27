package com.airport.ais.models.kwl;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the V_AOMMS_CAR_INFO database table.
 * 
 */
@Entity
@Table(name="V_AOMMS_CAR_INFO")
@NamedQuery(name="VAommsCarInfo.findAll", query="SELECT v FROM VAommsCarInfo v")
public class VAommsCarInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	@EmbeddedId
	private AommsId aommsId;

	@Column(name="ACTUAL_END_TIME")
	private Timestamp actualEndTime;

	@Column(name="ACTUAL_START_TIME")
	private Timestamp actualStartTime;

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

	

	@Column(name="ATA")
	private Timestamp ata;

	@Column(name="ATD")
	private Timestamp atd;

	@Column(name="BAY")
	private String bay;

	@Column(name="DEPT_NAME")
	private String deptName;

	

	@Column(name="DETAIL_NAME")
	private String detailName;

	

	@Column(name="DETAIL_SEQ")
	private int detailSeq;

	@Column(name="EST_END_TIME")
	private Timestamp estEndTime;

	@Column(name="EST_START_TIME")
	private Timestamp estStartTime;

	@Column(name="ETA")
	private Timestamp eta;

	@Column(name="ETD")
	private Timestamp etd;

	@Column(name="EVENT_CODE")
	private BigDecimal eventCode;

	@Column(name="FAR")
	private String far;

	@Column(name="FAR_ID")
	private String farId;

	
	@Column(name="NEAR")
	private String near;

	@Column(name="NEAR_ID")
	private String nearId;



	@Column(name="READ_ONLY")
	private int readOnly;

	@Column(name="RECENT_ABNORMAL_STATUS")
	private String recentAbnormalStatus;

	@Column(name="SCHED_END_TIME")
	private Timestamp schedEndTime;

	@Column(name="SCHED_ID")
	private BigDecimal schedId;

	@Column(name="SCHED_START_TIME")
	private Timestamp schedStartTime;

	@Column(name="SHOW_START_END")
	private int showStartEnd;

	@Column(name="SORT_TIME")
	private Timestamp sortTime;

	@Column(name="STA")
	private Timestamp sta;

	@Column(name="STD")
	private Timestamp std;

	public VAommsCarInfo() {
	}
	
	public AommsId getAommsId() {
		return aommsId;
	}

	public void setAommsId(AommsId aommsId) {
		this.aommsId = aommsId;
	}

	public Timestamp getActualEndTime() {
		return this.actualEndTime;
	}

	public void setActualEndTime(Timestamp actualEndTime) {
		this.actualEndTime = actualEndTime;
	}

	public Timestamp getActualStartTime() {
		return this.actualStartTime;
	}

	public void setActualStartTime(Timestamp actualStartTime) {
		this.actualStartTime = actualStartTime;
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

	public String getBay() {
		return this.bay;
	}

	public void setBay(String bay) {
		this.bay = bay;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getDetailName() {
		return this.detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}
	

	public int getDetailSeq() {
		return this.detailSeq;
	}

	public void setDetailSeq(int detailSeq) {
		this.detailSeq = detailSeq;
	}

	public Timestamp getEstEndTime() {
		return this.estEndTime;
	}

	public void setEstEndTime(Timestamp estEndTime) {
		this.estEndTime = estEndTime;
	}

	public Timestamp getEstStartTime() {
		return this.estStartTime;
	}

	public void setEstStartTime(Timestamp estStartTime) {
		this.estStartTime = estStartTime;
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

	public BigDecimal getEventCode() {
		return this.eventCode;
	}

	public void setEventCode(BigDecimal eventCode) {
		this.eventCode = eventCode;
	}

	public String getFar() {
		return this.far;
	}

	public void setFar(String far) {
		this.far = far;
	}

	public String getFarId() {
		return this.farId;
	}

	public void setFarId(String farId) {
		this.farId = farId;
	}



	public String getNear() {
		return this.near;
	}

	public void setNear(String near) {
		this.near = near;
	}

	public String getNearId() {
		return this.nearId;
	}

	public void setNearId(String nearId) {
		this.nearId = nearId;
	}
	
	public int getReadOnly() {
		return this.readOnly;
	}

	public void setReadOnly(int readOnly) {
		this.readOnly = readOnly;
	}

	public String getRecentAbnormalStatus() {
		return this.recentAbnormalStatus;
	}

	public void setRecentAbnormalStatus(String recentAbnormalStatus) {
		this.recentAbnormalStatus = recentAbnormalStatus;
	}

	public Timestamp getSchedEndTime() {
		return this.schedEndTime;
	}

	public void setSchedEndTime(Timestamp schedEndTime) {
		this.schedEndTime = schedEndTime;
	}

	public BigDecimal getSchedId() {
		return this.schedId;
	}

	public void setSchedId(BigDecimal schedId) {
		this.schedId = schedId;
	}

	public Timestamp getSchedStartTime() {
		return this.schedStartTime;
	}

	public void setSchedStartTime(Timestamp schedStartTime) {
		this.schedStartTime = schedStartTime;
	}

	public int getShowStartEnd() {
		return this.showStartEnd;
	}

	public void setShowStartEnd(int showStartEnd) {
		this.showStartEnd = showStartEnd;
	}

	public Timestamp getSortTime() {
		return this.sortTime;
	}

	public void setSortTime(Timestamp sortTime) {
		this.sortTime = sortTime;
	}

	public Timestamp getSta() {
		return this.sta;
	}

	public void setSta(Timestamp sta) {
		this.sta = sta;
	}

	public Timestamp getStd() {
		return this.std;
	}

	public void setStd(Timestamp std) {
		this.std = std;
	}
	
	public static class AommsId implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Column(name="AorD")
		private String aorD;
		
		@Column(name="DEPT_NO")
		private String deptNo;
		
		@Column(name="DETAIL_NO")
		private String detailNo;
		
		@Column(name="FLIGHT_NO")
		private String flightNo;
		
		@Column(name="OPERATION_DATE")
		private Timestamp operationDate;
		
		public String getAorD() {
			return this.aorD;
		}

		public void setAorD(String aorD) {
			this.aorD = aorD;
		}

		public String getDeptNo() {
			return this.deptNo;
		}

		public void setDeptNo(String deptNo) {
			this.deptNo = deptNo;
		}

		public String getDetailNo() {
			return this.detailNo;
		}

		public void setDetailNo(String detailNo) {
			this.detailNo = detailNo;
		}
		public String getFlightNo() {
			return this.flightNo;
		}

		public void setFlightNo(String flightNo) {
			this.flightNo = flightNo;
		}
		public Timestamp getOperationDate() {
			return this.operationDate;
		}

		public void setOperationDate(Timestamp operationDate) {
			this.operationDate = operationDate;
		}

	}
	
	
	
	

}