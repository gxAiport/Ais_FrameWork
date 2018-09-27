package com.airport.ais.dao.parameter;

import java.io.Serializable;

import com.airport.ais.enums.QuerySortMode;

/**
 * 
 * 
 * FileName      AisOrder.java
 * @Description  TODO ������ 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��22��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��22��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public class QueryOrder implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * �ֶ���
	 */
	private String name;
	
	/**
	 * ��������
	 */
	private QuerySortMode querySortMode;
	

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	

	public QuerySortMode getQuerySortMode() {
		return querySortMode;
	}
	
	
	public void setQuerySortMode(QuerySortMode querySortMode) {
		this.querySortMode = querySortMode;
	}
	

	
	

}
