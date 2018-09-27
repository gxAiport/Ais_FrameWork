package com.airport.ais.service;

import javax.ejb.Remote;

/**
 * 
 * 
 * FileName      IGeneralService.java
 * @Description  TODO 通常的Service接口
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月26日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月26日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Remote
public interface IGeneralService<K,E> extends IService<K, E> {

}
