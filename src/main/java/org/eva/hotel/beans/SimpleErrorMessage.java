package org.eva.hotel.beans;

public class SimpleErrorMessage extends ResponseBean {
	private String message;


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public SimpleErrorMessage(String message) {
		this.message = message;
	}
}
