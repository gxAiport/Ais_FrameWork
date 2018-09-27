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
 * @Description  TODO 利用反射技术操作对象的工具集合 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年11月19日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年11月19日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */


public class ObjectMethodUtil {
	
	
	
	/**
	 * 获取成员变量的Read方法的字符串
	 * @param fieldname 字段名
	 * @return Read方法的字符串
	 */
	private static String getReadMethodName(String fieldname){
		return "get" + fieldname.substring(0, 1).toUpperCase()
				+ fieldname.substring(1);
	}
	
	/**
	 * 获取成员变量的Set方法的字符串
	 * @param  fieldname 字段名
	 * @return Set方法的字符串 
	 */
	private static String getSetMethodName(String fieldname){
		return "set" + fieldname.substring(0, 1).toUpperCase()
				+ fieldname.substring(1);
	}
	
	/**
	 * 获取指定字段的get方法
	 * @param clazz 实体类类型
	 * @param field 字段
	 * @return GET方法
	 * @throws SecurityException              安全异常
	 * @throws NoSuchMethodException          没有方法异常 
	 */
	private static Method getReadModelMethod(Class<?> clazz,String field) throws NoSuchMethodException, SecurityException{
		Method m = null;
		m= clazz.getMethod(getReadMethodName(field));
		return m;
	}
	
	/**
	 * 获取指定字段的Set方法
	 * @param clazz 实体类类型
	 * @param field 指定字段
	 * @return Set方法
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */

	private static Method getSetModelMethod(Class<?> clazz,String field,Class<?> parmClass) throws NoSuchMethodException, SecurityException{
		Method m = null;
		m= clazz.getMethod(getSetMethodName(field),parmClass);
		return m;
	}
	
	/**
	 * 获取数据对象所对应的字段的值
	 * @param  obj    数据对象
	 * @param  field  字段名
	 * @param  direct 是否直接使用get方法 
	 * @return 对应的字段的值
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
				//如果直接使用get方法，不进行字段的首字变化
				m= obj.getClass().getDeclaredMethod("get" +field);
			} else {
				//否则进行字段变化
				m = getReadModelMethod(obj.getClass(), field);
			}
			return m.invoke(obj);
		}else {
			return null;
		}
	}
	

	
	/**
	 * 设置数据对象所对应的字段的值
	 * @param obj 数据对象
	 * @param field 字段名
	 * @param parm 设置的数据
	 * @param parmClass 设置数据的类型
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
			 * 如果是Timestamp.class转换为JAVA.DATE
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
	 * 获取类对应字段的类型
	 * @param clazz 数据对象的类型
	 * @param field 字段名
	 * @return 对应字段的类型
	 */
	public static Class<?> getFieldType(Class<?> clazz, String field){
		Method method = null;
		try {
			method = getReadModelMethod(clazz, field);
		} catch (NoSuchMethodException | SecurityException e) {
			//如果没有该方法，返回null
			return null;
		}
		return method.getReturnType();
	}
	
	/**
	 * 获取对象字段的指定序号泛型的实际类型
	 * @param obj 对象
	 * @param fieldName  指定字段
	 * @return 泛型的实际类型
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
	 * 判断两个对象是否相等，包括null的情况
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
	 * 对比赋值两个对象的指定字段，如果相同不进行赋值返回结构false;不同进行赋值返回结果true
	 * @param obj               需要对比的对象
	 * @param compareObj        用来对比的对象
	 * @param fields            需要对比的字段
	 * @param compareFields     用来对比的字段，需要和fields的长度一致
	 * @return                  是否一致 
	 * @throws Exception 
	 */

	public static boolean compareAndCopyFields(Object obj,Object compareObj,String[] fields,String[] compareFields) throws Exception {
		boolean result = false;
		for (int i=0;i< fields.length;i++){
			Object value = getFieldObject(obj, fields[i],false);
			Object compareValue = getFieldObject(compareObj, compareFields[i],false);
			
			if (value instanceof Set &&  compareValue instanceof Set) {
				/*
				 * 如果属性都为Set属性，调用Set属性进行比较
				 */
				if (compareAndCopySetFields((Set<?>)value,(Set<?>)compareValue)){
					result = true;
				}
			}else if (!equalsField(value, compareValue)){
				/*
				 * 如果两个属性不相等，进行赋值
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
	 * 对比赋值两个Set对象的指定字段，如果相同不进行赋值返回结构false;不同进行赋值返回结果true
	 * @param objSet       需要对比的Set对象
	 * @param compareSet   用来对比的Set对象
	 * @return             是否一致
	 * @throws Exception   
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean compareAndCopySetFields(Set objSet,Set compareSet) throws Exception{
		boolean isUpdate = false;
		
		for(Object compareObj:compareSet){
			loop://循环标签，用于跳出该循环的标签
			for(Object obj:objSet){
				for(Field field:obj.getClass().getFields()){
					Object value        = getFieldObject(obj, field.get(obj).toString(),false);
					Object compareValue = getFieldObject(compareObj, field.get(compareObj).toString(),false);
					/**
					 *   如果字段不一致（id字段不包含）
					 */
					if(!equalsField(value, compareValue)&&!"ID".equals(field.getName())){
						isUpdate = true;
						break loop;
					}
				}
			}
		}
		
		/*
		 * 如果数据不一致，则将用来对比的Set对象（compareSet）替换需要对比的Set对象（objSet）
		 * btw:如果有用来对比的Set对象集合成员中有id字段且id字段为Integer类型，将id设置成0
		 * 这是为了避免数据库保存ID出现相同可能性的问题
		 */
		if (isUpdate){
			for(Object compareObj:compareSet){
				try {
					setFieldObject(compareObj, "id", 0, Integer.class,false);
				} catch (Exception e) {
					// 如果没有id字段，则不进行处理
				}
			}
			objSet.clear();
			objSet.addAll(compareSet);
		}
		return isUpdate;
	}
	
	
}
