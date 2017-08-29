package org.eva.hotel.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.eva.hotel.entity.Hotel;
import org.eva.hotel.entity.Room;
import org.eva.hotel.repository.HotelRepository;
import org.eva.hotel.repository.RoomRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class HotelRepositoryImpl implements HotelRepository {

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

}
