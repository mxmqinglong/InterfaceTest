package com.hxsb.model.BUY_ERP_GET_ORDERS;

public class Contact {
	private String contact_role;
	private String name;
	private String id_card_number;
	private String mobile_number;

	public String getContact_role() {
		return contact_role;
	}

	public void setContact_role(String contact_role) {
		this.contact_role = contact_role;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId_card_number() {
		return id_card_number;
	}

	public void setId_card_number(String id_card_number) {
		this.id_card_number = id_card_number;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	@Override
	public String toString() {
		return "Contact [contact_role=" + contact_role + ", name=" + name + ", id_card_number=" + id_card_number
				+ ", mobile_number=" + mobile_number + "]";
	}
}
