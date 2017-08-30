package com.eva.phase2.beans;

import java.util.List;

public abstract class ResponseBean {
	protected List<String> message;
	protected String status;

	public ResponseBean() {

	}

	public ResponseBean(List<String> message, String status) {
		this.status = status;
		this.message = message;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}