package com.hxsb.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hxsb.util.ConstantProperties;
import com.hxsb.util.EncryptUtils;
import com.hxsb.util.HttpSendUtils;

/**
 * 拦截器，用于阻止未授权用户访问系统
 *
 * @author yehaomiao
 * @create 2018 -06-25 14:11
 */
public class RequestInterceptor implements HandlerInterceptor {
    /**
     * 前置拦截方法，拦截请求。未登录用户会被强制重定向到登录页面
     *
     * @param httpServletRequest  当前请求的HttpServletRequest对象，用来获取请求信息
     * @param httpServletResponse 当前请求的HttpServletResponse对象，用来进行页面重定向操作
     * @param o                   被拦截的方法的基本信息
     * @return 用户登录则拦截器放行，否则返回false并重定向到登录界面
     * @throws Exception 遇到异常则抛出
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        /*EdiUser loginUser = (EdiUser) httpServletRequest.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            return true;
        } else {
            httpServletResponse.sendRedirect("/edi/login");
            return false;
        }*/
    	
    	//System.out.println(httpServletRequest.getRequestURL());
    	
    	
    	
    	// 分析请求参数
    	String jsonData = httpServletRequest.getParameter("data");
    	// 检查有效性
    	String checkResult = HttpSendUtils.checkFormat(httpServletRequest, null, jsonData);
    	// 没有有报错信息表示检查未通过
    	if (null != checkResult){
    	    // 返回错误信息
    	    return false;
    	}
    	
    	/*RequestDispatcher dis=httpServletRequest.getRequestDispatcher("/order/BUY_ERP_GET_ORDERS");
    	dis.forward(httpServletRequest,httpServletResponse);*/
    	
    	//httpServletResponse.sendRedirect("/refund/BUY_ERP_GET_REFUND_RECORD"); 
    	return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
    
    
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

