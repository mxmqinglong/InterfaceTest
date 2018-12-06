package com.hxsb.model.BUY_ERP_ORDER_CREATE;

public class IntentionTemporary {
	private Long Biz_Unit;
	private Long Biz_Area;
	private Long Biz_Shop;
	private String Title;
	private Long OperatorID;
	private Long Creator;
	private Long BILLID;
	private String NO;
	
	
	public Long getBiz_Unit() {
		return Biz_Unit;
	}
	public void setBiz_Unit(Long biz_Unit) {
		Biz_Unit = biz_Unit;
	}
	public Long getBiz_Area() {
		return Biz_Area;
	}
	public void setBiz_Area(Long biz_Area) {
		Biz_Area = biz_Area;
	}
	public Long getBiz_Shop() {
		return Biz_Shop;
	}
	public void setBiz_Shop(Long biz_Shop) {
		Biz_Shop = biz_Shop;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Long getOperatorID() {
		return OperatorID;
	}
	public void setOperatorID(Long operatorID) {
		OperatorID = operatorID;
	}
	public Long getCreator() {
		return Creator;
	}
	public void setCreator(Long creator) {
		Creator = creator;
	}
	public Long getBILLID() {
		return BILLID;
	}
	public void setBILLID(Long bILLID) {
		BILLID = bILLID;
	}
	public String getNO() {
		return NO;
	}
	public void setNO(String nO) {
		NO = nO;
	}
	@Override
	public String toString() {
		return "IntentionTemporary [Biz_Unit=" + Biz_Unit + ", Biz_Area=" + Biz_Area + ", Biz_Shop=" + Biz_Shop
				+ ", Title=" + Title + ", OperatorID=" + OperatorID + ", Creator=" + Creator + ", BILLID=" + BILLID
				+ ", NO=" + NO + "]";
	}
}
