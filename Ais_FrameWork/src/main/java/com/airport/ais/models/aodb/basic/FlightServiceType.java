package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airport.ais.models.DefaultEntity;


/**
 * 
 * 
 * FileName      FlightServiceType.java
 * @Description  TODO �������͵�ʵ����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��14��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��14��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Entity
@Table(name="FlightServiceType")
public class FlightServiceType extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String SERVICETYPEIATACODE = "serviceTypeIATACode";	
	public static final String ENGLISHDESCRIPTION  = "englishDescription";	
	public static final String CHINESEDESCRIPTION  = "chineseDescription";
	public static final String FLIGHTNATURE        = "flightNature";
	/**
	 * IATA����
	 */
	@Id
	@Column(length=1)
	private String serviceTypeIATACode;
	/**
	 *  Ӣ������
	 */
	@Column(length=32)
	private String englishDescription;
	/**
	 * ��������
	 */
	@Column(length=32)
	private String chineseDescription;
	/**
	 * �������ʴ���
	 */
	@ManyToOne
	private FlightNature flightNature;
	
	public String getServiceTypeIATACode() {
		return serviceTypeIATACode;
	}
	
	public void setServiceTypeIATACode(String serviceTypeIATACode) {
		this.serviceTypeIATACode = serviceTypeIATACode;
	}
	
	public String getEnglishDescription() {
		return englishDescription;
	}
	
	public void setEnglishDescription(String englishDescription) {
		this.englishDescription = englishDescription;
	}
	
	public String getChineseDescription() {
		return chineseDescription;
	}
	
	public void setChineseDescription(String chineseDescription) {
		this.chineseDescription = chineseDescription;
	}
	
	public FlightNature getFlightNature() {
		return flightNature;
	}
	
	public void setFlightNature(FlightNature flightNature) {
		this.flightNature = flightNature;
	}
	

	@Override
	public Object getIdValue() {
		// TODO Auto-generated method stub
		return this.serviceTypeIATACode;
	}

}
