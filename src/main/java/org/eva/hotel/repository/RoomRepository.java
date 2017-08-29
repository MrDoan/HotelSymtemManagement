package org.eva.hotel.repository;

import java.util.List;

import org.eva.hotel.entity.Room;

public interface RoomRepository {
	List<Room> getByHotelId(long hotelId) throws Exception;
}
