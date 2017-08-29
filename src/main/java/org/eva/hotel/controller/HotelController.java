package org.eva.hotel.controller;

import java.util.List;

import org.eva.hotel.beans.HotelDetailResponseBean;
import org.eva.hotel.beans.HotelListResponseBean;
import org.eva.hotel.beans.ResponseBean;
import org.eva.hotel.beans.SimpleErrorMessage;
import org.eva.hotel.entity.Hotel;
import org.eva.hotel.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {

	private static final Logger log = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	HotelService hotelService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<ResponseBean> getHotels() {
		ResponseBean result = null;

		try {
			List<Hotel> hotels = hotelService.getHotels();
			// TEST CHUC NANG LOI

			//hotels = null;

			if (hotels == null || hotels.isEmpty()) {
				result = new SimpleErrorMessage("Hotel list is empty !");
			}
			else {
				result = new HotelListResponseBean(hotels);
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
			result = new SimpleErrorMessage("Server error");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
	}


	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ResponseEntity<ResponseBean> getHotelById(
			@RequestParam(value = "id", defaultValue = "0") String id) {
		ResponseBean result = null;
		long hotelId = 0;
		try {
			hotelId = Long.valueOf(id);
		}
		catch (NumberFormatException e) {
			log.error(e.getMessage());
			result = new SimpleErrorMessage("Invalid param value id = " + id);
			return new ResponseEntity<ResponseBean>(result, HttpStatus.BAD_REQUEST);
		}

		Hotel hotel = hotelService.getHotelById(hotelId);
		if (hotel == null) {
			result = new SimpleErrorMessage("Cannot find hotel with id = " + id);
		}
		else {
			result = new HotelDetailResponseBean(hotel);
		}

		return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> addHotel() {
		ResponseBean result = null;

		hotelService.insertHotel(new Hotel());

		return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
	}

}
