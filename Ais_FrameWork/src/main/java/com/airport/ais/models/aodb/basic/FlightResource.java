package com.airport.ais.models.aodb.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.airport.ais.enums.aodb.ResourceStatusCode;
import com.airport.ais.models.DefaultEntity;


/**
 * FileName      FlightResource.java
 * @Description  TODO ������Դ�Ļ��� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��14��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��14��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class FlightResource extends DefaultEntity {
	
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String  DESCRIPTION                   = "description";
	public static final String  STATUSCODE                    = "statusCode";
	public static final String  STATUSSTARTDATETIME           = "statusStartDateTime";
	public static final String  STATUSENDDATETIME             = "statusEndDateTime";
	public static final String  STATUSREASON                  = "statusReason";
	
	/*
	 * ����
	 */
	@Column(length=128)
	protected String description;
	/**
	 * ״̬
	 */
	@Column(length=1)
	@Enumerated(EnumType.STRING)
	protected ResourceStatusCode statusCode;
	/**
	 * ״̬��ʼʱ��
	 */
	protected Date statusStartDateTime;
	/**
	 * ״̬����ʱ��
	 */
	protected Date statusEndDateTime;
	/**
	 *  ״̬����
	 */
	protected String statusReason;
	


	
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

	

}