package org.eva.hotel.beans.hotel;

import java.util.List;

import org.eva.hotel.beans.ResponseBean;
import org.eva.hotel.beans.dto.hotel.HotelDTOOut;

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
