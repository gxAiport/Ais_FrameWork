package com.airport.ais.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.airport.ais.enums.aodb.OperationalDay;




/**
 * ����ʱ�����͵Ĺ�����
 * @author ZhangYu
 * @version 0.9a 13/05/14
 * @since JDK1.6 
 * 
 */

public class DateTimeUtil {
	
	
	public final static int addHours=8;
	
	public final static int Err_Day=-999;
	
	/**
	 * ������������֮����������
	 * @param smdate ǰһ������
	 * @param bdate  ��һ������
	 * @return ��������֮����������
	 * @throws ParseException
	 */
	 public static int daysBetween(Date smdate,Date bdate)    
	    {    
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
	        try {
	        	smdate=sdf.parse(sdf.format(smdate));  	        	
				bdate=sdf.parse(sdf.format(bdate));
				Calendar cal = Calendar.getInstance();    
		        cal.setTime(smdate);    
		        long time1 = cal.getTimeInMillis();                 
		        cal.setTime(bdate);    
		        long time2 = cal.getTimeInMillis();         
		        long between_days=(time2-time1)/(1000*3600*24);  
		        return Integer.parseInt(String.valueOf(between_days)); 				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return Err_Day;
			}  
	                  
	    }   
	 
	 

	 
	 
	 
	 /**
	  * �������������еļ��������    
     * @param smdate ǰһ������
	 * @param bdate  ��һ������
	 * @return ��������֮�����ĺ�����
	 * @throws ParseException
	  */
	 public static long MillisecondBetween(Date smdate,Date bdate) {
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(smdate);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(bdate);    
	        long time2 = cal.getTimeInMillis();         
	       return time2-time1;  
	 }
	 
