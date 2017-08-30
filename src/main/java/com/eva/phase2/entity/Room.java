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
	private int id;

	@Column(name = "hotel_id")
	private long hotelId;

	@Column(name = "room_number")
	private long roomNumber;

	@Column(name = "room_name")
	private long roomName;

	@Column(name = "description")
	private String desription;

	@Column(name = "room_area")
	private long roomArea;

	@Column(name = "number_of_beds")
	private long numOfBed;

	@Column(name = "number_of_adults")
	private long numOfAdult;

	@Column(name = "number_of_children")
	private long numOfChildren;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	public long getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(long roomNumber) {
		this.roomNumber = roomNumber;
	}

	public long getRoomName() {
		return roomName;
	}

	public void setRoomName(long roomName) {
		this.roomName = roomName;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public long getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(long roomArea) {
		this.roomArea = roomArea;
	}

	public long getNumOfBed() {
		return numOfBed;
	}

	public void setNumOfBed(long numOfBed) {
		this.numOfBed = numOfBed;
	}

	public long getNumOfAdult() {
		return numOfAdult;
	}

	public void setNumOfAdult(long numOfAdult) {
		this.numOfAdult = numOfAdult;
	}

	public long getNumOfChildren() {
		return numOfChildren;
	}

	public void setNumOfChildren(long numOfChildren) {
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

	@Override
	public String toString() {
		return "Room [id=" + id + ", hotelId=" + hotelId + ", roomNumber=" + roomNumber + ", roomName=" + roomName
				+ ", desription=" + desription + ", roomArea=" + roomArea + ", numOfBed=" + numOfBed + ", numOfAdult="
				+ numOfAdult + ", numOfChildren=" + numOfChildren + ", price=" + price + ", imagePath=" + imagePath
				+ ", active=" + active + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", lastModifiedBy="
				+ lastModifiedBy + ", lastModifiedOn=" + lastModifiedOn + "]";
	}

}
