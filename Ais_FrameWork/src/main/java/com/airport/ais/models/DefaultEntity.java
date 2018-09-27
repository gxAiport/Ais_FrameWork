package com.airport.ais.models;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;



/**
 * 
 * 
 * FileName      DefaultEntity.java
 * @Description  TODO  实体类原始父类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月11日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月11日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class DefaultEntity implements Serializable {
	
	/**
	 * 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	public abstract Object getIdValue();

	
	
	/**
	 * 重写的equals方法
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && DefaultEntity.class.isAssignableFrom(obj.getClass())){
			//如果obj和Entity类型一致或者是其子类，比较两个Id
			
			
			return (this.getIdValue() .equals(((DefaultEntity)obj).getIdValue()));
		}
		//否则用父类的方法进行比较，一般是比较内存地址
		return super.equals(obj);
	}

	
	
	

}
