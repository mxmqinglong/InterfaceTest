package com.hxsb.model.BUY_ERP_GET_REFUND_RECORD;

public class RefundRecord2 {
	private String record_details_id;
	private String payment_serial_number;
	private String refund_serial_number;
	private Double refund_amount;
	private String refund_time;
	public String getRecord_details_id() {
		return record_details_id;
	}
	public void setRecord_details_id(String record_details_id) {
		this.record_details_id = record_details_id;
	}
	public String getPayment_serial_number() {
		return payment_serial_number;
	}
	public void setPayment_serial_number(String payment_serial_number) {
		this.payment_serial_number = payment_serial_number;
	}
	public String getRefund_serial_number() {
		return refund_serial_number;
	}
	public void setRefund_serial_number(String refund_serial_number) {
		this.refund_serial_number = refund_serial_number;
	}
	public Double getRefund_amount() {
		return refund_amount;
	}
	public void setRefund_amount(Double refund_amount) {
		this.refund_amount = refund_amount;
	}
	public String getRefund_time() {
		return refund_time;
	}
	public void setRefund_time(String refund_time) {
		this.refund_time = refund_time;
	}
	@Override
	public String toString() {
		return "RefundRecord2 [record_details_id=" + record_details_id + ", payment_serial_number="
				+ payment_serial_number + ", refund_serial_number=" + refund_serial_number + ", refund_amount="
				+ refund_amount + ", refund_time=" + refund_time + "]";
	}
}
