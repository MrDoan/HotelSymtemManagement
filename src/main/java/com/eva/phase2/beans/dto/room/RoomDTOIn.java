package com.eva.phase2.beans.dto.room;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomDTOIn {
	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "hotel_id")
	private Long hotelId;

	@JsonProperty(value = "room_number")
	private Long roomNumber;

	@JsonProperty(value = "room_name")
	private String roomName;

	@JsonProperty(value = "description")
	private String description;

	@JsonProperty(value = "room_area")
	private Long roomArea;

	@JsonProperty(value = "number_of_beds")
	private Long numOfBed;

	@JsonProperty(value = "number_of_adults")
	private Long numOfAdult;

	@JsonProperty(value = "number_of_children")
	private Long numOfChildren;

	@JsonProperty(value = "price")
	private String price;

	@JsonProperty(value = "image_path")
	private String imagePath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Long roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(Long roomArea) {
		this.roomArea = roomArea;
	}

	public Long getNumOfBed() {
		return numOfBed;
	}

	public void setNumOfBed(Long numOfBed) {
		this.numOfBed = numOfBed;
	}

	public Long getNumOfAdult() {
		return numOfAdult;
	}

	public void setNumOfAdult(Long numOfAdult) {
		this.numOfAdult = numOfAdult;
	}

	public Long getNumOfChildren() {
		return numOfChildren;
	}

	public void setNumOfChildren(Long numOfChildren) {
		this.numOfChildren = numOfChildren;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
