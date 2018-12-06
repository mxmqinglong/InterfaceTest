package com.hxsb.model.BUY_ERP_ORDER_CREATE;

import java.math.BigDecimal;
import java.util.Date;

public class CP_HX00_Shop {
    private Long id;

    private String code;

    private String name;

    private String foreignname;

    private Short nodetype;

    private Short corpid;

    private Short status;

    private Short createbyid;

    private Date createtime;

    private Short updatebyid;

    private Date updatetime;

    private String notes;

    private String foreignnotes;

    private Short level;

    private Short tleft;

    private Short tright;

    private Short parentid;

    private Long bizareaid;

    private Short dlAddrType;

    private Short dlAddrRefid;

    private Short dlAddrDivid;

    private String dlAddrText;

    private String shopaddr;

    private Short addrType;

    private Short addrRefid;

    private Short addrDivid;

    private String addrText;

    private Short deptid;

    private BigDecimal roId;

    private String cond;

    private BigDecimal roLessee;

    private BigDecimal roShoplead;

    private BigDecimal roAssistant;

    private BigDecimal ltLessee;

    private BigDecimal ltShoplead;

    private BigDecimal ltAssistant;

    private BigDecimal ltLesseeW;

    private BigDecimal ltShopleadW;

    private BigDecimal ltAssistantW;

    private BigDecimal ltLesseeD;

    private BigDecimal ltShopleadD;

    private BigDecimal ltAssistantD;

    private Short ispublicshop;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
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

    public Long getBizareaid() {
		return bizareaid;
	}

	public void setBizareaid(Long bizareaid) {
		this.bizareaid = bizareaid;
	}

	public Short getDlAddrType() {
        return dlAddrType;
    }

    public void setDlAddrType(Short dlAddrType) {
        this.dlAddrType = dlAddrType;
    }

    public Short getDlAddrRefid() {
        return dlAddrRefid;
    }

    public void setDlAddrRefid(Short dlAddrRefid) {
        this.dlAddrRefid = dlAddrRefid;
    }

    public Short getDlAddrDivid() {
        return dlAddrDivid;
    }

    public void setDlAddrDivid(Short dlAddrDivid) {
        this.dlAddrDivid = dlAddrDivid;
    }

    public String getDlAddrText() {
        return dlAddrText;
    }

    public void setDlAddrText(String dlAddrText) {
        this.dlAddrText = dlAddrText == null ? null : dlAddrText.trim();
    }

    public String getShopaddr() {
        return shopaddr;
    }

    public void setShopaddr(String shopaddr) {
        this.shopaddr = shopaddr == null ? null : shopaddr.trim();
    }

    public Short getAddrType() {
        return addrType;
    }

    public void setAddrType(Short addrType) {
        this.addrType = addrType;
    }

    public Short getAddrRefid() {
        return addrRefid;
    }

    public void setAddrRefid(Short addrRefid) {
        this.addrRefid = addrRefid;
    }

    public Short getAddrDivid() {
        return addrDivid;
    }

    public void setAddrDivid(Short addrDivid) {
        this.addrDivid = addrDivid;
    }

    public String getAddrText() {
        return addrText;
    }

    public void setAddrText(String addrText) {
        this.addrText = addrText == null ? null : addrText.trim();
    }

    public Short getDeptid() {
        return deptid;
    }

    public void setDeptid(Short deptid) {
        this.deptid = deptid;
    }

    public BigDecimal getRoId() {
        return roId;
    }

    public void setRoId(BigDecimal roId) {
        this.roId = roId;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond == null ? null : cond.trim();
    }

    public BigDecimal getRoLessee() {
        return roLessee;
    }

    public void setRoLessee(BigDecimal roLessee) {
        this.roLessee = roLessee;
    }

    public BigDecimal getRoShoplead() {
        return roShoplead;
    }

    public void setRoShoplead(BigDecimal roShoplead) {
        this.roShoplead = roShoplead;
    }

