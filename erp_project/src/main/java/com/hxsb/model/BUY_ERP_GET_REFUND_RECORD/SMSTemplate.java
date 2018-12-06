package com.hxsb.model.BUY_ERP_GET_REFUND_RECORD;

public class SMSTemplate {
	private String Mobile;
	private Double Amount;
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}
	@Override
	public String toString() {
		return "SMSTemplate [Mobile=" + Mobile + ", Amount=" + Amount + "]";
	}
}
