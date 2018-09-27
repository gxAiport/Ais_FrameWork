package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      Route.java
 * @Description  TODO 航线 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月17日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月17日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
@Table(name="FlightRoute")
public class FlightRoute extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String CHINESEROUTE = "chineseRoute";
	public static final String IATAROUTE    = "IATARoute";
	public static final String SHORTROUTE   = "shortRoute";
	public static final String SECTOR       = "Sector";
	
	@Column(length=128)
	private String chineseRoute;

	@Column(length=64)
	private String IATARoute;
	
	@Column(length=64)
	private String shortRoute;
	
	
	@ManyToOne
	private Sector sector;

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

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	

}
