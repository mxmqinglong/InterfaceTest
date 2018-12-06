package com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD;

import java.math.BigDecimal;
import java.util.List;

public class PaymentRecord {
	private BigDecimal erp_payment_record_id;
	private String erp_payment_record_number;
	private String name;
	private String pay_type;
	private String time;
	private List<PaymentRecordDetail> details;
	
	private String ReceiveAccount;
	private String SerialNo;
	
	private BigDecimal total_amount;
	private String payer;
	
	public BigDecimal getErp_payment_record_id() {
		return erp_payment_record_id;
	}
	public void setErp_payment_record_id(BigDecimal erp_payment_record_id) {
		this.erp_payment_record_id = erp_payment_record_id;
	}
	public String getErp_payment_record_number() {
		return erp_payment_record_number;
	}
	public void setErp_payment_record_number(String erp_payment_record_number) {
		this.erp_payment_record_number = erp_payment_record_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<PaymentRecordDetail> getDetails() {
		return details;
	}
	public void setDetails(List<PaymentRecordDetail> details) {
		this.details = details;
	}
	
	public String getReceiveAccount() {
		return ReceiveAccount;
	}
	public void setReceiveAccount(String receiveAccount) {
		ReceiveAccount = receiveAccount;
	}
	public String getSerialNo() {
		return SerialNo;
	}
	public void setSerialNo(String serialNo) {
		SerialNo = serialNo;
	}
	
	public BigDecimal getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	@Override
	public String toString() {
		return "PaymentRecord [erp_payment_record_id=" + erp_payment_record_id + ", erp_payment_record_number="
				+ erp_payment_record_number + ", name=" + name + ", pay_type=" + pay_type + ", time=" + time
				+ ", details=" + details + ", ReceiveAccount=" + ReceiveAccount + ", SerialNo=" + SerialNo
				+ ", total_amount=" + total_amount + ", payer=" + payer + "]";
	}
}
