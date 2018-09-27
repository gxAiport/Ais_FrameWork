package com.airport.ais.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * FileName      IntIdEntity.java
 * @Description  TODO I idΪ����ʵ���ุ�� 
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
public abstract class IntIdEntity extends DefaultEntity   {
	
	public static String ID           = "id";
	
	/**
	 * ����
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id =  id;
	}

	@Override
	public Object getIdValue() {
		return this.id;
	}

	
	
	
	
}
