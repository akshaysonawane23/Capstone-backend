
package com.te.cardemo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.cardemo.dao.AdminDao;
import com.te.cardemo.dao.CarDetailsDao;
import com.te.cardemo.dto.AdminDetails;
import com.te.cardemo.dto.CarDetails;
import com.te.cardemo.dto.MyAdminDetails;
import com.te.cardemo.util.JwtUtil;

@Service
public class AdminServiceImpl implements UserDetailsService, AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private CarDetailsDao carDao;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdminDetails adminDetails = adminDao.findByUsername(username);
		if (adminDetails != null) {
			return new MyAdminDetails(adminDetails);
		} else {
			throw new UsernameNotFoundException("Username not Found for " + username);
		}
	}

	@Override
	public AdminDetails adminDetails(String name) {
		return adminDao.findByUsername(name);
	}

	@Override
	public AdminDetails saveSignupData(AdminDetails adminDetails) {
		return adminDao.save(adminDetails);
	}

	@Override
	public List<CarDetails> getAllCarDetails(HttpServletRequest request) {
		String tokenHeader = request.getHeader("Authorization");
		String token = tokenHeader.substring(7);
		String adminName = jwtUtil.extractUsername(token);
		return carDao.findByAdminName(adminName);
	}

	@Override
	public CarDetails addCarDetails(CarDetails carDetails, HttpServletRequest request) {
		String tokenHeader = request.getHeader("Authorization");
		String token = tokenHeader.substring(7);

		String adminName = jwtUtil.extractUsername(token);
		AdminDetails adminDetails = adminDao.findByUsername(adminName);

		double exactOnroadPrice = 0;
		if (carDetails.getFuelType().equals("Electric")) {
			exactOnroadPrice = (double) carDetails.getShowroomPrice() * 1.04;
		} else if (carDetails.getShowroomPrice() < 500000) {
			exactOnroadPrice = (double) carDetails.getShowroomPrice() * 1.13;
		} else if (carDetails.getShowroomPrice() > 500000 && carDetails.getShowroomPrice() < 1000000) {
			exactOnroadPrice = (double) carDetails.getShowroomPrice() * 1.14;
		} else if (carDetails.getShowroomPrice() > 1000000 && carDetails.getShowroomPrice() < 2000000) {
			exactOnroadPrice = (double) carDetails.getShowroomPrice() * 1.17;
		} else if (carDetails.getShowroomPrice() > 2000000) {
			exactOnroadPrice = (double) carDetails.getShowroomPrice() * 1.18;
		}

		carDetails.setAdminName(adminName);
		carDetails.setOnroadPrice(exactOnroadPrice);
		carDetails.setAdminFk(adminDetails);
		return carDao.save(carDetails);
	}

	@Override
	public CarDetails updateCarDetails(CarDetails carDetails, HttpServletRequest request, int carId) {

		carDetails.setId(carId);
		String tokenHeader = request.getHeader("Authorization");
		String token = tokenHeader.substring(7);

		String adminName = jwtUtil.extractUsername(token);
		AdminDetails adminDetails = adminDao.findByUsername(adminName);

		double exactOnroadPrice = 0;
		if (carDetails.getFuelType().equals("Electric")) {
			exactOnroadPrice = (double) carDetails.getShowroomPrice() * 1.04;
		} else if (carDetails.getShowroomPrice() < 500000) {
			exactOnroadPrice = (double) carDetails.getShowroomPrice() * 1.13;

		} else if (carDetails.getShowroomPrice() > 500000 && carDetails.getShowroomPrice() < 1000000) {
			exactOnroadPrice = (double) carDetails.getShowroomPrice() * 1.14;
		} else if (carDetails.getShowroomPrice() > 1000000 && carDetails.getShowroomPrice() < 2000000) {
			exactOnroadPrice = (double) carDetails.getShowroomPrice() * 1.17;
		} else if (carDetails.getShowroomPrice() > 2000000) {
			exactOnroadPrice = (double) carDetails.getShowroomPrice() * 1.18;
		}

		carDetails.setAdminName(adminName);
		carDetails.setOnroadPrice(exactOnroadPrice);
		carDetails.setAdminFk(adminDetails);
		return carDao.save(carDetails);
	}

	@Override
	public boolean deleteCarDetails(int carId) {
		CarDetails carDetails = carDao.findById(carId);
		if (carDetails != null) {
			carDao.deleteById(carId);
			return true;
		} else
			return false;
	}

	@Override
	public boolean checkIfUsernameExists(String username) {
		return adminDao.findByUsername(username) != null ? true : false;
	}

}