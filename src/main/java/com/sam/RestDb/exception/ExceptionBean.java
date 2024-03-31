package com.sam.RestDb.exception;

import java.util.Date;

public class ExceptionBean {

	private Date timestamp;
	private String message;
	private String details;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	@Override
	public String toString() {
		return "ExceptionBean [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}

	public ExceptionBean(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
