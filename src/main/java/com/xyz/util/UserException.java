package com.xyz.util;

public class UserException extends Exception {
	
	private static final long serialVersionUID = 4052399442981968183L;
	private String code;
	private String message;

	
	public org.springframework.http.HttpStatus getHttpStatus()
	{
		if (code.startsWith("VAERR") || code.startsWith("MQERR") )
			return org.springframework.http.HttpStatus.OK;
		else if(code.startsWith("RERR"))
			return org.springframework.http.HttpStatus.BAD_GATEWAY;
		else
			return  org.springframework.http.HttpStatus.ACCEPTED;
	}
	
	public UserException(String code) {
		super(code);
		this.code = code;
	}


	public UserException(String code, String message, Exception e) {
		this.code = code;
		this.message = message;

	}
	
	public UserException(String code, String message) {
		this.code = code;
		this.message = message;
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

}
