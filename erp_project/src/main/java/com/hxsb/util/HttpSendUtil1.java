package com.hxsb.util;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *
 */
public class HttpSendUtil1 {

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
	
	public static Map sendInfo(String url, Map<String, String> map, RefParameter<String> rstMSG){
        int responseCode = -1;
        Date beginDate=new Date();
        Date endDate=null;
		try{
	    	// 创建SSLContext对象，并使用我们指定的信任管理器初始化  
//	        SSLContext sc = SSLContext.getInstance("TLSv1");
//	        TrustManager[] tmArr={new X509TrustManager(){
//	            @Override
//	            public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate,String paramString) throws CertificateException{}
//	            @Override
//	            public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate,String paramString) throws CertificateException {}
//	            @Override
//	            public X509Certificate[] getAcceptedIssuers() {return null;}
//	        }};
//	        sc.init(null, tmArr, new SecureRandom());
//	        SSLSocketFactory ssf = sc.getSocketFactory();  
//	        
//	    	String APP_PUSH_SERVER = System.getProperty("APP_PUSH_HttpsSERVER");
//	    	if(null == APP_PUSH_SERVER || APP_PUSH_SERVER.trim().length()==0){
//	    		APP_PUSH_SERVER = System.getenv("APP_PUSH_HttpsSERVER");
//	    	}
	    	URL myURL = new URL(url);
	        // 创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
	    	HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();   
//	        conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
//	        conn.setSSLSocketFactory(ssf);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");        
	        conn.setDoOutput(true);
	        conn.connect();
	        DataOutputStream out = new DataOutputStream(conn.getOutputStream());        
	        String content = "";
	        Iterator<?> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> elem = (Entry<String, String>) iterator.next();
				content +="&"+ elem.getKey() +"="+URLEncoder.encode(elem.getValue(), "UTF-8");
			}
	        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
	        out.writeBytes(content.substring(1));
	        out.flush();
	        out.close(); 
	        // 刷新、关闭
	        beginDate = new Date();
	        responseCode = conn.getResponseCode();
            if (responseCode == 200) {
            	InputStream inputStream = conn.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer rstBuffer = new StringBuffer();
                String str = null;
                while ((str = bufferedReader.readLine()) != null) {
                	rstBuffer.append(str);
                }
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
                inputStream = null;
                conn.disconnect();
                rstMSG.setValue(rstBuffer.toString());
            }
		} catch (Exception e) { 
			rstMSG.setValue(e.getMessage());
			endDate=new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		endDate =new Date();
		Map rsCell =new HashMap();
		rsCell.put("responseCode", String.valueOf(responseCode));
		rsCell.put("beginDate", sdf.format(beginDate));
		rsCell.put("endDate", sdf.format(endDate));
		return rsCell;
    }

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
