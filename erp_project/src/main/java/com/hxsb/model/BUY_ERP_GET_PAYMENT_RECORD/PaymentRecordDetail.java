package com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD;

import java.math.BigDecimal;

public class PaymentRecordDetail {
	private BigDecimal amount;
	private BigDecimal erp_order_id;
	private BigDecimal erp_payment_record_details_id;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getErp_order_id() {
		return erp_order_id;
	}

	public void setErp_order_id(BigDecimal erp_order_id) {
		this.erp_order_id = erp_order_id;
	}

	public BigDecimal getErp_payment_record_details_id() {
		return erp_payment_record_details_id;
	}

	public void setErp_payment_record_details_id(BigDecimal erp_payment_record_details_id) {
		this.erp_payment_record_details_id = erp_payment_record_details_id;
	}

	@Override
	public String toString() {
		return "PaymentRecordDetail [amount=" + amount + ", erp_order_id=" + erp_order_id
				+ ", erp_payment_record_details_id=" + erp_payment_record_details_id + "]";
	}
}
