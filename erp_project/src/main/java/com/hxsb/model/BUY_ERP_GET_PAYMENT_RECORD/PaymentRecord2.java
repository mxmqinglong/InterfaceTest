package com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD;

public class PaymentRecord2 {
	private String payment_serial_number;
	private Double topup_amount;
	private String buy_user_id;
	private String user_name;
	private String user_mobile;
	private String pay_time;
	private String pay_way;
	public String getPayment_serial_number() {
		return payment_serial_number;
	}
	public void setPayment_serial_number(String payment_serial_number) {
		this.payment_serial_number = payment_serial_number;
	}
	public Double getTopup_amount() {
		return topup_amount;
	}
	public void setTopup_amount(Double topup_amount) {
		this.topup_amount = topup_amount;
	}
	public String getBuy_user_id() {
		return buy_user_id;
	}
	public void setBuy_user_id(String buy_user_id) {
		this.buy_user_id = buy_user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_mobile() {
		return user_mobile;
	}
	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}
	public String getPay_time() {
		return pay_time;
	}
	public void setPay_time(String pay_time) {
		this.pay_time = pay_time;
	}
	public String getPay_way() {
		return pay_way;
	}
	public void setPay_way(String pay_way) {
		this.pay_way = pay_way;
	}
	@Override
	public String toString() {
		return "PaymentRecord2 [payment_serial_number=" + payment_serial_number + ", topup_amount=" + topup_amount
				+ ", buy_user_id=" + buy_user_id + ", user_name=" + user_name + ", user_mobile=" + user_mobile
				+ ", pay_time=" + pay_time + ", pay_way=" + pay_way + "]";
	}
}
