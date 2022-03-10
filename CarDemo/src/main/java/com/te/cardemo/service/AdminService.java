package com.te.cardemo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.te.cardemo.dto.AdminDetails;
import com.te.cardemo.dto.CarDetails;

public interface AdminService {
	
	AdminDetails adminDetails(String name);
	
	AdminDetails saveSignupData(AdminDetails adminDetails);

	List<CarDetails> getAllCarDetails(HttpServletRequest request);

	CarDetails addCarDetails(CarDetails carDetails, HttpServletRequest request);

	CarDetails updateCarDetails(CarDetails carDetails, HttpServletRequest request, int carId);

	public boolean deleteCarDetails(int carId);

	public boolean checkIfUsernameExists(String username);
}