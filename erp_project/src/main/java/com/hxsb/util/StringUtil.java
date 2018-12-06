package com.hxsb.util;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 字符串工具类。
 * 
 * @author zhouxw
 */
public final class StringUtil {

	/**
	 * Comment for <code>DOT</code>
	 */
	public static final char DOT = '.';

	/**
	 * Comment for <code>UNDERSCORE</code>
	 */
	public static final char UNDERSCORE = '_';

	/**
	 * Comment for <code>EMPTY_STRING</code>
	 */
	public static final String EMPTY_STRING = "";
	
	/**
	 * Comment for <code>COMMA</code>
	 */
	public static final String COMMA = ",";

	/**
	 * Comment for <code>OPEN_PAREN</code>
	 */
	public static final String OPEN_PAREN = "(";

	/**
	 * Comment for <code>CLOSE_PAREN</code>
	 */
	public static final String CLOSE_PAREN = ")";

	/**
	 * 一个为"True"的私有变量,只是为了减少内存
	 */
	public static final String STR_TRUE = "True";

	/**
	 * 一个为"False"的私有变量,只是为了减少内存
	 */
	public static final String STR_FALSE = "False";

	/**
	 * 一个全局的空字符串
	 */
	public static final String STR_EMPTY = "";

	/**
	 * 数学符号,无穷数
	 */
	public static final String STR_INFINITUDE = "∞";

	
	/**
	 * @param arrO
	 * @param str
	 * @return String
	 */
	public static String join(Object[] arrO, String str) {
		String sReturn = "";
		if (arrO == null) {
			return null;
		}
		for (Object s : arrO) {
			sReturn += s.toString() + str;
		}
		// Delete last ;
		if (sReturn.length() != 0) {
			sReturn = sReturn.substring(0, sReturn.length() - str.length());
		}
		return sReturn;
	}
	
	/**
	 * @param obj
	 * @param style
	 * @return String
	 */
	public static String formatNum(Object obj, String style) {
		java.text.DecimalFormat format = new java.text.DecimalFormat(style);
		return format.format(obj);
	}
	
	/**
	 * @param seperator
	 * @param strings
	 * @return String
	 */
	public static String join(String seperator, String[] strings) {
		int length = strings.length;
		if (length == 0)
			return EMPTY_STRING;
		StringBuffer buf = new StringBuffer(length * strings[0].length())
				.append(strings[0]);
		for (int i = 1; i < length; i++) {
			buf.append(seperator).append(strings[i]);
		}
		return buf.toString();
	}
	
	
	/**
	 * @param seperator
	 * @param objects
	 * @return String
	 */
	public static String join(String seperator, Iterator<?> objects) {
		StringBuffer buf = new StringBuffer();
		buf.append(objects.next());
		while (objects.hasNext()) {
			buf.append(seperator).append(objects.next());
		}
		return buf.toString();
	}

}