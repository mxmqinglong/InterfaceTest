package com.hxsb.model.BUY_ERP_USER_SYNC;

public class Notice {
	private Long Biz_Unit;
	private Long Biz_Area;
	private String Title;
	private Long OperatorID;
	private Long Creator;
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
}
