package com.eva.phase2.controller;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.eva.phase2.beans.ResponseBean;
import com.eva.phase2.beans.dto.hotel.HotelDTOIn;
import com.eva.phase2.beans.dto.hotel.HotelDTOOut;
import com.eva.phase2.beans.hotel.AddHotelResponseBean;
import com.eva.phase2.beans.hotel.DeleteHotelResponseBean;
import com.eva.phase2.beans.hotel.GetHotelResponseBean;
import com.eva.phase2.beans.hotel.ListHotelResponseBean;
import com.eva.phase2.beans.hotel.UpdateHotelResponseBean;
import com.eva.phase2.entity.Hotel;
import com.eva.phase2.service.HotelService;
import com.eva.phase2.util.ValidationUtil;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/hotel")
public class HotelController {

	private static final Logger log = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	HotelService hotelService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<ResponseBean> getHotels() {
		ResponseBean result = null;

		try {
			List<Hotel> hotels = hotelService.getHotels();
			result = new ListHotelResponseBean(hotels, "success", Arrays.asList("Get list of hotel successly!"));
		}
		catch (Exception e) {
			log.error(e.getMessage());
			result = new ListHotelResponseBean("500",
					Arrays.asList("500 Internal Server Error", e.getMessage()));
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
			Hotel hotel = hotelService.getHotelById(hotelId);
			
			HotelDTOOut hotelDTOOut = new HotelDTOOut();
			BeanUtils.copyProperties(hotel, hotelDTOOut);
			hotelDTOOut.setRooms(hotelService.getRoomsByHotel(hotelId));
			result = new GetHotelResponseBean(hotelDTOOut, Arrays.asList("Get detail of hotel successly!"), "success");

			return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
		}
		catch (NumberFormatException e) {
			log.error(e.getMessage());
			result = new ListHotelResponseBean("400",
					Arrays.asList("Bad Request", "Invalid request parameter value for id = " + id));
			return new ResponseEntity<ResponseBean>(result, HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			log.error(e.getMessage());
			result = new GetHotelResponseBean(Arrays.asList(e.getMessage()),
					"500 Internal Server Error");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> addHotel(@RequestBody HotelDTOIn hotelInfo) {
		ResponseBean result = null;

		List<String> validationError = ValidationUtil.isValidHotelInfo(hotelInfo);
		if (!validationError.isEmpty()) {
			result = new AddHotelResponseBean(hotelInfo, validationError, "fail");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.BAD_REQUEST);
		}

		try {
			validationError = ValidationUtil.isValidHotelInfo(hotelInfo, hotelService.getByEmail(hotelInfo.getEmail()));
			if (!validationError.isEmpty()) {
				result = new AddHotelResponseBean(hotelInfo, validationError, "OK");
				return new ResponseEntity<ResponseBean>(result, HttpStatus.BAD_REQUEST);
			}
			Hotel hotel = new Hotel();

			BeanUtils.copyProperties(hotelInfo, hotel);

			hotel.setActive(true);
			hotel.setCreatedBy("TinDT");
			hotel.setCreatedOn(new Timestamp(new Date().getTime()));
			hotel.setLastModifiedOn(hotel.getCreatedOn());
			hotel.setLastModifiedBy(hotel.getCreatedBy());

			hotelService.insertHotel(hotel);

			result = new UpdateHotelResponseBean("success", Arrays.asList("insert hotel successly!"), hotel.getId().toString());

			return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
		}
		catch (Exception e) {
			result = new AddHotelResponseBean(null, Arrays.asList(e.getMessage()),
					"500 Internal Server Error");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> deleteHotel(@RequestBody HotelDTOIn hotelInfo) {
		ResponseBean result = null;

		try {
			long id = hotelInfo.getId();
			hotelService.deleteHotelById(id);

			result = new DeleteHotelResponseBean("success", Arrays.asList("Delete hotel successly!"));
			return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
		}

		catch (NumberFormatException e) {
			log.error(e.getMessage());
			String errorMessage = "Invalid hotelID: " + hotelInfo.getId();
			result = new DeleteHotelResponseBean("400 Bad Request", Arrays.asList(errorMessage));
			return new ResponseEntity<ResponseBean>(result, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {
			log.error(e.getMessage());
			//
			result = new DeleteHotelResponseBean("500 Internal Server Error",
					Arrays.asList(e.getMessage()));
			return new ResponseEntity<ResponseBean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> updateHotel(@RequestBody HotelDTOIn hotelInfo) {
		ResponseBean result = null;

		List<String> validationMessage = ValidationUtil.isValidHotelInfo(hotelInfo);
		if (!validationMessage.isEmpty()) {
			HotelDTOOut hotelDTOOut = new HotelDTOOut();
			BeanUtils.copyProperties(hotelInfo, hotelDTOOut);
			result = new GetHotelResponseBean(hotelDTOOut, validationMessage, "400 Bad Request");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.BAD_REQUEST);
		}

		try {
			Hotel hotel = new Hotel();

			BeanUtils.copyProperties(hotelInfo, hotel);
			hotel.setActive(true);
			hotel.setLastModifiedBy("TinDT");
			hotel.setLastModifiedOn(new Timestamp(new Date().getTime()));
			hotelService.updateHotel(hotel);

			result = new UpdateHotelResponseBean("success", Arrays.asList("update hotel successly!"), hotel.getId().toString());

			return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
		}
		catch (Exception e) {
			result = new UpdateHotelResponseBean("500 Internal Server Error",
					Arrays.asList(e.getMessage()), hotelInfo.getId().toString());
			return new ResponseEntity<ResponseBean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}