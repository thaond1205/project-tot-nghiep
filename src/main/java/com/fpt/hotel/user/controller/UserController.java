package com.fpt.hotel.user.controller;

import com.fpt.hotel.model.Booking;
import com.fpt.hotel.payload.response.ResponseObject;
import com.fpt.hotel.repository.BookingRepository;
import com.fpt.hotel.user.dto.response.BookingResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@PreAuthorize("isAuthenticated()")
public class UserController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ModelMapper modelMapper;


    @GetMapping("{id}")
    public ResponseEntity<ResponseObject> getAll(@PathVariable ( "id") Long id) {

        List<Booking> findAll = bookingRepository.findById_user(id);

        if(findAll.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseObject(HttpStatus.NOT_FOUND.toString(), "Không có dữ liệu", findAll));
        }

        List<BookingResponse> bookingResponses = findAll.stream().map
                (booking -> modelMapper.map(booking, BookingResponse.class)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("ok", "Trả về dữ liệu danh sách đặt phòng thành công", bookingResponses));
    }

}
