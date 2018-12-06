package com.hxsb.model.BUY_ERP_ORDER_CREATE;

import java.util.Date;

public class SCM_HX50_IntentionList2 {
	
	
    private Long billdtlid;

    private Long billid;

    private Long dtlProductnumber;

    private Date dtlEntertime;

    private Double dtlTenancy;

    private String dtlTenancyunit;

    private Double dtlLeaseprice;

    private Integer dtlQuantity;

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


    public Long getDtlProductnumber() {
		return dtlProductnumber;
	}

	public void setDtlProductnumber(Long dtlProductnumber) {
		this.dtlProductnumber = dtlProductnumber;
	}

	public Date getDtlEntertime() {
        return dtlEntertime;
    }

    public void setDtlEntertime(Date dtlEntertime) {
        this.dtlEntertime = dtlEntertime;
    }


    public Double getDtlTenancy() {
		return dtlTenancy;
	}

	public void setDtlTenancy(Double dtlTenancy) {
		this.dtlTenancy = dtlTenancy;
	}

	public String getDtlTenancyunit() {
        return dtlTenancyunit;
    }

    public void setDtlTenancyunit(String dtlTenancyunit) {
        this.dtlTenancyunit = dtlTenancyunit == null ? null : dtlTenancyunit.trim();
    }

    public Double getDtlLeaseprice() {
		return dtlLeaseprice;
	}

	public void setDtlLeaseprice(Double dtlLeaseprice) {
		this.dtlLeaseprice = dtlLeaseprice;
	}

	public Integer getDtlQuantity() {
		return dtlQuantity;
	}

	public void setDtlQuantity(Integer dtlQuantity) {
		this.dtlQuantity = dtlQuantity;
	}

	@Override
	public String toString() {
		return "SCM_HX50_IntentionList2 [billdtlid=" + billdtlid + ", billid=" + billid + ", dtlProductnumber="
				+ dtlProductnumber + ", dtlEntertime=" + dtlEntertime + ", dtlTenancy=" + dtlTenancy
				+ ", dtlTenancyunit=" + dtlTenancyunit + ", dtlLeaseprice=" + dtlLeaseprice + ", dtlQuantity="
				+ dtlQuantity + "]";
	}
}