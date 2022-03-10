package com.te.cardemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminResponse {
	
	private boolean error;
	private String message;
	private String token;
	private String role;

	
	public AdminResponse(boolean error, String message, String token, String role) {
		super();
		this.error = error;
		this.message = message;
		this.token = token;
		this.role = role;
	}

	public AdminResponse() {
		super();
	}

	
	
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AdminResponse [error=" + error + ", message=" + message + ", token=" + token + ", role=" + role + "]";
	}

}
