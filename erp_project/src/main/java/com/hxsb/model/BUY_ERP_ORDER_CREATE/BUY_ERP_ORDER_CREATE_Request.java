package com.hxsb.model.BUY_ERP_ORDER_CREATE;

import java.util.List;

public class BUY_ERP_ORDER_CREATE_Request {
	private String buy_intention_receipts_number;
	private String erp_bu_number;
	private String erp_shop_number;
	private String erp_salesman_number;
	private String purchasing_agent_name;
	
	private String purchasing_agent_mobile;
	private Double intention_receipts_total_amount;
	private String affirm_time;
	private String delivery_province;
	private String delivery_city;
	
	private String delivery_county;
	private String delivery_address;
	private String delivery_name;
	private String delivery_mobile;
	private Integer invoice_type;
	
	private Integer invoice_title;
	
	
	private String invoice_company_name;
	private String invoice_taxpayer_heading_code;
	private String invoice_opening_bank;
	private String invoice_addr_phoneno;
	private String invoice_bank_account;
	
	private String note;
	private String delivery_way;
	
	private List<Product> product_details;
	private List<Coupon> coupons;
	
	public String getBuy_intention_receipts_number() {
		return buy_intention_receipts_number;
	}
	public void setBuy_intention_receipts_number(String buy_intention_receipts_number) {
		this.buy_intention_receipts_number = buy_intention_receipts_number;
	}
	public String getErp_bu_number() {
		return erp_bu_number;
	}
	public void setErp_bu_number(String erp_bu_number) {
		this.erp_bu_number = erp_bu_number;
	}
	public String getErp_shop_number() {
		return erp_shop_number;
	}
	public void setErp_shop_number(String erp_shop_number) {
		this.erp_shop_number = erp_shop_number;
	}
	public String getErp_salesman_number() {
		return erp_salesman_number;
	}
	public void setErp_salesman_number(String erp_salesman_number) {
		this.erp_salesman_number = erp_salesman_number;
	}
	public String getPurchasing_agent_name() {
		return purchasing_agent_name;
	}
	public void setPurchasing_agent_name(String purchasing_agent_name) {
		this.purchasing_agent_name = purchasing_agent_name;
	}
	public String getPurchasing_agent_mobile() {
		return purchasing_agent_mobile;
	}
	public void setPurchasing_agent_mobile(String purchasing_agent_mobile) {
		this.purchasing_agent_mobile = purchasing_agent_mobile;
	}
	public Double getIntention_receipts_total_amount() {
		return intention_receipts_total_amount;
	}
	public void setIntention_receipts_total_amount(Double intention_receipts_total_amount) {
		this.intention_receipts_total_amount = intention_receipts_total_amount;
	}
	public String getAffirm_time() {
		return affirm_time;
	}
	public void setAffirm_time(String affirm_time) {
		this.affirm_time = affirm_time;
	}
	public String getDelivery_province() {
		return delivery_province;
	}
	public void setDelivery_province(String delivery_province) {
		this.delivery_province = delivery_province;
	}
	public String getDelivery_city() {
		return delivery_city;
	}
	public void setDelivery_city(String delivery_city) {
		this.delivery_city = delivery_city;
	}
	public String getDelivery_county() {
		return delivery_county;
	}
	public void setDelivery_county(String delivery_county) {
		this.delivery_county = delivery_county;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	public String getDelivery_name() {
		return delivery_name;
	}
	public void setDelivery_name(String delivery_name) {
		this.delivery_name = delivery_name;
	}
	public String getDelivery_mobile() {
		return delivery_mobile;
	}
	public void setDelivery_mobile(String delivery_mobile) {
		this.delivery_mobile = delivery_mobile;
	}
	public Integer getInvoice_type() {
		return invoice_type;
	}
	public void setInvoice_type(Integer invoice_type) {
		this.invoice_type = invoice_type;
	}
	
	public Integer getInvoice_title() {
		return invoice_title;
	}
	public void setInvoice_title(Integer invoice_title) {
		this.invoice_title = invoice_title;
	}
	
	public String getInvoice_company_name() {
		return invoice_company_name;
	}
	public void setInvoice_company_name(String invoice_company_name) {
		this.invoice_company_name = invoice_company_name;
	}
	public String getInvoice_taxpayer_heading_code() {
		return invoice_taxpayer_heading_code;
	}
	public void setInvoice_taxpayer_heading_code(String invoice_taxpayer_heading_code) {
		this.invoice_taxpayer_heading_code = invoice_taxpayer_heading_code;
	}
	public String getInvoice_opening_bank() {
		return invoice_opening_bank;
	}
	public void setInvoice_opening_bank(String invoice_opening_bank) {
		this.invoice_opening_bank = invoice_opening_bank;
	}
	public String getInvoice_addr_phoneno() {
		return invoice_addr_phoneno;
	}
	public void setInvoice_addr_phoneno(String invoice_addr_phoneno) {
		this.invoice_addr_phoneno = invoice_addr_phoneno;
	}
	public String getInvoice_bank_account() {
		return invoice_bank_account;
	}
	public void setInvoice_bank_account(String invoice_bank_account) {
		this.invoice_bank_account = invoice_bank_account;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDelivery_way() {
		return delivery_way;
	}
	public void setDelivery_way(String delivery_way) {
		this.delivery_way = delivery_way;
	}
	public List<Product> getProduct_details() {
		return product_details;
	}
	public void setProduct_details(List<Product> product_details) {
		this.product_details = product_details;
	}
	public List<Coupon> getCoupons() {
		return coupons;
	}
	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}
	@Override
	public String toString() {
		return "BUY_ERP_ORDER_CREATE_Request [buy_intention_receipts_number=" + buy_intention_receipts_number
				+ ", erp_bu_number=" + erp_bu_number + ", erp_shop_number=" + erp_shop_number + ", erp_salesman_number="
				+ erp_salesman_number + ", purchasing_agent_name=" + purchasing_agent_name
				+ ", purchasing_agent_mobile=" + purchasing_agent_mobile + ", intention_receipts_total_amount="
				+ intention_receipts_total_amount + ", affirm_time=" + affirm_time + ", delivery_province="
				+ delivery_province + ", delivery_city=" + delivery_city + ", delivery_county=" + delivery_county
				+ ", delivery_address=" + delivery_address + ", delivery_name=" + delivery_name + ", delivery_mobile="
				+ delivery_mobile + ", invoice_type=" + invoice_type + ", invoice_title=" + invoice_title + ", note="
				+ note + ", delivery_way=" + delivery_way + ", product_details=" + product_details + ", coupons="
				+ coupons + "]";
	}
}