	 /**
	  * ��0930������ʱ���ַ���ת��Ϊ���� ���ת�����󷵻�0
	  * @param HHMM ʱ���ַ���
	  * @return ת���ĺ�����
	  */
	 public static long HHMMToMillisecond(String HHMM){
		 
		try {
			int Hour = Integer.parseInt(HHMM.substring(0, 2));
			int Minute = Integer.parseInt(HHMM.substring(2, 4));
			int Days =0; 
			if (HHMM.length()>=6){
				Days = Integer.parseInt(HHMM.substring(5));
				if (HHMM.substring(4, 5).equals("+")){
					return  Hour*3600*1000+Minute*1000*60+Days*3600*1000*24;
				}else{
					return  Hour*3600*1000+Minute*1000*60-Days*3600*1000*24; 
				}
			}else {
				return Hour*3600*1000+Minute*1000*60;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}
	 }
	 
	 

	 
	 /**
	  * 
	  * @Description: ���ض�Ӧ���ڵĲ����ݵ�����
	  * @param date  ����
	  * @param diffYear �������
	  * @return
	  */
	 public static Date getDiffYearDate(Date date,int diffYear){
		 	Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.YEAR,(cal.get(Calendar.YEAR)-diffYear));
			return cal.getTime();
	}
	 
	 
	 /**
	  * 
	  * @Description: ���ַ���hhmmת����һ����������
	  * @param date ��������
	  * @param hhmm ʱ���ַ���hh-Сʱ��mm-����
	  * @return
	  */
	 public static Date hhmmtoDate(Date date,String hhmm){
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(hhmm.substring(0, 2)));
			cal.set(Calendar.MINUTE, Integer.parseInt(hhmm.substring(2, 4)));	
			return cal.getTime();			
	 }
	 
	 
	 /**
	  * ��HHmm��ʽ���غ���ʵ�����������������
	  * @param flight ����ʵ����
	  * @param date ��Ҫת��������
	  * @return ����HHmm��ʽ���ַ���
	  */
	 public static String dateToHH_MM(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
  		return sdf.format(date);
	 }
	 
	 
	 
	 public static String dateToYYYYMMDD(Date date){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 return sdf.format(date);
	 }
	 
	 /**
	  * һ�����ڼ��Ϻ��뷵�ؽ��
	  * @param date ��Ҫ���ӵ�����
	  * @param millis ���ӵĺ�����
	  * @return ���Ӻ�����������
	  */
	 public static Date addMillisecond(Date date,long millis){
		 
		 Calendar cal = Calendar.getInstance();    
	     cal.setTime(date);   
	     cal.add(Calendar.HOUR_OF_DAY,(int) (millis/(1000*3600)));
	     cal.add(Calendar.MINUTE, (int) (millis%(1000*3600)/(1000*60)));
		return cal.getTime();
		 
	 }
	 
	 
	 /**
	  * ��һ��ʱ��ķ����Կ�0�Ϳ�5�ķ�ʽ���н���ȡֵ
	  * @param date ��Ҫȡֵ��ʱ��
	  * @return ���صĽ���ֵ
	  */
	 public static Date roundDate(Date date){
		 Calendar cal = Calendar.getInstance();    
	     cal.setTime(date);
	     int mBit = cal.get(Calendar.MINUTE) % 10;
	     if ((mBit >= 0)&&(mBit <3 )){
	    	 //���>0  and <3 ȡֵ0
	    	 cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)-mBit);
	     }else if(mBit < 8){
	    	 //���>3 and <8 ȡֵ 5
	    	 cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)-(mBit-5));
	     }else {
	    	 //���>8 ��λ+1 ȡֵΪ0
	    	 cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)+(10-mBit));
	     }
		return cal.getTime();
	 }
	 
	 /**
	  *  ��"ʱʱ�ַ�"������������
	  * @param date ���������ʱ����
	  * @return "ʱʱ�ַ�"��ʽ���ַ���
	  */
	 public static String DispTime(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("HHmm");
		return sdf.format(date);
		 
	 }
	 
	 
		/**
		 * �����ڽ���Ļ����ϼӻ��߼�����������,��������ʱ���֣���Ϊ0
		 * @param day ����
		 * @return �Ӽ�������
		 */
		public static Date addToDay(Date date,int day){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 
					calendar.get(Calendar.DATE),0, 0, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.add(Calendar.DATE, day);
			return calendar.getTime();
			
		}
		
		/**
		 * ��01MAY14֮���ʽ��Eterm�����ַ���ת��Ϊ��������
		 * @param EtermDate Eterm�����ַ���
		 * @return ��������
		 * @throws ParseException ת���쳣
		 */
		public static Date parseEtermDate(String EtermDate){
			SimpleDateFormat sdf =null;
			sdf = new SimpleDateFormat("ddMMMy",Locale.US);
			try {
				return sdf.parse(EtermDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		
		/**
		 * 
		 * @Description: ת��һ����ͳ��ϵͳ�����ַ���
		 * @param AspDate ��ͳ��ϵͳ�����ַ���
		 * @return Java.util���͵�Date
		 */
		public static Date  parseAspDate(String AspDate){
			SimpleDateFormat sdf =null;
			sdf = new SimpleDateFormat("MM/dd/y");
			try {
				return sdf.parse(AspDate);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
			
		}

		
		
		public static String formatEtermDate(Date date){
			SimpleDateFormat sdf =null;
			sdf = new SimpleDateFormat("ddMMMyy",Locale.US);
			
			return sdf.format(date);
		}
	 
		
		/**
		 * ���ַ���ת��Ϊ����ʱ��
		 * @param str �ַ���
		 * @return ת��������ʱ��
		 */
		public static Date strToDate(String str){
			
			SimpleDateFormat sdf = new SimpleDateFormat();
			if (Ais_String_Util.PatternIsMatch("\\d{4}/\\d{1,2}/\\d{1,2}(\\s\\d{1,2}:\\d{1,2}(:\\d{1,2})?(.\\d+)?)?", str)){
				//ƥ��2014/09/29  12:00:00����������
				if (Ais_String_Util.PatternIsMatch(".+\\s\\d{1,2}:\\d{1,2}:\\d{1,2}.\\d+", str)){
					sdf.applyPattern("yyyy/MM/dd HH:mm:ss.S");
				}else if (Ais_String_Util.PatternIsMatch(".+\\s\\d{1,2}:\\d{1,2}:\\d{1,2}", str)){
					sdf.applyPattern("yyyy/MM/dd HH:mm:ss");
				}else if (Ais_String_Util.PatternIsMatch(".+\\s\\d{1,2}:\\d{1,2}", str)){
					sdf.applyPattern("yyyy/MM/dd HH:mm");
				}else{
					sdf.applyPattern("yyyy/MM/dd");
				}
			}else 	if (Ais_String_Util.PatternIsMatch("\\d{4}-\\d{1,2}-\\d{1,2}(\\s\\d{1,2}:\\d{1,2}(:\\d{1,2})?(.\\d+)?)?", str)){
				//ƥ��2014-09-29����������
				if (Ais_String_Util.PatternIsMatch(".+\\s\\d{1,2}:\\d{1,2}:\\d{1,2}.\\d+", str)){
					sdf.applyPattern("yyyy-MM-dd HH:mm:ss.S");
				}else if (Ais_String_Util.PatternIsMatch(".+\\s\\d{1,2}:\\d{1,2}:\\d{1,2}", str)){
					sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
				}else if (Ais_String_Util.PatternIsMatch(".+\\s\\d{1,2}:\\d{1,2}", str)){
					sdf.applyPattern("yyyy-MM-dd HH:mm");
				}else{
					sdf.applyPattern("yyyy-MM-dd");
				}
			}else if (Ais_String_Util.PatternIsMatch("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{4}(\\d{2}(.\\d+)?)?", str)){
				//ƥ��2014-09-29  1200����������
				if (Ais_String_Util.PatternIsMatch(".+\\s\\d{6}.\\d+", str)){
					sdf.applyPattern("yyyy-MM-dd HHmmss.S");
				}else if (Ais_String_Util.PatternIsMatch(".+\\s\\d{6}", str)){
					sdf.applyPattern("yyyy-MM-dd HHmmss");
				}else{
					sdf.applyPattern("yyyy-MM-dd HHmm");
				}
			}else if (Ais_String_Util.PatternIsMatch("\\d{8}", str)){
				sdf.applyPattern("yyyyMMdd");
			}else if (Ais_String_Util.PatternIsMatch("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}\\+\\d{2}:\\d{2}", str)){
				//ƥ��2014-09-29  12:00:00����������
				sdf.applyPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'+08:00'");
				
			}else if (Ais_String_Util.PatternIsMatch("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z", str)){
				sdf.applyPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
				
			}
			
			if ((str !=null)&&(!str.trim().equals(""))){
				try {
					return sdf.parse(str);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}
		
		
		/**
		 * ������ʱ��ת��Ϊyyyy-MM-dd HHmm�ķ�ʽ�ַ���
		 * @param date  ����ʱ��
		 * @return ת������ַ���
		 */
		public static String DateToStr(Date date){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmm");
			return sdf.format(date);
		}
		
		/**
		 * 
		 * @Description: TODOת��������������Ҫ�ĸ�ʽ
		 * @param date
		 * @return
		 */
		public static String DateToSettlementStr(Date date){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			return sdf.format(date);
		}
		
		/**
		 * ���ݵ籨��ʱ�鷵��һ��GMT+8������ʱ��
		 * @param date
		 * @param dateGroup
		 * @return GMT+8������ʱ��
		 */
		public static Date getgrpGMT8Time(Date date,String dateGroup){
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.HOUR,-addHours);
			cal.set(Calendar.DAY_OF_MONTH,Integer.parseInt(dateGroup.substring(0, 2)));
			cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(dateGroup.substring(2, 4))+addHours);
			cal.set(Calendar.MINUTE, Integer.parseInt(dateGroup.substring(4, 6)));
			return cal.getTime();
			
		}
		

		/**
		 * 
		 * @Description: ���ݱ���ʱ�䷵��һ��UTCʱ��
		 * @param date ����ʱ��
		 * @return UTCʱ��
		 */
		public static Date getUTCTime(Date date){
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.HOUR,-addHours);
			return cal.getTime();
		}
		
		/**
		 * ����HHmm��ʱ�䷵��һ��������ı���ʱ�� ��һ�����ڼ��㺽�����ɣ���أ�ʱ��
		 * @param execDate ����ִ������
		 * @param dateGroup �籨��ʱ��
		 * @param HHmm ʱ��
		 * @return ����ʱ��
		 */
		public static Date getExecTime(Date execDate,String dateGroup,String HHmm){
			Calendar cal = Calendar.getInstance();
			cal.setTime(execDate);
			//ȡ������
			int execDay = cal.get(Calendar.DATE);
			//ȡ���ϸ������һ��
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);
			cal.set(Calendar.DATE, 1);
			int preLastDay = cal.getActualMaximum(Calendar.DATE);
				//�ָ��·�,����
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
			cal.set(Calendar.DATE, execDay);
			//ȡ�÷�����ʱ�������
			int grpDay = Integer.parseInt(dateGroup.substring(0, 2));
			
			if ((grpDay != execDay) &&(grpDay == preLastDay)
					&&(execDay == 1)){
				/**
				 * ���������ʱ���day�Ǳ���籨ʱ����һ���µ��µ�
				 * ���ұ���籨��day�뷢����ʱ���day����ͬ��
				 * ��Ҫ��Ҫ�ų���ͬ������£��·ݲ��ܼ���
				 */
				cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);
			}
			cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(HHmm.substring(0, 2))+addHours);
			cal.set(Calendar.MINUTE, Integer.parseInt(HHmm.substring(2, 4)));	
			return cal.getTime();			
		}
		
		/**
		 * ����һ������Ĺ���ִ������
		 * @param telexDate ���ı���ʱ��
		 * @param dateGroup �籨��ʱ��
		 * @return ����ִ��ʱ��
		 */
		public static Date getExecDate(Date telexDate,String dateGroup){
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(telexDate);
			//ȡ������
			int telexDay = cal.get(Calendar.DATE);
			//ȡ���ϸ������һ��
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);
			cal.set(Calendar.DATE, 1);
			int preLastDay = cal.getActualMaximum(Calendar.DATE);
			//�ָ��·�,����
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
			cal.set(Calendar.DATE, telexDay);
			
			//ȡ�÷�����ʱ������ں�Сʱ
			int grpDay = Integer.parseInt(dateGroup.substring(0, 2));
			int grpHour = Integer.parseInt(dateGroup.substring(2, 4));
			
			if (((grpDay != telexDay) &&(grpDay == preLastDay)
					&&(telexDay == 1))||grpDay > telexDay){
				/**
				 * ���������ʱ���day�Ǳ���籨ʱ����һ���µ��µ�
				 * ���ұ���籨��day�뷢����ʱ���day����ͬ��
				 * ��Ҫ��Ҫ�ų���ͬ������£��·ݲ��ܼ���
				 */
				cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);
			}
			
			cal.set(Calendar.DATE, grpDay);
			cal.set(Calendar.HOUR_OF_DAY, grpHour+addHours);
    		cal.set(Calendar.MINUTE,0);
			cal.set(Calendar.SECOND, 0);
			return addToDay(cal.getTime(),0);
			
		}
		
		
		
		/**
		 * ���غ����ɿ��ܵĵڶ�����
		 * @param telexDate �籨����ʱ��
		 * @param dateGroup �籨��ʱ��
		 * @return ������ܵĵڶ�������
		 */
		public static Date getSupplyDate(Date telexDate,String dateGroup){
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(telexDate);
			//ȡ������
			int telexDay = cal.get(Calendar.DATE);
			//�ָ��·�
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
			//ȡ�÷�����ʱ������ں�Сʱ
			int grpDay = Integer.parseInt(dateGroup.substring(0, 2));
			int grpHour = Integer.parseInt(dateGroup.substring(2, 4));
			
			if ((telexDay != grpDay)&&(grpHour<16)){

				return getExecDate(telexDate, dateGroup);
				
			}else if ((telexDay != grpDay)&&(grpHour>=16)){
				
				return addToDay(getExecDate(telexDate, dateGroup), -1);
				
			}else if ((telexDay == grpDay)&&(grpHour<16)){
				
				return getExecDate(telexDate, dateGroup);
				
			}else if ((telexDay == grpDay)&&(grpHour>=16)){
				
				return addToDay(getExecDate(telexDate, dateGroup),-1);
			}else {
				return null;
			}
	
			
		}
		
		/**
		 * �����������ת��Ϊ��ʽΪ������ʱ�ֵ��ַ���
		 * @param time	   ���� 2016-01-01 00:00
		 * @return ����      ����  201601010000
		 */
		public static String TimeToATMTime(Date time){
			String returnStr="";
			if (time != null){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
				returnStr = sdf.format(time);
			}
			return returnStr;
		}
		
		/**
		 * �����������ת��Ϊ��ʽΪ�����յ��ַ���
		 */

		public static String DateToATMDate(Date date){
			String returnStr="";
			if (date != null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				returnStr = sdf.format(date);
			}
			
			return returnStr;
		}
		
		

		
		/**
		 * 
		 * @Description: ���ݸ��������ڣ����ض�Ӧ�ĸ��µĵ�һ��
		 * @param date ����������
		 * @return ���ض�Ӧ�ĸ��µĵ�һ��
		 */
		public static Date getMonthFristDate(Date date){
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			return addToDay(cal.getTime(),0);
		}
		
		
		/**
		 * 
		 * @Description: ���ݸ��������ڣ����ض�Ӧ�ĸ��µ����һ��
		 * @param date   ����������
		 * @return       ���ض�Ӧ�ĸ��µ����һ��
		 */
		public static Date getMonthLastDate(Date date){
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			return addToDay(cal.getTime(),0);
		}
		
		/**
		 * 
		 * @Description:���ݸ��������ڣ����ض�Ӧ�ĸ���ĵ�һ��
		 * @param date ����������
		 * @return ��Ӧ�ĸ���ĵ�һ��
		 */
		public static Date getYearFristDate(Date date){
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.MONTH, 0);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			return cal.getTime();
		}
		
		
		/**
		 * ��Date����ת��ΪXMLGregorianCalendar����
		 * @param date ��Ҫת����Date����
		 * @return ת����XMLGregorianCalendar
		 * @throws DatatypeConfigurationException 
		 */
		public static XMLGregorianCalendar convertToXMLGregorianCalendar(Date date) throws DatatypeConfigurationException {
			if (date != null){
		        GregorianCalendar cal = new GregorianCalendar();
		        cal.setTime(date);
		        XMLGregorianCalendar gc = null;
		        gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		        return gc;
			}else{
				return null;
			}
	    }
	 
		/**
		 * ��XMLGregorianCalendar����ת����Date����
		 * @param cal ��Ҫת����XMLGregorianCalendar����
		 * @return ת����Date
		 * @throws Exception
		 */
		public static Date convertToDate(XMLGregorianCalendar cal) throws Exception{
			if (cal!= null){
		         GregorianCalendar ca = cal.toGregorianCalendar();
		         return ca.getTime();
			}else{
				return null;
			}
        }
		
		
		/**
		 * ��ȡָ���·ݵ����һ�����ָ����ݼ�������
		 * @param year    ���
		 * @param month   �·�
		 * @param day     ��ݼ�
		 * @return        ��Ӧ������
		 */
		public static Date getMonthDayofWeek(int year,int month,OperationalDay day){
			Calendar cal = Calendar.getInstance();  
		    cal.set(Calendar.YEAR, year);
	        cal.set(Calendar.MONTH, month);//�·�+1  
	        cal.set(Calendar.DAY_OF_MONTH, 1);  
	        cal.add(Calendar.DAY_OF_MONTH, -1);//�������һ��  
	        cal.add(Calendar.DAY_OF_MONTH,(day.ordinal()+2)%7 - cal.get(Calendar.DAY_OF_WEEK));
	        return addToDay(cal.getTime(),0);
		}
		
		/**
		 * ��ȡһ�����ڶ�Ӧ��OperationalDay
		 * @param date
		 * @return
		 */
		public static OperationalDay getOperationalDay(Date date){
			Calendar cal = Calendar.getInstance();  
			cal.setTime(date);
			return OperationalDay.values()[(cal.get(Calendar.DAY_OF_WEEK)+5)%7];
		}

}
