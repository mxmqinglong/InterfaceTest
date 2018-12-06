package com.hxsb.model.BUY_ERP_GET_ORDERS;

import java.util.Date;

public class SCM_CSS_HttpSendOrderLog {
    private Long billid;

    private String methods;

    private Date logdate;

    private Long ispushenterexit;

    public Long getBillid() {
        return billid;
    }

    public void setBillid(Long billid) {
        this.billid = billid;
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods == null ? null : methods.trim();
    }

    public Date getLogdate() {
        return logdate;
    }

    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }

    public Long getIspushenterexit() {
        return ispushenterexit;
    }

    public void setIspushenterexit(Long ispushenterexit) {
        this.ispushenterexit = ispushenterexit;
    }

	@Override
	public String toString() {
		return "SCM_CSS_HttpSendOrderLog [billid=" + billid + ", methods=" + methods + ", logdate=" + logdate
				+ ", ispushenterexit=" + ispushenterexit + "]";
	}
}