package com.fpt.hotel.user.controller;

import com.fpt.hotel.payload.response.BookingUtilityResponse;
import com.fpt.hotel.payload.response.ResponseObject;
import com.fpt.hotel.user.dto.request.BookingUtilityRequest;
import com.fpt.hotel.user.service.BookingUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/booking-utilities")
@PreAuthorize("isAuthenticated()")
public class BookingUtilityController {

    @Autowired
    BookingUtilityService bookingUtilityService;


    @GetMapping("")
    public ResponseEntity<ResponseObject> getAll() {

        List<BookingUtilityResponse> utilityDTOS = bookingUtilityService.findAll();

        if (utilityDTOS.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseObject(HttpStatus.NOT_FOUND.toString(), "Không có dữ liệu!", utilityDTOS));
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("ok", "Trả về dữ liệu dịch vụ thành công", utilityDTOS));
    }

    @PostMapping
    public ResponseEntity<ResponseObject> createBookingUtility(@RequestBody BookingUtilityRequest bookingUtility) {

        List<BookingUtilityResponse> bookingUtilityDTOS = bookingUtilityService.createBookingUtility(bookingUtility);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("ok", "Đặt dịch vụ phòng thành công", bookingUtilityDTOS));
    }
}
