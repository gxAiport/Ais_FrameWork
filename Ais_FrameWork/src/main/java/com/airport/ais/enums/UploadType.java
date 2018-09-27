package com.airport.ais.enums;

/**
 * 
 * 
 * FileName      UploadType.java
 * @Description  TODO  �ϴ����͵�ö���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��8��6��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��8��6��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */


public enum UploadType {
	/**
	 *   ���Ⱥ��� 
	 */
	SeansonFlight("SeansonFlight"),
	/**
	 *   ����ɻ�
	 */
	CAAC_Settlement_Aircraft("CAAC_Settlement_Aircraft"),
	/**
	 *  ������������
	 */
	CAAC_Settlement_Income("CAAC_Settlement_Income"),
	/**
	 *   ��ͳ��ϵͳ�ɻ�����
	 */
	CAAC_Statistics_Aircraft("CAAC_Statistics_Aircraft"),
	/**
	 *  ��ͳ��ϵͳ��������
	 */
	CAAC_Statistics_Load("CAAC_Statistics_Load"),
	
	/**
	 *  �����ÿ�����
	 */
	CAAC_Passenger("CAAC_Passenger");
	
    private final String value;

	private UploadType(String value) {
		this.value = value;
	}
	
	public static  UploadType fromValue(String v) {
        for ( UploadType u:  UploadType.values()) {
            if (u.value.equals(v)) {
                return u;
            }
        }
        throw new IllegalArgumentException(v);
    }

	 
	 

}
