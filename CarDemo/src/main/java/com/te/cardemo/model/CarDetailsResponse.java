package com.te.cardemo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.te.cardemo.dto.CarDetails;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDetailsResponse {

	private boolean error;
	private String message;
	private List<CarDetails> allCarDetails;

	public CarDetailsResponse() {
		super();
	}

	public CarDetailsResponse(boolean error, String message, List<CarDetails> allCarDetails) {
		super();
		this.error = error;
		this.message = message;
		this.allCarDetails = allCarDetails;
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

	@Override
	public String toString() {
		return "CarDetailsResponse [error=" + error + ", message=" + message + ", allCarDetails=" + allCarDetails + "]";
	}

}
