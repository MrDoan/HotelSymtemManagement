package org.eva.hotel.beans;

import java.util.ArrayList;
import java.util.List;

import org.eva.hotel.beans.dto.HotelDTO;
import org.eva.hotel.entity.Hotel;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelListResponseBean extends ResponseBean {
	@JsonProperty(value = "hotels")
	private List<HotelDTO> responseData;

	public HotelListResponseBean() {

	}

	public HotelListResponseBean(List<Hotel> hotels) {
		this();
		setResponseData(hotels);
	}

	public List<HotelDTO> getResponseData() {
		return responseData;
	}

	public void setResponseData(List<Hotel> hotels) {
		responseData = new ArrayList<>();
		for (Hotel hotel : hotels) {
			HotelDTO hotelDto = new HotelDTO();
			BeanUtils.copyProperties(hotel, hotelDto);
			responseData.add(hotelDto);
		}
	}
}
