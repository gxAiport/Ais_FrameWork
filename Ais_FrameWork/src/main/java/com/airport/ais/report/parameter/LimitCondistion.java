
package com.airport.ais.report.parameter;

import java.util.List;

/**
 * FileName      ChartCondistion.java
 * @Description  ͼ�����������
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2016��4��14�� 
 * @ModificationHistory
 * Date         Author     Version   Discription
 * <p>---------------------------------------------
 * <p>2016��4��14��      Yu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */


public class LimitCondistion {
	
	
	private String name;
	
	private String index;
	
	private List<String> values;

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
	 * @return the index
	 */
	public String getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(String index) {
		this.index = index;
	}

	/**
	 * @return the values
	 */
	public List<String> getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(List<String> values) {
		this.values = values;
	}
	
	

}
