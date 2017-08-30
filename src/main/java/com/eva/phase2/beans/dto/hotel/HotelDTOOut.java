package com.eva.phase2.beans.dto.hotel;

import java.util.List;

import com.eva.phase2.entity.Room;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelDTOOut {
	@JsonProperty(value = "hotel_id")
	private Long id;

	private String name;

	private String address;

	private String email;

	private String phone;

	@JsonProperty(value = "image")
	private String imagePath;

	List<Room> rooms;

	public HotelDTOOut() {
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

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}