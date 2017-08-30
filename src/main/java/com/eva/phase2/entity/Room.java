package com.eva.phase2.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "hotel_id")
	private Long hotelId;

	@Column(name = "room_number")
	private Long roomNumber;

	@Column(name = "room_name")
	private String roomName;

	@Column(name = "description")
	private String description;

	@Column(name = "room_area")
	private Long roomArea;

	@Column(name = "number_of_beds")
	private Long numOfBed;

	@Column(name = "number_of_adults")
	private Long numOfAdult;

	@Column(name = "number_of_children")
	private Long numOfChildren;

	@Column(name = "price")
	private String price;

	@Column(name = "image_path")
	private String imagePath;

	@Column(name = "active")
	private boolean active = true;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_on")
	private Timestamp createdOn;

	@Column(name = "last_modified_by")
	private String lastModifiedBy;

	@Column(name = "last_modified_on")
	private Timestamp lastModifiedOn;

	public Room() {
	}

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

	public void setDescription(String desription) {
		this.description = desription;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Timestamp getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Timestamp lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

}
