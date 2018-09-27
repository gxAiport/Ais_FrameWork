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
 * FileName      FlightClassification.java
 * @Description  TODO ��������ʵ����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Entity
@Table(name="FlightClassification")
public class FlightClassification extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String CLASSIFICATIONCODE = "classificationCode";	
	public static final String ENGLISHDESCRIPTION = "englishDescription";	
	public static final String CHINESEDESCRIPTION = "chineseDescription";	
	public static final String FLIGHTSERVICETYPE  = "flightServiceType";	
	
	/**
	 * �������
	 */
	@Id
	@Column(length=3)
	private String classificationCode;
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
	 * �����������
	 */
	@ManyToOne
	private FlightServiceType flightServiceType;
	
	public String getClassificationCode() {
		return classificationCode;
	}
	
	public void setClassificationCode(String classificationCode) {
		this.classificationCode = classificationCode;
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
	
	public FlightServiceType getFlightServiceType() {
		return flightServiceType;
	}
	
	public void setFlightServiceType(FlightServiceType flightServiceType) {
		this.flightServiceType = flightServiceType;
	}
	

	@Override
	public Object getIdValue() {
		// TODO Auto-generated method stub
		return this.classificationCode;
	}
	

}
