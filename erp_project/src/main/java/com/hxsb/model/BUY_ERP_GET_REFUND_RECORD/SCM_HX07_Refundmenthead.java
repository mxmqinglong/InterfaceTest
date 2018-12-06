package com.hxsb.model.BUY_ERP_GET_REFUND_RECORD;

import java.util.Date;
import java.util.List;

public class SCM_HX07_Refundmenthead {
    private Long billid;
    
    private String receiveacount;
    
    private Date receivedate;
    
    private List<SCM_HX07_Refundment2> details;

	public Long getBillid() {
		return billid;
	}

	public void setBillid(Long billid) {
		this.billid = billid;
	}

	public String getReceiveacount() {
		return receiveacount;
	}

	public void setReceiveacount(String receiveacount) {
		this.receiveacount = receiveacount;
	}


	public Date getReceivedate() {
		return receivedate;
	}

	public void setReceivedate(Date receivedate) {
		this.receivedate = receivedate;
	}

	public List<SCM_HX07_Refundment2> getDetails() {
		return details;
	}

	public void setDetails(List<SCM_HX07_Refundment2> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "SCM_HX07_Refundmenthead [billid=" + billid + ", receiveacount=" + receiveacount + ", receivedate="
				+ receivedate + ", details=" + details + "]";
	}
    
	
    

