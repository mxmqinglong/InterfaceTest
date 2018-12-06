package com.hxsb.model.BUY_ERP_GET_PAYMENT_RECORD;

import java.math.BigDecimal;
import java.util.Date;

public class SCM_HX07_Receive_CAVHead {
    private Long billid;

    private Short billtype;

    private Short sequence;

    private String month;

    private String no;

    private Date billdate;

    private Integer status;

    private Integer corpid;

    private Integer maker;

    private Integer mender;

    private Integer checker;

    private Date makedate;

    private Date editdate;

    private Date checkdatetime;

    private Date receivedate;

    private String receivebank;

    private String receiveacount;

    private Double receiveamount;

    private BigDecimal cavAmount;

    private Integer bizUnit;

    private Integer bizArea;

    private Short rentingCust;

    private Integer bizShop;

    private String receivepayer;

    private BigDecimal uncavAmount;

    private Short claimstatus;

    private String serialno;

    private String ztext;

    private String receiveaccount;

    private String receivesummary;

    private String sourcefile;

    private Date importdate;

    private Short voucherversion;

    private Integer bizCompany;

    private Short fileid;

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

    private String sapNoPrefab2014;

    private String sapNo2014;

    private String sapMsgNo2014;

    private Short isfinancered;

    private String financeredreason;

    private Short financeredmarker;

    private Date financereddate;

    private Short issamebizcompany;

    private String billtitle;

    private String billdescr;

    private String extnotes;

    private Short payType;

    private String linker;

    private String linktel;

    private String rentingCustname;

    private Short sourcebillid;

    private String memberid;

    private String payway;

    private String membername;

    private String membertel;

    private Date paytime;
    
    private String note;
    
    //来源 :1 租赁 2销售
    private String onlineOrderType;
    //订单编号，销售订单维一标识
    private String onlineOrderNo;

    public Long getBillid() {
		return billid;
	}

	public void setBillid(Long billid) {
		this.billid = billid;
	}

	public Short getBilltype() {
        return billtype;
    }

