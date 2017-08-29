package org.eva.hotel.service.impl;

import java.util.List;

import org.eva.hotel.entity.Hotel;
import org.eva.hotel.entity.Room;
import org.eva.hotel.repository.HotelRepository;
import org.eva.hotel.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {

	private static final Logger log = LoggerFactory.getLogger(HotelServiceImpl.class);

	@Autowired
	HotelRepository hotelRepository;

	@Override
	public List<Hotel> getHotels() {
		try {
			return hotelRepository.getAll();
		}
		catch (Exception e) {
			log.error("Exception at HotelServiceImpl " + e.getMessage());
		}
		return null;
	}

	@Override
	public Hotel getHotelById(long hotelId) {
		try {
			return hotelRepository.getById(hotelId);
		}
		catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public void insertHotel(Hotel hotel) {
		try {
			hotelRepository.insert(hotel);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public void updateHotel(Hotel hotel) {
	}

	@Override
	public void deleteHotelById(long hotelId) {
	}

	@Override
	public List<Room> getRoomsByHotel(long hotelId) {
		return null;
	}

}
