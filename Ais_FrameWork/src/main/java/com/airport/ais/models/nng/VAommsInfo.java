package com.airport.ais.models.nng;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * FileName      VAommsNggInfo.java
 * @Description  TODO 南宁机场服务环节实体类 
 * @author       ZhangYu    Company:    GXAirport
 * @version      V0.9a CreateDate: 2017年10月19日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月19日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
@Table(name="SA.V_AOMMS_GXJT_INFO")
@NamedQuery(name="VAommsInfo.findAll", query="SELECT v FROM VAommsInfo v")
public class VAommsInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final  String  FLIGHTNO               =   "flightNo";
	public static final  String  AORD                   =   "aord";
	public static final  String  OPERATIONDATE          =   "operationDate";
	public static final  String  STA                    =   "sta";
	public static final  String  STD                    =   "std";
	public static final  String  ATD                    =   "atd";            
	public static final  String  ATA                    =   "ata";           
	
	@Id
	@Column(name="SCHED_ID")
	private BigDecimal schedId;
	
	
	@Column(name="DETAIL_NAME")
	private String detailName;

	@Column(name="DETAIL_NO")
	private String detailNo;
	
	@Column(name="FLIGHT_NO")
	private String flightNo;
	
	private String aord;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="OPERATION_DATE")
	private Date operationDate;	
	
	@Column(name="REPEAT_COUNT")
	private BigDecimal repeatCount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date sta;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date std;

	@Temporal(TemporalType.TIMESTAMP)
	private Date atd;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date ata;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EST_START_TIME")
	private Date estStartTime;	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EST_END_TIME")
	private Date estEndTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ACTUAL_START_TIME")
	private Date actualStartTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ACTUAL_END_TIME")
	private Date actualEndTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="SCHED_START_TIME")
	private Date schedStartTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="SCHED_END_TIME")
	private Date schedEndTime;
	
	
	
	public VAommsInfo() {
	}

	public BigDecimal getSchedId() {
		return schedId;
	}

	public void setSchedId(BigDecimal schedId) {
		this.schedId = schedId;
	}

	public Date getActualEndTime() {
		return actualEndTime;
	}

	public void setActualEndTime(Date actualEndTime) {
		this.actualEndTime = actualEndTime;
	}

	public Date getActualStartTime() {
		return actualStartTime;
	}

	public void setActualStartTime(Date actualStartTime) {
		this.actualStartTime = actualStartTime;
	}

	public String getAord() {
		return aord;
	}

	public void setAord(String aord) {
		this.aord = aord;
	}

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public String getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(String detailNo) {
		this.detailNo = detailNo;
	}

	public Date getEstEndTime() {
		return estEndTime;
	}

	public void setEstEndTime(Date estEndTime) {
		this.estEndTime = estEndTime;
	}

	public Date getEstStartTime() {
		return estStartTime;
	}

	public void setEstStartTime(Date estStartTime) {
		this.estStartTime = estStartTime;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public BigDecimal getRepeatCount() {
		return repeatCount;
	}

	public void setRepeatCount(BigDecimal repeatCount) {
		this.repeatCount = repeatCount;
	}

	public Date getSchedEndTime() {
		return schedEndTime;
	}

	public void setSchedEndTime(Date schedEndTime) {
		this.schedEndTime = schedEndTime;
	}

	public Date getSchedStartTime() {
		return schedStartTime;
	}

	public void setSchedStartTime(Date schedStartTime) {
		this.schedStartTime = schedStartTime;
	}

	public Date getSta() {
		return sta;
	}

	public void setSta(Date sta) {
		this.sta = sta;
	}

	public Date getStd() {
		return std;
	}

	public void setStd(Date std) {
		this.std = std;
	}

	public Date getAtd() {
		return atd;
	}

	public void setAtd(Date atd) {
		this.atd = atd;
	}

	public Date getAta() {
		return ata;
	}

	public void setAta(Date ata) {
		this.ata = ata;
	}

	

}