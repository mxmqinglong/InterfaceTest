package com.hxsb.model.BUY_ERP_GET_ORDERS;

import java.util.Date;

public class CP_HX00_MeasureUnit {
    private Short id;

    private String code;

    private String name;

    private String notes;

    private Short corpid;

    private Short status;

    private Short createbyid;

    private Date createtime;

    private Short updatebyid;

    private Date updatetime;

    private Short nodetype;

    private String foreignname;

    private String foreignnotes;

    private Short level;

    private Short tleft;

    private Short tright;

    private Short parentid;

    private Short unittype;

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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
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

    public Short getNodetype() {
        return nodetype;
    }

    public void setNodetype(Short nodetype) {
        this.nodetype = nodetype;
    }

    public String getForeignname() {
        return foreignname;
    }

    public void setForeignname(String foreignname) {
        this.foreignname = foreignname == null ? null : foreignname.trim();
    }

    public String getForeignnotes() {
        return foreignnotes;
    }

    public void setForeignnotes(String foreignnotes) {
        this.foreignnotes = foreignnotes == null ? null : foreignnotes.trim();
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

    public Short getUnittype() {
        return unittype;
    }

    public void setUnittype(Short unittype) {
        this.unittype = unittype;
    }

	@Override
	public String toString() {
		return "CP_HX00_MeasureUnit [id=" + id + ", code=" + code + ", name=" + name + ", notes=" + notes + ", corpid="
				+ corpid + ", status=" + status + ", createbyid=" + createbyid + ", createtime=" + createtime
				+ ", updatebyid=" + updatebyid + ", updatetime=" + updatetime + ", nodetype=" + nodetype
				+ ", foreignname=" + foreignname + ", foreignnotes=" + foreignnotes + ", level=" + level + ", tleft="
				+ tleft + ", tright=" + tright + ", parentid=" + parentid + ", unittype=" + unittype + "]";
	}
}