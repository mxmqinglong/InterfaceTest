package com.hxsb.model.BUY_ERP_ORDER_CREATE;

public class GP_Operator {
    private Long id;
    private Long operatorId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	
	
	@Override
	public String toString() {
		return "GP_Operator [id=" + id + ", operatorId=" + operatorId + "]";
	}
}