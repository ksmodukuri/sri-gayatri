package com.katrenikona.srigayatri.object;

public class SMSException extends Exception {

	private static final long serialVersionUID = 1780546688281675795L;
	
	private String code;
	private String message;
	private String description;
	private Error error;
	
	public SMSException( ExceptionCode code, String message) {
		super(message);
		this.code = code.name();
		this.message = message;
		this.description = code.description;
		error = new Error(code, message);
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

	public Error getError() {
		return error;
	}
	
}


