package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * FileName      BaggageMakeupPosition.java
 * @Description  TODO ����װ��ת�̵�ʵ����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Entity
@Table(name="BaggageMakeupPosition")
public class BaggageMakeupPosition extends FlightResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String  BAGGAGEMAKEUPPOSITIONID       = "baggageMakeupPositionID";
	public static final String  CAPACITY                      = "capacity";
	
	@Id
	@Column(length=15)
	private String baggageMakeupPositionID;
	
	/**
	 * װ������
	 */
	protected Integer capacity;
	
	public String getBaggageMakeupPositionID() {
		return baggageMakeupPositionID;
	}
	
	public void setBaggageMakeupPositionID(String baggageMakeupPositionID) {
		this.baggageMakeupPositionID = baggageMakeupPositionID;
	}
	
	
	public Integer getCapacity() {
		return capacity;
	}
	
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public Object getIdValue() {
		// TODO Auto-generated method stub
		return this.baggageMakeupPositionID;
	}

	
	
}
