

package com.airport.ais.dao.parameter;

import java.io.Serializable;
import java.util.List;



/**
 * 
 * FileName      QueryConditions.java
 * @Description  TODO  ��ѯ���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��22��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��22��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public class QueryCondition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * �������ʽ
	 */
	private Object[] expression;
	/**
	 * ѡ����ʾ���ֶ�
	 */
	private String[] selectFields;
	
	
	
	/**
	 *  �����ֶ�
	 */
	private QueryOrder[] orders;
	
	
	/**
	 *  ��ҳ��ʼ���
	 */
	private Integer first;
	
	/**
	 * ��ҳ�������
	 */
	private Integer max;

	/**
	 *  ����һ�Զ�ı�ʶ��
	 */
	private String fetchOneToMany = "";
	
	/**
	 *  ���Ӷ��һ�ı�ʶ��
	 */
	private String fetchManyToOne = "ALL";
	
	
	/**
	 *  �����ֶ�
	 */
	private List<GroupField> groupFields;
	
	/**
	 *  �ۺ��ֶ�
	 */
	private List<AggregationColumnField> aggregationFields;
	
	
 
	

	/**
	 * @return the expression
	 */
	public Object[] getExpression() {
		return expression;
	}

	/**
	 * @param expression the expression to set
	 */
	public void setExpression(Object[] expression) {
		this.expression = expression;
	}

	/**
	 * @return the orders
	 */
	public QueryOrder[] getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(QueryOrder[] orders) {
		this.orders = orders;
	}

	/**
	 * @return the first
	 */
	public Integer getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(Integer first) {
		
		this.first = first;
	}

	/**
	 * @return the max
	 */
	public Integer getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(Integer max) {
		this.max = max;
	}

	/**
	 * @return the fetchOneToMany
	 */
	public String getFetchOneToMany() {
		return fetchOneToMany;
	}

	/**
	 * @param fetchOneToMany the fetchOneToMany to set
	 */
	public void setFetchOneToMany(String fetchOneToMany) {
		this.fetchOneToMany = fetchOneToMany;
	}

	/**
	 * @return the fetchManyToOne
	 */
	public String getFetchManyToOne() {
		return fetchManyToOne;
	}

	/**
	 * @param fetchManyToOne the fetchManyToOne to set
	 */
	public void setFetchManyToOne(String fetchManyToOne) {
		this.fetchManyToOne = fetchManyToOne;
	}

	/**
	 * @return the groupFields
	 */
	public List<GroupField> getGroupFields() {
		return groupFields;
	}

	/**
	 * @param groupFields the groupFields to set
	 */
	public void setGroupFields(List<GroupField> groupFields) {
		this.groupFields = groupFields;
	}

	/**
	 * @return the aggregationFields
	 */
	public List<AggregationColumnField> getAggregationFields() {
		return aggregationFields;
	}

	/**
	 * @param aggregationFields the aggregationFields to set
	 */
	public void setAggregationFields(List<AggregationColumnField> aggregationFields) {
		this.aggregationFields = aggregationFields;
	}

	public String[] getSelectFields() {
		return selectFields;
	}

	public void setSelectFields(String[] selectFields) {
		this.selectFields = selectFields;
	}
	

	
}
