package com.airport.ais.models.aodb.flight;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.airport.ais.enums.aodb.FlightDirection;
import com.airport.ais.enums.aodb.IDCardType;
import com.airport.ais.enums.aodb.SectorCode;
import com.airport.ais.enums.aodb.Sex;
import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      HistoryPassager.java
 * @Description  TODO �ÿ͵���ʷ����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��9��24��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��9��24��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Entity
@Table(name="History_Passenger")
public class HistoryPassenger extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */				
	public static final String  FLIGHT                    = "flight";
	public static final String  SCHEDULEDDATE             = "scheduledDate";
	public static final String  FLIGHTNUMBER              = "flightNumber";
	public static final String  FLIGHTDIRECTION           = "flightDirection";
	public static final String  NAMECN                    = "nameCn";
	public static final String  NAMEEN                    = "nameEn";
	public static final String  IDCARDTYPE                = "idCardType";
	public static final String  IDCARDNUMBER              = "idCardNumber";
	public static final String  SEX                       = "sex";
	public static final String  ADDRESS                   = "address";
	public static final String  IDCARDDEPARTMENT          = "idCardDepartment";
	public static final String  IDCARDVALIDEDATE          = "idCardValideDate";  
	public static final String  DEPARTUREAIRPORTIATACODE  = "departureAirportIATACode";
	public static final String  DEPARTUREAIRPORTCNCODE    = "departureAirportCnCode";
	public static final String  ARRIVALAIRPORTIATACODE    = "arrivalAirportIATACode";
	public static final String  ARRIVALAIRPORTCNCODE      = "arrivalAirportCnCode";
	public static final String  TICKETNUMBER              = "ticketNumber";
	public static final String  SEATCLASS                 = "seatClass";
	public static final String  SEATNUMBER                = "seatNumber";
	public static final String  BOARDNUMBER               = "boardNumber";
	public static final String  BAGGAGEIATACODE           = "baggageIATACode";
	public static final String  GATENUMBER                = "gateNumber";
	public static final String  BOARDINGTIME              = "boardingTime";
	public static final String  HASVIP                    = "hasVip";
	public static final String  HASBORAD                  = "hasBorad";
	public static final String  ICSCODE                   = "icsCode";
	public static final String  AGE                       = "age";	
	public static final String  SECTORCODE                = "sectorCode";	
	public static final String  PROVINCES                 = "provinces";	
	public static final String  CITY                      = "city";	
				
	
	
	
	/**
	 * �����ʶ
	 */
	@ManyToOne
	protected HistoryFlight flight;
	/**
	 * ����ִ������
	 */
	private Date scheduledDate;
	/**
	 * �����
	 */
	@Column(length=8)
	private String flightNumber;
	
	/**
	 * �����۱�ʶ
	 */
	@Column(length=10)
	@Enumerated(EnumType.STRING)
	private FlightDirection flightDirection;
	
	/**
	 * ��������
	 */
	@Column(length=32)
	private  String nameCn;
	/**
	 * ����Ӣ��
	 */
	@Column(length=32)
	private  String nameEn;
	/**
	 * ֤������
	 */
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private IDCardType idCardType;
	/**
	 * ֤������
	 */
	@Column(length=32)
	private String idCardNumber;
	/**
	 * �Ա�
	 */
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private Sex sex;
	/**
	 * ��ַ
	 */
	@Column(length=64)
	private String address;
	/**
	 *  ��֤����
	 */
	@Column(length=32)
	private String idCardDepartment;
	
	/**
	 * ֤����Ч��
	 */
	private Date idCardValideDate;  
	
	/**
	 *    ʼ������IATA����
	 */
	@Column(length=10)
	private String departureAirportIATACode;
	
	/**
	 *    ʼ���������Ĵ���
	 */
	@Column(length=32)
	private String departureAirportCnCode;
	/**
	 *    Ŀ�Ļ���IATA����
	 */
	@Column(length=10)
	private String arrivalAirportIATACode;
	/**
	 *   Ŀ�Ļ������Ĵ���
	 */
	@Column(length=32)
	private	String arrivalAirportCnCode;
	/**
	 * ��Ʊ��
	 */
	@Column(length=32)
	private  String ticketNumber;
	/**
	 * ��λ�ȼ�
	 */
	@Column(length=1)
	private String seatClass;
	/**
	 * ��λ��
	 */
	@Column(length=4)
	private String seatNumber;
	/**
	 * �ǻ��ƺ���
	 */
	@Column(length=32)
	private String boardNumber;
	/**
	 *  ����IATA����
	 */
	@Column(length=32)
	private String  baggageIATACode;
	
	/**
	 * �ǻ���
	 */
	private String gateNumber;
	/**
	 * �ǻ�ʱ��
	 */
	private Date boardingTime;
	/**
	 * �Ƿ�VIP
	 */
	private boolean hasVip;
	/**
	 * �Ƿ�ǻ�
	 */
	private boolean hasBorad;
	/**
	 * �ÿ�ICS����
	 */
	@Column(length=10)
	private String icsCode;
	/**
	 * ����
	 */
	private int age;
	/**
	 * ����
	 */
	private SectorCode sectorCode;
	/**
	 * ʡ��
	 */
	private String provinces;
	/**
	 * ����
	 */
	private String city;
	/**
	 * �绰����
	 */
	@Column(length=20)
	private String telephoneNumber;
	
	public HistoryFlight getFlight() {
		return flight;
	}
	public void setFlight(HistoryFlight flight) {
		this.flight = flight;
	}
	public Date getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public FlightDirection getFlightDirection() {
		return flightDirection;
	}
	public void setFlightDirection(FlightDirection flightDirection) {
		this.flightDirection = flightDirection;
	}
	public String getNameCn() {
		return nameCn;
	}
	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public IDCardType getIdCardType() {
		return idCardType;
	}
	public void setIdCardType(IDCardType idCardType) {
		this.idCardType = idCardType;
	}
	public String getIdCardNumber() {
		return idCardNumber;
	}
	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdCardDepartment() {
		return idCardDepartment;
	}
	public void setIdCardDepartment(String idCardDepartment) {
		this.idCardDepartment = idCardDepartment;
	}
	public Date getIdCardValideDate() {
		return idCardValideDate;
	}
	public void setIdCardValideDate(Date idCardValideDate) {
		this.idCardValideDate = idCardValideDate;
	}
	public String getDepartureAirportIATACode() {
		return departureAirportIATACode;
	}
	public void setDepartureAirportIATACode(String departureAirportIATACode) {
		this.departureAirportIATACode = departureAirportIATACode;
	}
	public String getDepartureAirportCnCode() {
		return departureAirportCnCode;
	}
	public void setDepartureAirportCnCode(String departureAirportCnCode) {
		this.departureAirportCnCode = departureAirportCnCode;
	}
	public String getArrivalAirportIATACode() {
		return arrivalAirportIATACode;
	}
	public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
		this.arrivalAirportIATACode = arrivalAirportIATACode;
	}
	public String getArrivalAirportCnCode() {
		return arrivalAirportCnCode;
	}
	public void setArrivalAirportCnCode(String arrivalAirportCnCode) {
		this.arrivalAirportCnCode = arrivalAirportCnCode;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(String boardNumber) {
		this.boardNumber = boardNumber;
	}
	public String getBaggageIATACode() {
		return baggageIATACode;
	}
	public void setBaggageIATACode(String baggageIATACode) {
		this.baggageIATACode = baggageIATACode;
	}
	public String getGateNumber() {
		return gateNumber;
	}
	public void setGateNumber(String gateNumber) {
		this.gateNumber = gateNumber;
	}
	public Date getBoardingTime() {
		return boardingTime;
	}
	public void setBoardingTime(Date boardingTime) {
		this.boardingTime = boardingTime;
	}
	public boolean isHasVip() {
		return hasVip;
	}
	public void setHasVip(boolean hasVip) {
		this.hasVip = hasVip;
	}
	public boolean isHasBorad() {
		return hasBorad;
	}
	public void setHasBorad(boolean hasBorad) {
		this.hasBorad = hasBorad;
	}
	public String getIcsCode() {
		return icsCode;
	}
	public void setIcsCode(String icsCode) {
		this.icsCode = icsCode;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public SectorCode getSectorCode() {
		return sectorCode;
	}
	public void setSectorCode(SectorCode sectorCode) {
		this.sectorCode = sectorCode;
	}
	public String getProvinces() {
		return provinces;
	}
	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
}

	
	
	
