package com.hxsb.model.BUY_ERP_ORDER_CREATE;

public class SCM_S00_NOTICEKey {
    private String noticename;

    private Long reckey;

    private Long operator;

    public String getNoticename() {
        return noticename;
    }

    public void setNoticename(String noticename) {
        this.noticename = noticename == null ? null : noticename.trim();
    }

	public Long getReckey() {
		return reckey;
	}

	public void setReckey(Long reckey) {
		this.reckey = reckey;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "SCM_S00_NOTICEKey [noticename=" + noticename + ", reckey=" + reckey + ", operator=" + operator + "]";
	}
}