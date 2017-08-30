package com.eva.phase2.beans.hotel;

import java.util.List;

import com.eva.phase2.beans.ResponseBean;

public class DeleteHotelResponseBean extends ResponseBean {
	public DeleteHotelResponseBean() {

	}

	public DeleteHotelResponseBean(String status, List<String> message) {
		super(message, status);
	}
}