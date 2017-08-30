package com.eva.phase2.beans.room;

import java.util.List;

import com.eva.phase2.beans.ResponseBean;
import com.eva.phase2.beans.dto.room.RoomDTOIn;

public class InsertRoomResponseBean extends ResponseBean {
	private Long id;

	public InsertRoomResponseBean() {

	}

	public InsertRoomResponseBean(Long id, List<String> message, String status) {
		super(message, status);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
