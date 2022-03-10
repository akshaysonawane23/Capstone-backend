package com.te.cardemo.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Car_Details")
public class CarDetails implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String company;

	private String fuelType;

	private boolean powerSteering;

	private String breakSystem;

	private Double showroomPrice;

	private Double onroadPrice;

	@Column(name = "image_url")
	private String imageURL;

	private Double mileage;

	private int seatingCapacity;

	private int engineCapacity;

	private String gearType;

	private String adminName;


	
	@ManyToOne()
	@JoinColumn(name = "admin_fk", referencedColumnName = "id")
	@JsonIgnore
	private AdminDetails adminFk;

	
	
	public CarDetails(int id, String name, String company, String fuelType, boolean powerSteering, String breakSystem,
			Double showroomPrice, Double onroadPrice, String imageURL, Double mileage, int seatingCapacity,
			int engineCapacity, String gearType, String adminName, AdminDetails adminFk) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.fuelType = fuelType;
		this.powerSteering = powerSteering;
		this.breakSystem = breakSystem;
		this.showroomPrice = showroomPrice;
		this.onroadPrice = onroadPrice;
		this.imageURL = imageURL;
		this.mileage = mileage;
		this.seatingCapacity = seatingCapacity;
		this.engineCapacity = engineCapacity;
		this.gearType = gearType;
		this.adminName = adminName;
		this.adminFk = adminFk;
	}

	public CarDetails() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public boolean isPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(boolean powerSteering) {
		this.powerSteering = powerSteering;
	}

	public String getBreakSystem() {
		return breakSystem;
	}

	public void setBreakSystem(String breakSystem) {
		this.breakSystem = breakSystem;
	}

	public Double getShowroomPrice() {
		return showroomPrice;
	}

	public void setShowroomPrice(Double showroomPrice) {
		this.showroomPrice = showroomPrice;
	}

	public Double getOnroadPrice() {
		return onroadPrice;
	}

	public void setOnroadPrice(Double onroadPrice) {
		this.onroadPrice = onroadPrice;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public String getGearType() {
		return gearType;
	}

	public void setGearType(String gearType) {
		this.gearType = gearType;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public AdminDetails getAdminFk() {
		return adminFk;
	}

	public void setAdminFk(AdminDetails adminFk) {
		this.adminFk = adminFk;
	}

	@Override
	public String toString() {
		return "CarDetails [id=" + id + ", name=" + name + ", company=" + company + ", fuelType=" + fuelType
				+ ", powerSteering=" + powerSteering + ", breakSystem=" + breakSystem + ", showroomPrice="
				+ showroomPrice + ", onroadPrice=" + onroadPrice + ", imageURL=" + imageURL + ", mileage=" + mileage
				+ ", seatingCapacity=" + seatingCapacity + ", engineCapacity=" + engineCapacity + ", gearType="
				+ gearType + ", adminName=" + adminName + ", adminFk=" + adminFk + "]";
	}
	
	
}
