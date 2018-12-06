package com.hxsb.model.BUY_ERP_GET_REFUND_RECORD;

import java.math.BigDecimal;
import java.util.List;

public class RefundRecord {
	private BigDecimal amount;
	private Long erp_refund_record_id;
	private String erp_refund_record_number;
	private String name;
	private String time;
	private List<RefundRecordDetail> details;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public Long getErp_refund_record_id() {
		return erp_refund_record_id;
	}
	public void setErp_refund_record_id(Long erp_refund_record_id) {
		this.erp_refund_record_id = erp_refund_record_id;
	}
	public String getErp_refund_record_number() {
		return erp_refund_record_number;
	}
	public void setErp_refund_record_number(String erp_refund_record_number) {
		this.erp_refund_record_number = erp_refund_record_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<RefundRecordDetail> getDetails() {
		return details;
	}
	public void setDetails(List<RefundRecordDetail> details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "RefundRecord [amount=" + amount + ", erp_refund_record_id=" + erp_refund_record_id
				+ ", erp_refund_record_number=" + erp_refund_record_number + ", name=" + name + ", time=" + time
				+ ", details=" + details + "]";
	}
}
