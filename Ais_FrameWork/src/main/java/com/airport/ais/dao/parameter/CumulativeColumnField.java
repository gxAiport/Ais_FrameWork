package com.airport.ais.dao.parameter;

import javax.persistence.Transient;

import com.airport.ais.enums.CumulativeType;

/**
 * 
 * FileName      CumulativeColumnField.java
 * @Description  TODO 用于累计计算的列字段 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月22日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */


public class CumulativeColumnField extends ColumnField {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 需要对什么数据进行累计
	 */
	@Transient
	private AggregationColumnField aggregationColumnField;
	
	
	/**
	 * 限定的年份
	 */
	private String year;
	
	/**
	 * 是否需要进行比较
	 */
	private boolean compare;

	/**
	 * 进行年或者是月的比较的标识
	 */
	private CumulativeType cumulativeType;

	/**
	 * @return the aggregationColumnField
	 */
	public AggregationColumnField getAggregationColumnField() {
		return aggregationColumnField;
	}

	/**
	 * @param aggregationColumnField the aggregationColumnField to set
	 */
	public void setAggregationColumnField(AggregationColumnField aggregationColumnField) {
		this.aggregationColumnField = aggregationColumnField;
	}

	/**
	 * @return the compare
	 */
	public Boolean getCompare() {
		return compare;
	}

	/**
	 * @param compare the compare to set
	 */
	public void setCompare(Boolean compare) {
		this.compare = compare;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	public CumulativeType getCumulativeType() {
		return cumulativeType;
	}

	public void setCumulativeType(CumulativeType cumulativeType) {
		this.cumulativeType = cumulativeType;
	}

	public void setCompare(boolean compare) {
		this.compare = compare;
	}

	
	
	

}
