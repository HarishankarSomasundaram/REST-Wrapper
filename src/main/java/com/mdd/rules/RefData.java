package com.mdd.rules;

public class RefData {
	
	private String refType;
	private String value;
	
	public RefData() { }
	
	public RefData(String refType, String value) {
		this.refType = refType;
		this.value = value;
	}
	
	public String getRefType() {
		return refType;
	}
	public void setRefType(String refType) {
		this.refType = refType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}	
}

