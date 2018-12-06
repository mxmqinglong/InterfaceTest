package com.hxsb.model.BUY_ERP_GET_REFUND_RECORD;

import java.io.Serializable;
import java.math.BigDecimal;

public class RefundRecordDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1255038100738736420L;
	private BigDecimal amount;
	private Long erp_order_id;
	private Long erp_refund_record_details_id;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Long getErp_order_id() {
		return erp_order_id;
	}
	public void setErp_order_id(Long erp_order_id) {
		this.erp_order_id = erp_order_id;
	}
	public Long getErp_refund_record_details_id() {
		return erp_refund_record_details_id;
	}
	public void setErp_refund_record_details_id(Long erp_refund_record_details_id) {
		this.erp_refund_record_details_id = erp_refund_record_details_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String billid;
	public String getBillid() {
		return billid;
	}
	public void setBillid(String billid) {
		this.billid = billid;
	}
	@Override
	public String toString() {
		return "RefundRecordDetail [amount=" + amount + ", erp_order_id=" + erp_order_id
				+ ", erp_refund_record_details_id=" + erp_refund_record_details_id + ", billid=" + billid + "]";
	}
}
