package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * FileName      Stand.java
 * @Description  TODO ͣ��λ��ʵ���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 * 
 */

@Entity
@Table(name="Stand")
public class Stand extends FlightResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String  STANDPOSITION    = "standPosition";
	public static final String  STANDISSECURE    = "standIsSecure";
	public static final String  GATE             = "gate";

	/**
	 * ͣ��λ���
	 */
	@Id
	@Column(length=30)
	private String standPosition;
	/**
	 * ��ȫ�ǻ���
	 */
	private Boolean standIsSecure;
	/**
	 * ��Ӧ�ĵǻ���
	 */
	@ManyToOne
	private Gate gate;
	
	public String getStandPosition() {
		return standPosition;
	}
	
	public void setStandPosition(String standPosition) {
		this.standPosition = standPosition;
	}
	
	public Boolean getStandIsSecure() {
		return standIsSecure;
	}
	
	public void setStandIsSecure(Boolean standIsSecure) {
		this.standIsSecure = standIsSecure;
	}
	
	public Gate getGate() {
		return gate;
	}
	
	public void setGate(Gate gate) {
		this.gate = gate;
	}

	@Override
	public Object getIdValue() {
		// TODO Auto-generated method stub
		return this.standPosition;
	}
	
	
	
}
