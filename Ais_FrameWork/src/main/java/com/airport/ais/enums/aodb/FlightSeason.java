package com.airport.ais.enums.aodb;
/**
 * 
 * 
 * FileName      Season.java
 * @Description  TODO ������ö���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��19��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��19��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */


public enum FlightSeason {

	/**
	 *   ����
	 */
	SUMMER_AUTUMN("Summer_Autumn"),
	
	/**
	 *  ����
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
