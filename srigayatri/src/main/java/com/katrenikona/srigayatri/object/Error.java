package com.katrenikona.srigayatri.object;

public class Error {
	
	private String code;
	
	private String message;
	
	private String description;
	
	
	public Error (ExceptionCode code, String message) {
		this.code = code.name();
		this.message = message;
		this.description = code.getDescription();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
