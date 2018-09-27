package com.airport.ais.service.aodb;

import javax.ejb.Remote;

import com.airport.ais.models.aodb.flight.Flight;
import com.airport.ais.models.aodb.flight.SeasonFlight;

/**
 * 
 * 
 * FileName      ISeasonFlightService.java
 * @Description  TODO ���Ⱥ����Service�ӿ�
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��8��16��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��8��16��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Remote
public interface ISeasonFlightService extends IBasicFlightService<SeasonFlight> {
	
	/**
	 * ���ݶ�̬���ഴ�����Ⱥ�������
	 * @param dynamicFlight
	 * @throws Exception 
	 */
	void createSeasonByDynamic(Flight flight) throws Exception;
	
	
}
