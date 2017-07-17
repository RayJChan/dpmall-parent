package com.dpmall.api.enums;

public enum ESaleLeadsOrderStatus {
	
	DISTRIBUTE_PEND(0,"2distribute"),
	REJECTED(5,"distributed"),
	DISTRIBUTED(10,"distributed"),
	ACCEPTED(15,"accepted"),
	APPOINTED(20,"appointed"),
	SUCCESS(25,"appointed"),
	FAILED(30,"failed");
	
    
	private Integer value;
	
	private String code;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private ESaleLeadsOrderStatus(Integer value, String code) {
		this.value = value;
		this.code = code;
	}
	
}
