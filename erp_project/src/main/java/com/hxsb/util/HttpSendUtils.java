package com.hxsb.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *
 */
public class HttpSendUtils {

//	public static String doPost(String url, Map<String, String> map, String charset) {
//		HttpClient httpClient = null;
//		HttpPost httpPost = null;
//		String result = null;
//		try {
//			httpClient = new SSLClient();
//			httpPost = new HttpPost(url);
//			// 设置参数
//			List<NameValuePair> list = new ArrayList<NameValuePair>();
//			Iterator<?> iterator = map.entrySet().iterator();
//			while (iterator.hasNext()) {
//				Entry<String, String> elem = (Entry<String, String>) iterator.next();
//				list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
//			}
//			if (list.size() > 0) {
//				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
//				httpPost.setEntity(entity);
//			}
//
//			HttpResponse response = httpClient.execute(httpPost);
//			if (response != null) {
//				HttpEntity resEntity = response.getEntity();
//				if (resEntity != null) {
//					result = EntityUtils.toString(resEntity, charset);
//				}
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return result;
//	}
//
//	/**
//	 * Post Json字符串
//	 */
//	public static String doJsonPost(String url, String jsonStr, String charset) {
//
//		HttpClient httpClient = null;
//		HttpPost httpPost = null;
//		String result = null;
//		try {
//			httpClient = HttpClientBuilder.create().build();
//			httpPost = new HttpPost(url);
//			// 设置参数
//			HttpEntity entity = EntityBuilder.create().setContentType(ContentType.APPLICATION_JSON)
//					.setContentEncoding(charset).setText(jsonStr).build();
//			httpPost.setEntity(entity);
//			HttpResponse response = httpClient.execute(httpPost);
//
//			if (response != null) {
//				HttpEntity resEntity = response.getEntity();
//				if (resEntity != null) {
//					result = EntityUtils.toString(resEntity, charset);
//				}
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return result;
//	}
	
	

	@SuppressWarnings("finally")
	public static String checkFormat(HttpServletRequest request, HttpServletResponse response, String jsonData) {
		String msg = null;
		if(null == jsonData){
			return msg;
		}
		String data = jsonData;
		String account = request.getParameter("account");
		String version = request.getParameter("version");
		String method = request.getParameter("method");
		String sign = request.getParameter("sign");
	
		try {
			if (account == null || version == null || method == null || sign == null 
					|| "".equals(account.trim()) || "".equals(version.trim()) 
					|| "".equals(method.trim()) || "".equals(sign.trim())) {
				// 公共错误1002，POST体中的必传项缺失
				msg = "status:1,error_code:1002,error_msg:POST体中的必传项缺失";
			}

			if (!ConstantProperties.Version.equals(version)) {
				// 公共错误1003，接口版本号（version）不正确
				msg = "status:1,error_code:1003,error_msg:接口版本号（version）不正确";
			}

			if (!ConstantProperties.ACCOUNT.equals(account)) {
				// 公共错误1004，传入的接入用户名（account）不存在
				msg = "status:1,error_code:1004,error_msg:传入的接入用户名（account）不存在";
			}

			String signLocal = EncryptUtils.signCreater(data);
			if (!sign.equals(signLocal)) {
				// 公共错误1005，业务参数签名（sign）校验失败
				msg = "status:1,error_code:1005,error_msg:业务参数签名（sign）校验失败";
			}
		} catch (Exception e) {
			// 公共错误1001，程序异常
			msg = "status:1,error_code:1001,error_msg:" + e.getMessage();
		}finally{
			return msg;
		}
		
	}
}