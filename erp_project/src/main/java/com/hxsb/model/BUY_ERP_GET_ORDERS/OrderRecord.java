package com.hxsb.model.BUY_ERP_GET_ORDERS;

import java.math.BigDecimal;
import java.util.List;

public class OrderRecord {
	private Long erp_order_id;
	private String erp_order_number;
	private String project_name;
	private String signatory;
	private String order_status;
	private String create_time;
	private String payment_time_limit;
	private String payment_way;
	private BigDecimal contract_amount;
	private BigDecimal cash_pledge_amount;
	private BigDecimal advance_payment_amount;
	private String city;
	private String enter_arena_logistics;
	private String out_arena_logistics;
	
	private BigDecimal logistics_cost;
	
	private String erp_salesman_number;
	
	
	private String erp_department_name;
	private String erp_shop_name;
	
	
	private List<OrderRecordDetail> details;
	private List<ChangeLog> change_logs;
	private List<Contact> contacts;
	
	
	
	public Long getErp_order_id() {
		return erp_order_id;
	}
	public void setErp_order_id(Long erp_order_id) {
		this.erp_order_id = erp_order_id;
	}
	public String getErp_order_number() {
		return erp_order_number;
	}
	public void setErp_order_number(String erp_order_number) {
		this.erp_order_number = erp_order_number;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getSignatory() {
		return signatory;
	}
	public void setSignatory(String signatory) {
		this.signatory = signatory;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getPayment_time_limit() {
		return payment_time_limit;
	}
	public void setPayment_time_limit(String payment_time_limit) {
		this.payment_time_limit = payment_time_limit;
	}
	public String getPayment_way() {
		return payment_way;
	}
	public void setPayment_way(String payment_way) {
		this.payment_way = payment_way;
	}
	
	public BigDecimal getContract_amount() {
		return contract_amount;
	}
	public void setContract_amount(BigDecimal contract_amount) {
		this.contract_amount = contract_amount;
	}
	
	public BigDecimal getCash_pledge_amount() {
		return cash_pledge_amount;
	}
	public void setCash_pledge_amount(BigDecimal cash_pledge_amount) {
		this.cash_pledge_amount = cash_pledge_amount;
	}
	
	public BigDecimal getAdvance_payment_amount() {
		return advance_payment_amount;
	}
	public void setAdvance_payment_amount(BigDecimal advance_payment_amount) {
		this.advance_payment_amount = advance_payment_amount;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEnter_arena_logistics() {
		return enter_arena_logistics;
	}
	public void setEnter_arena_logistics(String enter_arena_logistics) {
		this.enter_arena_logistics = enter_arena_logistics;
	}
	public String getOut_arena_logistics() {
		return out_arena_logistics;
	}
	public void setOut_arena_logistics(String out_arena_logistics) {
		this.out_arena_logistics = out_arena_logistics;
	}
	
	public BigDecimal getLogistics_cost() {
		return logistics_cost;
	}
	public void setLogistics_cost(BigDecimal logistics_cost) {
		this.logistics_cost = logistics_cost;
	}
	public String getErp_salesman_number() {
		return erp_salesman_number;
	}
	public void setErp_salesman_number(String erp_salesman_number) {
		this.erp_salesman_number = erp_salesman_number;
	}
	public String getErp_department_name() {
		return erp_department_name;
	}
	public void setErp_department_name(String erp_department_name) {
		this.erp_department_name = erp_department_name;
	}
	public String getErp_shop_name() {
		return erp_shop_name;
	}
	public void setErp_shop_name(String erp_shop_name) {
		this.erp_shop_name = erp_shop_name;
	}
	public List<OrderRecordDetail> getDetails() {
		return details;
	}
	public void setDetails(List<OrderRecordDetail> details) {
		this.details = details;
	}
	public List<ChangeLog> getChange_logs() {
		return change_logs;
	}
	public void setChange_logs(List<ChangeLog> change_logs) {
		this.change_logs = change_logs;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	@Override
	public String toString() {
		return "OrderRecord [erp_order_id=" + erp_order_id + ", erp_order_number=" + erp_order_number
				+ ", project_name=" + project_name + ", signatory=" + signatory + ", order_status=" + order_status
				+ ", create_time=" + create_time + ", payment_time_limit=" + payment_time_limit + ", payment_way="
				+ payment_way + ", contract_amount=" + contract_amount + ", cash_pledge_amount=" + cash_pledge_amount
				+ ", advance_payment_amount=" + advance_payment_amount + ", city=" + city + ", enter_arena_logistics="
				+ enter_arena_logistics + ", out_arena_logistics=" + out_arena_logistics + ", logistics_cost="
				+ logistics_cost + ", erp_salesman_number=" + erp_salesman_number + ", erp_department_name="
				+ erp_department_name + ", erp_shop_name=" + erp_shop_name + ", details=" + details + ", change_logs="
				+ change_logs + ", contacts=" + contacts + "]";
	}
}
