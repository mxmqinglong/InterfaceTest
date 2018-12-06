package com.hxsb.util;

/**
 * 模块状态枚举 1.初始 2.待审核 3.生效 4.作废 Created by youguoqiang on 2017/3/28.
 */
public enum VerifyStatusEnum {

	INIT("1", "INIT", "初始"),

	WAIT_VERIFY("2", "WAIT_VERIFY", "待审核"),

	EFFECTIVE("3", "EFFECTIVE", "生效"),

	DELETE("4", "DELETE", "作废"),

	REJECT("5", "REJECT", "已驳回"),

	PENDING_DEPARTMENT_VERIFY("6", "PENDING_DEPARTMENT_VERIFY", "部门审核"),

	PENDING_HR_VERIFY("7", "PENDING_HR_VERIFY", "人事审核"),

	PENDING_FINANCIAL_VERIFY("8", "PENDING_FINANCIAL_VERIFY", "人事审核"),

	PENDING_MANAGER_VERIFY("9", "PENDING_MANAGER_VERIFY", "总经理审核"),;

	private final String code;

	private final String value;

	private final String text;

	VerifyStatusEnum(String code, String value, String text) {
		this.code = code;
		this.value = value;
		this.text = text;
	}

	public static String explainByCode(String code) {
		for (VerifyStatusEnum verifyStatusEnum : VerifyStatusEnum.values()) {
			if (code.equals(verifyStatusEnum.getCode())) {
				return verifyStatusEnum.getText();
			}
		}
		return "";
	}

	public static String explainByValue(String value) {
		for (VerifyStatusEnum verifyStatusEnum : VerifyStatusEnum.values()) {
			if (value.equals(verifyStatusEnum.getValue())) {
				return verifyStatusEnum.getText();
			}
		}
		return "";
	}

	public String getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

	public String getText() {
		return text;
	}
}

