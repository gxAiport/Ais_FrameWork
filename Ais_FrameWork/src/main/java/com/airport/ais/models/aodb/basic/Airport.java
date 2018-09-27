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
 * FileName      Airport.java
 * @Description  TODO ������ʵ���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Entity
@Table(name="Airport")
public class Airport extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String IATACODE                   = "IATACode";
	public static final String ICAOCODE                   = "ICAOCode";
	public static final String ENGLISHNAME                = "ENGLISHNAME";
	public static final String CHINESENAME                = "chineseName";
	public static final String SHORTNAME                  = "shortName";
	public static final String SECTOR                     = "sector";
	public static final String DESCRIPTION                = "description";
	public static final String MAXIMUMSUBTYPE             = "maximumSubtype";
	public static final String INTERVALDELAYTIME          = "intervalDelayTime";
	public static final String RECEIVEADDRESSDEPARTURE    = "receiveAddressDeparture";
	public static final String RECEIVEADDRESSARRIVAL      = "receiveAddressArrival";
	public static final String RECEIVEADDRESSPLAN         = "receiveAddressPlan";
	public static final String RECEIVEADDRESSEST          = "receiveAddressEST";
	public static final String COUNTRYCODE                = "countryCode";
	public static final String COUNTRYNAME                = "CountryName";
	
	/**
	 * ���ִ���
	 */
	@Id
	@Column(length = 10)
	private String IATACode;
	
	/**
	 * ���ִ���
	 */
	@Column(length = 10)
	private String ICAOCode;
	
	/**
	 * Ӣ����
	 */
	@Column(length=32)
	private String englishName;
	/**
	 * ������
	 */
	@Column(length=64)
	private String chineseName;
	/**
	 *  ���м�д
	 */
	@Column(length=4)
	private String shortName;
	/**
	 * ������루����,����)
	 */
	@ManyToOne
	private Sector sector;
	/**
	 * ���Ҵ���
	 */
	@Column(length=10)
	private String countryCode;
	/**
	 * ��������
	 */
	@Column(length=32)
	private String CountryName;
	/**
	 * ����
	 */
	@Column(length=64)
	private String description;
	/**
	 * ��������������
	 */
	@ManyToOne
	private AircraftSubtype maximumSubtype;
	
	
	/**
	 * �����ж�ʱ��
	 */
	private int intervalDelayTime;
	
	/**
	 * ��ɱ��յ��ַ FPL��ͬ
	 */
	private String receiveAddressDeparture;
	
	/**
	 * ��ر��յ��ַ 
	 */
	private String receiveAddressArrival;
	
	/**
	 *  �ƻ����յ��ַ
	 */
	private String receiveAddressPlan;
	
	/**
	 * ��Խ�����յ��ַ
	 */
	private String receiveAddressEST;


	/**
	 * @return the intervalDelayTime
	 */
	public int getIntervalDelayTime() {
		return intervalDelayTime;
	}

	/**
	 * @param intervalDelayTime the intervalDelayTime to set
	 */
	public void setIntervalDelayTime(int intervalDelayTime) {
		this.intervalDelayTime = intervalDelayTime;
	}

	/**
	 * @return the receiveAddressDeparture
	 */
	public String getReceiveAddressDeparture() {
		return receiveAddressDeparture;
	}

	/**
	 * @param receiveAddressDeparture the receiveAddressDeparture to set
	 */
	public void setReceiveAddressDeparture(String receiveAddressDeparture) {
		this.receiveAddressDeparture = receiveAddressDeparture;
	}

	/**
	 * @return the receiveAddressArrival
	 */
	public String getReceiveAddressArrival() {
		return receiveAddressArrival;
	}

	/**
	 * @param receiveAddressArrival the receiveAddressArrival to set
	 */
	public void setReceiveAddressArrival(String receiveAddressArrival) {
		this.receiveAddressArrival = receiveAddressArrival;
	}

	/**
	 * @return the receiveAddressPlan
	 */
	public String getReceiveAddressPlan() {
		return receiveAddressPlan;
	}

	/**
	 * @param receiveAddressPlan the receiveAddressPlan to set
	 */
	public void setReceiveAddressPlan(String receiveAddressPlan) {
		this.receiveAddressPlan = receiveAddressPlan;
	}

	/**
	 * @return the receiveAddressEST
	 */
	public String getReceiveAddressEST() {
		return receiveAddressEST;
	}

	/**
	 * @param receiveAddressEST the receiveAddressEST to set
	 */
	public void setReceiveAddressEST(String receiveAddressEST) {
		this.receiveAddressEST = receiveAddressEST;
	}

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
	
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AircraftSubtype getMaximumSubtype() {
		return maximumSubtype;
	}

	public void setMaximumSubtype(AircraftSubtype maximumSubtype) {
		this.maximumSubtype = maximumSubtype;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	

	@Override
	public Object getIdValue() {
		// TODO Auto-generated method stub
		return this.IATACode;
	}
	
	
	

}
