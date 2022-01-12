package com.fpt.hotel.owner.service;

import com.fpt.hotel.model.Room;
import com.fpt.hotel.owner.dto.response.RoomResponse;

import java.util.List;

public interface IRoomService {
    List<RoomResponse> findAll(Long id);

    RoomResponse save(Room room);

}
