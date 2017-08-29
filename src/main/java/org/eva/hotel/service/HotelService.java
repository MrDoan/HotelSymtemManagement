package org.eva.hotel.service;

import java.util.List;

import org.eva.hotel.entity.Hotel;
import org.eva.hotel.entity.Room;

public interface HotelService {
	List<Hotel> getHotels();

	Hotel getHotelById(long hotelId);

	void insertHotel(Hotel hotel);

	void updateHotel(Hotel hotel);

	void deleteHotelById(long hotelId);

	List<Room> getRoomsByHotel(long hotelId);


}
