package com.eva.phase2.beans.hotel;

import java.util.List;

import com.eva.phase2.beans.ResponseBean;

public class UpdateHotelResponseBean extends ResponseBean {
	private String id;

	public UpdateHotelResponseBean() {
	}

	public UpdateHotelResponseBean(String status, List<String> message, String hotelId) {
		super(message, status);
		this.id = hotelId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
