package org.eva.hotel.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.eva.hotel.entity.Room;
import org.eva.hotel.repository.RoomRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class RoomRepositoryImpl implements RoomRepository {

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


	@Override
	public List<Room> getByHotelId(long hotelId) throws Exception {
		String query = "FROM room r WHERE r.hotel_id = ? ORDER BY r.room_name";
		List<Room> result = entityManager.createQuery(query).setParameter(1,
				Long.valueOf(hotelId)).getResultList();
		return result;
	}

}
