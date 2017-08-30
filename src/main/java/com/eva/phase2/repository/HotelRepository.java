package com.eva.phase2.repository;

import java.util.List;

import com.eva.phase2.entity.Hotel;
import com.eva.phase2.entity.Room;

public interface HotelRepository {
	Hotel getById(long id) throws Exception;

	List<Hotel> getAll() throws Exception;

	void insert(Hotel hotel) throws Exception;

	void update(Hotel hotel) throws Exception;

	void deleteById(long id) throws Exception;

	List<Room> getRoom(long hotelId) throws Exception;
	
	Hotel getByEmail(String hotelEmail) throws Exception;

}