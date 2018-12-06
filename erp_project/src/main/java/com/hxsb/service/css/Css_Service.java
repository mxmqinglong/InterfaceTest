package com.hxsb.service.css;

import com.hxsb.model.css.SCM_CSS_HTTPRECEIVELOG;

public interface Css_Service {  
	//记录请求日志
	public void insertHttpReceiveLog(SCM_CSS_HTTPRECEIVELOG bean);
	//获取NO
	String getNO(String strObjName);
}  