/**
 * 
 */
package com.airport.ais.report;

import java.util.List;

import com.airport.ais.dao.parameter.SummaryField;
import com.airport.ais.dao.parameter.ReportField;



/**
 * FileName      Report.java
 * @Description  �����࣬ÿ�������Ӧһ����
 *<p>   �����ֶεĴ�Ź���
 *<p>   1�� Group�ֶ�
 *<p>   2�� �ۺ����ֶ�
 *<p>   3�� �����ֶ�
 *<p>   4�� �ۼ��ֶΡ��ƻ��ֶ�
 *<p>   ���˳�򲻶Գ�����������Ԥ֪�Ĵ���
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2016��2��26�� 
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2016��2��26��      Yu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public class Report {
	/**
	 *   ����бȽϣ��˲��������������������ֵ 
	 */
	private int diffYear;
	
	/**
	 * ���������
	 */
	private String name;
	
	
	/**
	 * ����ı���
	 */
	private String title;
	
	
	/**
	 *   �����ֶε�List
	 *   
	 */
	private List<ReportField> fields;
	
	/**
	 *  �������ʽ
	 */
	private Object[] expresstion;
	
	
	/**
	 * Ԥ��������
	 */
	private Object[] condistion;
	
	
	/**
	 * �����ֶ�
	 */
	private String order;
	
	/**
	 * ������Ҫ��ʾ���ֶ�
	 */
	private SummaryField[] summaryFields;
	
	/**
	 *  ����̶������� ���磺
	 *  
	 *  �� ���չ�˾
	 *  01 CA
	 *  02 MU 
	 *  03 EU
	 *  
	 */
	private int colNum;
	
	

	/**
	 * @return the diffYear
	 */
	public int getDiffYear() {
		return diffYear;
	}

	/**
	 * @param diffYear the diffYear to set
	 */
	public void setDiffYear(int diffYear) {
		this.diffYear = diffYear;
	}

	/**
	 * @return the fields
	 */
	public List<ReportField> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(List<ReportField> fields) {
		this.fields = fields;
	}

	/**
	 * @return the expresstion
	 */
	public Object[] getExpresstion() {
		return expresstion;
	}

	/**
	 * @param expresstion the expresstion to set
	 */
	public void setExpresstion(Object[] expresstion) {
		this.expresstion = expresstion;
	}

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
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the condistion
	 */
	public Object[] getCondistion() {
		return condistion;
	}

	/**
	 * @param condistion the condistion to set
	 */
	public void setCondistion(Object[] condistion) {
		this.condistion = condistion;
	}

	

	public SummaryField[] getSummaryFields() {
		return summaryFields;
	}

	public void setSummaryFields(SummaryField[] summaryFields) {
		this.summaryFields = summaryFields;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the colNum
	 */
	public int getColNum() {
		return colNum;
	}

	/**
	 * @param colNum the colNum to set
	 */
	public void setColNum(int colNum) {
		this.colNum = colNum;
	}

	

	
	

}
