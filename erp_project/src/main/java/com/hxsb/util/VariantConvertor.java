package com.hxsb.util;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;



public class VariantConvertor {
	/**
	 * 将数据转化为一个字符串型
	 * 
	 * @param value
	 * @return String
	 */
	public static String toString(Object value) {
		if (value == null) {
			return ""; 
		} else if (value instanceof String) {
			return (String) value;
		} else if (value instanceof Integer) {
			return ((Integer) value).toString();
		} else if (value instanceof Double) {
			// 转string不需要科学计数 
			// 直接传入Double类型 会造成精度丢失
			BigDecimal b = new BigDecimal(value.toString());
			return adaptFormat(b.toString());
			// 原来的做法会造成小数精度缺省
			// if ((Double) value % 1 == 0)
			// return new DecimalFormat("#0").format((Double) value);
			// return new DecimalFormat("#0.000000").format((Double) value);
		} else if (value instanceof Boolean) {
			return ((Boolean) value) ? "true" : "false";
		} else if (value instanceof Timestamp) {
			return DateUtil.format((Timestamp) value, "yyyy-MM-dd HH:mm:ss");
			// DateFormat dateFormat = new Simple DateFormat("yyyy-MM-dd
			// HH:mm:ss"); return dateFormat.format((Timestamp) value);
		} else if (value instanceof Time) {
			return DateUtil.format((Time) value, "yyyy-MM-dd HH:mm:ss");
			// Date Format dateFormat = new Simple DateFormat("yyyy-MM-dd
			// HH:mm:ss"); return dateFormat.format((Time) value);
		} else if (value instanceof Date) {
			return DateUtil.format((Date) value, "yyyy-MM-dd");
			// Date Format dateFormat = new Simple DateFormat("yyyy-MM-dd");
			// return dateFormat.format((Date) value);
			// return value.toString();
		} else if (value instanceof Integer[]) {
			return StringUtil.join((Object[]) value, ";");
		} else if (value instanceof Long) {
			return ((Long) value).toString();
		} else if (value instanceof BigDecimal){
			return ((BigDecimal)value).toString();
		} else if (value instanceof List) {
			//JSONArray json = JSONArray.fromObject(value);
			return value.toString();
		}
		// assert false;
		return "";
	}
	
	
	/**
	 * 将Double BigDecimal转换成的字符串中小数点后多余的零去掉
	 * 
	 * @param value
	 * @return String
	 */
	public static String adaptFormat(String value) {
		String newValue = value;
		if (value.indexOf('.') >= 0) {
			int index = value.length() - 1;
			int lastIndex = 0;
			while (index > 0) {
				if (value.charAt(index) == '.') {
					lastIndex = index;
					break;
				} else if (value.charAt(index) != '0') {
					lastIndex = index + 1;
					break;
				}
				index--;
			}
			if (lastIndex > 0 && lastIndex < value.length()) {
				newValue = value.substring(0, lastIndex);
			}
		}
		return newValue;
	}
}
