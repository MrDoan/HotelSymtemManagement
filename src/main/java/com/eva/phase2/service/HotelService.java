package com.eva.phase2.service;

import java.util.List;

import com.eva.phase2.entity.Hotel;
import com.eva.phase2.entity.Room;

public interface HotelService {
	List<Hotel> getHotels() throws Exception;

	Hotel getHotelById(long hotelId) throws Exception;

	void insertHotel(Hotel hotel) throws Exception;

	void updateHotel(Hotel hotel) throws Exception;

	void deleteHotelById(long hotelId) throws Exception;

	List<Room> getRoomsByHotel(long hotelId) throws Exception;

	Hotel getByEmail(String hotelEmail) throws Exception;
}
