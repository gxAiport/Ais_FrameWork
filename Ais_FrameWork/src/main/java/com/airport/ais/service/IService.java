package com.airport.ais.service;

import java.util.List;
import java.util.Map;
import com.airport.ais.dao.IDao;
import com.airport.ais.dao.parameter.QueryCondition;



/**
 * ͨ�õ�Service��ӿڣ��ṩ������ʵ�����������
 * @author ZhangYu
 * @since JDK1.6
 * @version 0.9a 24/06/2014	
 */


public interface IService<K,E>  {
	

	/**
	 * ���ò������ݵ�Dao����
	 * @param dao
	 */
	public void setDao(IDao<K, E> dao);	

	
	/**
	 * ɾ��һ�����ݶ���
	 * @param obj
	 */
	public void remove(E obj);	
	
	/**
	 * ���ݸ���������ɾ����Ӧ�Ķ���
	 * @param  condition  ���������  
	 * @param  clazz      ʵ�������
	 * @return ɾ����ʵ������� 
	 * @throws Exception  
	 */
	public int removeByCondition(QueryCondition condition,Class<E> clazz) throws Exception;
	
	
	/**
	 * ����һ�����ݶ���
	 * @param obj
	 */
	public E add(E obj);
	
	/**
	 * ����һ�����ݶ���
	 * @param object
	 */
	public E update(E object);
	
	/**
	 * �������е����ݶ���
	 * @return
	 * @throws Exception 
	 */
	public  List <E> getAll(Class<E> clazz) throws Exception;

	/**
	 * ����ָ��Id����������ݶ���
	 * @param id �ؼ���
	 * @return ָ��Id����������ݶ���
	 * @throws Exception 
	 */
	public E findByID(K id,Class<E> clazz) throws Exception;
	
	/**
	 * ����ָ���ֶ�ֵ�õ������ݶ���
	 * @param field
	 * @param value
	 * @return ָ���ֶ�ֵ�����ݶ���
	 * @throws Exception 
	 */
	public  List <E>  findByFieldAll(String field,Object value,Class<E> clazz) throws Exception;

	/**
	 * ����ָ���ֶ�ֵ�����ݶ���ļ���
	 * @param field
	 * @param value
	 * @return ָ���ֶ�ֵ�����ݶ���ļ���
	 */
	public E  findByFieldSingle(String field,Object value,Class<E> clazz);
	
	/**
	 * ���ݸ��������������������ʵ����󼯺�
	 * @param fields �ֶ�����
	 * @param opers ��ϵ�����
	 * @param links ���ӷ� and or
	 * @param values ��������
	 * @return ����������һ��ʵ�����
	 */
	public E  findByConditionSingle(QueryCondition condition,Class<E> clazz);
	
	/**
	 ���ݸ��������������������ʵ����󼯺�
	 * @param fields �ֶ�����
	 * @param opers ��ϵ�����
	 * @param links ���ӷ� and or
	 * @param values ��������
	 * @return ����������ʵ����󼯺�
	 * @throws Exception 
	 */
	public  List <E>  findByConditionAll(QueryCondition condition,Class<E> clazz) throws Exception;
	
	/**
	 * ���ݸ�����������ȡ��������������
	 * @Description: TODO(������һ�仰�����������������)
	 * @param conditions ���������
	 * @return ��ȡ�����������������
	 * @throws Exception 
	 */
	public int countByCondition(QueryCondition condition,Class<E> clazz) throws Exception;
	
	/**
	 * 
	 * @Description: TODO ���ݸ������������оۺϴ���
	 * @param conditions ���������
	 * @return �ۺϵĽ��
	 * @throws Exception 
	 */
	public List<Map<String,Object>> findAggregationByCondition(QueryCondition condition,Class<E> clazz) throws Exception;
	
	
	/**
	 * @Description: TODO ���ݸ�������������ǰ������Ҫ��Map����
	 * @param condition   ��������
	 * @param clazz       ��Ӧ��ʵ����������
	 * @return            ��������������ǰ������Ҫ��Map����
	 * @throws Exception 
	 */
	public Map<String,Object> fetchResponseByCondistion(QueryCondition condition,Class<E> clazz) throws Exception;
	
	
	
}