    /*private Short sequence;

    private String month;

    private String no;

    private Date billdate;

    private Short status;

    private Short rentingCustCond;

    private Short billtype;

    private Short corpid;

    private Short maker;

    private Short mender;

    private Short checker;

    private Date makedate;

    private Date editdate;

    private Date checkdatetime;

    private Short bizUnit;

    private Short bizArea;

    private Short shop;

    private Short rentingCust;

    private String billtitle;

    private String billdescr;

    private Short bizShop;

    private Short isnomalrefund;

    private String note;

    private BigDecimal amount;

    private String ztext;

    private String receiveacount;

    private String serialno;

    private Date receivedate;

    private Short voucherversion;

    private Short bizCompany;

    private String year;

    private String sapNo;

    private String sapNoPrefab;

    private String saperror;

    private String sapMsgNo;

    private Date bluebilldate;

    private String sapNoBack;

    private String sapMsgNoBack;

    private Date redbilldate;

    private String saperrorBack;

    private Short voucherparentbillid;

    private Short isfinancered;

    private String financeredreason;

    private Short financeredmarker;

    private Date financereddate;

    private String receivebank;

    private String receivepayer;

    private Short paystatus;

    private String customerreceiveacount;

    private String rentingCustnmae;

    private BigDecimal clientid;

    private Short payway;

    private String memberid;

    private String membername;

    private Short refundstatus;

    private String membertel;

    private Date refundtime;


    public Long getBillid() {
		return billid;
	}

	public void setBillid(Long billid) {
		this.billid = billid;
	}

	public Short getSequence() {
        return sequence;
    }

    public void setSequence(Short sequence) {
        this.sequence = sequence;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getRentingCustCond() {
        return rentingCustCond;
    }

    public void setRentingCustCond(Short rentingCustCond) {
        this.rentingCustCond = rentingCustCond;
    }

    public Short getBilltype() {
        return billtype;
    }

    public void setBilltype(Short billtype) {
        this.billtype = billtype;
    }

    public Short getCorpid() {
        return corpid;
    }

    public void setCorpid(Short corpid) {
        this.corpid = corpid;
    }

    public Short getMaker() {
        return maker;
    }

    public void setMaker(Short maker) {
        this.maker = maker;
    }

    public Short getMender() {
        return mender;
    }

    public void setMender(Short mender) {
        this.mender = mender;
    }

    public Short getChecker() {
        return checker;
    }

    public void setChecker(Short checker) {
        this.checker = checker;
    }

    public Date getMakedate() {
        return makedate;
    }

    public void setMakedate(Date makedate) {
        this.makedate = makedate;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public Date getCheckdatetime() {
        return checkdatetime;
    }

    public void setCheckdatetime(Date checkdatetime) {
        this.checkdatetime = checkdatetime;
    }

    public Short getBizUnit() {
        return bizUnit;
    }

    public void setBizUnit(Short bizUnit) {
        this.bizUnit = bizUnit;
    }

    public Short getBizArea() {
        return bizArea;
    }

    public void setBizArea(Short bizArea) {
        this.bizArea = bizArea;
    }

    public Short getShop() {
        return shop;
    }

    public void setShop(Short shop) {
        this.shop = shop;
    }

    public Short getRentingCust() {
        return rentingCust;
    }

    public void setRentingCust(Short rentingCust) {
        this.rentingCust = rentingCust;
    }

    public String getBilltitle() {
        return billtitle;
    }

    public void setBilltitle(String billtitle) {
        this.billtitle = billtitle == null ? null : billtitle.trim();
    }

    public String getBilldescr() {
        return billdescr;
    }

    public void setBilldescr(String billdescr) {
        this.billdescr = billdescr == null ? null : billdescr.trim();
    }

    public Short getBizShop() {
        return bizShop;
    }

    public void setBizShop(Short bizShop) {
        this.bizShop = bizShop;
    }

    public Short getIsnomalrefund() {
        return isnomalrefund;
    }

    public void setIsnomalrefund(Short isnomalrefund) {
        this.isnomalrefund = isnomalrefund;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getZtext() {
        return ztext;
    }

    public void setZtext(String ztext) {
        this.ztext = ztext == null ? null : ztext.trim();
    }

    public String getReceiveacount() {
        return receiveacount;
    }

    public void setReceiveacount(String receiveacount) {
        this.receiveacount = receiveacount == null ? null : receiveacount.trim();
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

    public Date getReceivedate() {
        return receivedate;
    }

    public void setReceivedate(Date receivedate) {
        this.receivedate = receivedate;
    }

    public Short getVoucherversion() {
        return voucherversion;
    }

    public void setVoucherversion(Short voucherversion) {
        this.voucherversion = voucherversion;
    }

    public Short getBizCompany() {
        return bizCompany;
    }

    public void setBizCompany(Short bizCompany) {
        this.bizCompany = bizCompany;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getSapNo() {
        return sapNo;
    }

    public void setSapNo(String sapNo) {
        this.sapNo = sapNo == null ? null : sapNo.trim();
    }

    public String getSapNoPrefab() {
        return sapNoPrefab;
    }

    public void setSapNoPrefab(String sapNoPrefab) {
        this.sapNoPrefab = sapNoPrefab == null ? null : sapNoPrefab.trim();
    }

    public String getSaperror() {
        return saperror;
    }

    public void setSaperror(String saperror) {
        this.saperror = saperror == null ? null : saperror.trim();
    }

    public String getSapMsgNo() {
        return sapMsgNo;
    }

    public void setSapMsgNo(String sapMsgNo) {
        this.sapMsgNo = sapMsgNo == null ? null : sapMsgNo.trim();
    }

    public Date getBluebilldate() {
        return bluebilldate;
    }

    public void setBluebilldate(Date bluebilldate) {
        this.bluebilldate = bluebilldate;
    }

    public String getSapNoBack() {
        return sapNoBack;
    }

    public void setSapNoBack(String sapNoBack) {
        this.sapNoBack = sapNoBack == null ? null : sapNoBack.trim();
    }

    public String getSapMsgNoBack() {
        return sapMsgNoBack;
    }

    public void setSapMsgNoBack(String sapMsgNoBack) {
        this.sapMsgNoBack = sapMsgNoBack == null ? null : sapMsgNoBack.trim();
    }

    public Date getRedbilldate() {
        return redbilldate;
    }

    public void setRedbilldate(Date redbilldate) {
        this.redbilldate = redbilldate;
    }

    public String getSaperrorBack() {
        return saperrorBack;
    }

    public void setSaperrorBack(String saperrorBack) {
        this.saperrorBack = saperrorBack == null ? null : saperrorBack.trim();
    }

    public Short getVoucherparentbillid() {
        return voucherparentbillid;
    }

    public void setVoucherparentbillid(Short voucherparentbillid) {
        this.voucherparentbillid = voucherparentbillid;
    }

    public Short getIsfinancered() {
        return isfinancered;
    }

    public void setIsfinancered(Short isfinancered) {
        this.isfinancered = isfinancered;
    }

    public String getFinanceredreason() {
        return financeredreason;
    }

    public void setFinanceredreason(String financeredreason) {
        this.financeredreason = financeredreason == null ? null : financeredreason.trim();
    }

    public Short getFinanceredmarker() {
        return financeredmarker;
    }

    public void setFinanceredmarker(Short financeredmarker) {
        this.financeredmarker = financeredmarker;
    }

    public Date getFinancereddate() {
        return financereddate;
    }

    public void setFinancereddate(Date financereddate) {
        this.financereddate = financereddate;
    }

    public String getReceivebank() {
        return receivebank;
    }

    public void setReceivebank(String receivebank) {
        this.receivebank = receivebank == null ? null : receivebank.trim();
    }

    public String getReceivepayer() {
        return receivepayer;
    }

    public void setReceivepayer(String receivepayer) {
        this.receivepayer = receivepayer == null ? null : receivepayer.trim();
    }

    public Short getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Short paystatus) {
        this.paystatus = paystatus;
    }

    public String getCustomerreceiveacount() {
        return customerreceiveacount;
    }

    public void setCustomerreceiveacount(String customerreceiveacount) {
        this.customerreceiveacount = customerreceiveacount == null ? null : customerreceiveacount.trim();
    }

    public String getRentingCustnmae() {
        return rentingCustnmae;
    }

    public void setRentingCustnmae(String rentingCustnmae) {
        this.rentingCustnmae = rentingCustnmae == null ? null : rentingCustnmae.trim();
    }

    public BigDecimal getClientid() {
        return clientid;
    }

    public void setClientid(BigDecimal clientid) {
        this.clientid = clientid;
    }

    public Short getPayway() {
        return payway;
    }

    public void setPayway(Short payway) {
        this.payway = payway;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername == null ? null : membername.trim();
    }

    public Short getRefundstatus() {
        return refundstatus;
    }

    public void setRefundstatus(Short refundstatus) {
        this.refundstatus = refundstatus;
    }

    public String getMembertel() {
        return membertel;
    }

    public void setMembertel(String membertel) {
        this.membertel = membertel == null ? null : membertel.trim();
    }

    public Date getRefundtime() {
        return refundtime;
    }

    public void setRefundtime(Date refundtime) {
        this.refundtime = refundtime;
    }*/
}