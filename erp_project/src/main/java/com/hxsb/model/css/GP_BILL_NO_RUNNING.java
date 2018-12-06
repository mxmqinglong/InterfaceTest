package com.hxsb.model.css;

public class GP_BILL_NO_RUNNING {
    private Long id;

    private String bnrBillTypeCode;

    private String bnrResetPattern;

    private Integer bnrMaxRunningNumber;
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBnrBillTypeCode() {
        return bnrBillTypeCode;
    }

    public void setBnrBillTypeCode(String bnrBillTypeCode) {
        this.bnrBillTypeCode = bnrBillTypeCode == null ? null : bnrBillTypeCode.trim();
    }

    public String getBnrResetPattern() {
        return bnrResetPattern;
    }

    public void setBnrResetPattern(String bnrResetPattern) {
        this.bnrResetPattern = bnrResetPattern == null ? null : bnrResetPattern.trim();
    }

	public Integer getBnrMaxRunningNumber() {
		return bnrMaxRunningNumber;
	}

	public void setBnrMaxRunningNumber(Integer bnrMaxRunningNumber) {
		this.bnrMaxRunningNumber = bnrMaxRunningNumber;
	}
}