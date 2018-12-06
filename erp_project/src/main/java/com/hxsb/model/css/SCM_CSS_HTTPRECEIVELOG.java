package com.hxsb.model.css;

import java.util.Date;

public class SCM_CSS_HTTPRECEIVELOG {
	private Long id;
	private String module;
	private String method;
	private String datajsonstr;
	private Long responsecode;
	private String responsemsg;
	private Date responsedate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getDatajsonstr() {
		return datajsonstr;
	}
	public void setDatajsonstr(String datajsonstr) {
		this.datajsonstr = datajsonstr;
	}
	public Long getResponsecode() {
		return responsecode;
	}
	public void setResponsecode(Long responsecode) {
		this.responsecode = responsecode;
	}
	public String getResponsemsg() {
		return responsemsg;
	}
	public void setResponsemsg(String responsemsg) {
		this.responsemsg = responsemsg;
	}
	public Date getResponsedate() {
		return responsedate;
	}
	public void setResponsedate(Date responsedate) {
		this.responsedate = responsedate;
	}
	@Override
	public String toString() {
		return "SCM_CSS_HTTPRECEIVELOG [id=" + id + ", module=" + module + ", method=" + method + ", datajsonstr="
				+ datajsonstr + ", responsecode=" + responsecode + ", responsemsg=" + responsemsg + ", responsedate="
				+ responsedate + "]";
	}
}