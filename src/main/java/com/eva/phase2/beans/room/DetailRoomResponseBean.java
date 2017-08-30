package com.eva.phase2.beans.room;

import java.util.List;

import com.eva.phase2.beans.ResponseBean;
import com.eva.phase2.beans.dto.room.RoomDTOOut;

public class DetailRoomResponseBean extends ResponseBean {

	private RoomDTOOut room;

	public DetailRoomResponseBean() {
	}

	public DetailRoomResponseBean(List<String> message, String status) {
		super(message, status);
		room = new RoomDTOOut();
	}

	public DetailRoomResponseBean(RoomDTOOut room, List<String> message, String status) {
		super(message, status);
		this.room = room;
	}

	public RoomDTOOut getRoom() {
		return room;
	}

	public void setRoom(RoomDTOOut room) {
		this.room = room;
	}

}
