package com.airport.ais.models.collection;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import org.springframework.format.annotation.DateTimeFormat;
import com.airport.ais.enums.UploadType;
import com.airport.ais.models.IntIdEntity;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 
 * 
 * FileName      UploadRecord.java
 * @Description  TODO 上传数据的实体类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年8月5日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年8月5日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
public class UploadRecord extends IntIdEntity {

	/**  
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 各个数据字段名,用来直接点用字段名
	 */
	public static String UPLOADTYPE    = "uploadType";
	public static String UPLOADDATE    = "uploadDate";
	public static String TOTALRECORDS  = "totalRecords";
	public static String UPDATERECORDS = "updateRecords";
	public static String NEWRECORDS    = "newRecords";
	public static String FAILRECORDS   = "failRecords";
	public static String DESCRIPTION   = "description"; 
	public static String UPLOADSOURCE  = "uploadSource";

	/**
	 * 上传类型
	 */
	@Enumerated(EnumType.STRING)
	@Column(length=40)
	private UploadType uploadType;
	
	/**
	 *  上传日期
	 */
	private Date uploadDate;
	
	/**
	 * 总记录数
	 */
	private int totalRecords;
	
	/**
	 * 更新记录数
	 */
	private int updateRecords;
	
	
	/**
	 * 新增记录数
	 */
	private int newRecords;
	
	/**
	 * 失败记录数
	 */
	private int failRecords;
	
	/**
	 * 描述文件
	 */
	private String description;
	
	
	/**
	 * 上传源
	 */
	@Column(length=30)
	private String uploadSource;

	/**
	 * @return the uploadType
	 */
	public UploadType getUploadType() {
		return uploadType;
	}

	/**
	 * @param uploadType the uploadType to set
	 */
	public void setUploadType(UploadType uploadType) {
		this.uploadType = uploadType;
	}

	/**
	 * @return the uploadDate
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  	
	public Date getUploadDate() {
		return uploadDate;
	}

	/**
	 * @param uploadDate the uploadDate to set
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	/**
	 * @return the totalRecords
	 */
	public int getTotalRecords() {
		return totalRecords;
	}

	/**
	 * @param totalRecords the totalRecords to set
	 */
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * @return the updateRecords
	 */
	public int getUpdateRecords() {
		return updateRecords;
	}

	/**
	 * @param updateRecords the updateRecords to set
	 */
	public void setUpdateRecords(int updateRecords) {
		this.updateRecords = updateRecords;
	}

	/**
	 * @return the newRecords
	 */
	public int getNewRecords() {
		return newRecords;
	}

	/**
	 * @param newRecords the newRecords to set
	 */
	public void setNewRecords(int newRecords) {
		this.newRecords = newRecords;
	}

	/**
	 * @return the failRecords
	 */
	public int getFailRecords() {
		return failRecords;
	}

	/**
	 * @param failRecords the failRecords to set
	 */
	public void setFailRecords(int failRecords) {
		this.failRecords = failRecords;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getUploadSource() {
		return uploadSource;
	}

	public void setUploadSource(String uploadSource) {
		this.uploadSource = uploadSource;
	}


	

}
