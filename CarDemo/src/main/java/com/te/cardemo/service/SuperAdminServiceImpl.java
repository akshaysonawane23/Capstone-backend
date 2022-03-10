package com.te.cardemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.cardemo.dao.AdminDao;
import com.te.cardemo.dao.CarDetailsDao;
import com.te.cardemo.dto.AdminDetails;
import com.te.cardemo.dto.CarDetails;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {

	@Autowired
	private CarDetailsDao carDao;

	@Autowired
	private AdminDao adminDao;

	@Override
	public List<CarDetails> getAllCarDetails() {
		return (List<CarDetails>) carDao.findAll();
	}

}