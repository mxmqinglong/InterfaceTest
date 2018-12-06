package com.hxsb.model.BUY_ERP_GET_ORDERS;

public class SCM_HX03_ROContactNew {
    private Short billdtlid;

    private Short billid;

    private Short xuhao;

    private String contacttype;

    private Short roletype;

    private String contactname;

    private String contactmobile;

    private String doctype;

    private String idcard;

    private String idcardfront;

    private String idcardback;

    private String frontno;

    private String backno;

    private String expirydate;

    private Short ismate;

    private String backnoCopy;

    private String backurlno;

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

    public Short getXuhao() {
        return xuhao;
    }

    public void setXuhao(Short xuhao) {
        this.xuhao = xuhao;
    }

    public String getContacttype() {
        return contacttype;
    }

    public void setContacttype(String contacttype) {
        this.contacttype = contacttype == null ? null : contacttype.trim();
    }

    public Short getRoletype() {
        return roletype;
    }

    public void setRoletype(Short roletype) {
        this.roletype = roletype;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname == null ? null : contactname.trim();
    }

    public String getContactmobile() {
        return contactmobile;
    }

    public void setContactmobile(String contactmobile) {
        this.contactmobile = contactmobile == null ? null : contactmobile.trim();
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype == null ? null : doctype.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getIdcardfront() {
        return idcardfront;
    }

    public void setIdcardfront(String idcardfront) {
        this.idcardfront = idcardfront == null ? null : idcardfront.trim();
    }

    public String getIdcardback() {
        return idcardback;
    }

    public void setIdcardback(String idcardback) {
        this.idcardback = idcardback == null ? null : idcardback.trim();
    }

    public String getFrontno() {
        return frontno;
    }

    public void setFrontno(String frontno) {
        this.frontno = frontno == null ? null : frontno.trim();
    }

    public String getBackno() {
        return backno;
    }

    public void setBackno(String backno) {
        this.backno = backno == null ? null : backno.trim();
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate == null ? null : expirydate.trim();
    }

    public Short getIsmate() {
        return ismate;
    }

    public void setIsmate(Short ismate) {
        this.ismate = ismate;
    }

    public String getBacknoCopy() {
        return backnoCopy;
    }

    public void setBacknoCopy(String backnoCopy) {
        this.backnoCopy = backnoCopy == null ? null : backnoCopy.trim();
    }

    public String getBackurlno() {
        return backurlno;
    }

    public void setBackurlno(String backurlno) {
        this.backurlno = backurlno == null ? null : backurlno.trim();
    }

	@Override
	public String toString() {
		return "SCM_HX03_ROContactNew [billdtlid=" + billdtlid + ", billid=" + billid + ", xuhao=" + xuhao
				+ ", contacttype=" + contacttype + ", roletype=" + roletype + ", contactname=" + contactname
				+ ", contactmobile=" + contactmobile + ", doctype=" + doctype + ", idcard=" + idcard + ", idcardfront="
				+ idcardfront + ", idcardback=" + idcardback + ", frontno=" + frontno + ", backno=" + backno
				+ ", expirydate=" + expirydate + ", ismate=" + ismate + ", backnoCopy=" + backnoCopy + ", backurlno="
				+ backurlno + "]";
	}
}