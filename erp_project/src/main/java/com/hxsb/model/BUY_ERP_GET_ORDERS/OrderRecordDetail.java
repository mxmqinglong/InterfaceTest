package com.hxsb.model.BUY_ERP_GET_ORDERS;

import java.math.BigDecimal;

public class OrderRecordDetail {
	private String product_erp_number;
	private String name;
	private Integer quantity;
	private BigDecimal lease_price;
	private BigDecimal tenancy;
	private String tenancy_unit;
	private String model;
	private String predict_enter_arena_time;
	private String additional_provisions;

	public String getProduct_erp_number() {
		return product_erp_number;
	}

	public void setProduct_erp_number(String product_erp_number) {
		this.product_erp_number = product_erp_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getLease_price() {
		return lease_price;
	}

	public void setLease_price(BigDecimal lease_price) {
		this.lease_price = lease_price;
	}

	public BigDecimal getTenancy() {
		return tenancy;
	}

	public void setTenancy(BigDecimal tenancy) {
		this.tenancy = tenancy;
	}

	public String getTenancy_unit() {
		return tenancy_unit;
	}

	public void setTenancy_unit(String tenancy_unit) {
		this.tenancy_unit = tenancy_unit;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPredict_enter_arena_time() {
		return predict_enter_arena_time;
	}

	public void setPredict_enter_arena_time(String predict_enter_arena_time) {
		this.predict_enter_arena_time = predict_enter_arena_time;
	}

	public String getAdditional_provisions() {
		return additional_provisions;
	}

	public void setAdditional_provisions(String additional_provisions) {
		this.additional_provisions = additional_provisions;
	}

	@Override
	public String toString() {
		return "OrderRecordDetail [product_erp_number=" + product_erp_number + ", name=" + name + ", quantity="
				+ quantity + ", lease_price=" + lease_price + ", tenancy=" + tenancy + ", tenancy_unit=" + tenancy_unit
				+ ", model=" + model + ", predict_enter_arena_time=" + predict_enter_arena_time
				+ ", additional_provisions=" + additional_provisions + "]";
	}
}
