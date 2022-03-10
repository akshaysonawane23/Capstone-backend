package com.te.cardemo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.te.cardemo.dto.CarDetails;

public interface CarDetailsDao extends CrudRepository<CarDetails, Integer> {

	List<CarDetails> findByCompany(String company);

	List<CarDetails> findByName(String name);

	List<CarDetails> findByFuelType(String fuelType);

	CarDetails findById(int carId);

	List<CarDetails> findByAdminName(String name);

}