package com.hxsb.model.BUY_ERP_ORDER_CREATE;

public class SCM_HX50_IntentionList3 {
    private Long billdtlid;

    private Long billid;

    private String dcCouponnumber;

    private String dcCouponname;

    private Double dcCouponamount;


    public Long getBilldtlid() {
		return billdtlid;
	}

	public void setBilldtlid(Long billdtlid) {
		this.billdtlid = billdtlid;
	}

	public Long getBillid() {
		return billid;
	}

	public void setBillid(Long billid) {
		this.billid = billid;
	}

	public String getDcCouponnumber() {
		return dcCouponnumber;
	}

	public void setDcCouponnumber(String dcCouponnumber) {
		this.dcCouponnumber = dcCouponnumber;
	}

	public String getDcCouponname() {
        return dcCouponname;
    }

    public void setDcCouponname(String dcCouponname) {
        this.dcCouponname = dcCouponname == null ? null : dcCouponname.trim();
    }

	public Double getDcCouponamount() {
		return dcCouponamount;
	}

	public void setDcCouponamount(Double dcCouponamount) {
		this.dcCouponamount = dcCouponamount;
	}

	@Override
	public String toString() {
		return "SCM_HX50_IntentionList3 [billdtlid=" + billdtlid + ", billid=" + billid + ", dcCouponnumber="
				+ dcCouponnumber + ", dcCouponname=" + dcCouponname + ", dcCouponamount=" + dcCouponamount + "]";
	}
}