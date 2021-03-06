package com.te.cardemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.cardemo.dto.CarDetails;
import com.te.cardemo.model.SuperAdminResponse;
import com.te.cardemo.service.SuperAdminService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/superAdmin")
public class SuperAdminController {

	@Autowired
	private SuperAdminService superAdminService;

	
	@GetMapping("/car/info")
	public ResponseEntity<?> getAllCarDetailsWithAdminDetails() {
		List<CarDetails> allCarDetails = superAdminService.getAllCarDetails();
		if (allCarDetails != null) {
			return ResponseEntity.ok(new SuperAdminResponse(false, "success", allCarDetails));
		} else {
			return new ResponseEntity<SuperAdminResponse>(new SuperAdminResponse(true, "Data not Available", null),
					HttpStatus.BAD_REQUEST);
		}

	}
}