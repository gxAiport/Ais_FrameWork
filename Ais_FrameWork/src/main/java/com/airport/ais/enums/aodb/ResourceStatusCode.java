package com.airport.ais.enums.aodb;


/**
 * 
 * 
 * FileName      ResourceStatus.java
 * @Description  TODO ��Դ״̬
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��14��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��14��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
public enum ResourceStatusCode {
		/**
		 * ��
		 */
	 	O,
	 	/**
	 	 * �ر�
	 	 */
	    C,
	    /**
	     * ά��
	     */
	    S,
	    /**
	     * ������
	     */
	    U;

	    public String value() {
	        return name();
	    }

	    public static ResourceStatusCode fromValue(String v) {
	        return valueOf(v);
	    }

}
