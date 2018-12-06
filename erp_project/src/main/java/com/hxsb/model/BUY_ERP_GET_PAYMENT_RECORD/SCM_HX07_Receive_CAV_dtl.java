package com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD;

import java.math.BigDecimal;
import java.util.Date;

public class SCM_HX07_Receive_CAV_dtl {
    private Short billdtlid;

    private Short billid;

    private String dtlRoId;

    private String dtlOrder;

    private String dtlProjectname;

    private Short dtlCustomer;

    private String dtl;

    private String dtlSettle;

    private Short dtlPaymenttype;

    private BigDecimal dtlCavAmount;

    private BigDecimal dtlRoid;

    private String dtlProjec;

    private String dtlSettleno;

    private String dtlOrderno;

    private Short dtlSettleid;

    private Short dtlSettledtlid;

    private Short dtlChargetype;

    private String dtlNotes;

    private Date dtlEntrydate;

    private Date dtlClaimdate;

    private Short dtlOverduedays;

    private Short dtlClaimstaff;

    private Short dtlNotbusinesstype;

    public Short getBilldtlid() {
        return billdtlid;
    }

    public void setBilldtlid(Short billdtlid) {
        this.billdtlid = billdtlid;
    }

    public Short getBillid() {
        return billid;
    }

    public void setBillid(Short billid) {
        this.billid = billid;
    }

    public String getDtlRoId() {
        return dtlRoId;
    }

    public void setDtlRoId(String dtlRoId) {
        this.dtlRoId = dtlRoId == null ? null : dtlRoId.trim();
    }

    public String getDtlOrder() {
        return dtlOrder;
    }

    public void setDtlOrder(String dtlOrder) {
        this.dtlOrder = dtlOrder == null ? null : dtlOrder.trim();
    }

    public String getDtlProjectname() {
        return dtlProjectname;
    }

    public void setDtlProjectname(String dtlProjectname) {
        this.dtlProjectname = dtlProjectname == null ? null : dtlProjectname.trim();
    }

    public Short getDtlCustomer() {
        return dtlCustomer;
    }

    public void setDtlCustomer(Short dtlCustomer) {
        this.dtlCustomer = dtlCustomer;
    }

    public String getDtl() {
        return dtl;
    }

    public void setDtl(String dtl) {
        this.dtl = dtl == null ? null : dtl.trim();
    }

    public String getDtlSettle() {
        return dtlSettle;
    }

    public void setDtlSettle(String dtlSettle) {
        this.dtlSettle = dtlSettle == null ? null : dtlSettle.trim();
    }

    public Short getDtlPaymenttype() {
        return dtlPaymenttype;
    }

    public void setDtlPaymenttype(Short dtlPaymenttype) {
        this.dtlPaymenttype = dtlPaymenttype;
    }

    public BigDecimal getDtlCavAmount() {
        return dtlCavAmount;
    }

    public void setDtlCavAmount(BigDecimal dtlCavAmount) {
        this.dtlCavAmount = dtlCavAmount;
    }

    public BigDecimal getDtlRoid() {
        return dtlRoid;
    }

    public void setDtlRoid(BigDecimal dtlRoid) {
        this.dtlRoid = dtlRoid;
    }

    public String getDtlProjec() {
        return dtlProjec;
    }

    public void setDtlProjec(String dtlProjec) {
        this.dtlProjec = dtlProjec == null ? null : dtlProjec.trim();
    }

    public String getDtlSettleno() {
        return dtlSettleno;
    }

    public void setDtlSettleno(String dtlSettleno) {
        this.dtlSettleno = dtlSettleno == null ? null : dtlSettleno.trim();
    }

    public String getDtlOrderno() {
        return dtlOrderno;
    }

    public void setDtlOrderno(String dtlOrderno) {
        this.dtlOrderno = dtlOrderno == null ? null : dtlOrderno.trim();
    }

    public Short getDtlSettleid() {
        return dtlSettleid;
    }

    public void setDtlSettleid(Short dtlSettleid) {
        this.dtlSettleid = dtlSettleid;
    }

    public Short getDtlSettledtlid() {
        return dtlSettledtlid;
    }

    public void setDtlSettledtlid(Short dtlSettledtlid) {
        this.dtlSettledtlid = dtlSettledtlid;
    }

    public Short getDtlChargetype() {
        return dtlChargetype;
    }

    public void setDtlChargetype(Short dtlChargetype) {
        this.dtlChargetype = dtlChargetype;
    }

    public String getDtlNotes() {
        return dtlNotes;
    }

    public void setDtlNotes(String dtlNotes) {
        this.dtlNotes = dtlNotes == null ? null : dtlNotes.trim();
    }

    public Date getDtlEntrydate() {
        return dtlEntrydate;
    }

    public void setDtlEntrydate(Date dtlEntrydate) {
        this.dtlEntrydate = dtlEntrydate;
    }

    public Date getDtlClaimdate() {
        return dtlClaimdate;
    }

    public void setDtlClaimdate(Date dtlClaimdate) {
        this.dtlClaimdate = dtlClaimdate;
    }

    public Short getDtlOverduedays() {
        return dtlOverduedays;
    }

    public void setDtlOverduedays(Short dtlOverduedays) {
        this.dtlOverduedays = dtlOverduedays;
    }

    public Short getDtlClaimstaff() {
        return dtlClaimstaff;
    }

    public void setDtlClaimstaff(Short dtlClaimstaff) {
        this.dtlClaimstaff = dtlClaimstaff;
    }

    public Short getDtlNotbusinesstype() {
        return dtlNotbusinesstype;
    }

    public void setDtlNotbusinesstype(Short dtlNotbusinesstype) {
        this.dtlNotbusinesstype = dtlNotbusinesstype;
    }

	@Override
	public String toString() {
		return "SCM_HX07_Receive_CAV_dtl [billdtlid=" + billdtlid + ", billid=" + billid + ", dtlRoId=" + dtlRoId
				+ ", dtlOrder=" + dtlOrder + ", dtlProjectname=" + dtlProjectname + ", dtlCustomer=" + dtlCustomer
				+ ", dtl=" + dtl + ", dtlSettle=" + dtlSettle + ", dtlPaymenttype=" + dtlPaymenttype + ", dtlCavAmount="
				+ dtlCavAmount + ", dtlRoid=" + dtlRoid + ", dtlProjec=" + dtlProjec + ", dtlSettleno=" + dtlSettleno
				+ ", dtlOrderno=" + dtlOrderno + ", dtlSettleid=" + dtlSettleid + ", dtlSettledtlid=" + dtlSettledtlid
				+ ", dtlChargetype=" + dtlChargetype + ", dtlNotes=" + dtlNotes + ", dtlEntrydate=" + dtlEntrydate
				+ ", dtlClaimdate=" + dtlClaimdate + ", dtlOverduedays=" + dtlOverduedays + ", dtlClaimstaff="
				+ dtlClaimstaff + ", dtlNotbusinesstype=" + dtlNotbusinesstype + "]";
	}
}