package com.airport.ais.enums.aodb;


/**
 * 
 * FileName      PassagerLabelType.java
 * @Description  TODO �ÿͱ�ǩ���͵�ö���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2018��9��4��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2018��9��4��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public enum PassagerLabelType {
	/**
	 * ���䣺30��
	 */
	Age("Age"),
	/**
	 * �Ա��У�Ů
	 */
	Sex("Sex"),
	/**
	 * ��λ�ȼ���ͷ�ȣ����񣬾���
	 */
	SeatClass("SeatClass"),
	/**
	 *  ����:���ڡ�����  
	 */
	Sector("Sector"),
	/**
	 * ʡ�ݣ�����
	 */
	Provinces("Provinces"),
	/**
	 * ���У�����
	 */
	City("City");
	
	private final String value;
	
	PassagerLabelType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PassagerLabelType fromValue(String v) {
        for (PassagerLabelType c: PassagerLabelType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}
