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
 * @Description  TODO 空中航线实体表
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月21日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月21日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="AirRoute")
public class AirRoute extends IntIdEntity  {
	
	private static final long   serialVersionUID = 1L;
	/**
	 *   查询条件字段与实际数据库字段一一对应
	 */
	
	public final  static  String  DEPARTUREAIRPORT           = "departureAirport";
	public final  static  String  ARRIVALAIRPORT             = "arrivalAirport";
	public final  static  String  AIRROUTE                   = "airRoute";
	public final  static  String  AIRROUTEDISTANCE           = "airRouteDistance";

	/**
	 *  多对一转换关系对应字段，主要用于前端框架转换之用
	 */
	public final  static String[]  searchParams            = {"departureAirport","arrivalAirport"};
	public final static String[]   CODE_FIELD_NAMES        = {"departureAirportCode","arrivalAirportCode"};
	public final static String[]   RELATION_FIELD_NAMES    = {"departureAirport","arrivalAirport"};
	public final static Class<?>[] RELATION_FIELD_CLASSS   = {Airport.class,Airport.class};
	
	/**
	 * 出港机场
	 */
	@ManyToOne
	protected Airport departureAirport;
	/**
	 * 到达机场
	 */
	@ManyToOne
	protected Airport arrivalAirport;	
	
	/**
	 * 航路
	 */
	private String airRoute;
	

	/**
	 * 航线的距离
	 */
	private Integer airRouteDistance;

	
	/**
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------
	 *   Transient标注的字段用来与前端框架进行交互显示，不真正作为保存字段
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
	 *   返回Transient标注的字段对应多对一字段的相应的值
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
	 *   设置Transient标注的字段对应字段的值，用于前端设置多对一字段的值
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
