package com.eva.phase2.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.eva.phase2.entity.Hotel;
import com.eva.phase2.entity.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.eva.phase2.repository.HotelRepository;
import com.eva.phase2.repository.RoomRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class HotelRepositoryImpl implements HotelRepository {

	static Logger log = LoggerFactory.getLogger(HotelRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private RoomRepository roomRepository;

	public HotelRepositoryImpl() {
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public RoomRepository getRoomRepository() {
		return roomRepository;
	}

	public void setRoomRepository(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	@Override
	public Hotel getById(long id) throws Exception {
		return entityManager.find(Hotel.class, Long.valueOf(id));
	}

	@Override
	public List<Hotel> getAll() throws Exception {
		String query = "FROM Hotel";
		List<Hotel> resultList = entityManager.createQuery(query).getResultList();
		return resultList;
	}

	@Override
	public void insert(Hotel hotel) throws Exception {
		entityManager.persist(hotel);
		try {
			entityManager.persist(hotel);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Hotel hotel) throws Exception {
		Hotel oldHotel = getById(hotel.getId());
		if (oldHotel != null) {
			BeanUtils.copyProperties(hotel, oldHotel);
			entityManager.flush();
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		Hotel hotel = getById(id);
		if (hotel != null) {
			entityManager.remove(hotel);
		}
	}

	@Override
	public List<Room> getRoom(long hotelId) throws Exception {
		return roomRepository.getByHotelId(hotelId);
	}

	@Override
	public Hotel getByEmail(String hotelEmail) throws Exception {
		try {
			String query = "FROM Hotel ht WHERE ht.email = ?";
			Hotel hotel = (Hotel) entityManager.createQuery(query).setParameter(1, hotelEmail).getSingleResult();
			return hotel;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
}