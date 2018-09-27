package com.airport.ais.dao.parameter;

import javax.persistence.Transient;

import com.airport.ais.enums.CumulativeType;

/**
 * 
 * FileName      CumulativeColumnField.java
 * @Description  TODO �����ۼƼ�������ֶ� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��22��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��22��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */


public class CumulativeColumnField extends ColumnField {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ��Ҫ��ʲô���ݽ����ۼ�
	 */
	@Transient
	private AggregationColumnField aggregationColumnField;
	
	
	/**
	 * �޶������
	 */
	private String year;
	
	/**
	 * �Ƿ���Ҫ���бȽ�
	 */
	private boolean compare;

	/**
	 * ������������µıȽϵı�ʶ
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
