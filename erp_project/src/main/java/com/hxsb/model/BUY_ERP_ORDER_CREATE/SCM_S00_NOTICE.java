package com.hxsb.model.BUY_ERP_ORDER_CREATE;

import java.util.Date;

public class SCM_S00_NOTICE  {
	private Long reckey;
	private String taskname;
	private String dataname;
	private String datacode;
	private Long bizunitid;
	private Long bizareaid;
	private Long bizshopid;
	private Integer deptid;
	private String title;
	private Long operator;
	private String optexp;
	private Integer optdata;
	private String noticename;
	private Date createtime;
	private Long creator;
	private Long billid;
	private String billkey;
	public Long getReckey() {
		return reckey;
	}
	public void setReckey(Long reckey) {
		this.reckey = reckey;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getDataname() {
		return dataname;
	}
	public void setDataname(String dataname) {
		this.dataname = dataname;
	}
	public String getDatacode() {
		return datacode;
	}
	public void setDatacode(String datacode) {
		this.datacode = datacode;
	}
	public Long getBizunitid() {
		return bizunitid;
	}
	public void setBizunitid(Long bizunitid) {
		this.bizunitid = bizunitid;
	}
	public Long getBizareaid() {
		return bizareaid;
	}
	public void setBizareaid(Long bizareaid) {
		this.bizareaid = bizareaid;
	}
	
	public Long getBizshopid() {
		return bizshopid;
	}
	public void setBizshopid(Long bizshopid) {
		this.bizshopid = bizshopid;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getOperator() {
		return operator;
	}
	public void setOperator(Long operator) {
		this.operator = operator;
	}
	public String getOptexp() {
		return optexp;
	}
	public void setOptexp(String optexp) {
		this.optexp = optexp;
	}
	public Integer getOptdata() {
		return optdata;
	}
	public void setOptdata(Integer optdata) {
		this.optdata = optdata;
	}
	public String getNoticename() {
		return noticename;
	}
	public void setNoticename(String noticename) {
		this.noticename = noticename;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Long getCreator() {
		return creator;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	public Long getBillid() {
		return billid;
	}
	public void setBillid(Long billid) {
		this.billid = billid;
	}
	public String getBillkey() {
		return billkey;
	}
	public void setBillkey(String billkey) {
		this.billkey = billkey;
	}
	@Override
	public String toString() {
		return "SCM_S00_NOTICE [reckey=" + reckey + ", taskname=" + taskname + ", dataname=" + dataname + ", datacode="
				+ datacode + ", bizunitid=" + bizunitid + ", bizareaid=" + bizareaid + ", bizshopid=" + bizshopid
				+ ", deptid=" + deptid + ", title=" + title + ", operator=" + operator + ", optexp=" + optexp
				+ ", optdata=" + optdata + ", noticename=" + noticename + ", createtime=" + createtime + ", creator="
				+ creator + ", billid=" + billid + ", billkey=" + billkey + "]";
	}
}