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
 * FileName      Airline.java
 * @Description  TODO ���չ�˾��ʵ���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Entity
@Table(name="Airline")
public class Airline extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final  String IATACODE         = "IATACode";
	public static final  String ICAOCODE         = "ICAOCode";
	public static final  String DESCRIPTION      = "description";
	public static final  String ENGLISHNAME      = "englishName";
	public static final  String CHINESENAME      = "chineseName";
	public static final  String SECTOR           = "sector";
	public static final  String RECEIVEADDRESS   = "receiveAddress";
	
	
	
	/**
	 * ���ִ���
	 */

	@Column(length=10)
	private String IATACode;
	/**
	 * ���ִ���
	 */
	@Id
	@Column(length=10)
	private String ICAOCode;
	/**
	 * ���չ�˾Ӣ������
	 */
	@Column(length=32)
	private String englishName;
	/**
	 * ���չ�˾��������
	 */
	@Column(length=32)
	private String chineseName;
	/**
	 * ����
	 */
	@Column(length=128)
	private String description;
	/**
	 * ���չ�˾����
	 */
	@ManyToOne
	private Sector sector;
	/**
	 * ���յ�ַ�����ڿչ�ϵͳ
	 */
	private String receiveAddress;
	
	
	public String getIATACode() {
		return IATACode;
	}
	
	public void setIATACode(String iATACode) {
		IATACode = iATACode;
	}
	
	public String getICAOCode() {
		return ICAOCode;
	}
	
	public void setICAOCode(String iCAOCode) {
		ICAOCode = iCAOCode;
	}
	
	public String getEnglishName() {
		return englishName;
	}
	
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	
	public String getChineseName() {
		return chineseName;
	}
	
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Sector getSector() {
		return sector;
	}
	
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	public String getReceiveAddress() {
		return receiveAddress;
	}
	
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}

	

	@Override
	public Object getIdValue() {
		return this.IATACode;
	}

	

	

}
