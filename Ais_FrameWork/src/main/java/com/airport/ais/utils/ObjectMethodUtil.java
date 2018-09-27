package com.airport.ais.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 * 
 * FileName      ObjectMethodUtil.java
 * @Description  TODO ���÷��似����������Ĺ��߼��� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��11��19��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��11��19��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */


public class ObjectMethodUtil {
	
	
	
	/**
	 * ��ȡ��Ա������Read�������ַ���
	 * @param fieldname �ֶ���
	 * @return Read�������ַ���
	 */
	private static String getReadMethodName(String fieldname){
		return "get" + fieldname.substring(0, 1).toUpperCase()
				+ fieldname.substring(1);
	}
	
	/**
	 * ��ȡ��Ա������Set�������ַ���
	 * @param  fieldname �ֶ���
	 * @return Set�������ַ��� 
	 */
	private static String getSetMethodName(String fieldname){
		return "set" + fieldname.substring(0, 1).toUpperCase()
				+ fieldname.substring(1);
	}
	
	/**
	 * ��ȡָ���ֶε�get����
	 * @param clazz ʵ��������
	 * @param field �ֶ�
	 * @return GET����
	 * @throws SecurityException              ��ȫ�쳣
	 * @throws NoSuchMethodException          û�з����쳣 
	 */
	private static Method getReadModelMethod(Class<?> clazz,String field) throws NoSuchMethodException, SecurityException{
		Method m = null;
		m= clazz.getMethod(getReadMethodName(field));
		return m;
	}
	
	/**
	 * ��ȡָ���ֶε�Set����
	 * @param clazz ʵ��������
	 * @param field ָ���ֶ�
	 * @return Set����
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */

	private static Method getSetModelMethod(Class<?> clazz,String field,Class<?> parmClass) throws NoSuchMethodException, SecurityException{
		Method m = null;
		m= clazz.getMethod(getSetMethodName(field),parmClass);
		return m;
	}
	
