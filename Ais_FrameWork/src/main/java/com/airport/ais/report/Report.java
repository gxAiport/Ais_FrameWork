/**
 * 
 */
package com.airport.ais.report;

import java.util.List;

import com.airport.ais.dao.parameter.SummaryField;
import com.airport.ais.dao.parameter.ReportField;



/**
 * FileName      Report.java
 * @Description  报表类，每个报表对应一个类
 *<p>   报表字段的存放规则：
 *<p>   1、 Group字段
 *<p>   2、 聚合类字段
 *<p>   3、 计算字段
 *<p>   4、 累计字段、计划字段
 *<p>   如果顺序不对程序将遇见不可预知的错误
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2016年2月26日 
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2016年2月26日      Yu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public class Report {
	/**
	 *   如果有比较，此参数代表两个年份相差的数值 
	 */
	private int diffYear;
	
	/**
	 * 报表的名字
	 */
	private String name;
	
	
	/**
	 * 报表的标题
	 */
	private String title;
	
	
	/**
	 *   报表字段的List
	 *   
	 */
	private List<ReportField> fields;
	
	/**
	 *  条件表达式
	 */
	private Object[] expresstion;
	
	
	/**
	 * 预定的条件
	 */
	private Object[] condistion;
	
	
	/**
	 * 排序字段
	 */
	private String order;
	
	/**
	 * 报表需要显示的字段
	 */
	private SummaryField[] summaryFields;
	
	/**
	 *  分组固定的列数 例如：
	 *  
	 *  月 航空公司
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
