package com.hxsb.model.BUY_ERP_GET_REFUND_RECORD;

import java.util.Date;

public class SCM_HX07_Refundment2 {
	private Long billdtlid;
	
	private Long billid;
	
	private Integer dtlRefundstatus;
	
	private Date dtlRefundtime;
	
	private String dtlRefserialno;

	public Long getBilldtlid() {
		return billdtlid;
	}

	public void setBilldtlid(Long billdtlid) {
		this.billdtlid = billdtlid;
	}

	
	public Long getBillid() {
		return billid;
	}

	public void setBillid(Long billid) {
		this.billid = billid;
	}

	public Integer getDtlRefundstatus() {
		return dtlRefundstatus;
	}

	public void setDtlRefundstatus(Integer dtlRefundstatus) {
		this.dtlRefundstatus = dtlRefundstatus;
	}
	

	public Date getDtlRefundtime() {
		return dtlRefundtime;
	}

	public void setDtlRefundtime(Date dtlRefundtime) {
		this.dtlRefundtime = dtlRefundtime;
	}

	public String getDtlRefserialno() {
		return dtlRefserialno;
	}

	public void setDtlRefserialno(String dtlRefserialno) {
		this.dtlRefserialno = dtlRefserialno;
	}

	@Override
	public String toString() {
		return "SCM_HX07_Refundment2 [billdtlid=" + billdtlid + ", billid=" + billid + ", dtlRefundstatus="
				+ dtlRefundstatus + ", dtlRefundtime=" + dtlRefundtime + ", dtlRefserialno=" + dtlRefserialno + "]";
	}
}