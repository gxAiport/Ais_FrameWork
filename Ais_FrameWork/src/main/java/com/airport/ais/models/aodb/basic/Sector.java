package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.airport.ais.enums.aodb.SectorCode;
import com.airport.ais.models.DefaultEntity;

/**
 * 
 * 
 * FileName      FlightSector.java
 * @Description  TODO ���������ʵ����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Entity
@Table(name="Sector")
public class Sector extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String SECTORCODE         = "sectorCode";	
	public static final String ENGLISHDESCRIPTION = "englishDescription";	
	public static final String CHINESEDESCRIPTION = "chineseDescription";	
	public static final String FLIGHTSERVICETYPE  = "flightServiceType";		
	/**
	 * 
	 */
	@Id
	@Column(length=1)
	@Enumerated(EnumType.STRING)
	private SectorCode sectorCode;
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
	
	public SectorCode getSectorCode() {
		return sectorCode;
	}
	
	public void setSectorCode(SectorCode sectorCode) {
		this.sectorCode = sectorCode;
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
		// TODO Auto-generated method stub
		return this.sectorCode;
	}

}
