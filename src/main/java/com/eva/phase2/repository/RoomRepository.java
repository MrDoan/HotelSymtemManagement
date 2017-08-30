package com.eva.phase2.repository;

import java.util.List;

import com.eva.phase2.entity.Room;

public interface RoomRepository {
	List<Room> getByHotelId(long hotelId) throws Exception;
}
