package com.te.cardemo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.te.cardemo.dto.CarDetails;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

	private boolean error;
	private String message;
	private List<CarDetails> allCarDetails;
	private List<CarDetails> searchCarDetails;

	
	
	public UserResponse() {
		super();
	}

	
	public UserResponse(boolean error, String message, List<CarDetails> allCarDetails,
			List<CarDetails> searchCarDetails) {
		super();
		this.error = error;
		this.message = message;
		this.allCarDetails = allCarDetails;
		this.searchCarDetails = searchCarDetails;
	}

	@Override
	public String toString() {
		return "UserResponse [error=" + error + ", message=" + message + ", allCarDetails=" + allCarDetails
				+ ", searchCarDetails=" + searchCarDetails + "]";
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

	public List<CarDetails> getAllCarDetails() {
		return allCarDetails;
	}

	public void setAllCarDetails(List<CarDetails> allCarDetails) {
		this.allCarDetails = allCarDetails;
	}

	public List<CarDetails> getSearchCarDetails() {
		return searchCarDetails;
	}

	public void setSearchCarDetails(List<CarDetails> searchCarDetails) {
		this.searchCarDetails = searchCarDetails;
	}

}