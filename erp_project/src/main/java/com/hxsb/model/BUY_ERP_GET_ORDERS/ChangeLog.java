package com.hxsb.model.BUY_ERP_GET_ORDERS;

public class ChangeLog {
	private String erp_change_number;
	private String change_description;

	public String getErp_change_number() {
		return erp_change_number;
	}

	public void setErp_change_number(String erp_change_number) {
		this.erp_change_number = erp_change_number;
	}

	public String getChange_description() {
		return change_description;
	}

	public void setChange_description(String change_description) {
		this.change_description = change_description;
	}

	@Override
	public String toString() {
		return "ChangeLog [erp_change_number=" + erp_change_number + ", change_description=" + change_description + "]";
	}
}
