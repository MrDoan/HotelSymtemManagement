package com.eva.phase2.beans.hotel;

import java.util.List;

import com.eva.phase2.beans.ResponseBean;
import com.eva.phase2.beans.dto.hotel.HotelDTOOut;

public class GetHotelResponseBean extends ResponseBean {

	private HotelDTOOut hotel;

	public GetHotelResponseBean() {
	}

	public GetHotelResponseBean(List<String> message, String status) {
		super(message, status);
		hotel = new HotelDTOOut();
	}

	public GetHotelResponseBean(HotelDTOOut hotel, List<String> message, String status) {
		super(message, status);
		this.hotel = hotel;
	}

	public HotelDTOOut getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTOOut hotel) {
		this.hotel = hotel;
	}

}