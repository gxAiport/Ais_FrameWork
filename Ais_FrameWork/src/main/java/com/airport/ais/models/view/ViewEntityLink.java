package com.airport.ais.models.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import com.airport.ais.models.IntIdEntity;


/**
 * 
 * 
 * FileName      ViewEntityLink.java
 * @Description  TODO ��ͼ��ʵ���������ʵ����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��27��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��27��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Entity 
public class ViewEntityLink extends IntIdEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ���������ֶ���,����ֱ�ӵ����ֶ���
	 */
	public static final String VIEWTYPENAME    =  "viewTypeName";
	public static final String VIEWENTITY      =  "viewEntity";

	/**
	 * ��ͼ������
	 */
	@Column(length=32)
	private String viewTypeName;
	
	/**
	 * ��ͼ������ʵ��
	 */
	@ManyToOne
	private ViewEntity viewEntity;

	/**
	 * @return the viewTypeName
	 */
	public String getViewTypeName() {
		return viewTypeName;
	}

	/**
	 * @param viewTypeName the viewTypeName to set
	 */
	public void setViewTypeName(String viewTypeName) {
		this.viewTypeName = viewTypeName;
	}

	/**
	 * @return the viewEntity
	 */
	public ViewEntity getViewEntity() {
		return viewEntity;
	}

	/**
	 * @param viewEntity the viewEntity to set
	 */
	public void setViewEntity(ViewEntity viewEntity) {
		this.viewEntity = viewEntity;
	}

	

	
}
