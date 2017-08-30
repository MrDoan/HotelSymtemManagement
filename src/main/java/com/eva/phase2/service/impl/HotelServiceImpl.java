package com.eva.phase2.service.impl;

import java.util.List;

import com.eva.phase2.entity.Hotel;
import com.eva.phase2.entity.Room;
import com.eva.phase2.repository.HotelRepository;
import com.eva.phase2.service.HotelService;
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
	public List<Hotel> getHotels() throws Exception {
		try {
			return hotelRepository.getAll();
		} catch (Exception e) {
			log.error("Exception at HotelServiceImpl " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Hotel getHotelById(long hotelId) throws Exception {
		try {
			return hotelRepository.getById(hotelId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public void insertHotel(Hotel hotel) throws Exception {
		try {
			hotelRepository.insert(hotel);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public void updateHotel(Hotel hotel) throws Exception {
		try {
			hotelRepository.update(hotel);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public void deleteHotelById(long hotelId) throws Exception {
		try {
			hotelRepository.deleteById(hotelId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Room> getRoomsByHotel(long hotelId) throws Exception {
		try {
			return hotelRepository.getRoom(hotelId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public Hotel getByEmail(String hotelEmail) throws Exception {
		try {
			return hotelRepository.getByEmail(hotelEmail);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

}