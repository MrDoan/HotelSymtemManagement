package com.eva.phase2.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eva.phase2.entity.Room;
import com.eva.phase2.repository.RoomRepository;
import com.eva.phase2.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	private static final Logger log = LoggerFactory.getLogger(HotelServiceImpl.class);

	@Autowired
	RoomRepository roomRepository;

	@Override
	public Room getRoomById(long roomId) throws Exception {
		try {
			return roomRepository.getById(roomId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public void insertRoom(Room room) throws Exception {
		try {
			roomRepository.insert(room);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}

	}

	@Override
	public void updateRoom(Room room) throws Exception {
		try {
			roomRepository.update(room);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public void deleteRoomById(long roomId) throws Exception {
		try {
			roomRepository.deleteById(roomId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public Room getByRoomNumber(Long roomNumber) throws Exception {
		try {
			return roomRepository.getByRoomNumber(roomNumber);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

}