	/**
	 * ��ȡ���ݶ�������Ӧ���ֶε�ֵ
	 * @param  obj    ���ݶ���
	 * @param  field  �ֶ���
	 * @param  direct �Ƿ�ֱ��ʹ��get���� 
	 * @return ��Ӧ���ֶε�ֵ
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static Object getFieldObject(Object obj, String field,boolean direct) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (obj != null && field != null) {
			Method m  = null;
			if (direct){
				//���ֱ��ʹ��get�������������ֶε����ֱ仯
				m= obj.getClass().getDeclaredMethod("get" +field);
			} else {
				//��������ֶα仯
				m = getReadModelMethod(obj.getClass(), field);
			}
			return m.invoke(obj);
		}else {
			return null;
		}
	}
	

	
	/**
	 * �������ݶ�������Ӧ���ֶε�ֵ
	 * @param obj ���ݶ���
	 * @param field �ֶ���
	 * @param parm ���õ�����
	 * @param parmClass �������ݵ�����
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws Exception 
	 */
	public static void setFieldObject(Object obj, String field,Object parm,Class<?> parmClass,boolean direct) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (parmClass.equals(Timestamp.class)){
			/*
			 * �����Timestamp.classת��ΪJAVA.DATE
			 */
			parmClass = Date.class;
		}
		if (obj != null && field != null) {
			Method m = null;
			if (!direct){
				m = getSetModelMethod(obj.getClass(),field,parmClass);
			}else {
				m =  obj.getClass().getMethod(field, parmClass);
			}
			m.invoke(obj,parm);
		}
	}

	/**
	 * ��ȡ���Ӧ�ֶε�����
	 * @param clazz ���ݶ��������
	 * @param field �ֶ���
	 * @return ��Ӧ�ֶε�����
	 */
	public static Class<?> getFieldType(Class<?> clazz, String field){
		Method method = null;
		try {
			method = getReadModelMethod(clazz, field);
		} catch (NoSuchMethodException | SecurityException e) {
			//���û�и÷���������null
			return null;
		}
		return method.getReturnType();
	}
	
	/**
	 * ��ȡ�����ֶε�ָ����ŷ��͵�ʵ������
	 * @param obj ����
	 * @param fieldName  ָ���ֶ�
	 * @return ���͵�ʵ������
	 */
	public  static   Type getFieldGenericType(Object obj,String fieldName,Integer index){

		ParameterizedType type = null;
		try {
			type = (ParameterizedType)obj.getClass().getDeclaredField(fieldName).getGenericType();
		} catch (NoSuchFieldException | SecurityException e) {
			return null;
		}
		return  type.getActualTypeArguments()[index];
	}
	
	

	
	/**
	 * �ж����������Ƿ���ȣ�����null�����
	 * @param obj
	 * @param other
	 * @return
	 */
	public static  boolean equalsField(Object obj,Object other){
		if (obj != null && obj.equals(other)){
			return true;
		}else if (obj == null && other == null) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * �Աȸ�ֵ���������ָ���ֶΣ������ͬ�����и�ֵ���ؽṹfalse;��ͬ���и�ֵ���ؽ��true
	 * @param obj               ��Ҫ�ԱȵĶ���
	 * @param compareObj        �����ԱȵĶ���
	 * @param fields            ��Ҫ�Աȵ��ֶ�
	 * @param compareFields     �����Աȵ��ֶΣ���Ҫ��fields�ĳ���һ��
	 * @return                  �Ƿ�һ�� 
	 * @throws Exception 
	 */

	public static boolean compareAndCopyFields(Object obj,Object compareObj,String[] fields,String[] compareFields) throws Exception {
		boolean result = false;
		for (int i=0;i< fields.length;i++){
			Object value = getFieldObject(obj, fields[i],false);
			Object compareValue = getFieldObject(compareObj, compareFields[i],false);
			
			if (value instanceof Set &&  compareValue instanceof Set) {
				/*
				 * ������Զ�ΪSet���ԣ�����Set���Խ��бȽ�
				 */
				if (compareAndCopySetFields((Set<?>)value,(Set<?>)compareValue)){
					result = true;
				}
			}else if (!equalsField(value, compareValue)){
				/*
				 * ����������Բ���ȣ����и�ֵ
				 */
				if (compareValue == null){
					setFieldObject(obj, fields[i],compareValue,value.getClass(),false);
				}else{
					setFieldObject(obj, fields[i],compareValue,compareValue.getClass(),false);
				}
				result = true;
			}
		}
		
		return result;
	}
	
	
	
	/**
	 * �Աȸ�ֵ����Set�����ָ���ֶΣ������ͬ�����и�ֵ���ؽṹfalse;��ͬ���и�ֵ���ؽ��true
	 * @param objSet       ��Ҫ�Աȵ�Set����
	 * @param compareSet   �����Աȵ�Set����
	 * @return             �Ƿ�һ��
	 * @throws Exception   
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean compareAndCopySetFields(Set objSet,Set compareSet) throws Exception{
		boolean isUpdate = false;
		
		for(Object compareObj:compareSet){
			loop://ѭ����ǩ������������ѭ���ı�ǩ
			for(Object obj:objSet){
				for(Field field:obj.getClass().getFields()){
					Object value        = getFieldObject(obj, field.get(obj).toString(),false);
					Object compareValue = getFieldObject(compareObj, field.get(compareObj).toString(),false);
					/**
					 *   ����ֶβ�һ�£�id�ֶβ�������
					 */
					if(!equalsField(value, compareValue)&&!"ID".equals(field.getName())){
						isUpdate = true;
						break loop;
					}
				}
			}
		}
		
		/*
		 * ������ݲ�һ�£��������Աȵ�Set����compareSet���滻��Ҫ�Աȵ�Set����objSet��
		 * btw:����������Աȵ�Set���󼯺ϳ�Ա����id�ֶ���id�ֶ�ΪInteger���ͣ���id���ó�0
		 * ����Ϊ�˱������ݿⱣ��ID������ͬ�����Ե�����
		 */
		if (isUpdate){
			for(Object compareObj:compareSet){
				try {
					setFieldObject(compareObj, "id", 0, Integer.class,false);
				} catch (Exception e) {
					// ���û��id�ֶΣ��򲻽��д���
				}
			}
			objSet.clear();
			objSet.addAll(compareSet);
		}
		return isUpdate;
	}
	
	
}
