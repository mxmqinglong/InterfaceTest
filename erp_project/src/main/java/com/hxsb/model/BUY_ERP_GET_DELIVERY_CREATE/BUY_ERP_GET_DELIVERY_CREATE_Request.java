package com.hxsb.model.BUY_ERP_GET_DELIVERY_CREATE;

import java.util.List;

public class BUY_ERP_GET_DELIVERY_CREATE_Request {
	private List<Long> erp_order_ids;
	private String delivery_type;
	
	public List<Long> getErp_order_ids() {
		return erp_order_ids;
	}
	public void setErp_order_ids(List<Long> erp_order_ids) {
		this.erp_order_ids = erp_order_ids;
	}
	public String getDelivery_type() {
		return delivery_type;
	}
	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}
	@Override
	public String toString() {
		return "BUY_ERP_GET_DELIVERY_CREATE_Request [erp_order_ids=" + erp_order_ids + ", delivery_type="
				+ delivery_type + "]";
	}
	
	
	
	
	
}
