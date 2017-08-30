package com.eva.phase2.repository;

import java.util.List;

import com.eva.phase2.entity.Room;

public interface RoomRepository {
	List<Room> getByHotelId(long hotelId) throws Exception;

	Room getById(long roomId) throws Exception;
	
	void insert(Room room) throws Exception;

	void update(Room room) throws Exception;

	void deleteById(long id) throws Exception;
	
	Room getByRoomNumber(Long roomNumber) throws Exception;
}
