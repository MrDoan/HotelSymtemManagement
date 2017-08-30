package org.eva.hotel.beans.hotel;

import java.util.ArrayList;
import java.util.List;

import org.eva.hotel.beans.ResponseBean;
import org.eva.hotel.beans.dto.hotel.HotelDTOOut;
import org.eva.hotel.entity.Hotel;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListHotelResponseBean extends ResponseBean {
	@JsonProperty(value = "hotels")
	private List<HotelDTOOut> hotelList;

	public ListHotelResponseBean() {
		hotelList = new ArrayList<HotelDTOOut>();
	}

	public ListHotelResponseBean(String status, List<String> message) {
		super(message, status);
	}

	public ListHotelResponseBean(List<Hotel> hotels, String status, List<String> message) {
		super(message, status);
		hotelList = new ArrayList<HotelDTOOut>();
		for (Hotel hotel : hotels) {
			HotelDTOOut dtoOut = new HotelDTOOut();
			BeanUtils.copyProperties(hotel, dtoOut);
			hotelList.add(dtoOut);
		}
	}

	public List<HotelDTOOut> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<HotelDTOOut> hotelList) {
		this.hotelList = hotelList;
	}


}
