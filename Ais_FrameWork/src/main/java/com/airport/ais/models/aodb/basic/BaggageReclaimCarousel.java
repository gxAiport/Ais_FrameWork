package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 
 * FileName      BaggageReclaimCarousel.java
 * @Description  TODO ����ת�̵�ʵ���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Entity
@Table(name="BaggageReclaimCarousel")
public class BaggageReclaimCarousel extends FlightResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String  BAGGAGERECLAIMCAROUSELID     = "BaggageReclaimCarouselID";	
	public static final String  CAPACITY                     = "capacity";
	public static final String  EXITDOOR                     = "exitDoor";
	
	/**
	 * ����ת��ID
	 */
	@Id
	@Column(length=15)
	private String BaggageReclaimCarouselID;
	
	/**
	 * װ������
	 */
	private Integer capacity;
	/**
	 * ���ڱ��
	 */
	private Integer exitDoor;
	
	public String getBaggageReclaimCarouselID() {
		return BaggageReclaimCarouselID;
	}
	
	public void setBaggageReclaimCarouselID(String baggageReclaimCarouselID) {
		BaggageReclaimCarouselID = baggageReclaimCarouselID;
	}
	
	public Integer getCapacity() {
		return capacity;
	}
	
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
	public Integer getExitDoor() {
		return exitDoor;
	}
	
	public void setExitDoor(Integer exitDoor) {
		this.exitDoor = exitDoor;
	}

	@Override
	public Object getIdValue() {
		return this.BaggageReclaimCarouselID;
	}
	
	
	

}
