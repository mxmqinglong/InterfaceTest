package com.hxsb.model.BUY_ERP_REFUND_CONFIRM;

import java.util.Date;

public class SCM_CSS_HttpSendLog {
	private Long id;
	private String billkey;
	private String unique;
	private String method;
	private String datajsonstr;
	private Integer responsecode;
	private String msg;
	private Date responsedate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBillkey() {
		return billkey;
	}
	public void setBillkey(String billkey) {
		this.billkey = billkey;
	}
	public String getUnique() {
		return unique;
	}
	public void setUnique(String unique) {
		this.unique = unique;
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
	public Integer getResponsecode() {
		return responsecode;
	}
	public void setResponsecode(Integer responsecode) {
		this.responsecode = responsecode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getResponsedate() {
		return responsedate;
	}
	public void setResponsedate(Date responsedate) {
		this.responsedate = responsedate;
	}
	@Override
	public String toString() {
		return "SCM_CSS_HttpSendLog [id=" + id + ", billkey=" + billkey + ", unique=" + unique + ", method=" + method
				+ ", datajsonstr=" + datajsonstr + ", responsecode=" + responsecode + ", msg=" + msg + ", responsedate="
				+ responsedate + "]";
	}
}