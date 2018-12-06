package com.hxsb.util;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;



/**
 * @author zhouxw
 * 
 *         对Calendar, Date的再封装
 */
public class DateUtil implements Serializable {

	/**
	 * @return Timestamp
	 */
	public static Timestamp getCurrTime() {
		return new Timestamp(System.currentTimeMillis());
	}



	/**
	 * 将日期类型转化为字符串类型
	 * 
	 * @param timeStr
	 * @param sFormat
	 * @return String
	 */
	public static String format(java.util.Date date, String sFormat) {
		sFormat = sFormat == null ? "yyyy-MM-dd" : sFormat;
		if ("YY-MM-DD".equalsIgnoreCase(sFormat))
			sFormat = "yy-MM-dd";
		else if ("YYMMDD".equalsIgnoreCase(sFormat))
			sFormat = "yyMMdd";
		else if ("MM-DD".equalsIgnoreCase(sFormat))
			sFormat = "MM-dd";
		else if ("MMDD".equalsIgnoreCase(sFormat))
			sFormat = "MMdd";
		else if ("YYYY-MM".equalsIgnoreCase(sFormat))
			sFormat = "yyyy-MM";
		else if ("YYYYMM".equalsIgnoreCase(sFormat))
			sFormat = "yyyyMM";
		else if ("YYYY-MM-DD".equalsIgnoreCase(sFormat))
			sFormat = "yyyy-MM-dd";
		else if ("YYYY-MM-DD HH".equalsIgnoreCase(sFormat))
			sFormat = "yyyy-MM-dd HH";
		else if ("YYYY-MM-DD HH:MM".equalsIgnoreCase(sFormat))
			sFormat = "yyyy-MM-dd HH:mm";
		else if ("YYYY-MM-DD HH:MM:SS".equalsIgnoreCase(sFormat))
			sFormat = "yyyy-MM-dd HH:mm:ss";
		else if ("YYYY".equalsIgnoreCase(sFormat))
			sFormat = "yyyy";
		else if ("YYYYMMDD".equalsIgnoreCase(sFormat))
			sFormat = "yyyyMMdd";
		else if ("YYYYMMDDMMSS".equalsIgnoreCase(sFormat)) 
			sFormat = "yyyyMMddmmss";
		else if ("YYYYMMDDHH".equalsIgnoreCase(sFormat))
			sFormat = "yyyyMMddHH";
		else if ("YYYYMMDDHHSS".equalsIgnoreCase(sFormat)) 
			sFormat = "yyyyMMddHHSS";
		else if ("YYYYMMDDHHMM".equalsIgnoreCase(sFormat)) 
			sFormat = "yyyyMMddHHmm";
		else if ("YYYYMMDDHHMMSS".equalsIgnoreCase(sFormat)) 
			sFormat = "yyyyMMddHHmmss";
		else if ("YY-MM".equalsIgnoreCase(sFormat)) 
			sFormat = "yy-MM";
		else if ("YYMM".equalsIgnoreCase(sFormat)) 
			sFormat = "yyMM";
		return getDateFormatStr(date, sFormat);
	}
	
	
	private static String getDateFormatStr(java.util.Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}
	
}
