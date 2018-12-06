package com.hxsb.model.BUY_ERP_GET_DELIVERY_CREATE;

public class ReceiptRecordDetail {
	private String product_erp_number;
	private String facility_erp_number;
	private String machine_number;
	private String name;
	private String model;
	private String time;
	public String getProduct_erp_number() {
		return product_erp_number;
	}
	public void setProduct_erp_number(String product_erp_number) {
		this.product_erp_number = product_erp_number;
	}
	public String getFacility_erp_number() {
		return facility_erp_number;
	}
	public void setFacility_erp_number(String facility_erp_number) {
		this.facility_erp_number = facility_erp_number;
	}
	public String getMachine_number() {
		return machine_number;
	}
	public void setMachine_number(String machine_number) {
		this.machine_number = machine_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "ReceiptRecordDetail [product_erp_number=" + product_erp_number + ", facility_erp_number="
				+ facility_erp_number + ", machine_number=" + machine_number + ", name=" + name + ", model=" + model
				+ ", time=" + time + "]";
	}
	
	
	
	
	
}
