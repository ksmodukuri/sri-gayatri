package com.katrenikona.srigayatri.object;

public enum ExceptionCode {
	
	WEX350("Unknow Exception"),
	WEX450("Unauthorized User"),
	WEX500("Unknow User");
	
	public final String description;
	
	public String getDescription() {
		return this.description;
	}
	 
	
    private ExceptionCode(String description) {
        this.description = description;
    }
	
}
