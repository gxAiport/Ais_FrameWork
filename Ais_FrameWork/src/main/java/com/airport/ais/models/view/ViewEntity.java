package com.airport.ais.models.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import com.airport.ais.models.IntIdEntity;



/**
 * 
 * 
 * FileName      ViewEntity.java
 * @Description  TODO  实体类连接的实体类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月27日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月27日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
public class ViewEntity extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 各个数据字段名,用来直接调用字段名
	 */
	
	public static String NAME               = "name";
	public static String ENTITYTYPENAME     = "entityTypeName";
	
	/**
	 * 视图名
	 */
	@Column(length=32)
	private String name;
	/**
	 * 对应的实体对象类名
	 */
	@Column(length=64)
	private String entityTypeName;
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
	 * @return the entityTypeName
	 */
	public String getEntityTypeName() {
		return entityTypeName;
	}
	/**
	 * @param entityTypeName the entityTypeName to set
	 */
	public void setEntityTypeName(String entityTypeName) {
		this.entityTypeName = entityTypeName;
	}
	
	
	
	

}
