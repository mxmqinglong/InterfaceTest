package com.hxsb.model.BUY_ERP_GET_DELIVERY_CREATE;

import java.util.List;

public class ReceiptRecord {
	private Long erp_delivery_id;
	private Long erp_order_id;
	private String erp_delivery_number;
	private String delivery_type;
	private String delivery_man_name;
	private List<ReceiptRecordDetail> details;
	
	public Long getErp_delivery_id() {
		return erp_delivery_id;
	}
	public void setErp_delivery_id(Long erp_delivery_id) {
		this.erp_delivery_id = erp_delivery_id;
	}
	public Long getErp_order_id() {
		return erp_order_id;
	}
	public void setErp_order_id(Long erp_order_id) {
		this.erp_order_id = erp_order_id;
	}
	public String getErp_delivery_number() {
		return erp_delivery_number;
	}
	public void setErp_delivery_number(String erp_delivery_number) {
		this.erp_delivery_number = erp_delivery_number;
	}
	public String getDelivery_type() {
		return delivery_type;
	}
	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}
	public String getDelivery_man_name() {
		return delivery_man_name;
	}
	public void setDelivery_man_name(String delivery_man_name) {
		this.delivery_man_name = delivery_man_name;
	}
	public List<ReceiptRecordDetail> getDetails() {
		return details;
	}
	public void setDetails(List<ReceiptRecordDetail> details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "ReceiptRecord [erp_delivery_id=" + erp_delivery_id + ", erp_order_id=" + erp_order_id
				+ ", erp_delivery_number=" + erp_delivery_number + ", delivery_type=" + delivery_type
				+ ", delivery_man_name=" + delivery_man_name + ", details=" + details + "]";
	}
	
}
