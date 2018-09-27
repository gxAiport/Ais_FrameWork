package com.airport.ais.models.aodb.basic;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      AirportAirRoute.java
 * @Description  TODO ���к���ʵ���
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��21��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��21��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Entity
@Table(name="AirRoute")
public class AirRoute extends IntIdEntity  {
	
	private static final long   serialVersionUID = 1L;
	/**
	 *   ��ѯ�����ֶ���ʵ�����ݿ��ֶ�һһ��Ӧ
	 */
	
	public final  static  String  DEPARTUREAIRPORT           = "departureAirport";
	public final  static  String  ARRIVALAIRPORT             = "arrivalAirport";
	public final  static  String  AIRROUTE                   = "airRoute";
	public final  static  String  AIRROUTEDISTANCE           = "airRouteDistance";

	/**
	 *  ���һת����ϵ��Ӧ�ֶΣ���Ҫ����ǰ�˿��ת��֮��
	 */
	public final  static String[]  searchParams            = {"departureAirport","arrivalAirport"};
	public final static String[]   CODE_FIELD_NAMES        = {"departureAirportCode","arrivalAirportCode"};
	public final static String[]   RELATION_FIELD_NAMES    = {"departureAirport","arrivalAirport"};
	public final static Class<?>[] RELATION_FIELD_CLASSS   = {Airport.class,Airport.class};
	
	/**
	 * ���ۻ���
	 */
	@ManyToOne
	protected Airport departureAirport;
	/**
	 * �������
	 */
	@ManyToOne
	protected Airport arrivalAirport;	
	
	/**
	 * ��·
	 */
	private String airRoute;
	

	/**
	 * ���ߵľ���
	 */
	private Integer airRouteDistance;

	
	/**
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------
	 *   Transient��ע���ֶ�������ǰ�˿�ܽ��н�����ʾ����������Ϊ�����ֶ�
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
	
	@Transient
	private String departureAirportCnName;
	
	@Transient
	private String arrivalAirportCnName;
	
	@Transient
	public String departureAirportCode;
	
	@Transient
	public String arrivalAirportCode;



	/**
	 * @return the departureAirport
	 */
	public Airport getDepartureAirport() {
		return departureAirport;
	}


	/**
	 * @param departureAirport the departureAirport to set
	 */
	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}


	/**
	 * @return the arrivalAirport
	 */
	public Airport getArrivalAirport() {
		return arrivalAirport;
	}


	/**
	 * @param arrivalAirport the arrivalAirport to set
	 */
	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}


	/**
	 * @return the airRoute
	 */
	public String getAirRoute() {
		return airRoute;
	}


	/**
	 * @param airRoute the airRoute to set
	 */
	public void setAirRoute(String airRoute) {
		this.airRoute = airRoute;
	}


	/**
	 * @return the airRouteDistance
	 */
	public Integer getAirRouteDistance() {
		return airRouteDistance;
	}


	/**
	 * @param airRouteDistance the airRouteDistance to set
	 */
	public void setAirRouteDistance(Integer airRouteDistance) {
		this.airRouteDistance = airRouteDistance;
	}

	/**
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------
	 *   ����Transient��ע���ֶζ�Ӧ���һ�ֶε���Ӧ��ֵ
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------
	 */	

	public String getDepartureAirportCnName() {
		if (departureAirport != null){
			return departureAirport.getChineseName();
		}else{
			return null;
		}
		
	}


	public String getArrivalAirportCnName() {
		if (arrivalAirport != null){
			return arrivalAirport.getChineseName();
		}else{
			return null;
		}
	}


	

	/**
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------
	 *   ����Transient��ע���ֶζ�Ӧ�ֶε�ֵ������ǰ�����ö��һ�ֶε�ֵ
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------
	 */	
	
	public String getDepartureAirportCode() {
		if (departureAirport != null){
			return departureAirport.getIATACode();
		}else{
			return null;
		}
	}

	public String getArrivalAirportCode() {
		if (arrivalAirport != null){
			return arrivalAirport.getIATACode();
		}else{
			return null;
		}
	}
	
	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}




}
