package com.hxsb.model.BUY_ERP_USER_SYNC;

import java.util.Date;

public class SCM_HX00_MemberInfoHead {
    private Long billid;

    private Short billtype;

    private Short sequence;

    private String month;

    private String no;

    private Date billdate;

    private Integer status;

    private Integer maker;

    private Short corpid;

    private Short isapp;

    private Short checker;

    private Date makedate;

    private Short mender;

    private Date checkdatetime;

    private Date editdate;

    private String billdescr;

    private Integer bizArea;

    private String buyUserId;

    private String userName;

    private String userMobile;

    private String beizhu;


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

    public Integer getMaker() {
		return maker;
	}

	public void setMaker(Integer maker) {
		this.maker = maker;
	}

	public Short getCorpid() {
        return corpid;
    }

    public void setCorpid(Short corpid) {
        this.corpid = corpid;
    }

    public Short getIsapp() {
        return isapp;
    }

    public void setIsapp(Short isapp) {
        this.isapp = isapp;
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

    public Short getMender() {
        return mender;
    }

    public void setMender(Short mender) {
        this.mender = mender;
    }

    public Date getCheckdatetime() {
        return checkdatetime;
    }

    public void setCheckdatetime(Date checkdatetime) {
        this.checkdatetime = checkdatetime;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public String getBilldescr() {
        return billdescr;
    }

    public void setBilldescr(String billdescr) {
        this.billdescr = billdescr == null ? null : billdescr.trim();
    }


    public Integer getBizArea() {
		return bizArea;
	}

	public void setBizArea(Integer bizArea) {
		this.bizArea = bizArea;
	}

	public String getBuyUserId() {
		return buyUserId;
	}

	public void setBuyUserId(String buyUserId) {
		this.buyUserId = buyUserId;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }

	@Override
	public String toString() {
		return "SCM_HX00_MemberInfoHead [billid=" + billid + ", billtype=" + billtype + ", sequence=" + sequence
				+ ", month=" + month + ", no=" + no + ", billdate=" + billdate + ", status=" + status + ", maker="
				+ maker + ", corpid=" + corpid + ", isapp=" + isapp + ", checker=" + checker + ", makedate=" + makedate
				+ ", mender=" + mender + ", checkdatetime=" + checkdatetime + ", editdate=" + editdate + ", billdescr="
				+ billdescr + ", bizArea=" + bizArea + ", buyUserId=" + buyUserId + ", userName=" + userName
				+ ", userMobile=" + userMobile + ", beizhu=" + beizhu + "]";
	}
}