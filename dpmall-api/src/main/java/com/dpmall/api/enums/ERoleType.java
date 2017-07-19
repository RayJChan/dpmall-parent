package com.dpmall.api.enums;

public enum ERoleType {
	
	STORE_USER(1,"store_user"),
	STORE_MGR(2,"store_mgr"),
	AGENCY(3,"agency");
	
    private Integer value;
	
	private String roleCode;
	
	private ERoleType(Integer value, String roleCode) {
		this.value = value;
		this.roleCode = roleCode;
	}

	public Integer getValue() {
		return value;
	}

	public String getRoleCode() {
		return roleCode;
	}
	
	
}
