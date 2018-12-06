package com.hxsb.model.BUY_ERP_ORDER_CREATE;

public class Product {
	private String  product_erp_number;
	private String  predict_enter_arena_time;
	private Double  tenancy;
	private String  tenancy_unit;
	private Double  lease_price;
	private Integer  quantity;
	public String getProduct_erp_number() {
		return product_erp_number;
	}
	public void setProduct_erp_number(String product_erp_number) {
		this.product_erp_number = product_erp_number;
	}
	public String getPredict_enter_arena_time() {
		return predict_enter_arena_time;
	}
	public void setPredict_enter_arena_time(String predict_enter_arena_time) {
		this.predict_enter_arena_time = predict_enter_arena_time;
	}
	public Double getTenancy() {
		return tenancy;
	}
	public void setTenancy(Double tenancy) {
		this.tenancy = tenancy;
	}
	public String getTenancy_unit() {
		return tenancy_unit;
	}
	public void setTenancy_unit(String tenancy_unit) {
		this.tenancy_unit = tenancy_unit;
	}
	public Double getLease_price() {
		return lease_price;
	}
	public void setLease_price(Double lease_price) {
		this.lease_price = lease_price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [product_erp_number=" + product_erp_number + ", predict_enter_arena_time="
				+ predict_enter_arena_time + ", tenancy=" + tenancy + ", tenancy_unit=" + tenancy_unit
				+ ", lease_price=" + lease_price + ", quantity=" + quantity + "]";
	}
}
