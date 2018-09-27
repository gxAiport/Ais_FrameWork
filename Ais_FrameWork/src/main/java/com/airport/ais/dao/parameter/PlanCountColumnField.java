package com.airport.ais.dao.parameter;

import java.util.Date;

import javax.persistence.Transient;

/**
 * 
 * 
 * FileName      PlanCountColumnField.java
 * @Description  TODO �ƻ����мܴε����ֶ� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��22��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��22��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */


public class PlanCountColumnField extends ColumnField {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ���ֶΣ���һ��Group�ֶ�
	 */
	@Transient
	private GroupField rowField;
	
	/**
	 * ��ʼʱ��
	 */
	private Date startDate;
	
	/**
	 * �����ֶ�
	 */
	private Date endDate;
	/**
	 * @return the rowField
	 */
	public GroupField getRowField() {
		return rowField;
	}

	/**
	 * @param rowField the rowField to set
	 */
	public void setRowField(GroupField rowField) {
		this.rowField = rowField;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	
}
