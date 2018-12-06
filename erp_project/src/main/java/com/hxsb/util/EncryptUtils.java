package com.hxsb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {

	public static String MD5(String strSource, int returnLength) {

		String md5String = MD5Creater(strSource);

		switch (returnLength) {
		case 16:
			return md5String.substring(8, 16);
		case 32:
			return md5String;
		default:
			return md5String;
		}
	}

	public static String MD5(String strSource) {
		return MD5Creater(strSource);
	}

	public static String Password(String password) {
		return MD5(MD5(password) + "." + password + "." + MD5(password));
	}

	/**
	 * 生成MD5加密
	 * 
	 * @param strSource
	 *            待加密字符
	 * @return 加密字符
	 */
	private static String MD5Creater(String strSource) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = strSource.getBytes("UTF-8");
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str).toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String SHA1(String strSource) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
			digest.update(strSource.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 生成签名
	 * 
	 * @param data_json
	 * @return
	 */
	public static String signCreater(String data_json) {
		String sign = MD5(MD5(ConstantProperties.ACCOUNT + MD5(ConstantProperties.KEY)) + data_json + "HX_B2B");
		return sign;
	}

}
