package com.mdd.rules;

import java.util.Arrays;

public class POSClass {

	private String Token;
	private String POS;

	public POSClass() { }

	public POSClass(String token, String pos) {
		this.Token = token;
		this.POS = pos;
	}

	public String getPOSClass() {
		return Token;
	}
	public void setPOSClass(String token) {
		this.Token = token;
	}
	public String getPOS() {
		return POS;
	}
	public void setPOS(String pos) {
		this.POS = pos;
	}
}



