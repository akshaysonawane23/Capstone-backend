
package com.te.cardemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.cardemo.dao.CarDetailsDao;
import com.te.cardemo.dto.CarDetails;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CarDetailsDao carDao;

	@Override
	public List<CarDetails> getAllCarInfo() {
		return (List<CarDetails>) carDao.findAll();
	}

	@Override
	public List<CarDetails> SearchCarInfo(String searchData) {

		String search = searchData.toUpperCase();
		if (search.startsWith("ELECTRIC")) {
			return (List<CarDetails>) carDao.findByFuelType("Electric");
		}
		if (search.startsWith("DIESEL")) {
			return (List<CarDetails>) carDao.findByFuelType("Diesel");
		}
		if (search.startsWith("PETROL")) {
			return (List<CarDetails>) carDao.findByFuelType("Petrol");
		}
		if (search.equalsIgnoreCase("BMW") || search.equalsIgnoreCase("Honda") || search.equalsIgnoreCase("Mahindra")
				|| search.equalsIgnoreCase("Tata") || search.equalsIgnoreCase("Maruti Suzuki")) {
			return (List<CarDetails>) carDao.findByCompany(search);
		}
		if (search.equalsIgnoreCase("BMW 6520") || search.equalsIgnoreCase("All New City ZX")
				|| search.equalsIgnoreCase("XUV700") || search.equalsIgnoreCase("Nexon")
				|| search.equalsIgnoreCase("Vitara Brezza") || search.equalsIgnoreCase("Safari"))
//				|| search.equalsIgnoreCase("Brezza") || search.equalsIgnoreCase("Toyota Hybrid Electric")
//				|| search.equalsIgnoreCase("Swift Desire")) 
		{
			return (List<CarDetails>) carDao.findByName(search);
		}
		return null;
	}
}
