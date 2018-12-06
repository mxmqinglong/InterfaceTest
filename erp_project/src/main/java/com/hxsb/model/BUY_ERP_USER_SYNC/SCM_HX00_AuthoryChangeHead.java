package com.hxsb.model.BUY_ERP_USER_SYNC;

import java.util.Date;

public class SCM_HX00_AuthoryChangeHead {
	private String relatenos;
	private String relateids;
	private String buyUserId;
	private String nowname;
	private String nowmobile;
	
	private String changename;
	private String changemobile;
	private Long bizArea;
	private Integer bizShop;
	private Integer maker;
	
	private Integer status;
	private Date billdate;
	private Long bizUnit;
	private Long billid;
	private String no;
	public String getRelatenos() {
		return relatenos;
	}
	public void setRelatenos(String relatenos) {
		this.relatenos = relatenos;
	}
	public String getRelateids() {
		return relateids;
	}
	public void setRelateids(String relateids) {
		this.relateids = relateids;
	}
	
	public String getBuyUserId() {
		return buyUserId;
	}
	public void setBuyUserId(String buyUserId) {
		this.buyUserId = buyUserId;
	}
	public String getNowname() {
		return nowname;
	}
	public void setNowname(String nowname) {
		this.nowname = nowname;
	}
	public String getNowmobile() {
		return nowmobile;
	}
	public void setNowmobile(String nowmobile) {
		this.nowmobile = nowmobile;
	}
	public String getChangename() {
		return changename;
	}
	public void setChangename(String changename) {
		this.changename = changename;
	}
	public String getChangemobile() {
		return changemobile;
	}
	public void setChangemobile(String changemobile) {
		this.changemobile = changemobile;
	}
	public Long getBizArea() {
		return bizArea;
	}
	public void setBizArea(Long bizArea) {
		this.bizArea = bizArea;
	}
	public Integer getBizShop() {
		return bizShop;
	}
	public void setBizShop(Integer bizShop) {
		this.bizShop = bizShop;
	}
	public Integer getMaker() {
		return maker;
	}
	public void setMaker(Integer maker) {
		this.maker = maker;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getBilldate() {
		return billdate;
	}
	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}
	
	public Long getBizUnit() {
		return bizUnit;
	}
	public void setBizUnit(Long bizUnit) {
		this.bizUnit = bizUnit;
	}
	public Long getBillid() {
		return billid;
	}
	public void setBillid(Long billid) {
		this.billid = billid;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
}