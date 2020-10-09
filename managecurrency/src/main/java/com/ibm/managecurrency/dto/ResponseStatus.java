package com.ibm.managecurrency.dto;

public class ResponseStatus {

	
	public ResponseStatus() {
	}
	public String status;
	public String errorMessage;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
