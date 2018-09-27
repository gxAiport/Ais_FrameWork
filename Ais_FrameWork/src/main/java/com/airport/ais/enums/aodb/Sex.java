package com.airport.ais.enums.aodb;

public enum Sex {

	/**
	 * ����
	 */
	Male("Male"),
	
	/**
	 * Ů��
	 */
	Female("Female");
    
	private final String value;
		
	private Sex(String value) {
		this.value = value;
	}
		
	public static  Sex fromValue(String v) {
       for ( Sex u:  Sex.values()) {
           if (u.value.equals(v)) {
               return u;
           }
       }
       throw new IllegalArgumentException(v);
	}
}
