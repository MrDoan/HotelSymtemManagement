package org.eva.hotel.beans.hotel;

import java.util.List;

import org.eva.hotel.beans.ResponseBean;
import org.eva.hotel.beans.dto.hotel.HotelDTOIn;

/**
 * Return the original request data in case of validation failed or any exceptions caused
 */
public class AddHotelResponseBean extends ResponseBean {
	private HotelDTOIn hotel;

	public AddHotelResponseBean() {

	}

	public AddHotelResponseBean(HotelDTOIn hotelInfo, List<String> message, String status) {
		super(message, status);
		this.hotel = hotelInfo;
	}

	public HotelDTOIn getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTOIn hotel) {
		this.hotel = hotel;
	}

}
