package com.airport.ais.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * �ַ�������ù�����
 * @author ZhangYu
 * @version 0.9a 28/06/14
 * @since JDK 1.6
 */

public class Ais_String_Util {
	
	public static String SplitChar="|";

	/**
	 * 
	 * @Description: ���ַ����ֽ⣬���մ���ķֽ��ַ�
	 * @param content
	 * @param splitChar
	 * @return
	 */
	public static List<String> SplitField(String content,String splitChar){
		List<String> listStrs = new ArrayList<String>();
		Pattern pat = Pattern.compile("[^"+splitChar+"]+");   
		Matcher mat = pat.matcher(content);  
		while (mat.find()){
			listStrs.add(mat.group());
		}
		return listStrs;
	}
	
	
	
	/**
	 * ��һ��String��|Ϊ�ָ�����ֳ�һ�������ַ���
	 * @param Content �����ַ���
	 * @return List �ַ�������
	 */
	public static List<String> SplitField(String Content){
		List<String> listStrs = new ArrayList<String>();
		Pattern pat = Pattern.compile("[^\\|]+");   
		Matcher mat = pat.matcher(Content);  
		while (mat.find()){
			listStrs.add(mat.group());
		}
		return listStrs;
	}
	
	
	/**
	 * ��һ��String�Կո�Ϊ�ָ�����ֳ�һ�������ַ���
	 * @param Content �����ַ���
	 * @return List �ַ�������
	 */
	public static List<String> SplitField_Spc(String Content){
		List<String> listStrs = new ArrayList<String>();
		Pattern pat = Pattern.compile("[^\\s]+");   
		Matcher mat = pat.matcher(Content);  
		while (mat.find()){
			listStrs.add(mat.group());
		}
		return listStrs;
	}
	
	/**
	 * ��һ��String��"\"Ϊ�ָ�����ֳ�һ�������ַ���
	 * @param Content
	 * @return
	 */
	public static List<String> SplitSubEname(String Content){
		return SplitField(Content,"/");
	}

	/**
	 * ��һ��String�Ի���Ϊ�ָ����ֳ�һ���еĵ籨��
	 * @param Content �����ַ���
	 * @return List �ַ�������
	 */
	public static List<String> SplitLine(String Content){
		List<String> listStrs = new ArrayList<String>();
		Pattern pat = Pattern.compile(".+");   
		Matcher mat = pat.matcher(Content);  
		while (mat.find()){
			listStrs.add(mat.group());
		}
		return listStrs;
	}
	
	/**
	 * ����������ʽ���ж������ַ����Ƿ���Ϲ���Ҫ��ȫ��ƥ��	
	 * @param regEx �����ַ���
	 * @param str ��Ҫ�жϵ��ַ���
	 * @return ���
	 */
	public static boolean PatternIsMatch(String regEx,String str){
		Pattern pat = Pattern.compile(regEx);   
		Matcher mat = pat.matcher(str);  
		return mat.matches();
	}
	
	/**
	 * ����������ʽ��Ѱ�ҷ��Ϲ�����ַ����������أ���Ҫ��ȫ��ƥ��
	 * @param regEx �����ַ���
	 * @param str ��Ҫ�жϵ��ַ���
	 * @return
	 */
	
	public static String PatternFind(String regEx,String str){
		Pattern pat = Pattern.compile(regEx);   
		Matcher mat = pat.matcher(str);  
		if (mat.find()){

			return mat.group();
		}
		else {
			return null;
		}
	}
	
	/**
	 * �ж�һ���ַ����Ƿ�������
	 * @param str �ַ���
	 * @return �Ƿ�
	 */
	public static boolean isNumeric(String str){
		  for (int i = str.length();--i>=0;){   
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
	}
	
	/**
	 * 
	 * @Description: �ж�һ���ַ��������һ���Ƿ�Ϊ����
	 * @param str �ַ���
	 * @return �Ƿ�Ϊ����
	 */
	public static boolean lastCharIsOdd(String str){
		String lastNum = str.substring(str.length()-1);
		if (Character.isDigit(lastNum.charAt(0))){
			if (Integer.valueOf(lastNum) %2 !=0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	
	
 
}
