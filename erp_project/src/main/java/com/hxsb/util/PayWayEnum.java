package com.hxsb.util;





/*10:"010"支付宝扫码, 
11:"011"支付宝代付, 
12:"012"支付宝APP, 
20:"020"微信扫码,
21:"021"微信代付,
22:"022"微信公众号,
23:"023"微信APP,
30:"030"银联网关,
31:"031"银联B2B,
32:"032"银联WAP,
40:"040"线下*/
public enum PayWayEnum {

	INITA("10", "支付宝扫码", "010"),
	INITB("11", "支付宝代付", "011"),
	INITC("12", "支付宝APP", "012"),
	INITD("20", "微信扫码", "020"),
	INITE("21", "微信代付", "021"),
	INITF("22", "微信公众号", "022"),
	INITG("23", "微信APP", "023"),
	INITH("30", "银联B2B", "030"),
	INITI("31", "银联B2B", "031"),
	INITJ("32", "银联WAP", "032"),
	INITK("40", "线下", "040"),

	;

	private final String code;

	private final String value;

	private final String text;

	PayWayEnum(String code, String value, String text) {
		this.code = code;
		this.value = value;
		this.text = text;
	}

	public static String explainByCode(String code) {
		//if (!StringUtils.isEmpty(code)) {
			for (PayWayEnum verifyStatusEnum : PayWayEnum.values()) {
				if (code.equals(verifyStatusEnum.getCode())) {
					return verifyStatusEnum.getText();
				}
			}
		//}
		return "";
	}

	public static String explainByValue(String value) {
		//if (!StringUtils.isEmpty(value)) {
			for (PayWayEnum verifyStatusEnum : PayWayEnum.values()) {
				if (value.equals(verifyStatusEnum.getValue())) {
					return verifyStatusEnum.getText();
				}
			}
		//}
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

