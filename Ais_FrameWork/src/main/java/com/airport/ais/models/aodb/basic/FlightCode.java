package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.airport.ais.models.DefaultEntity;

/**
 * 
 * 
 * FileName      FlightCode.java
 * @Description  TODO �������
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��7��22��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��7��22��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Entity 
public class FlightCode extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String CODE                  = "code";
	public static final String ENGLISHDESCRIPTION    = "englishDescription";	
	public static final String CHINESEDESCRIPTION    = "chineseDescription";	
	/**
	 * ��������
	 */
	@Id
	@Column(length=3)
	private String code;
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
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
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
	
	

	@Override
	public Object getIdValue() {
		return this.code;
	}
	
}
