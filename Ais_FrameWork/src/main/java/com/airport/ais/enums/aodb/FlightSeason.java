package com.airport.ais.enums.aodb;
/**
 * 
 * 
 * FileName      Season.java
 * @Description  TODO 航季的枚举类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月19日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月19日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */


public enum FlightSeason {

	/**
	 *   夏秋
	 */
	SUMMER_AUTUMN("Summer_Autumn"),
	
	/**
	 *  冬春
	 */
	WINTER_SPRING("Winter_Spring");
	
	private final String value;
	
	FlightSeason(String v){
		value = v;
	}
	
	
	public String value() {
	       return value;
	}
	
	
	public static FlightSeason fromValue(String v) {
	   for (FlightSeason c: FlightSeason.values()) {
	        if (c.value.equals(v)) {
	            return c;
	        }
	    }
	    throw new IllegalArgumentException(v);
    }
}
