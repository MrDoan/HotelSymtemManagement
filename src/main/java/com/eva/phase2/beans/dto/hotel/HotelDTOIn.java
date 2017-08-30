package com.eva.phase2.beans.dto.hotel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelDTOIn {
	@JsonProperty(value = "hotel_id")
	private Long id;

	private String name;

	private String address;

	private String email;

	private String phone;

	private String description;

	@JsonProperty(value = "image_path")
	private String imagePath;

	public HotelDTOIn() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}