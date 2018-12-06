package com.hxsb.model.BUY_ERP_USER_SYNC;

public class MemberInfo {
	private String userName;
	private String userMobile;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	@Override
	public String toString() {
		return "MemberInfo [userName=" + userName + ", userMobile=" + userMobile + "]";
	}
}
