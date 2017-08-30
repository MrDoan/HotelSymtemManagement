package com.eva.phase2.controller;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eva.phase2.beans.ResponseBean;
import com.eva.phase2.beans.dto.hotel.HotelDTOIn;
import com.eva.phase2.beans.dto.hotel.HotelDTOOut;
import com.eva.phase2.beans.dto.room.RoomDTOIn;
import com.eva.phase2.beans.dto.room.RoomDTOOut;
import com.eva.phase2.beans.hotel.AddHotelResponseBean;
import com.eva.phase2.beans.hotel.DeleteHotelResponseBean;
import com.eva.phase2.beans.hotel.GetHotelResponseBean;
import com.eva.phase2.beans.hotel.ListHotelResponseBean;
import com.eva.phase2.beans.hotel.UpdateHotelResponseBean;
import com.eva.phase2.beans.room.DeleteRoomResponseBean;
import com.eva.phase2.beans.room.DetailRoomResponseBean;
import com.eva.phase2.beans.room.InsertRoomResponseBean;
import com.eva.phase2.entity.Hotel;
import com.eva.phase2.entity.Room;
import com.eva.phase2.service.RoomService;
import com.eva.phase2.util.ValidationUtil;

@RestController
@RequestMapping(value = "/api/room")
public class RoomController {

	private static final Logger log = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	RoomService roomService;

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ResponseEntity<ResponseBean> getRoomById(@RequestParam(value = "id", defaultValue = "0") Long roomId) {
		ResponseBean result = null;

		try {
			Room room = roomService.getRoomById(roomId);

			RoomDTOOut roomDTOOut = new RoomDTOOut();
			BeanUtils.copyProperties(room, roomDTOOut);
			result = new DetailRoomResponseBean(roomDTOOut, Arrays.asList("Get detail of room successly!"), "success");

			return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
		} catch (NumberFormatException e) {
			log.error(e.getMessage());
			result = new DetailRoomResponseBean(
					Arrays.asList("Bad Request4444", "Invalid request parameter value for id = " + roomId), "400");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error(e.getMessage());
			result = new DetailRoomResponseBean(Arrays.asList(e.getMessage()), "500 Internal Server Error");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> insertRoom(@RequestBody RoomDTOIn roomInfo) {
		ResponseBean result = null;

		List<String> validationError = ValidationUtil.isValidRoomInfo(roomInfo);
		if (!validationError.isEmpty()) {
			result = new InsertRoomResponseBean(roomInfo.getId(), validationError, "fail");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.BAD_REQUEST);
		}

		try {
			// validationError = ValidationUtil.isValidRoomInfo(roomInfo,
			// roomService.getByRoomNumber(roomInfo.getRoomNumber()));
			// if (!validationError.isEmpty()) {
			// result = new InsertRoomResponseBean(roomInfo, validationError,
			// "OK");
			// return new ResponseEntity<ResponseBean>(result,
			// HttpStatus.BAD_REQUEST);
			// }
			Room room = new Room();

			BeanUtils.copyProperties(roomInfo, room);

			room.setActive(true);
			room.setCreatedBy("TinDT");
			room.setCreatedOn(new Timestamp(new Date().getTime()));
			room.setLastModifiedOn(room.getCreatedOn());
			room.setLastModifiedBy(room.getCreatedBy());

			try {
				roomService.insertRoom(room);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			result = new InsertRoomResponseBean(room.getId(), Arrays.asList("insert room successly!"), "success");

			return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
		} catch (Exception e) {
			result = new InsertRoomResponseBean(null, Arrays.asList(e.getMessage()), "500 Internal Server Error");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> deleteRoom(@RequestBody RoomDTOIn roomInfo) {
		ResponseBean result = null;

		try {
			long id = roomInfo.getId();
			roomService.deleteRoomById(id);

			result = new DeleteRoomResponseBean(Arrays.asList("Delete room successly!"), "success");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
		}

		catch (NumberFormatException e) {
			log.error(e.getMessage());
			String errorMessage = "Invalid RoomID: " + roomInfo.getId();
			result = new DeleteRoomResponseBean(Arrays.asList(errorMessage), "400 Bad Request");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {
			log.error(e.getMessage());
			//
			result = new DeleteRoomResponseBean(Arrays.asList(e.getMessage()), "500 Internal Server Error");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> updateRoom(@RequestBody RoomDTOIn roomInfo) {
		ResponseBean result = null;

		List<String> validationMessage = ValidationUtil.isValidRoomInfo(roomInfo);
		if (!validationMessage.isEmpty()) {
			HotelDTOOut roomDTOOut = new HotelDTOOut();
			BeanUtils.copyProperties(roomInfo, roomDTOOut);
			result = new GetHotelResponseBean(roomDTOOut, validationMessage, "400 Bad Request");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.BAD_REQUEST);
		}

		try {
			Room room = new Room();

			BeanUtils.copyProperties(roomInfo, room);
			room.setActive(true);
			room.setLastModifiedBy("TinDT");
			room.setLastModifiedOn(new Timestamp(new Date().getTime()));
			roomService.updateRoom(room);

			result = new InsertRoomResponseBean(room.getId(), Arrays.asList("update room successly!"), "success");

			return new ResponseEntity<ResponseBean>(result, HttpStatus.OK);
		}
		catch (Exception e) {
			result = new InsertRoomResponseBean(0L, Arrays.asList(e.getMessage()), "500 Internal Server Error");
			return new ResponseEntity<ResponseBean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
