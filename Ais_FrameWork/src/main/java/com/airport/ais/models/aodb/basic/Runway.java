package com.airport.ais.models.aodb.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.airport.ais.enums.aodb.ResourceStatusCode;
import com.airport.ais.models.DefaultEntity;

/**
 * 
 * 
 * FileName      Runway.java
 * @Description  TODO �ܵ���ʵ����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Entity
@Table(name="Runway")
public class Runway extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String  RUNWAYID                      = "runwayID";
	public static final String  DESCRIPTION                   = "description";
	public static final String  STATUSCODE                    = "statusCode";
	public static final String  STATUSSTARTDATETIME           = "statusStartDateTime";
	public static final String  STATUSENDDATETIME             = "statusEndDateTime";
	public static final String  STATUSREASON                  = "statusReason";
	
	/**
	 * �ܵ�ID
	 */
	@Id
	@Column(length=10)
	private String runwayID;
	/**
	 * ����
	 */
	@Column(length=64)
	private String description;
	/**
	 * ״̬
	 */
	@Column(length=1)
	@Enumerated(EnumType.STRING)
	private ResourceStatusCode statusCode;
	/**
	 * ״̬��ʼʱ��
	 */
	private Date statusStartDateTime;
	/**
	 * ״̬����ʱ��
	 */
	private Date statusEndDateTime;
	/**
	 *  ״̬����
	 */
	private String statusReason;
	
	
	
	public String getRunwayID() {
		return runwayID;
	}
	
	public void setRunwayID(String runwayID) {
		this.runwayID = runwayID;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ResourceStatusCode getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(ResourceStatusCode statusCode) {
		this.statusCode = statusCode;
	}
	
	public Date getStatusStartDateTime() {
		return statusStartDateTime;
	}
	
	public void setStatusStartDateTime(Date statusStartDateTime) {
		this.statusStartDateTime = statusStartDateTime;
	}
	
	public Date getStatusEndDateTime() {
		return statusEndDateTime;
	}
	
	public void setStatusEndDateTime(Date statusEndDateTime) {
		this.statusEndDateTime = statusEndDateTime;
	}
	
	public String getStatusReason() {
		return statusReason;
	}
	
	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}
	
	

	@Override
	public Object getIdValue() {
		return this.runwayID;
		// TODO Auto-generated method stub
	}
	

}
