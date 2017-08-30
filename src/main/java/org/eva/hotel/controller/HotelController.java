package org.eva.hotel.controller;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eva.hotel.beans.ResponseBean;
import org.eva.hotel.beans.dto.hotel.HotelDTOIn;
import org.eva.hotel.beans.dto.hotel.HotelDTOOut;
import org.eva.hotel.beans.hotel.AddHotelResponseBean;
import org.eva.hotel.beans.hotel.DeleteHotelResponseBean;
import org.eva.hotel.beans.hotel.GetHotelResponseBean;
import org.eva.hotel.beans.hotel.ListHotelResponseBean;
import org.eva.hotel.beans.hotel.UpdateHotelResponseBean;
import org.eva.hotel.entity.Hotel;
import org.eva.hotel.service.HotelService;
import org.eva.hotel.util.ValidationUtil;
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
			result = new ListHotelResponseBean(hotels, "OK", Arrays.asList("sucess"));
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
			result = new UpdateHotelResponseBean("OK", Arrays.asList("success"), hotel.getEmail());

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

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> addHotel(@RequestBody HotelDTOIn hotelInfo) {
		ResponseBean result = null;

		List<String> validationError = ValidationUtil.isValidHotelInfo(hotelInfo);
		if (!validationError.isEmpty()) {
			result = new AddHotelResponseBean(hotelInfo, validationError, "OK");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.BAD_REQUEST);
		}

		try {

			validationError = ValidationUtil.isValidHotelInfo(hotelInfo,
					hotelService.getByEmail(hotelInfo.getEmail()));
			if (!validationError.isEmpty()) {
				result = new AddHotelResponseBean(hotelInfo, validationError, "OK");
				return new ResponseEntity<ResponseBean>(result, HttpStatus.BAD_REQUEST);
			}

			Hotel hotel = new Hotel();

			BeanUtils.copyProperties(hotelInfo, hotel);

			hotel.setActive(true);
			hotel.setCreatedBy("TinLOZ");
			hotel.setCreatedOn(new Timestamp(new Date().getTime()));
			hotel.setLastModifiedOn(hotel.getCreatedOn());
			hotel.setLastModifiedBy(hotel.getCreatedBy());

			hotelService.insertHotel(hotel);

			result = new UpdateHotelResponseBean("OK", Arrays.asList("sucess"), hotel.getEmail());

			return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
		}
		catch (Exception e) {
			result = new AddHotelResponseBean(hotelInfo, Arrays.asList(e.getMessage()),
					"500 Internal Server Error");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> deleteHotel(@RequestBody String hotelId) {
		ResponseBean result = null;

		try {
			long id = Long.parseLong(hotelId);
			hotelService.deleteHotelById(id);

			result = new DeleteHotelResponseBean("OK", Arrays.asList("success"));
			return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
		}

		catch (NumberFormatException e) {
			log.error(e.getMessage());
			String errorMessage = "Invalid hotelID: " + hotelId;
			result = new DeleteHotelResponseBean("400 Bad Request", Arrays.asList(errorMessage));
			return new ResponseEntity<ResponseBean>(result, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {
			log.error(e.getMessage());
			// Thực tế đék nên show full error mesage ra (e.getMessage(), ko nên show full ra)
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
			hotel.setLastModifiedBy("TinLOZ");
			hotel.setLastModifiedOn(new Timestamp(new Date().getTime()));
			hotelService.updateHotel(hotel);

			result = new UpdateHotelResponseBean("OK", Arrays.asList("sucess"), hotel.getEmail());

			return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
		}
		catch (Exception e) {
			result = new UpdateHotelResponseBean("500 Internal Server Error",
					Arrays.asList(e.getMessage()), hotelInfo.getEmail());
			return new ResponseEntity<ResponseBean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
