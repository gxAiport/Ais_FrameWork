//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2017.06.01 ʱ�� 09:59:39 PM CST 
//


package com.airport.ais.enums.aodb;

import javax.xml.bind.annotation.XmlEnumValue;



/**
 * 
 * 
 * FileName      BaggageReclaimCarouselRole.java
 * @Description  TODO  ����ת�̹���
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��17��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��17��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
public enum BaggageReclaimCarouselRole {

    @XmlEnumValue("Primary")
    PRIMARY("Primary"),
    @XmlEnumValue("Secondary")
    SECONDARY("Secondary");
    private final String value;

    BaggageReclaimCarouselRole(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BaggageReclaimCarouselRole fromValue(String v) {
        for (BaggageReclaimCarouselRole c: BaggageReclaimCarouselRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
