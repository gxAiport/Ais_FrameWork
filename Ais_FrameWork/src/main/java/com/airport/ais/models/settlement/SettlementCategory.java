package com.airport.ais.models.settlement;

import java.io.Serializable;
import javax.persistence.Entity;
import com.airport.ais.models.IntIdEntity;

/**
 * 
 * FileName      SettlementCategory.java
 * @Description  TODO  结算类别
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2018年7月31日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2018年7月31日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 * 
 */


@Entity
public class SettlementCategory extends IntIdEntity implements Serializable {
	
	/**  
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;
	
	
	public static String NAME = "name";

	
	
	private String name;
	
	
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

	@Override
	public String toString() {
		return this.name;
	}
	
	
	

}
