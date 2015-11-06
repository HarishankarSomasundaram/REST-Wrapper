package com.mdd.rules;

public class ElementDetail {
	
	private int elementId;
	private String elementName;
	private int dataStoreId;
	private String dataStoreName;
	private String dataTypeCode;
	
	public ElementDetail() { }
	
	public ElementDetail(int elementId, String elementName, int dataStoreId, String dataStoreName, String dataTypeCode) {
		this.elementId = elementId;
		this.elementName = elementName;
		this.dataStoreId = dataStoreId;
		this.dataStoreName = dataStoreName;
		this.dataTypeCode = dataTypeCode;
	}
	
	public int getElementId() {
		return elementId;
	}
	public void setElementId(int elementId) {
		this.elementId = elementId;
	}
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	public int getDataStoreId() {
		return dataStoreId;
	}
	public void setDataStoreId(int dataStoreId) {
		this.dataStoreId = dataStoreId;
	}
	public String getDataStoreName() {
		return dataStoreName;
	}
	public void setDataStoreName(String dataStoreName) {
		this.dataStoreName = dataStoreName;
	}
	public String getDataTypeCode() {
		return dataTypeCode;
	}
	public void setDataTypeCode(String dataTypeCode) {
		this.dataTypeCode = dataTypeCode;
	}	
	
}
