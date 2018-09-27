package com.airport.ais.models.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import com.airport.ais.models.IntIdEntity;


/**
 * 
 * 
 * FileName      ViewEntityLink.java
 * @Description  TODO 视图和实体类关联的实体类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月27日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月27日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity 
public class ViewEntityLink extends IntIdEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 各个数据字段名,用来直接调用字段名
	 */
	public static final String VIEWTYPENAME    =  "viewTypeName";
	public static final String VIEWENTITY      =  "viewEntity";

	/**
	 * 视图的类名
	 */
	@Column(length=32)
	private String viewTypeName;
	
	/**
	 * 视图的连接实体
	 */
	@ManyToOne
	private ViewEntity viewEntity;

	/**
	 * @return the viewTypeName
	 */
	public String getViewTypeName() {
		return viewTypeName;
	}

	/**
	 * @param viewTypeName the viewTypeName to set
	 */
	public void setViewTypeName(String viewTypeName) {
		this.viewTypeName = viewTypeName;
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

	

	
}
