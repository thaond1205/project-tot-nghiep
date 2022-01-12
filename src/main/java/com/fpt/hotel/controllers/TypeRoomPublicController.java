package com.fpt.hotel.controllers;

import com.fpt.hotel.model.TypeRoomImage;
import com.fpt.hotel.model.Type_room;
import com.fpt.hotel.repository.TypeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TypeRoomPublicController {

    @Autowired
    TypeRoomRepository typeRoomRepository;

    @GetMapping("api/user/typeroom")
    public List<TypeRoomImage> roomList () {
        return typeRoomRepository.findById(8L).get().getTypeRoomImages();
    }
}
