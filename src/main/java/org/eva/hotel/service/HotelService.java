package org.eva.hotel.service;

import java.util.List;

import org.eva.hotel.entity.Hotel;
import org.eva.hotel.entity.Room;

public interface HotelService {
	List<Hotel> getHotels() throws Exception;

	Hotel getHotelById(long hotelId) throws Exception;

	void insertHotel(Hotel hotel) throws Exception;

	void updateHotel(Hotel hotel) throws Exception;

	void deleteHotelById(long hotelId) throws Exception;

	List<Room> getRoomsByHotel(long hotelId) throws Exception;

	Hotel getByEmail(String hotelEmail) throws Exception;
}