    public BigDecimal getRoAssistant() {
        return roAssistant;
    }

    public void setRoAssistant(BigDecimal roAssistant) {
        this.roAssistant = roAssistant;
    }

    public BigDecimal getLtLessee() {
        return ltLessee;
    }

    public void setLtLessee(BigDecimal ltLessee) {
        this.ltLessee = ltLessee;
    }

    public BigDecimal getLtShoplead() {
        return ltShoplead;
    }

    public void setLtShoplead(BigDecimal ltShoplead) {
        this.ltShoplead = ltShoplead;
    }

    public BigDecimal getLtAssistant() {
        return ltAssistant;
    }

    public void setLtAssistant(BigDecimal ltAssistant) {
        this.ltAssistant = ltAssistant;
    }

    public BigDecimal getLtLesseeW() {
        return ltLesseeW;
    }

    public void setLtLesseeW(BigDecimal ltLesseeW) {
        this.ltLesseeW = ltLesseeW;
    }

    public BigDecimal getLtShopleadW() {
        return ltShopleadW;
    }

    public void setLtShopleadW(BigDecimal ltShopleadW) {
        this.ltShopleadW = ltShopleadW;
    }

    public BigDecimal getLtAssistantW() {
        return ltAssistantW;
    }

    public void setLtAssistantW(BigDecimal ltAssistantW) {
        this.ltAssistantW = ltAssistantW;
    }

    public BigDecimal getLtLesseeD() {
        return ltLesseeD;
    }

    public void setLtLesseeD(BigDecimal ltLesseeD) {
        this.ltLesseeD = ltLesseeD;
    }

    public BigDecimal getLtShopleadD() {
        return ltShopleadD;
    }

    public void setLtShopleadD(BigDecimal ltShopleadD) {
        this.ltShopleadD = ltShopleadD;
    }

    public BigDecimal getLtAssistantD() {
        return ltAssistantD;
    }

    public void setLtAssistantD(BigDecimal ltAssistantD) {
        this.ltAssistantD = ltAssistantD;
    }

    public Short getIspublicshop() {
        return ispublicshop;
    }

    public void setIspublicshop(Short ispublicshop) {
        this.ispublicshop = ispublicshop;
    }

	@Override
	public String toString() {
		return "CP_HX00_Shop [id=" + id + ", code=" + code + ", name=" + name + ", foreignname=" + foreignname
				+ ", nodetype=" + nodetype + ", corpid=" + corpid + ", status=" + status + ", createbyid=" + createbyid
				+ ", createtime=" + createtime + ", updatebyid=" + updatebyid + ", updatetime=" + updatetime
				+ ", notes=" + notes + ", foreignnotes=" + foreignnotes + ", level=" + level + ", tleft=" + tleft
				+ ", tright=" + tright + ", parentid=" + parentid + ", bizareaid=" + bizareaid + ", dlAddrType="
				+ dlAddrType + ", dlAddrRefid=" + dlAddrRefid + ", dlAddrDivid=" + dlAddrDivid + ", dlAddrText="
				+ dlAddrText + ", shopaddr=" + shopaddr + ", addrType=" + addrType + ", addrRefid=" + addrRefid
				+ ", addrDivid=" + addrDivid + ", addrText=" + addrText + ", deptid=" + deptid + ", roId=" + roId
				+ ", cond=" + cond + ", roLessee=" + roLessee + ", roShoplead=" + roShoplead + ", roAssistant="
				+ roAssistant + ", ltLessee=" + ltLessee + ", ltShoplead=" + ltShoplead + ", ltAssistant=" + ltAssistant
				+ ", ltLesseeW=" + ltLesseeW + ", ltShopleadW=" + ltShopleadW + ", ltAssistantW=" + ltAssistantW
				+ ", ltLesseeD=" + ltLesseeD + ", ltShopleadD=" + ltShopleadD + ", ltAssistantD=" + ltAssistantD
				+ ", ispublicshop=" + ispublicshop + "]";
	}
}