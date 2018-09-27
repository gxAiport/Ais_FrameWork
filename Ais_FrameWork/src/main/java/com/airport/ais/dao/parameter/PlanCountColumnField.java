package com.airport.ais.dao.parameter;

import java.util.Date;

import javax.persistence.Transient;

/**
 * 
 * 
 * FileName      PlanCountColumnField.java
 * @Description  TODO 计划飞行架次的列字段 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月22日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */


public class PlanCountColumnField extends ColumnField {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 行字段，第一个Group字段
	 */
	@Transient
	private GroupField rowField;
	
	/**
	 * 开始时间
	 */
	private Date startDate;
	
	/**
	 * 结束字段
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
