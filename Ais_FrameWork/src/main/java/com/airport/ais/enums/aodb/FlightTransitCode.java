package com.airport.ais.enums.aodb;

/**
 * 
 * 
 * FileName      FlightTransitCode.java
 * @Description  TODO �ɻ��� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��12��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��12��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */



public enum FlightTransitCode {
	/**
	 * �����Ծ�ͣ
	 */
    T,
    /**
     * һ�㾭ͣ
     */
    Y;

    public String value() {
        return name();
    }

    public static FlightTransitCode fromValue(String v) {
        return valueOf(v);
    }

}