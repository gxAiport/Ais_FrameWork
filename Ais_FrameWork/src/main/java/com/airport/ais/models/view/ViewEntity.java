package com.airport.ais.models.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import com.airport.ais.models.IntIdEntity;



/**
 * 
 * 
 * FileName      ViewEntity.java
 * @Description  TODO  ʵ�������ӵ�ʵ����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��27��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��27��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Entity
public class ViewEntity extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ���������ֶ���,����ֱ�ӵ����ֶ���
	 */
	
	public static String NAME               = "name";
	public static String ENTITYTYPENAME     = "entityTypeName";
	
	/**
	 * ��ͼ��
	 */
	@Column(length=32)
	private String name;
	/**
	 * ��Ӧ��ʵ���������
	 */
	@Column(length=64)
	private String entityTypeName;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the entityTypeName
	 */
	public String getEntityTypeName() {
		return entityTypeName;
	}
	/**
	 * @param entityTypeName the entityTypeName to set
	 */
	public void setEntityTypeName(String entityTypeName) {
		this.entityTypeName = entityTypeName;
	}
	
	
	
	

}
