package com.eva.phase2.service;

import com.eva.phase2.entity.Room;

public interface RoomService {

	Room getRoomById(long roomId) throws Exception;

	void insertRoom(Room room) throws Exception;

	void updateRoom(Room room) throws Exception;

	void deleteRoomById(long roomId) throws Exception;

	Room getByRoomNumber(Long roomNumber) throws Exception;
}