    public void setBilltype(Short billtype) {
        this.billtype = billtype;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCorpid() {
		return corpid;
	}

	public void setCorpid(Integer corpid) {
		this.corpid = corpid;
	}

    public Integer getMaker() {
		return maker;
	}

	public void setMaker(Integer maker) {
		this.maker = maker;
	}

	public Integer getMender() {
		return mender;
	}

	public void setMender(Integer mender) {
		this.mender = mender;
	}

	public Integer getChecker() {
		return checker;
	}

	public void setChecker(Integer checker) {
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
    

	public Date getReceivedate() {
		return receivedate;
	}

	public void setReceivedate(Date receivedate) {
		this.receivedate = receivedate;
	}

	public String getReceivebank() {
        return receivebank;
    }

    public void setReceivebank(String receivebank) {
        this.receivebank = receivebank == null ? null : receivebank.trim();
    }

    public String getReceiveacount() {
        return receiveacount;
    }

    public void setReceiveacount(String receiveacount) {
        this.receiveacount = receiveacount == null ? null : receiveacount.trim();
    }


	public Double getReceiveamount() {
		return receiveamount;
	}

	public void setReceiveamount(Double receiveamount) {
		this.receiveamount = receiveamount;
	}

	public BigDecimal getCavAmount() {
        return cavAmount;
    }

    public void setCavAmount(BigDecimal cavAmount) {
        this.cavAmount = cavAmount;
    }


    public Integer getBizUnit() {
		return bizUnit;
	}

	public void setBizUnit(Integer bizUnit) {
		this.bizUnit = bizUnit;
	}

	public Integer getBizArea() {
		return bizArea;
	}

	public void setBizArea(Integer bizArea) {
		this.bizArea = bizArea;
	}

	public Short getRentingCust() {
        return rentingCust;
    }

    public void setRentingCust(Short rentingCust) {
        this.rentingCust = rentingCust;
    }

    public Integer getBizShop() {
		return bizShop;
	}

	public void setBizShop(Integer bizShop) {
		this.bizShop = bizShop;
	}

	public String getReceivepayer() {
        return receivepayer;
    }

    public void setReceivepayer(String receivepayer) {
        this.receivepayer = receivepayer == null ? null : receivepayer.trim();
    }

    public BigDecimal getUncavAmount() {
        return uncavAmount;
    }

    public void setUncavAmount(BigDecimal uncavAmount) {
        this.uncavAmount = uncavAmount;
    }

    public Short getClaimstatus() {
        return claimstatus;
    }

    public void setClaimstatus(Short claimstatus) {
        this.claimstatus = claimstatus;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

    public String getZtext() {
        return ztext;
    }

    public void setZtext(String ztext) {
        this.ztext = ztext == null ? null : ztext.trim();
    }

    public String getReceiveaccount() {
        return receiveaccount;
    }

    public void setReceiveaccount(String receiveaccount) {
        this.receiveaccount = receiveaccount == null ? null : receiveaccount.trim();
    }

    public String getReceivesummary() {
        return receivesummary;
    }

    public void setReceivesummary(String receivesummary) {
        this.receivesummary = receivesummary == null ? null : receivesummary.trim();
    }

    public String getSourcefile() {
        return sourcefile;
    }

    public void setSourcefile(String sourcefile) {
        this.sourcefile = sourcefile == null ? null : sourcefile.trim();
    }

    public Date getImportdate() {
        return importdate;
    }

    public void setImportdate(Date importdate) {
        this.importdate = importdate;
    }

    public Short getVoucherversion() {
        return voucherversion;
    }

    public void setVoucherversion(Short voucherversion) {
        this.voucherversion = voucherversion;
    }

    public Integer getBizCompany() {
		return bizCompany;
	}

	public void setBizCompany(Integer bizCompany) {
		this.bizCompany = bizCompany;
	}

	public Short getFileid() {
        return fileid;
    }

    public void setFileid(Short fileid) {
        this.fileid = fileid;
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

    public String getSapNoPrefab2014() {
        return sapNoPrefab2014;
    }

    public void setSapNoPrefab2014(String sapNoPrefab2014) {
        this.sapNoPrefab2014 = sapNoPrefab2014 == null ? null : sapNoPrefab2014.trim();
    }

    public String getSapNo2014() {
        return sapNo2014;
    }

    public void setSapNo2014(String sapNo2014) {
        this.sapNo2014 = sapNo2014 == null ? null : sapNo2014.trim();
    }

    public String getSapMsgNo2014() {
        return sapMsgNo2014;
    }

    public void setSapMsgNo2014(String sapMsgNo2014) {
        this.sapMsgNo2014 = sapMsgNo2014 == null ? null : sapMsgNo2014.trim();
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

    public Short getIssamebizcompany() {
        return issamebizcompany;
    }

    public void setIssamebizcompany(Short issamebizcompany) {
        this.issamebizcompany = issamebizcompany;
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

    public String getExtnotes() {
        return extnotes;
    }

    public void setExtnotes(String extnotes) {
        this.extnotes = extnotes == null ? null : extnotes.trim();
    }

    public Short getPayType() {
        return payType;
    }

    public void setPayType(Short payType) {
        this.payType = payType;
    }

    public String getLinker() {
        return linker;
    }

    public void setLinker(String linker) {
        this.linker = linker == null ? null : linker.trim();
    }

    public String getLinktel() {
        return linktel;
    }

    public void setLinktel(String linktel) {
        this.linktel = linktel == null ? null : linktel.trim();
    }

    public String getRentingCustname() {
        return rentingCustname;
    }

    public void setRentingCustname(String rentingCustname) {
        this.rentingCustname = rentingCustname == null ? null : rentingCustname.trim();
    }

    public Short getSourcebillid() {
        return sourcebillid;
    }

    public void setSourcebillid(Short sourcebillid) {
        this.sourcebillid = sourcebillid;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

	public String getPayway() {
		return payway;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}

	public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername == null ? null : membername.trim();
    }

    public String getMembertel() {
        return membertel;
    }

    public void setMembertel(String membertel) {
        this.membertel = membertel == null ? null : membertel.trim();
    }

	public Date getPaytime() {
		return paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public String getOnlineOrderType() {
		return onlineOrderType;
	}

	public void setOnlineOrderType(String onlineOrderType) {
		this.onlineOrderType = onlineOrderType;
	}

	public String getOnlineOrderNo() {
		return onlineOrderNo;
	}

	public void setOnlineOrderNo(String onlineOrderNo) {
		this.onlineOrderNo = onlineOrderNo;
	}

	@Override
	public String toString() {
		return "SCM_HX07_Receive_CAVHead [billid=" + billid + ", billtype=" + billtype + ", sequence=" + sequence
				+ ", month=" + month + ", no=" + no + ", billdate=" + billdate + ", status=" + status + ", corpid="
				+ corpid + ", maker=" + maker + ", mender=" + mender + ", checker=" + checker + ", makedate=" + makedate
				+ ", editdate=" + editdate + ", checkdatetime=" + checkdatetime + ", receivedate=" + receivedate
				+ ", receivebank=" + receivebank + ", receiveacount=" + receiveacount + ", receiveamount="
				+ receiveamount + ", cavAmount=" + cavAmount + ", bizUnit=" + bizUnit + ", bizArea=" + bizArea
				+ ", rentingCust=" + rentingCust + ", bizShop=" + bizShop + ", receivepayer=" + receivepayer
				+ ", uncavAmount=" + uncavAmount + ", claimstatus=" + claimstatus + ", serialno=" + serialno
				+ ", ztext=" + ztext + ", receiveaccount=" + receiveaccount + ", receivesummary=" + receivesummary
				+ ", sourcefile=" + sourcefile + ", importdate=" + importdate + ", voucherversion=" + voucherversion
				+ ", bizCompany=" + bizCompany + ", fileid=" + fileid + ", sapNo=" + sapNo + ", sapNoPrefab="
				+ sapNoPrefab + ", saperror=" + saperror + ", sapMsgNo=" + sapMsgNo + ", bluebilldate=" + bluebilldate
				+ ", sapNoBack=" + sapNoBack + ", sapMsgNoBack=" + sapMsgNoBack + ", redbilldate=" + redbilldate
				+ ", saperrorBack=" + saperrorBack + ", voucherparentbillid=" + voucherparentbillid
				+ ", sapNoPrefab2014=" + sapNoPrefab2014 + ", sapNo2014=" + sapNo2014 + ", sapMsgNo2014=" + sapMsgNo2014
				+ ", isfinancered=" + isfinancered + ", financeredreason=" + financeredreason + ", financeredmarker="
				+ financeredmarker + ", financereddate=" + financereddate + ", issamebizcompany=" + issamebizcompany
				+ ", billtitle=" + billtitle + ", billdescr=" + billdescr + ", extnotes=" + extnotes + ", payType="
				+ payType + ", linker=" + linker + ", linktel=" + linktel + ", rentingCustname=" + rentingCustname
				+ ", sourcebillid=" + sourcebillid + ", memberid=" + memberid + ", payway=" + payway + ", membername="
				+ membername + ", membertel=" + membertel + ", paytime=" + paytime + ", note=" + note
				+ ", onlineOrderType=" + onlineOrderType + ", onlineOrderNo=" + onlineOrderNo + "]";
	}

	
}