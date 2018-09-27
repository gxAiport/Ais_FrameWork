package com.airport.ais.models;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;



/**
 * 
 * 
 * FileName      DefaultEntity.java
 * @Description  TODO  ʵ����ԭʼ����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��11��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��11��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class DefaultEntity implements Serializable {
	
	/**
	 * 
	 * @Description: TODO(������һ�仰�����������������)
	 * @return
	 */
	public abstract Object getIdValue();

	
	
	/**
	 * ��д��equals����
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && DefaultEntity.class.isAssignableFrom(obj.getClass())){
			//���obj��Entity����һ�»����������࣬�Ƚ�����Id
			
			
			return (this.getIdValue() .equals(((DefaultEntity)obj).getIdValue()));
		}
		//�����ø���ķ������бȽϣ�һ���ǱȽ��ڴ��ַ
		return super.equals(obj);
	}

	
	
	

}
