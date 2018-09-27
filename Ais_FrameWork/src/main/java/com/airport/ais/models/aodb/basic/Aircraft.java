package com.airport.ais.models.aodb.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airport.ais.models.DefaultEntity;

/**
 * 
 * 
 * FileName      Aiscraft.java
 * @Description  TODO �ɻ�ע����Ϣ��ʵ���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Entity
@Table(name="Aircraft")
public class Aircraft extends DefaultEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String  REGISTRATION               = "registration";
	public static final String  REGISTRATIONDESCRIPTION    = "registrationDescription";
	public static final String  CARRIER                    = "carrier";
	public static final String  AIRCRAFTSUBTYPE            = "aircraftSubtype";
	public static final String  PASSENGERCAPACITY          = "passengerCapacity";
	public static final String  AIRCRAFTNOSENUMBER         = "aircraftNoseNumber";
	public static final String  SETTLEMENTWEIGHT           = "settlementWeight";	
	public static final String  SETTLEMENTLOAD             = "settlementPayload";
	public static final String  MAXIMUMPAYLOAD             = "maximumPayload";
	public static final String  MAXIMUMPASSENGERCAPACITY   = "maximumPassengerCapacity";
	public static final String  AVAILABLEPAYLOAD           = "availablePayload";
	public static final String  AVAILABLEPASSENGERCAPACITY = "availablePassengerCapacity";
	public static final String  EQUIPMENT                  = "equipment";
	public static final String  CALLSIGN                   = "callsign";
	public static final String  STARUSETTIME               = "startUseTime";
	public static final String  STOPUSETIME                = "stopUseTime";
	
	/**
	 * �ɻ�ע���
	 */
	@Id
	@Column(length=15)
	private String  registration;
	/**
	 * �ɻ�ע��ŵ����� 
	 */
	@Column(length=64)
	private String  registrationDescription;
	/**
	 * ����������
	 */
	@ManyToOne
	private Carrier carrier;
	/**
	 * ����
	 */
	@ManyToOne
	private AircraftSubtype aircraftSubtype;
	/**
	 * �ɻ���λ��
	 */
	private Integer passengerCapacity;
	/**
	 * �ɻ�������ֵ
	 */
	private String  aircraftNoseNumber;
	/**
	 * �ɻ�������,���ڽ���ϵͳ
	 */
	private Integer settlementWeight;
	
	/**
	 * ����ҵ�أ����ڽ���
	 */
	private Integer settlementPayload;
	
	/**
	 * ���ҵ�أ�����ͳ��ϵͳ
	 */
	private Integer maximumPayload;
	/**
	 * �����λ��������ͳ��ϵͳ
	 */
	private Integer  maximumPassengerCapacity;
	/**
	 * ����ҵ�أ�����ͳ��ϵͳ
	 */
	private Integer availablePayload;
	/**
	 * ������λ��������ͳ��ϵͳ
	 */
	private Integer availablePassengerCapacity;
	
	/**
	 * �����豸�����ڿչ�ϵͳ
	 */
	private String equipment;
	/**
	 * ���ţ����ڿչ�ϵͳ
	 */
	private String callsign;
	/**
	 *  ��ʼʹ��ʱ�䣬���ڸ�������ɻ�������
	 */
	private Date startUseTime;
	/**
	 *  ֹͣʹ��ʱ�䣬���ڸ�������ɻ�������
	 */
	private Date stopUseTime;
	
	

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getRegistrationDescription() {
		return registrationDescription;
	}

	public void setRegistrationDescription(String registrationDescription) {
		this.registrationDescription = registrationDescription;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public AircraftSubtype getAircraftSubtype() {
		return aircraftSubtype;
	}

	public void setAircraftSubtype(AircraftSubtype aircraftSubtype) {
		this.aircraftSubtype = aircraftSubtype;
	}

	public Integer getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(Integer passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public String getAircraftNoseNumber() {
		return aircraftNoseNumber;
	}

	public void setAircraftNoseNumber(String aircraftNoseNumber) {
		this.aircraftNoseNumber = aircraftNoseNumber;
	}

	

	public Integer getSettlementWeight() {
		return settlementWeight;
	}

	public void setSettlementWeight(Integer settlementWeight) {
		this.settlementWeight = settlementWeight;
	}

	public Integer getMaximumPayload() {
		return maximumPayload;
	}

	public void setMaximumPayload(Integer maximumPayload) {
		this.maximumPayload = maximumPayload;
	}

	public Integer getSettlementPayload() {
		return settlementPayload;
	}

	public void setSettlementPayload(Integer settlementPayload) {
		this.settlementPayload = settlementPayload;
	}
	
	

	public Integer getMaximumPassengerCapacity() {
		return maximumPassengerCapacity;
	}

	public void setMaximumPassengerCapacity(Integer maximumPassengerCapacity) {
		this.maximumPassengerCapacity = maximumPassengerCapacity;
	}

	public Integer getAvailablePayload() {
		return availablePayload;
	}

	public void setAvailablePayload(Integer availablePayload) {
		this.availablePayload = availablePayload;
	}

	public Integer getAvailablePassengerCapacity() {
		return availablePassengerCapacity;
	}

	public void setAvailablePassengerCapacity(Integer availablePassengerCapacity) {
		this.availablePassengerCapacity = availablePassengerCapacity;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getCallsign() {
		return callsign;
	}

	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	public Date getStartUseTime() {
		return startUseTime;
	}

	public void setStartUseTime(Date startUseTime) {
		this.startUseTime = startUseTime;
	}

	public Date getStopUseTime() {
		return stopUseTime;
	}

	public void setStopUseTime(Date stopUseTime) {
		this.stopUseTime = stopUseTime;
	}

	@Override
	public Object getIdValue() {
		return this.registration;
	}

	

	
	
	

}
