package org.eva.hotel.repository;

import java.util.List;

import org.eva.hotel.entity.Hotel;
import org.eva.hotel.entity.Room;

public interface HotelRepository {
	Hotel getById(long id) throws Exception;

	List<Hotel> getAll() throws Exception;

	void insert(Hotel hotel) throws Exception;

	void update(Hotel hotel) throws Exception;

	void deleteById(long id) throws Exception;

	List<Room> getRoom(long hotelId) throws Exception;

	Hotel getByEmail(String hotelEmail) throws Exception;
}
