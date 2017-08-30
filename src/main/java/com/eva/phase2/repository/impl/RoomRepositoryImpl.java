package com.eva.phase2.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.eva.phase2.entity.Hotel;
import com.eva.phase2.entity.Room;
import com.eva.phase2.repository.RoomRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class RoomRepositoryImpl implements RoomRepository {

	static final Logger log = LoggerFactory.getLogger(RoomRepositoryImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	public RoomRepositoryImpl() {
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> getByHotelId(long hotelId) throws Exception {
		try {
			String query = "FROM Room r WHERE r.hotelId = ? AND r.active = 1";
			List<Room> result = entityManager.createQuery(query).setParameter(1, Long.valueOf(hotelId)).getResultList();
			return result;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public Room getById(long id) throws Exception {
		return entityManager.find(Room.class, Long.valueOf(id));
	}

	@Override
	public void insert(Room room) throws Exception {
		try {
			entityManager.persist(room);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Room room) throws Exception {
		Room oldRoom = getById(room.getId());
		if (oldRoom != null) {
			BeanUtils.copyProperties(room, oldRoom);
			entityManager.flush();
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		Room room = getById(id);
		if (room != null) {
			entityManager.remove(room);
		}

	}

	@Override
	public Room getByRoomNumber(Long roomNumber) throws Exception {
		try {
			String query = "FROM Room r WHERE r.roomNumber = ?";
			Room room = (Room) entityManager.createQuery(query).setParameter(1, roomNumber).getSingleResult();
			return room;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

}