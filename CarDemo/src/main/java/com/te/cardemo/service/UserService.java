package com.te.cardemo.service;

import java.util.List;

import com.te.cardemo.dto.CarDetails;

public interface UserService {

	List<CarDetails> getAllCarInfo();

	List<CarDetails> SearchCarInfo(String searchData);

}
