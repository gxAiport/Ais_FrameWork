package com.airport.ais.utils;

import java.util.Arrays;
import java.util.List;





/**
 * ����ϵͳ��չ�ַ�������ʾ�����趨
 * @author ZhangYu
 * @version 0.9a 28/06/14
 * @since JDK 1.6
 */

public class SYS_VARS {
	
	
	//ʵ��������Ӧ�ı����ɫ������Ĺ�ϵ��һһ��Ӧ
	
	
	
	
	//����ʵ���࣬һһ��Ӧ
	/**
	 *  ʵ��������
	 */
	public final static List<String> ModelName  =Arrays.asList(
			"com.lzairport.ais.models.TelexBO",
			"com.lzairport.ais.models.aodb.FlightState"
			);
	
	
	/**
	 * ��Ӧ�Ĺ���ʵ��������
	 */
	public final static List<String> RelationModelName  =Arrays.asList(
			"com.lzairport.ais.models.TelexBO",
			"com.lzairport.ais.models.aodb.DynFlight"
			);

	
	 //��ѡ����ɫ���ò�����List�ֶ���
	/**
	  *  ����������ɫ�ֶ���   
	  */
	public final static String AnalyticyTypeColorFieldName="name";
	
	/**
	 *  �籨������ɫ�ֶ���
	 */
	public final static String TelexTypeColorFieldName="name";

	
    //  ��ѡ����ɫ���õı�־λ
     
	/**
	 *  ����������ɫ��־
	 */
	public final static int brfrColorSet = 0;
	
	/**
	 *  ��Ԫ��������ɫ��־
	 */
	public final static int cellColorSet = 1;
	
	/**
	 *  ������ɫ��־
	 */
	public final static int allColorSet =2 ;
   
	/**
	 *  �༭�Ի���ÿ�����Ŀؼ���
	 */
	public final static int RowMaxNum = 10;

	/**
	 *  ʵ�����ͷ
	 */
	public static String ModelClassHeader="com.airport.ais.models.";
	
	
	//  ���Ҷ�����߼������
	public static String LinkSqlNull = "";
	
	public static String LinkSqlAnd  = "AND";
	
	public static String LinkSqlOr   = "OR";
	
	public static String Oper_Like   = "LIKE";
	
	public static String Oper_Is     = "IS";
	
	public static String SqlOrderBy="Order By";
	
	public static List<String> LinkSqlLev = Arrays.asList("(",LinkSqlOr,LinkSqlAnd);
	
	public static List<String> Operations= Arrays.asList(">","<",">=","<=","<>","=",Oper_Like,Oper_Is);

	public static List<String> OperationsCN= Arrays.asList("����","С��","���ڵ���","С�ڵ���","������","����","����");
	
	public static String Aggregation_Field ="Field";

	
	/**
	 *  ���ػ������ִ���
	 */
	public static String LocalAirportThreeCode="LZH";
	
	/**
	 * ���ػ���������
	 */
	public static String LocalAirportCn="����";

	/**
	 *  ���ػ������ִ���
	 */
	public static String LocalAirportFourCode="ZGZH";
	
	/**
	 *  �����������Ѵ���
	 */
	
	public static int FlightDelayTimes =2;
	
	/**
	 * �������෢��FPL��ʾ����
	 */
	public static int FlightFPLTimes = 1;
	
	/**
	 * �������෢��FPL���ѵľ��뺽��ƻ���ɵ�����
	 * <p>һ��Сʱ
	 */
	public static int FlightFPLSecond = -60*60*1000;
	
	/**
	 *  ����
	 */
	public static String AscSORT="ASC";
	
	
	/**
	 * ����
	 */
	public static String DescSORT="DESC";
	
	/**
	 * 
	 * ������Ϣ����״̬
	 *
	 */
	
	public enum LoadState {  
		NotInmport,PlnImported,Imported
      }  	
	
	public static List<String> LoadStateCn = 
			Arrays.asList("δ����","Ԥ����","�ѵ���");
	/**
	 * ViewConfig����ʾ����
	 */
	public static String  ViewItemType_Static = "Static";
	public static String  ViewItemType_Dyniamic = "Dyniamic";
	public static String  ViewItemType_Enum = "Enum" ;
	public static String  ViewItemType_Num = "Number" ;
	public static String  ViewItemType_Bool ="Bool";
	
	public static List<String> ViewItemTypeCn = 
			Arrays.asList("��̬","��̬","ö��","���");

	public static String[] ViewItemType = 
			{ViewItemType_Static,ViewItemType_Dyniamic,ViewItemType_Enum,
					ViewItemType_Num,ViewItemType_Bool};
	

	public enum SizeType {  
		Big,Mid,Small
      }  
	
	
	/**
	 *  ���оۺϲ�ѯʱ��������꣬�£��յ�ö������
	 */
	public enum GrpDate{
		Year,Month,Day
	}
	
	
	
	public static List<String> SizeTypeCn = 
			Arrays.asList("����","����","С��");
	
    /**
     * ִ������
     */
	public enum Week {  
        Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday  
      }  
	
	/**
	 *   �����ÿ����� 
	 */
	public enum  PayingServiceType{
		Gold,silver,FClass
	}
	
	public static List<String> PayingServiceTypeCn = 
			Arrays.asList("��","����","ͷ�Ȳ�");
    
    /**
     * ���ڼƻ�����
     */
	public enum Quarter{
		WinterSpring,SummerAutumn
    }
	
	public static List<String> QuarterCn = Arrays.asList("����","����");
	
	
	//����ۺ��ֶε����ͣ���ͣ�ƽ����,���������ʽ,���㣨��ѯ����ݽ����
	public enum AggregationFieldType {
		Sum,Avg,Count,None
	}
	
	
	/**
	 *   ���񻷽ڵ����� 
	 */
	public enum DisPatchItemType{
		End,Start_End,Start_End_Times
	}
	
	public static List<String> DisPatchItemTypeCn 
	= Arrays.asList("����","��ʼ/����","��ʼ/����/����");
	
	
	
	
	
	
	
	/**
	 * 
	 * �����ۺ��������
	 *
	 */
	public enum OutIn{
		Dep,Arr,Srd
	}
	
	public enum RouteType{
		Dom,Dom_Tra,Int,Int_Tra,Reg,Reg_Tra
	}
	
	public enum DiscountStyle{
		direct,Range
	}

	/**
	 * �����ۺ����Ӧ��List
	 */
	public static List<String> RouteTypeCn = Arrays.asList("����","������ת","����","������ת","����","������ת");
	
	
	/**
	 * �����ۺ����Ӧ��List
	 */
	public static List<String> OutInCn = Arrays.asList("����","����","����");
	
	/**
	 * �����ۺ����Ӧ��List Code
	 */
	public static List<String> OutInCode = Arrays.asList("Dep","Arr","Srd");
	
	public enum ConverterFlag{
		PO2VO,VO2PO
	}
	
	
	/**
	 *  ����������������յĽ��ۺ���---���ս���
	 */
	public static String LinkFlightDep = "�������ͣ��";
	
	/**
	 *  ��������ǲ����ڱ����ĺ���-----���ۿ�ʼ
	 */
	public static String LinkFlightArr = "���߿�ʼ";
	
	
	
	public static String SysTemStartDate="01JAN14";
	
	
	

	




	
}
