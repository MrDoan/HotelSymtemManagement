package org.eva.hotel.beans;

import org.eva.hotel.beans.dto.HotelDTO;
import org.eva.hotel.entity.Hotel;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelDetailResponseBean extends ResponseBean {

	@JsonProperty(value = "hotel")
	private HotelDTO responseData;

	public HotelDetailResponseBean() {
	}

	public HotelDetailResponseBean(Hotel hotel) {
		setResponseData(hotel);
	}

	public HotelDTO getResponseData() {
		return responseData;
	}

	public void setResponseData(Hotel hotel) {
		HotelDTO hotelDto = new HotelDTO();
		BeanUtils.copyProperties(hotel, hotelDto);
		this.responseData = hotelDto;
	}

}
