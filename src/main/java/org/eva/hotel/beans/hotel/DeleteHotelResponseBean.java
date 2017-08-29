package org.eva.hotel.beans.hotel;

import java.util.List;

import org.eva.hotel.beans.ResponseBean;

public class DeleteHotelResponseBean extends ResponseBean {
	public DeleteHotelResponseBean() {

	}

	public DeleteHotelResponseBean(String status, List<String> message) {
		super(message, status);
	}
}
