package com.hxsb.model.BUY_ERP_ORDER_CREATE;

import java.util.Date;

public class CP_HX00_BizUnit {
    private Short id;

    private String code;

    private String name;

    private Short corpid;

    private Short status;

    private Short createbyid;

    private Date createtime;

    private Short updatebyid;

    private Date updatetime;

    private String foreignnotes;

    private String foreignname;

    private Short nodetype;

    private String notes;

    private Short level;

    private Short tleft;

    private Short tright;

    private Short parentid;

    private String shortcut;

    private Short deptid;

    private Short xuyaokehushouxinkongzhi;

    private Short businessmode;

    private Short roDeclareFuel;

    private String idCode;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getCorpid() {
        return corpid;
    }

    public void setCorpid(Short corpid) {
        this.corpid = corpid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getCreatebyid() {
        return createbyid;
    }

    public void setCreatebyid(Short createbyid) {
        this.createbyid = createbyid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Short getUpdatebyid() {
        return updatebyid;
    }

    public void setUpdatebyid(Short updatebyid) {
        this.updatebyid = updatebyid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getForeignnotes() {
        return foreignnotes;
    }

    public void setForeignnotes(String foreignnotes) {
        this.foreignnotes = foreignnotes == null ? null : foreignnotes.trim();
    }

    public String getForeignname() {
        return foreignname;
    }

    public void setForeignname(String foreignname) {
        this.foreignname = foreignname == null ? null : foreignname.trim();
    }

    public Short getNodetype() {
        return nodetype;
    }

    public void setNodetype(Short nodetype) {
        this.nodetype = nodetype;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Short getTleft() {
        return tleft;
    }

    public void setTleft(Short tleft) {
        this.tleft = tleft;
    }

    public Short getTright() {
        return tright;
    }

    public void setTright(Short tright) {
        this.tright = tright;
    }

    public Short getParentid() {
        return parentid;
    }

    public void setParentid(Short parentid) {
        this.parentid = parentid;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut == null ? null : shortcut.trim();
    }

    public Short getDeptid() {
        return deptid;
    }

    public void setDeptid(Short deptid) {
        this.deptid = deptid;
    }

    public Short getXuyaokehushouxinkongzhi() {
        return xuyaokehushouxinkongzhi;
    }

    public void setXuyaokehushouxinkongzhi(Short xuyaokehushouxinkongzhi) {
        this.xuyaokehushouxinkongzhi = xuyaokehushouxinkongzhi;
    }

    public Short getBusinessmode() {
        return businessmode;
    }

    public void setBusinessmode(Short businessmode) {
        this.businessmode = businessmode;
    }

    public Short getRoDeclareFuel() {
        return roDeclareFuel;
    }

    public void setRoDeclareFuel(Short roDeclareFuel) {
        this.roDeclareFuel = roDeclareFuel;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode == null ? null : idCode.trim();
    }

	@Override
	public String toString() {
		return "CP_HX00_BizUnit [id=" + id + ", code=" + code + ", name=" + name + ", corpid=" + corpid + ", status="
				+ status + ", createbyid=" + createbyid + ", createtime=" + createtime + ", updatebyid=" + updatebyid
				+ ", updatetime=" + updatetime + ", foreignnotes=" + foreignnotes + ", foreignname=" + foreignname
				+ ", nodetype=" + nodetype + ", notes=" + notes + ", level=" + level + ", tleft=" + tleft + ", tright="
				+ tright + ", parentid=" + parentid + ", shortcut=" + shortcut + ", deptid=" + deptid
				+ ", xuyaokehushouxinkongzhi=" + xuyaokehushouxinkongzhi + ", businessmode=" + businessmode
				+ ", roDeclareFuel=" + roDeclareFuel + ", idCode=" + idCode + "]";
	}
}