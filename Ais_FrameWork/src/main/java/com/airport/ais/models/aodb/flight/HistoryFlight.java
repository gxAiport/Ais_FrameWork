package com.airport.ais.models.aodb.flight;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import com.airport.ais.enums.aodb.FlightDirection;
import com.airport.ais.enums.aodb.LogisticsCustomerType;
import com.airport.ais.enums.aodb.LogisticsGoodsType;
import com.airport.ais.enums.aodb.SectorCode;
import com.airport.ais.models.IntIdEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * 
 * FileName HistoryFlight.java
 * 
 * @Description TODO ��Ӫ�������ʷ���ݣ���Ҫ�Ƕ�����к�����ص�ʵ���
 * @author ZhangYu Company: LZAirport
 * @version V0.9a CreateDate: 2017��6��20��
 * @ModificationHistory Date Author Version Description
 * <p> * ---------------------------------------------
 * <p> * 2017��6��20�� ZhangYu 1.0 1.0
 * <p> * Why & What is modified: <�޸�ԭ������>
 */

@Entity
@Table(name = "History_Flight")
public class HistoryFlight extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @Description �����ʶ��Ϣ�ľ�̬�࣬��Ψһ��ʶһ������
	 * -------------------------------------------------------------------------------------------------
	 */

	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */
	public static final String FLIGHTNUMBER        =   "flightNumber";
	public static final String FLIGHTDIRECTION     =   "flightDirection";
	public static final String SCHEDULEDDATETIME   =   "scheduledDateTime";
	public static final String EXECDATETIME        =   "execDateTime";
	public static final String SETTLEMENTDATE      =   "settlementDate";
	public static final String FLIGHTREPEATCOUNT   =   "flightRepeatCount";
	public static final String AIRLINEIATACODE     =   "airlineIATACode";

	/**
	 * �����
	 */
	@Column(length = 8)
	protected String flightNumber;
	/**
	 * �����۱�ʶ
	 */
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	protected FlightDirection flightDirection;

	@Column(length = 10)
	protected String airlineIATACode;

	/**
	 * ִ������1 ��ʶ��ۺ������ڸ��ƻ�������ڣ����ۺ������ڸ��ƻ���������
	 */
	protected Date scheduledDateTime;

	/**
	 * ִ������2 ��ʶ���к������ڶ����ƻ��������
	 */
	protected Date execDateTime;

	/**
	 * �������� ���ݽ����ۺ���ʵ��������ʱ��
	 */
	private Date settlementDate;
	/**
	 * �����ظ�������һ��ָ����
	 */
	protected Integer flightRepeatCount;

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

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getScheduledDateTime() {
		return scheduledDateTime;
	}

	public void setScheduledDateTime(Date scheduledDateTime) {
		this.scheduledDateTime = scheduledDateTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getExecDateTime() {
		return execDateTime;
	}

	public void setExecDateTime(Date execDateTime) {
		this.execDateTime = execDateTime;
	}

	public Integer getFlightRepeatCount() {
		return flightRepeatCount;
	}

	public void setFlightRepeatCount(Integer flightRepeatCount) {
		this.flightRepeatCount = flightRepeatCount;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getAirlineIATACode() {
		return airlineIATACode;
	}

	public void setAirlineIATACode(String airlineIATACode) {
		this.airlineIATACode = airlineIATACode;
	}

	/**
	 * @Description �ɻ����ݵľ�̬�࣬��ɻ�������ص����ݼ���
	 * ---------------------------------------------------------------------------------------------------------------
	 */
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */
	public static final String AIRCRAFTREGISTRATION = "aircraftRegistration";
	public static final String SUBTYPEIATACODE = "SubtypeIATACode";
	public static final String CARRIERCODE = "carrierCode";
	public static final String SETTLEMENTLOAD = "settlementPayload";
	public static final String MAXIMUMPAYLOAD = "maximumPayload";
	public static final String MAXIMUMPASSENGERCAPACITY = "maximumPassengerCapacity";
	public static final String AVAILABLEPAYLOAD = "availablePayload";
	public static final String AVAILABLEPASSENGERCAPACITY = "availablePassengerCapacity";

	/**
	 * �ɻ�ע���
	 */
	@Column(length = 15)
	protected String aircraftRegistration;
	/**
	 * ����
	 */
	@Column(length = 10)
	protected String SubtypeIATACode;

	@Column(length = 3)
	protected String carrierCode;

	/**
	 * ���ҵ�أ�����ͳ��ϵͳ
	 */
	protected Integer maximumPayload;
	/**
	 * �����λ��������ͳ��ϵͳ
	 */
	protected Integer maximumPassengerCapacity;
	/**
	 * ����ҵ�أ�����ͳ��ϵͳ
	 */
	protected Integer availablePayload;
	/**
	 * ������λ��������ͳ��ϵͳ
	 */
	protected Integer availablePassengerCapacity;

	public String getAircraftRegistration() {
		return aircraftRegistration;
	}

	public void setAircraftRegistration(String aircraftRegistration) {
		this.aircraftRegistration = aircraftRegistration;
	}

	

	public String getSubtypeIATACode() {
		return SubtypeIATACode;
	}

	public void setSubtypeIATACode(String subtypeIATACode) {
		SubtypeIATACode = subtypeIATACode;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public Integer getMaximumPayload() {
		return maximumPayload;
	}

	public void setMaximumPayload(Integer maximumPayload) {
		this.maximumPayload = maximumPayload;
	}

	public Integer getMaximumPassengerCapacity() {
		return maximumPassengerCapacity;
	}

	public void setMaximumPassengerCapacity(Integer maximumPassengerCapacity) {
		this.maximumPassengerCapacity = maximumPassengerCapacity;
	}

	public Integer getAvailablePayload() {
		return availablePayload;
	}

	public void setAvailablePayload(Integer availablePayload) {
		this.availablePayload = availablePayload;
	}

	public Integer getAvailablePassengerCapacity() {
		return availablePassengerCapacity;
	}

	public void setAvailablePassengerCapacity(Integer availablePassengerCapacity) {
		this.availablePassengerCapacity = availablePassengerCapacity;
	}

	/**
	 * @Description �������ݵľ�̬�࣬�뺽����ص�����
	 * ---------------------------------------------------------------------------------------------------------------
	 */
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */
	public static final String JOINFLIGHTNUMBER = "joinFlightNumber";
	public static final String CLASSIFICATIONCODE = "classificationCode";
	public static final String NATURECODE = "natureCode";
	public static final String SERVICETYPEIATACODE = "serviceTypeIATACode";
	public static final String DEPARTUREAIRPORTIATACODE = "departureAirportIATACode";
	public static final String ARRIVALAIRPORTIATACODE = "arrivalAirportIATACode";
	public static final String ISOPERATESOVERNIGHT = "isOperatesOvernight";
	public static final String ISBEFOREFLIGHT = "isBeforeFlight";
	public static final String ISGENERALAVIATIONFLIGHT = "isGeneralAviationFlight";
	public static final String ISTRANSFERFLIGHT = "isTransferFlight";
	public static final String SECTORCODE = "sectorCode";
	public static final String FLIGHTSTATUSCODE = "flightStatusCode";
	public static final String DIVERTAIRPORTIATACODE = "divertAirportIATACode";
	public static final String ISRETURNFLIGHT = "isReturnFlight";
	public static final String HASVIPS = "hasVIPs";
	public static final String FLIGHTCODE = "flightCode";
	public static final String CAACDELAYCATEGORYCODE = "caacDelayCategoryCode";
	public static final String CAACDELAYCODE = "caacDelayCode";
	public static final String CAACDELAYDURATION = "caacDelayDuration";
	public static final String CAACDELAYAIRPORTORIGINATED = "caacDelayAirportOriginated";
	public static final String LINKEDFLIGHTNUMBER = "linkedFlightNumber";
	public static final String LINKEDFLIGHTDIRECTION = "linkedFlightDirection";
	public static final String LINKEDSCHEDULEDDATETIME = "linkedscheduledDateTime";
	public static final String SHAREFLIGHTNUMBER_1 = "shareFlightNumber_1";
	public static final String SHAREAIRLINE_1 = "shareAirlineIATACode_1";
	public static final String SHAREFLIGHTNUMBER_2 = "shareFlightNumber_2";
	public static final String SHAREAIRLINE_2 = "shareAirlineIATACode_2";

	/**
	 * ƴ�Ӻ����
	 */
	@Column(length = 17)
	protected String joinFlightNumber;
	/**
	 * ���������룬���� W/Z
	 */
	@Column(length = 3)
	protected String classificationCode;

	/**
	 * �������ʣ�����PAX
	 */
	@Column(length = 3)
	protected String natureCode;

	/**
	 * ����������ʣ�����J
	 */
	@Column(length = 1)
	protected String serviceTypeIATACode;
	/**
	 * �����������
	 */
	protected String serviceTypeCnName;
	/**
	 * ����������ڹ���
	 */
	protected SectorCode sectorCode;
	/**
	 * ���ۻ���IATA����
	 */
	@Column(length = 10)
	protected String departureAirportIATACode;

	/**
	 * �������IATA����
	 */
	@Column(length = 10)
	protected String arrivalAirportIATACode;

	/**
	 * ��������־
	 */
	protected Boolean isOperatesOvernight;
	/**
	 * ��ǰ�����־
	 */
	protected Boolean isBeforeFlight;
	/**
	 * ͨ�������־
	 */
	protected Boolean isGeneralAviationFlight;
	/**
	 * ��ת�����־
	 */
	protected Boolean isTransferFlight;
	/**
	 * ����״̬
	 */
	@Column(length = 3)
	protected String flightStatusCode;
	/**
	 * ��������IATA����
	 */
	@Column(length = 10)
	protected String divertAirportIATACode;

	/**
	 * ���ຽ���ʶ
	 */
	protected Boolean isReturnFlight;
	/**
	 * �Ƿ���VIP
	 */
	protected Boolean hasVIPs;
	/**
	 * �������
	 */
	@Column(length = 3)
	protected String flightCode;
	/**
	 * �������
	 */
	@Column(length = 4)
	protected String caacDelayCategoryCode;
	/**
	 * �������
	 */
	@Column(length = 4)
	protected String caacDelayCode;
	/**
	 * ����ʱ��
	 */
	@Column(length = 6)
	protected String caacDelayDuration;
	/**
	 * �Ƿ���ʼ������ԭ��
	 */
	protected Boolean caacDelayAirportOriginated;
	/**
	 * ���Ӻ����
	 */
	@Column(length = 8)
	protected String linkedFlightNumber;
	/**
	 * �����۱�ʶ
	 */
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	protected FlightDirection linkedFlightDirection;
	/**
	 * ���Ӻ�������
	 */
	protected Date linkedscheduledDateTime;
	/**
	 * �������
	 */
	@Column(length = 8)
	protected String shareFlightNumber_1;
	/**
	 * �����չ�˾
	 */
	@Column(length = 10)
	protected String shareAirlineICAOCode_1;
	/**
	 * �������
	 */
	@Column(length = 8)
	protected String shareFlightNumber_2;
	/**
	 * �����չ�˾
	 */
	@Column(length = 10)
	protected String shareAirlineICAOCode_2;

	public String getJoinFlightNumber() {
		return joinFlightNumber;
	}

	public void setJoinFlightNumber(String joinFlightNumber) {
		this.joinFlightNumber = joinFlightNumber;
	}

	public String getClassificationCode() {
		return classificationCode;
	}

	public void setClassificationCode(String classificationCode) {
		this.classificationCode = classificationCode;
	}

	public String getNatureCode() {
		return natureCode;
	}

	public void setNatureCode(String natureCode) {
		this.natureCode = natureCode;
	}

	public String getServiceTypeIATACode() {
		return serviceTypeIATACode;
	}

	public void setServiceTypeIATACode(String serviceTypeIATACode) {
		this.serviceTypeIATACode = serviceTypeIATACode;
	}

	public SectorCode getSectorCode() {
		return sectorCode;
	}

	public void setSectorCode(SectorCode sectorCode) {
		this.sectorCode = sectorCode;
	}

	public String getDepartureAirportIATACode() {
		return departureAirportIATACode;
	}

	public void setDepartureAirportIATACode(String departureAirportIATACode) {
		this.departureAirportIATACode = departureAirportIATACode;
	}

	public String getArrivalAirportIATACode() {
		return arrivalAirportIATACode;
	}

	public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
		this.arrivalAirportIATACode = arrivalAirportIATACode;
	}

	public Boolean getIsOperatesOvernight() {
		return isOperatesOvernight;
	}

	public void setIsOperatesOvernight(Boolean isOperatesOvernight) {
		this.isOperatesOvernight = isOperatesOvernight;
	}

	public Boolean getIsBeforeFlight() {
		return isBeforeFlight;
	}

	public void setIsBeforeFlight(Boolean isBeforeFlight) {
		this.isBeforeFlight = isBeforeFlight;
	}

	public Boolean getIsGeneralAviationFlight() {
		return isGeneralAviationFlight;
	}

	public void setIsGeneralAviationFlight(Boolean isGeneralAviationFlight) {
		this.isGeneralAviationFlight = isGeneralAviationFlight;
	}

	public Boolean getIsTransferFlight() {
		return isTransferFlight;
	}

	public void setIsTransferFlight(Boolean isTransferFlight) {
		this.isTransferFlight = isTransferFlight;
	}

	public String getFlightStatusCode() {
		return flightStatusCode;
	}

	public void setFlightStatusCode(String flightStatusCode) {
		this.flightStatusCode = flightStatusCode;
	}

	public String getDivertAirportIATACode() {
		return divertAirportIATACode;
	}

	public void setDivertAirportIATACode(String divertAirportIATACode) {
		this.divertAirportIATACode = divertAirportIATACode;
	}

	public Boolean getIsReturnFlight() {
		return isReturnFlight;
	}

	public void setIsReturnFlight(Boolean isReturnFlight) {
		this.isReturnFlight = isReturnFlight;
	}

	public Boolean getHasVIPs() {
		return hasVIPs;
	}

	public void setHasVIPs(Boolean hasVIPs) {
		this.hasVIPs = hasVIPs;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getCaacDelayCategoryCode() {
		return caacDelayCategoryCode;
	}

	public void setCaacDelayCategoryCode(String caacDelayCategoryCode) {
		this.caacDelayCategoryCode = caacDelayCategoryCode;
	}

	public String getCaacDelayCode() {
		return caacDelayCode;
	}

	public void setCaacDelayCode(String caacDelayCode) {
		this.caacDelayCode = caacDelayCode;
	}

	public String getCaacDelayDuration() {
		return caacDelayDuration;
	}

	public void setCaacDelayDuration(String caacDelayDuration) {
		this.caacDelayDuration = caacDelayDuration;
	}

	public Boolean getCaacDelayAirportOriginated() {
		return caacDelayAirportOriginated;
	}

	public void setCaacDelayAirportOriginated(Boolean caacDelayAirportOriginated) {
		this.caacDelayAirportOriginated = caacDelayAirportOriginated;
	}

	public String getLinkedFlightNumber() {
		return linkedFlightNumber;
	}

	public void setLinkedFlightNumber(String linkedFlightNumber) {
		this.linkedFlightNumber = linkedFlightNumber;
	}

	public FlightDirection getLinkedFlightDirection() {
		return linkedFlightDirection;
	}

	public void setLinkedFlightDirection(FlightDirection linkedFlightDirection) {
		this.linkedFlightDirection = linkedFlightDirection;
	}

	public Date getLinkedscheduledDateTime() {
		return linkedscheduledDateTime;
	}

	public void setLinkedscheduledDateTime(Date linkedscheduledDateTime) {
		this.linkedscheduledDateTime = linkedscheduledDateTime;
	}

	public String getShareFlightNumber_1() {
		return shareFlightNumber_1;
	}

	public void setShareFlightNumber_1(String shareFlightNumber_1) {
		this.shareFlightNumber_1 = shareFlightNumber_1;
	}

	public String getShareAirlineICAOCode_1() {
		return shareAirlineICAOCode_1;
	}

	public void setShareAirlineICAOCode_1(String shareAirlineICAOCode_1) {
		this.shareAirlineICAOCode_1 = shareAirlineICAOCode_1;
	}

	public String getShareFlightNumber_2() {
		return shareFlightNumber_2;
	}

	public void setShareFlightNumber_2(String shareFlightNumber_2) {
		this.shareFlightNumber_2 = shareFlightNumber_2;
	}

	public String getShareAirlineICAOCode_2() {
		return shareAirlineICAOCode_2;
	}

	public void setShareAirlineICAOCode_2(String shareAirlineICAOCode_2) {
		this.shareAirlineICAOCode_2 = shareAirlineICAOCode_2;
	}

	public String getServiceTypeCnName() {
		return serviceTypeCnName;
	}

	public void setServiceTypeCnName(String serviceTypeCnName) {
		this.serviceTypeCnName = serviceTypeCnName;
	}

	/**
	 * @Description �������ݵľ�̬�࣬�������ص����ݼ���
	 * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */

	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */
	public static final String LOCALAIRPOTIATACODE = "localAirpotIATACode";
	public static final String TERMINALCODE = "terminalCode";
	public static final String STANDPOSITION = "standPosition";
	public static final String RUNWAYID = "runwayID";
	public static final String BAGGAGEMAKEUPPOSITIONID = "baggageMakeupPositionID";
	public static final String BAGGAGEMAKEUPOPENDATETIME = "baggageMakeupOpenDateTime";
	public static final String BAGGAGEMAKEUPCLOSEDATETIME = "baggageMakeupCloseDateTime";
	public static final String BAGGAGERECLAIMCAROUSELID = "baggageReclaimCarouselID";
	public static final String BAGGAGERECLAIMOPENDATETIME = "baggageReclaimOpenDateTime";
	public static final String BAGGAGERECLAIMCLOSEDATETIME = "baggageReclaimCloseDateTime";
	public static final String FIRSTBAGDATETIME = "firstBagDateTime";
	public static final String LASTBAGDATETIME = "lastBagDateTime";
	public static final String EXITDOORNUMBER = "exitDoorNumber";
	public static final String CHECKINDESKRANGE = "checkinDeskRange";
	public static final String CHECKINOPENDATETIME = "checkinOpenDateTime";
	public static final String CHECKINCLOSEDATETIME = "checkinCloseDateTime";
	public static final String GATENUMBER = "gateNumber";
	public static final String GATEOPENDATETIME = "gateOpenDateTime";
	public static final String GATECLOSEDATETIME = "gateCloseDateTime";
	/**
	 * ���ػ���
	 */
	@Column(length = 10)
	protected String localAirpotIATACode;

	/**
	 * ��Ƶ��
	 */
	protected Integer landFreq;
	/**
	 * ��վ¥
	 */
	@Column(length = 4)
	protected String terminalCode;
	/**
	 * ͣ��λ
	 */
	@Column(length = 15)
	protected String standPosition;
	/**
	 * �ܵ�
	 */
	@Column(length = 10)
	protected String runwayID;
	/**
	 * ����װ��ת�̱��
	 */
	@Column(length = 4)
	protected String baggageMakeupPositionID;
	/**
	 * ����ʱ��
	 */
	protected Date baggageMakeupOpenDateTime;
	/**
	 * �ر�ʱ��
	 */
	protected Date baggageMakeupCloseDateTime;

	/**
	 * ������ȡת�̱��
	 */
	@Column(length = 4)
	protected String baggageReclaimCarouselID;

	/**
	 * ����ʱ��
	 */
	protected Date baggageReclaimOpenDateTime;
	/**
	 * �ر�ʱ��
	 */
	protected Date baggageReclaimCloseDateTime;
	/**
	 * ����ʱ��
	 */
	protected Date firstBagDateTime;
	/**
	 * �ر�ʱ��
	 */
	protected Date lastBagDateTime;
	/**
	 * ���ڱ�ʶ
	 */
	@Column(length = 4)
	protected String exitDoorNumber;

	@Column(length = 32)
	protected String checkinDeskRange;
	/**
	 * ֵ����ʼʱ��
	 */
	protected Date checkinOpenDateTime;
	/**
	 * ֵ������ʱ��
	 */
	protected Date checkinCloseDateTime;
	/**
	 * �ǻ��ڱ��
	 */
	protected String gateNumber;
	/**
	 * �ǻ����ŵ�ʱ��
	 */
	protected Date gateOpenDateTime;
	/**
	 * �ǻ�������ʱ��
	 */
	protected Date gateCloseDateTime;

	public String getLocalAirpotIATACode() {
		return localAirpotIATACode;
	}

	public void setLocalAirpotIATACode(String localAirpotIATACode) {
		this.localAirpotIATACode = localAirpotIATACode;
	}

	public Integer getLandFreq() {
		return landFreq;
	}

	public void setLandFreq(Integer landFreq) {
		this.landFreq = landFreq;
	}

	public String getTerminalCode() {
		return terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	public String getStandPosition() {
		return standPosition;
	}

	public void setStandPosition(String standPosition) {
		this.standPosition = standPosition;
	}

	public String getRunwayID() {
		return runwayID;
	}

	public void setRunwayID(String runwayID) {
		this.runwayID = runwayID;
	}

	public String getBaggageMakeupPositionID() {
		return baggageMakeupPositionID;
	}

	public void setBaggageMakeupPositionID(String baggageMakeupPositionID) {
		this.baggageMakeupPositionID = baggageMakeupPositionID;
	}

	public Date getBaggageMakeupOpenDateTime() {
		return baggageMakeupOpenDateTime;
	}

	public void setBaggageMakeupOpenDateTime(Date baggageMakeupOpenDateTime) {
		this.baggageMakeupOpenDateTime = baggageMakeupOpenDateTime;
	}

	public Date getBaggageMakeupCloseDateTime() {
		return baggageMakeupCloseDateTime;
	}

	public void setBaggageMakeupCloseDateTime(Date baggageMakeupCloseDateTime) {
		this.baggageMakeupCloseDateTime = baggageMakeupCloseDateTime;
	}

	public String getBaggageReclaimCarouselID() {
		return baggageReclaimCarouselID;
	}

	public void setBaggageReclaimCarouselID(String baggageReclaimCarouselID) {
		this.baggageReclaimCarouselID = baggageReclaimCarouselID;
	}

	public Date getBaggageReclaimOpenDateTime() {
		return baggageReclaimOpenDateTime;
	}

	public void setBaggageReclaimOpenDateTime(Date baggageReclaimOpenDateTime) {
		this.baggageReclaimOpenDateTime = baggageReclaimOpenDateTime;
	}

	public Date getBaggageReclaimCloseDateTime() {
		return baggageReclaimCloseDateTime;
	}

	public void setBaggageReclaimCloseDateTime(Date baggageReclaimCloseDateTime) {
		this.baggageReclaimCloseDateTime = baggageReclaimCloseDateTime;
	}

	public Date getFirstBagDateTime() {
		return firstBagDateTime;
	}

	public void setFirstBagDateTime(Date firstBagDateTime) {
		this.firstBagDateTime = firstBagDateTime;
	}

	public Date getLastBagDateTime() {
		return lastBagDateTime;
	}

	public void setLastBagDateTime(Date lastBagDateTime) {
		this.lastBagDateTime = lastBagDateTime;
	}

	public String getExitDoorNumber() {
		return exitDoorNumber;
	}

	public void setExitDoorNumber(String exitDoorNumber) {
		this.exitDoorNumber = exitDoorNumber;
	}

	public String getCheckinDeskRange() {
		return checkinDeskRange;
	}

	public void setCheckinDeskRange(String checkinDeskRange) {
		this.checkinDeskRange = checkinDeskRange;
	}

	public Date getCheckinOpenDateTime() {
		return checkinOpenDateTime;
	}

	public void setCheckinOpenDateTime(Date checkinOpenDateTime) {
		this.checkinOpenDateTime = checkinOpenDateTime;
	}

	public Date getCheckinCloseDateTime() {
		return checkinCloseDateTime;
	}

	public void setCheckinCloseDateTime(Date checkinCloseDateTime) {
		this.checkinCloseDateTime = checkinCloseDateTime;
	}

	public String getGateNumber() {
		return gateNumber;
	}

	public void setGateNumber(String gateNumber) {
		this.gateNumber = gateNumber;
	}

	public Date getGateOpenDateTime() {
		return gateOpenDateTime;
	}

	public void setGateOpenDateTime(Date gateOpenDateTime) {
		this.gateOpenDateTime = gateOpenDateTime;
	}

	public Date getGateCloseDateTime() {
		return gateCloseDateTime;
	}

	public void setGateCloseDateTime(Date gateCloseDateTime) {
		this.gateCloseDateTime = gateCloseDateTime;
	}

	/**
	 * @Description ����ʱ����صľ�̬�࣬���в���ʱ��ļ��� ע������ʱ��Ҳ������������ʱ����
	 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */
	public static final String ACTUALOFFBLOCKSDATETIME = "actualOffBlocksDateTime";
	public static final String ACTUALONBLOCKSDATETIME = "actualOnBlocksDateTime";
	public static final String SCHEDULEDDEPARTUREDATETIME = "scheduledDepartureDateTime";
	public static final String ESTIMATEDDEPARTUREDATETIME = "estimatedDepartureDateTime";
	public static final String ACTUALAIRBORNEDATETIME = "actualAirborneDateTime";
	public static final String SCHEDULEDARRIVALDATETIME = "scheduledArrivalDateTime";
	public static final String ESTIMATEDARRIVALDATETIME = "estimatedArrivalDateTime";
	public static final String ACTUALLANDDATETIME = "actualLandDateTime";
	public static final String ESTIMATEDFLIGHTDURATION = "estimatedFlightDuration";

	/**
	 * ʵ��ͣ��ͣ��λ��ʱ��
	 */
	protected Date actualOffBlocksDateTime;
	/**
	 * ʵ��ͣ��ͣ��λ��ʱ��
	 */
	protected Date actualOnBlocksDateTime;

	/**
	 * �ƻ�������ʱ��
	 */
	protected Date scheduledDepartureDateTime;
	/**
	 * Ԥ�Ƴ�����ʱ��
	 */
	protected Date estimatedDepartureDateTime;
	/**
	 * ʵ����ɵ�ʱ��
	 */
	protected Date actualAirborneDateTime;
	/**
	 * �ƻ������ʱ��
	 */
	protected Date scheduledArrivalDateTime;
	/**
	 * Ԥ�Ƶ����ʱ��
	 */
	protected Date estimatedArrivalDateTime;
	/**
	 * ʵ����ص�ʱ��
	 */
	protected Date actualLandDateTime;
	/**
	 * Ԥ�Ʒ���ʱ��
	 */
	@Column(length = 6)
	protected String estimatedFlightDuration;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getActualOffBlocksDateTime() {
		return actualOffBlocksDateTime;
	}

	public void setActualOffBlocksDateTime(Date actualOffBlocksDateTime) {
		this.actualOffBlocksDateTime = actualOffBlocksDateTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getActualOnBlocksDateTime() {
		return actualOnBlocksDateTime;
	}

	public void setActualOnBlocksDateTime(Date actualOnBlocksDateTime) {
		this.actualOnBlocksDateTime = actualOnBlocksDateTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getActualAirborneDateTime() {
		return actualAirborneDateTime;
	}

	public void setActualAirborneDateTime(Date actualAirborneDateTime) {
		this.actualAirborneDateTime = actualAirborneDateTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getActualLandDateTime() {
		return actualLandDateTime;
	}

	public void setActualLandDateTime(Date actualLandDateTime) {
		this.actualLandDateTime = actualLandDateTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getScheduledDepartureDateTime() {
		return scheduledDepartureDateTime;
	}

	public void setScheduledDepartureDateTime(Date scheduledDepartureDateTime) {
		this.scheduledDepartureDateTime = scheduledDepartureDateTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getEstimatedDepartureDateTime() {
		return estimatedDepartureDateTime;
	}

	public void setEstimatedDepartureDateTime(Date estimatedDepartureDateTime) {
		this.estimatedDepartureDateTime = estimatedDepartureDateTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getScheduledArrivalDateTime() {
		return scheduledArrivalDateTime;
	}

	public void setScheduledArrivalDateTime(Date scheduledArrivalDateTime) {
		this.scheduledArrivalDateTime = scheduledArrivalDateTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getEstimatedArrivalDateTime() {
		return estimatedArrivalDateTime;
	}

	public void setEstimatedArrivalDateTime(Date estimatedArrivalDateTime) {
		this.estimatedArrivalDateTime = estimatedArrivalDateTime;
	}

	public String getEstimatedFlightDuration() {
		return estimatedFlightDuration;
	}

	public void setEstimatedFlightDuration(String estimatedFlightDuration) {
		this.estimatedFlightDuration = estimatedFlightDuration;
	}

	/**
	 * @Description �������ݵľ�̬�࣬�뺽��������ص����ݼ���
	 * -------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */
	public static final String FIRSTSTATIONIATACODE = "firstStationIATACode";
	public static final String STOPIATACODE_1 = "stopIATACode_1";
	public static final String STOPIATACODE_2 = "stopIATACode_2";
	public static final String DESTINATIONSTATIONIATACODE = "destinationStationIATACode";
	public static final String AIRROUTE = "airRoute";
	public static final String CHINESEROUTE = "chineseRoute";
	public static final String IATAROUTE = "IATARoute";
	public static final String SHORTROUTE = "shortRoute";
	public static final String AIRROUTEDISTANCE = "airRouteDistance";

	/**
	 * ��·
	 */
	@Column(length = 64)
	protected String airRoute;
	/**
	 * ���ߵľ���
	 */
	protected Integer airRouteDistance;
	/**
	 * ��ʼ����IATA����
	 */
	@Column(length = 10)
	protected String firstStationIATACode;
	/**
	 * ��ͣ��1 IATA����
	 */
	@Column(length = 10)
	protected String stopIATACode_1;
	/**
	 * ��ͣ��2 IATA����
	 */
	@Column(length = 10)
	protected String stopIATACode_2;
	/**
	 * �ն˻���
	 */
	@Column(length = 10)
	protected String destinationStationIATACode;
	/**
	 * ��������
	 */
	@Column(length = 128)
	private String chineseRoute;
	/**
	 * ����IATA����
	 */
	@Column(length = 64)
	private String IATARoute;
	/***
	 * ���߼�д
	 */
	@Column(length = 64)
	private String shortRoute;

	public String getAirRoute() {
		return airRoute;
	}

	public void setAirRoute(String airRoute) {
		this.airRoute = airRoute;
	}

	public Integer getAirRouteDistance() {
		return airRouteDistance;
	}

	public void setAirRouteDistance(Integer airRouteDistance) {
		this.airRouteDistance = airRouteDistance;
	}

	public String getFirstStationIATACode() {
		return firstStationIATACode;
	}

	public void setFirstStationIATACode(String firstStationIATACode) {
		this.firstStationIATACode = firstStationIATACode;
	}

	public String getStopIATACode_1() {
		return stopIATACode_1;
	}

	public void setStopIATACode_1(String stopIATACode_1) {
		this.stopIATACode_1 = stopIATACode_1;
	}

	public String getStopIATACode_2() {
		return stopIATACode_2;
	}

	public void setStopIATACode_2(String stopIATACode_2) {
		this.stopIATACode_2 = stopIATACode_2;
	}

	public String getDestinationStationIATACode() {
		return destinationStationIATACode;
	}

	public void setDestinationStationIATACode(String destinationStationIATACode) {
		this.destinationStationIATACode = destinationStationIATACode;
	}

	public String getChineseRoute() {
		return chineseRoute;
	}

	public void setChineseRoute(String chineseRoute) {
		this.chineseRoute = chineseRoute;
	}

	public String getIATARoute() {
		return IATARoute;
	}

	public void setIATARoute(String iATARoute) {
		IATARoute = iATARoute;
	}

	public String getShortRoute() {
		return shortRoute;
	}

	public void setShortRoute(String shortRoute) {
		this.shortRoute = shortRoute;
	}

	/**
	 * @Description ���������ľ�̬�࣬��������ص��������ݵļ���
	 *------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
	public static final String PASSENGERLOADFACTOR = "passengerLoadFactor";
	public static final String PASSENGERTONKILOMETERS = "passengerTonkilometers";
	public static final String PASSENGERKILOMETERS = "passengerKilometers";
	public static final String CARGOTONKILOMETERS = "cargoMailTonkilometers";
	public static final String ADULT = "adult";
	public static final String CHD = "chd";
	public static final String INF = "inf";
	public static final String CARGO = "cargo";
	public static final String MAIL = "mail";
	public static final String BAGGAGE = "baggage";
	public static final String LOADS = "loads";
	public static final String PASSAGERLABELCOUNTS = "passagerLabelCounts";
	public static final String LOGISTICSDEPARTURELABELCOUNTS = "logisticsDepartureLabelCounts";
	public static final String LOGISTICSDEPARTURELOADCOUNTS  = "logisticsDepartureLoadCounts";
	public static final String LOGISTICSARRIVALLABELCOUNTS   = "logisticsArrivalLabelCounts";
	/**
	 * ���������
	 */
	private Double passengerLoadFactor;
	/**
	 * �ÿ���ת��(�ֹ���)
	 */
	private Integer passengerTonkilometers;

	/**
	 * �ÿ���ת��(�˹���)
	 */
	private Integer passengerKilometers;
	/**
	 * ������ת��
	 */
	private Integer cargoMailTonkilometers;

	/**
	 * ����
	 */
	private Integer adult;
	/**
	 * ��ͯ
	 */
	private Integer chd;
	/**
	 * Ӥ��
	 */
	private Integer inf;
	/**
	 * ����
	 */
	private Integer cargo;
	/**
	 * �ʼ�
	 */
	private Integer mail;
	/**
	 * ����
	 */
	private Integer baggage;
	/**
	 * ��ת����
	 */
	private Integer transferAdult;
	/**
	 * ��ת��ͯ
	 */
	private Integer transferChd;
	/**
	 * ��תӤ��
	 */
	private Integer transferInf;

	/**
	 * ��ϸ��������
	 */
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST }, orphanRemoval = true)
	@JoinColumn(name = "historyFlight_id")
	protected Set<Load> loads;

	/**
	 * �ÿͱ�ǩͳ�ƶ�
	 */
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST }, orphanRemoval = true)
	@JoinColumn(name = "historyFlight_id")
	protected Set<PassengerLabelCount> passengerLabelCounts;
	
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST }, orphanRemoval = true)
	@JoinColumn(name = "historyFlight_id")
	protected Set<LogisticsDepartureLabelCount> logisticsDepartureLabelCounts;
	
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST }, orphanRemoval = true)
	@JoinColumn(name = "historyFlight_id")
	protected Set<LogisticsDepartureLoadCount> logisticsDepartureLoadCounts;
	
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST }, orphanRemoval = true)
	@JoinColumn(name = "historyFlight_id")
	protected Set<LogisticsArrivalLabelCount> logisticsArrivalLabelCounts;
	
	

	public Set<Load> getLoads() {
		if (loads == null) {
			loads = new HashSet<Load>();
		}
		return loads;
	}

	public void setLoads(Set<Load> loads) {
		this.loads = loads;
	}
	
	

	public Set<PassengerLabelCount> getPassagerLabelCounts() {
		if (passengerLabelCounts == null){
			passengerLabelCounts = new HashSet<PassengerLabelCount>();
		}
		return passengerLabelCounts;
	}

	public void setPassagerLabelCounts(Set<PassengerLabelCount> passagerLabelCounts) {
		this.passengerLabelCounts = passagerLabelCounts;
	}

	public Set<LogisticsDepartureLabelCount> getLogisticsDepartureLabelCounts() {
		if (logisticsDepartureLabelCounts == null){
			logisticsDepartureLabelCounts = new HashSet<LogisticsDepartureLabelCount>();
		}
		return logisticsDepartureLabelCounts;
	}

	public void setLogisticsDepartureLabelCounts(Set<LogisticsDepartureLabelCount> logisticsDepartureLabelCounts) {
		this.logisticsDepartureLabelCounts = logisticsDepartureLabelCounts;
	}

	public Set<LogisticsDepartureLoadCount> getLogisticsDepartureLoadCounts() {
		if (logisticsDepartureLoadCounts == null){
			logisticsDepartureLoadCounts = new HashSet<LogisticsDepartureLoadCount>();
		}
		return logisticsDepartureLoadCounts;
	}

	public void setLogisticsDepartureLoadCounts(Set<LogisticsDepartureLoadCount> logisticsDepartureLoadCounts) {
		this.logisticsDepartureLoadCounts = logisticsDepartureLoadCounts;
	}

	public Set<LogisticsArrivalLabelCount> getLogisticsArrivalLabelCounts() {
		return logisticsArrivalLabelCounts;
	}

	public void setLogisticsArrivalLabelCounts(Set<LogisticsArrivalLabelCount> logisticsArrivalLabelCounts) {
		this.logisticsArrivalLabelCounts = logisticsArrivalLabelCounts;
	}

	public Double getPassengerLoadFactor() {
		return passengerLoadFactor;
	}

	public void setPassengerLoadFactor(Double passengerLoadFactor) {
		this.passengerLoadFactor = passengerLoadFactor;
	}

	public Integer getPassengerTonkilometers() {
		return passengerTonkilometers;
	}

	public void setPassengerTonkilometers(Integer passengerTonkilometers) {
		this.passengerTonkilometers = passengerTonkilometers;
	}

	public Integer getPassengerKilometers() {
		return passengerKilometers;
	}

	public void setPassengerKilometers(Integer passengerKilometers) {
		this.passengerKilometers = passengerKilometers;
	}

	public Integer getCargoMailTonkilometers() {
		return cargoMailTonkilometers;
	}

	public void setCargoMailTonkilometers(Integer cargoMailTonkilometers) {
		this.cargoMailTonkilometers = cargoMailTonkilometers;
	}

	public Integer getAdult() {
		return adult;
	}

	public void setAdult(Integer adult) {
		this.adult = adult;
	}

	public Integer getChd() {
		return chd;
	}

	public void setChd(Integer chd) {
		this.chd = chd;
	}

	public Integer getInf() {
		return inf;
	}

	public void setInf(Integer inf) {
		this.inf = inf;
	}

	public Integer getCargo() {
		return cargo;
	}

	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}

	public Integer getMail() {
		return mail;
	}

	public void setMail(Integer mail) {
		this.mail = mail;
	}

	public Integer getBaggage() {
		return baggage;
	}

	public void setBaggage(Integer baggage) {
		this.baggage = baggage;
	}

	public Integer getTransferAdult() {
		return transferAdult;
	}

	public void setTransferAdult(Integer transferAdult) {
		this.transferAdult = transferAdult;
	}

	public Integer getTransferChd() {
		return transferChd;
	}

	public void setTransferChd(Integer transferChd) {
		this.transferChd = transferChd;
	}

	public Integer getTransferInf() {
		return transferInf;
	}

	public void setTransferInf(Integer transferInf) {
		this.transferInf = transferInf;
	}

	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST }, orphanRemoval = true)
	@JoinColumn(name = "historyFlight_id")
	protected Set<EnsureService> ensuerServces;

	public Set<EnsureService> getEnsuerServces() {
		return ensuerServces;
	}

	public void setEnsuerServces(Set<EnsureService> ensuerServces) {
		this.ensuerServces = ensuerServces;
	}

	@Entity
	@SuppressWarnings("serial")
	@Table(name = "History_EnsureService")
	public static class EnsureService extends Flight.EnsureService {
		@ManyToOne
		@JoinColumn(name = "historyFlight_id")
		private HistoryFlight flight;

		public HistoryFlight getHistoryFlight() {
			return flight;
		}

		public void setHistoryFlight(HistoryFlight flight) {
			this.flight = flight;
		}

		@Override
		public Flight getFlight() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setFlight(Flight flight) {
			// TODO Auto-generated method stub

		}
	}

	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST }, orphanRemoval = true)
	@JoinColumn(name = "historyFlight_id")
	protected Set<Charge> charges;

	@Entity
	@SuppressWarnings("serial")
	@Table(name = "History_Charge")
	public static class Charge extends Flight.Charge {
		@ManyToOne
		@JoinColumn(name = "historyFlight_id")
		private HistoryFlight flight;

		public HistoryFlight getHistoryFlight() {
			return flight;
		}

		public void setHistoryFlight(HistoryFlight flight) {
			this.flight = flight;
		}

	}

	public Set<Charge> getCharges() {
		return charges;
	}

	public void setCharges(Set<Charge> charges) {
		this.charges = charges;
	}
	
	/**
	 * 
	 * 
	 * TypeName PassagerLabelCount
	 * @Description  �ÿͱ�ǩͳ������ʵ����  
	 * Date         Author     Version   Description
	 * <p>---------------------------------------------
	 * <p>2018��9��4��      ZhangYu    1.0        1.0
	 * <p>Why & What is modified: <�޸�ԭ������>
	 */
	@Entity
	@Table(name="History_PassengerLabelCount")
	public static class PassengerLabelCount extends IntIdEntity{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * ���������ֶ���,�������õ����ֶ���
		 */
		public static final String LABCONDITION = "labCondition";
		public static final String VALUE        = "value";
		
		/**
		 * ��ǩ������
		 */
		@Column(length=64)
		private String labCondition;
		
		/**
		 * ��ǩ��ֵ
		 */
		private int value;

		public String getLabCondition() {
			return labCondition;
		}

		public void setLabCondition(String labCondition) {
			this.labCondition = labCondition;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
		
		
		
	}
	
	/**
	 * 
	 * TypeName GoodsDepartureCount
	 * @Description  TODO  �������ͳ��ʵ����
	 * Date         Author     Version   Description
	 * <p>---------------------------------------------
	 * <p>2018��9��4��      ZhangYu    1.0        1.0
	 * <p>Why & What is modified: <�޸�ԭ������>
	 */
	@Entity
	@Table(name = "History_LogisticsDepartureLabelCount")
	public static class LogisticsDepartureLabelCount extends IntIdEntity {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * ���������ֶ���,�������õ����ֶ���
		 */
		public static final String DEPLABCUSTOMER = "depLabCustomer";
		public static final String DEPLABCUSTOMERTYPE = "depLabCustomerType";
		public static final String DEPLABGOODSTYPE = "depLabGoodsType";
		public static final String DEPLABPACKAGESNUMBER = "depLabPackagesNumber";
		public static final String DEPLABDOCUMENTSNUMBER = "depLabDocumentsNumber";
		public static final String DEPLABWEIGHT = "depLabWeight";
		public static final String DEPLABLOGISTICSDESTINATIONIATACODE = "depLabLogisticsDestinationIATACode";
		public static final String DEPLABLOGISTICSFIRSTIATACODE = "depLablogisticsFirstIATACode";
		
		
		/**
		 * �ͻ�
		 */
		@Column(length=32)
		private String depLabCustomer;
		
		/**
		 * �ͻ�����
		 */
		@Column(length = 10)
		@Enumerated(EnumType.STRING)
		private LogisticsCustomerType depLabCustomerType;
		/**
		 * �������
		 */
		@Column(length = 10)
		@Enumerated(EnumType.STRING)
		private LogisticsGoodsType depLabGoodsType;
		/**
		 * ����
		 */
		private int depLabPackagesNumber;
		/**
		 * ������
		 */
		private int depLabDocumentsNumber;
		/**
		 * ����
		 */
		private int depLabWeight;
		
		/**
		 * ����Ŀ�ĵ�IATA����
		 */
		@Column(length = 10)
		private String depLabLogisticsDestinationIATACode;
		
		@Column(length = 10)
		private String depLablogisticsFirstIATACode;

		public String getDepLabCustomer() {
			return depLabCustomer;
		}

		public void setDepLabCustomer(String depLabCustomer) {
			this.depLabCustomer = depLabCustomer;
		}

		public LogisticsCustomerType getDepLabCustomerType() {
			return depLabCustomerType;
		}

		public void setDepLabCustomerType(LogisticsCustomerType depLabCustomerType) {
			this.depLabCustomerType = depLabCustomerType;
		}

		public LogisticsGoodsType getDepLabGoodsType() {
			return depLabGoodsType;
		}

		public void setDepLabGoodsType(LogisticsGoodsType depLabGoodsType) {
			this.depLabGoodsType = depLabGoodsType;
		}

		public int getDepLabPackagesNumber() {
			return depLabPackagesNumber;
		}

		public void setDepLabPackagesNumber(int depLabPackagesNumber) {
			this.depLabPackagesNumber = depLabPackagesNumber;
		}

		public int getDepLabDocumentsNumber() {
			return depLabDocumentsNumber;
		}

		public void setDepLabDocumentsNumber(int depLabDocumentsNumber) {
			this.depLabDocumentsNumber = depLabDocumentsNumber;
		}

		public int getDepLabWeight() {
			return depLabWeight;
		}

		public void setDepLabWeight(int depLabWeight) {
			this.depLabWeight = depLabWeight;
		}

		public String getDepLabLogisticsDestinationIATACode() {
			return depLabLogisticsDestinationIATACode;
		}

		public void setDepLabLogisticsDestinationIATACode(String depLabLogisticsDestinationIATACode) {
			this.depLabLogisticsDestinationIATACode = depLabLogisticsDestinationIATACode;
		}

		public String getDepLablogisticsFirstIATACode() {
			return depLablogisticsFirstIATACode;
		}

		public void setDepLablogisticsFirstIATACode(String depLablogisticsFirstIATACode) {
			this.depLablogisticsFirstIATACode = depLablogisticsFirstIATACode;
		}

		
		
	}
	
	/**
	 * 
	 * TypeName GoodsDepartureCount
	 * @Description  TODO  �����������ͳ��ʵ����
	 * Date         Author     Version   Description
	 * <p>---------------------------------------------
	 * <p>2018��9��4��      ZhangYu    1.0        1.0
	 * <p>Why & What is modified: <�޸�ԭ������>
	 */
	@Entity
	@Table(name = "History_LogisticsDepartureLoadCount")
	public static class LogisticsDepartureLoadCount extends IntIdEntity {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * ���������ֶ���,�������õ����ֶ���
		 */
		public static final String DEPLOADCUSTOMER = "depLoadCustomer";
		public static final String DEPLOADCUSTOMERTYPE = "depLoadCustomerType";
		public static final String DEPLOADGOODSTYPE = "depLoadGoodsType";
		public static final String DEPLOADPACKAGESNUMBER = "depLoadPackagesNumber";
		public static final String DEPLOADLOGISTICSDESTINATIONIATACODE = "depLoadLogisticsDestinationIATACode";
		public static final String DEPLOADWEIGHT = "depLoadWeight";
		
		/**
		 * �ͻ�
		 */
		@Column(length=32)
		private String depLoadCustomer;
		/**
		 * �ͻ�����
		 */
		@Column(length = 10)
		@Enumerated(EnumType.STRING)
		private LogisticsCustomerType depLoadCustomerType;
		/**
		 * �������
		 */
		@Column(length = 10)
		@Enumerated(EnumType.STRING)
		private LogisticsGoodsType depLoadGoodsType;
		/**
		 * ����
		 */
		private int depLoadPackagesNumber;
		/**
		 * ����
		 */
		private int depLoadWeight;
		/**
		 * ����Ŀ�ĵ�IATA����
		 */
		@Column(length = 10)
		private String depLoadLogisticsDestinationIATACode;
		
		public String getDepLoadCustomer() {
			return depLoadCustomer;
		}
		public void setDepLoadCustomer(String depLoadCustomer) {
			this.depLoadCustomer = depLoadCustomer;
		}
		public LogisticsCustomerType getDepLoadCustomerType() {
			return depLoadCustomerType;
		}
		public void setDepLoadCustomerType(LogisticsCustomerType depLoadCustomerType) {
			this.depLoadCustomerType = depLoadCustomerType;
		}
		public LogisticsGoodsType getDepLoadGoodsType() {
			return depLoadGoodsType;
		}
		public void setDepLoadGoodsType(LogisticsGoodsType depLoadGoodsType) {
			this.depLoadGoodsType = depLoadGoodsType;
		}
		public int getDepLoadPackagesNumber() {
			return depLoadPackagesNumber;
		}
		public void setDepLoadPackagesNumber(int depLoadPackagesNumber) {
			this.depLoadPackagesNumber = depLoadPackagesNumber;
		}
		public int getDepLoadWeight() {
			return depLoadWeight;
		}
		public void setDepLoadWeight(int depLoadWeight) {
			this.depLoadWeight = depLoadWeight;
		}
		public String getDepLoadLogisticsDestinationIATACode() {
			return depLoadLogisticsDestinationIATACode;
		}
		public void setDepLoadLogisticsDestinationIATACode(String depLoadLogisticsDestinationIATACode) {
			this.depLoadLogisticsDestinationIATACode = depLoadLogisticsDestinationIATACode;
		}

		
	}
	
	/**
	 * 
	 * TypeName GoodsDepartureCount
	 * @Description  TODO  �������ͳ��ʵ����
	 * Date         Author     Version   Description
	 * <p>---------------------------------------------
	 * <p>2018��9��4��      ZhangYu    1.0        1.0
	 * <p>Why & What is modified: <�޸�ԭ������>
	 */
	@Entity
	@Table(name = "History_LogisticsArrivalLabelCount")
	public static class LogisticsArrivalLabelCount extends IntIdEntity {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * ���������ֶ���,�������õ����ֶ���
		 */
		public static final String ARRLABCUSTOMER = "arrLabCustomer";
		public static final String ARRLABCUSTOMERTYPE = "arrLabCustomerType";
		public static final String ARRLABGOODSTYPE = "arrLabGoodsType";
		public static final String ARRLABPACKAGESNUMBER = "arrLabPackagesNumber";
		public static final String ARRLABWEIGHT = "arrLabWeight";
		public static final String ARRLABLOGISTICSDEPARTUREIATACODE = "arrLablogisticsDepartureIATACode";		
		/**
		 * �ͻ�
		 */
		@Column(length=32)
		private String arrLabCustomer;
		/**
		 * �ͻ�����
		 */
		@Column(length = 10)
		@Enumerated(EnumType.STRING)
		private LogisticsCustomerType arrLabCustomerType;
		/**
		 * ��������
		 */
		@Column(length = 10)
		@Enumerated(EnumType.STRING)
		private LogisticsGoodsType arrLabGoodsType;
		/**
		 * ����
		 */
		private int arrLabPackagesNumber;
		/**
		 * ����
		 */
		private int arrLabWeight;
		/**
		 * ����Ŀ�ĵ�IATA����
		 */
		@Column(length = 10)
		private String arrLablogisticsDepartureIATACode;
		
		public String getArrLabCustomer() {
			return arrLabCustomer;
		}
		public void setArrLabCustomer(String arrLabCustomer) {
			this.arrLabCustomer = arrLabCustomer;
		}
		public LogisticsCustomerType getArrLabCustomerType() {
			return arrLabCustomerType;
		}
		public void setArrLabCustomerType(LogisticsCustomerType arrLabCustomerType) {
			this.arrLabCustomerType = arrLabCustomerType;
		}
		public LogisticsGoodsType getArrLabGoodsType() {
			return arrLabGoodsType;
		}
		public void setArrLabGoodsType(LogisticsGoodsType arrLabGoodsType) {
			this.arrLabGoodsType = arrLabGoodsType;
		}
		public int getArrLabPackagesNumber() {
			return arrLabPackagesNumber;
		}
		public void setArrLabPackagesNumber(int arrLabPackagesNumber) {
			this.arrLabPackagesNumber = arrLabPackagesNumber;
		}
		public int getArrLabWeight() {
			return arrLabWeight;
		}
		public void setArrLabWeight(int arrLabWeight) {
			this.arrLabWeight = arrLabWeight;
		}
		public String getArrLablogisticsDepartureIATACode() {
			return arrLablogisticsDepartureIATACode;
		}
		public void setArrLablogisticsDepartureIATACode(String arrLablogisticsDepartureIATACode) {
			this.arrLablogisticsDepartureIATACode = arrLablogisticsDepartureIATACode;
		}
		
		
		
	}

	/**
	 * TypeName Flight.Load.LoadFlight
	 * @Description ����������ʵ����
	 */
	@Entity
	@Table(name = "History_Load")
	public static class Load extends IntIdEntity {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * ���������ֶ���,�������õ����ֶ���
		 */
		public static final String LOADDEPARTUREAIRPORTIATACODE = "loadDepartureAirportIATACode";
		public static final String LOADARRIVALAIRPORTIATACODE = "loadArrivalAirportIATACode";
		public static final String LOADPASSENGERTONKILOMETERS = "loadPassengerTonkilometers";
		public static final String LOADCARGOTONKILOMETERS = "loadCargoTonkilometers";
		public static final String LOADMAILTONKILOMETERS = "loadMailTonkilometers";
		public static final String LOADAIRROUTEDISTANCE = "loadAirRouteDistance";
		public static final String LOADADULT = "loadAdult";
		public static final String LOADCHD = "loadChd";
		public static final String LOADINF = "loadInf";
		public static final String LOADCARGO = "loadCargo";
		public static final String LOADMAIL = "loadMail";
		public static final String LOADBAGGAGE = "loadBaggage";
		public static final String LOADSECTORCODE = "loadSectorCode";

		/**
		 * ��ʼ����
		 */
		@Column(length = 10)
		protected String loadDepartureAirportIATACode;
		/**
		 * ��ػ���
		 */
		@Column(length = 10)
		protected String loadArrivalAirportIATACode;
		/**
		 * ���ߵľ���
		 */
		protected Integer loadAirRouteDistance;
		/**
		 * �ÿ���ת��
		 */
		protected Integer loadPassengerTonkilometers;
		/**
		 * ������ת��
		 */
		protected Integer loadCargoTonkilometers;
		/**
		 * �ʼ���ת��
		 */
		protected Integer loadMailTonkilometers;
		/**
		 * ����������ڹ���
		 */
		protected SectorCode loadSectorCode;
		/**
		 * ����
		 */
		protected Integer loadAdult;
		/**
		 * ��ͯ
		 */
		protected Integer loadChd;
		/**
		 * Ӥ��
		 */
		protected Integer loadInf;
		/**
		 * ����
		 */
		protected Integer loadCargo;
		/**
		 * �ʼ�
		 */
		protected Integer loadMail;
		/**
		 * ����
		 */
		protected Integer loadBaggage;

		public String getLoadDepartureAirportIATACode() {
			return loadDepartureAirportIATACode;
		}

		public void setLoadDepartureAirportIATACode(String loadDepartureAirportIATACode) {
			this.loadDepartureAirportIATACode = loadDepartureAirportIATACode;
		}

		public String getLoadArrivalAirportIATACode() {
			return loadArrivalAirportIATACode;
		}

		public void setLoadArrivalAirportIATACode(String loadArrivalAirportIATACode) {
			this.loadArrivalAirportIATACode = loadArrivalAirportIATACode;
		}

		public Integer getLoadAirRouteDistance() {
			return loadAirRouteDistance;
		}

		public void setLoadAirRouteDistance(Integer loadAirRouteDistance) {
			this.loadAirRouteDistance = loadAirRouteDistance;
		}

		public Integer getLoadPassengerTonkilometers() {
			return loadPassengerTonkilometers;
		}

		public void setLoadPassengerTonkilometers(Integer loadPassengerTonkilometers) {
			this.loadPassengerTonkilometers = loadPassengerTonkilometers;
		}

		public Integer getLoadCargoTonkilometers() {
			return loadCargoTonkilometers;
		}

		public void setLoadCargoTonkilometers(Integer loadCargoTonkilometers) {
			this.loadCargoTonkilometers = loadCargoTonkilometers;
		}

		public Integer getLoadMailTonkilometers() {
			return loadMailTonkilometers;
		}

		public void setLoadMailTonkilometers(Integer loadMailTonkilometers) {
			this.loadMailTonkilometers = loadMailTonkilometers;
		}

		public SectorCode getLoadSectorCode() {
			return loadSectorCode;
		}

		public void setLoadSectorCode(SectorCode loadSectorCode) {
			this.loadSectorCode = loadSectorCode;
		}

		public Integer getLoadAdult() {
			return loadAdult;
		}

		public void setLoadAdult(Integer loadAdult) {
			this.loadAdult = loadAdult;
		}

		public Integer getLoadChd() {
			return loadChd;
		}

		public void setLoadChd(Integer loadChd) {
			this.loadChd = loadChd;
		}

		public Integer getLoadInf() {
			return loadInf;
		}

		public void setLoadInf(Integer loadInf) {
			this.loadInf = loadInf;
		}

		public Integer getLoadCargo() {
			return loadCargo;
		}

		public void setLoadCargo(Integer loadCargo) {
			this.loadCargo = loadCargo;
		}

		public Integer getLoadMail() {
			return loadMail;
		}

		public void setLoadMail(Integer loadMail) {
			this.loadMail = loadMail;
		}

		public Integer getLoadBaggage() {
			return loadBaggage;
		}

		public void setLoadBaggage(Integer loadBaggage) {
			this.loadBaggage = loadBaggage;
		}

	}
	
	
	
	
	
	
	
	
	

	/**
	 * @Description ����ֶ�
	 * -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */

	public static final String UPDATEBYASP = "updateByASP";
	public static final String UPDATEBYSETTLEMENT = "updateBySettlement";

	/**
	 * ���ͳ��ϵͳ�����Ƿ����
	 */
	protected boolean updateByASP;

	public boolean isUpdateByASP() {
		return updateByASP;
	}

	public void setUpdateByASP(boolean updateByASP) {
		this.updateByASP = updateByASP;
	}

	/**
	 * ��������
	 */
	public final static String[] searchParams = { FLIGHTDIRECTION, SECTORCODE, LOCALAIRPOTIATACODE, AIRLINEIATACODE,
			FLIGHTNUMBER, CLASSIFICATIONCODE, DEPARTUREAIRPORTIATACODE, ARRIVALAIRPORTIATACODE,
			PASSENGERTONKILOMETERS };
}
