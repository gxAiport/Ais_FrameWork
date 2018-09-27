package com.airport.ais.models.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import com.airport.ais.enums.ViewColumnType;
import com.airport.ais.models.IntIdEntity;




/**
 * 
 * 
 * FileName      ViewConfig.java
 * @Description  TODO ����е�ʵ���࣬�������ж��������
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��27��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��27��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Entity
public class ViewColumnConfig  extends IntIdEntity{

	private static final long serialVersionUID = 1L;
	
	/**
	 * ���������ֶ���,����ֱ�ӵ����ֶ���
	 */
	public static  final String NAME          =  "name";
	public static  final String FIELD         =  "field";
	public static  final String	CHILDFIELD    =  "childField";
	public static  final String WIDTH         =  "width";
	public static  final String VIEWENTITY    =  "viewEntity";
	public static  final String SORT          =  "sort";
	public static  final String FINDNUMBER    =  "findNumber";
	
	
	/**
	 * ������
	 */
	@Column(length=32)
	private String name;
	/**
	 * ʵ������ֶ���
	 */
	@Column(length=32)
	private String field;
	/**
	 * �Ӷ����ֶ���
	 */
	@Column(length=128)
	private String childField;
	
	/**
	 * �еĿ��
	 */
	private Integer width;
	/**
	 * ��������ͼ
	 */
	@ManyToOne
	private ViewEntity viewEntity;
	/**
	 * ����λ��
	 */
	private Integer sort;
	@Column(length=10)
	@Enumerated(EnumType.STRING)
	private ViewColumnType viewColumnType;
	/**
	 * ��ѯ������һ������Date�ֶ�
	 */
	private Integer findNumber;
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
	 * @return the field
	 */
	public String getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}
	/**
	 * @return the childField
	 */
	public String getChildField() {
		return childField;
	}
	/**
	 * @param childField the childField to set
	 */
	public void setChildField(String childField) {
		this.childField = childField;
	}
	/**
	 * @return the width
	 */
	public Integer getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(Integer width) {
		this.width = width;
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
	/**
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * @return the viewColumnType
	 */
	public ViewColumnType getViewColumnType() {
		return viewColumnType;
	}
	/**
	 * @param viewColumnType the viewColumnType to set
	 */
	public void setViewColumnType(ViewColumnType viewColumnType) {
		this.viewColumnType = viewColumnType;
	}
	/**
	 * @return the findNumber
	 */
	public Integer getFindNumber() {
		return findNumber;
	}
	/**
	 * @param findNumber the findNumber to set
	 */
	public void setFindNumber(Integer findNumber) {
		this.findNumber = findNumber;
	}
	
	
	
	
	
}
