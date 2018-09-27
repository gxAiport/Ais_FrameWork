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
 * FileName      Carrier.java
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
@Table(name="Carrier")
public class Carrier extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final  String CARRIERCODE                = "carrierCode";
	public static final  String SETTLEMENTOWNERCODE        = "settlementOwnerCode";
	public static final  String SETTLEMENTPAYCODE          = "settlementPayCode";
	public static final  String ENGLISHNAME                = "englishName";
	public static final  String CHINESENAME                = "chineseName";
	public static final  String DESCRIPTION                = "description";
	public static final  String AIRLINE                    = "airline";
	public static final  String FLIGHTSERVICETYPE          = "flightServiceType";
	public static final  String CARGOCHECK                 = "cargoCheck";
	
	/**
	 * �����˴���
	 */
	@Id
	@Column(length=3)
	private String carrierCode;
	/**
	 *  ������룬����������
	 */
	@Column(length=3)
	private String settlementOwnerCode;  
	
	/**
	 *  ������룬����������
	 */
	@Column(length=5)
	private String settlementPayCode;
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
	 * �������չ�˾
	 */
	@ManyToOne
	private Airline airline;
	/**
	 * ��������
	 */
	@ManyToOne
	private FlightServiceType flightServiceType;
	/**
	 * �����жϱ�־������������
	 */
	private boolean cargoCheck;
	
	public String getCarrierCode() {
		return carrierCode;
	}
	
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	
	public String getSettlementOwnerCode() {
		return settlementOwnerCode;
	}
	
	public void setSettlementOwnerCode(String settlementOwnerCode) {
		this.settlementOwnerCode = settlementOwnerCode;
	}
	
	public String getSettlementPayCode() {
		return settlementPayCode;
	}
	
	public void setSettlementPayCode(String settlementPayCode) {
		this.settlementPayCode = settlementPayCode;
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
	
	public Airline getAirline() {
		return airline;
	}
	
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
	public FlightServiceType getFlightServiceType() {
		return flightServiceType;
	}
	
	public void setFlightServiceType(FlightServiceType flightServiceType) {
		this.flightServiceType = flightServiceType;
	}
	
	public boolean isCargoCheck() {
		return cargoCheck;
	}
	
	public void setCargoCheck(boolean cargoCheck) {
		this.cargoCheck = cargoCheck;
	}
	

	@Override
	public Object getIdValue() {
		// TODO Auto-generated method stub
		return this.carrierCode;
	}

}
