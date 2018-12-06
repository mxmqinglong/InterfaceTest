package com.hxsb.model.BUY_ERP_ORDER_CREATE;

public class Coupon {
	private String coupon_number;
	private String coupon_name;
	private Double coupon_amount;
	
	public String getCoupon_number() {
		return coupon_number;
	}
	public void setCoupon_number(String coupon_number) {
		this.coupon_number = coupon_number;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public Double getCoupon_amount() {
		return coupon_amount;
	}
	public void setCoupon_amount(Double coupon_amount) {
		this.coupon_amount = coupon_amount;
	}
	@Override
	public String toString() {
		return "Coupon [coupon_number=" + coupon_number + ", coupon_name=" + coupon_name + ", coupon_amount="
				+ coupon_amount + "]";
	}
}
