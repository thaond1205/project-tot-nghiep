package com.fpt.hotel.owner.impl;

import com.fpt.hotel.model.Room;
import com.fpt.hotel.owner.dto.response.RoomResponse;
import com.fpt.hotel.owner.service.IRoomService;
import com.fpt.hotel.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<RoomResponse> findAll(Long id ) {
       return roomRepository.findAll(id).stream().map(
               room -> modelMapper.map(room , RoomResponse.class)).collect(Collectors.toList());
    }

    @Override
    public RoomResponse save(Room room) {

        boolean check = roomRepository.existsByNumberRoom(room.getNumberRoom());
        if(check){
            return null;
        }

        Room newRoom = roomRepository.save(room);
        return modelMapper.map(newRoom, RoomResponse.class);
    }
}
