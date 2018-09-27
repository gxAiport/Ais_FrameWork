package com.airport.ais.models.settlement;

import java.io.Serializable;
import javax.persistence.Entity;
import com.airport.ais.models.IntIdEntity;

/**
 * 
 * FileName      SettlementCategory.java
 * @Description  TODO  �������
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2018��7��31��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2018��7��31��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 * 
 */


@Entity
public class SettlementCategory extends IntIdEntity implements Serializable {
	
	/**  
	 * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)   
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
