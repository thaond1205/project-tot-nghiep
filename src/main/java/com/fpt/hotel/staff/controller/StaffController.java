package com.fpt.hotel.staff.controller;

import com.fpt.hotel.model.Booking;
import com.fpt.hotel.model.Transaction_Info;
import com.fpt.hotel.payload.response.ResponseObject;
import com.fpt.hotel.repository.BookingRepository;
import com.fpt.hotel.repository.TransactionInfoRepository;
import com.fpt.hotel.repository.UserRepository;
import com.fpt.hotel.staff.dto.request.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasRole('STAFF')")
public class StaffController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionInfoRepository transactionInfoRepository;


    @PostMapping("api/confirm-booking")
    public ResponseEntity<ResponseObject> confirmBooking(@RequestBody TransactionRequest transactionRequest) {
        List<Booking> bookings = bookingRepository.listBookingByIdUser(
                transactionRequest.getId_user(), transactionRequest.getId_hotel());
        Booking booking = bookings.get(0);
        String newStatus = "Đã checkin";
        booking.setStatus(newStatus);
        Booking newBooking = bookingRepository.save(booking);

        if (newBooking.getStatus() == newStatus) {
            Transaction_Info transaction_info = new Transaction_Info();
            transaction_info.setId_booking(newBooking);
            transaction_info.setId_creator(userRepository.findById(transactionRequest.getId_creator()).get());
            transaction_info.setStatus(newStatus);
            transaction_info.setTotal_price(booking.getTotalPrice());
            Transaction_Info transactionInfoResp =  transactionInfoRepository.save(transaction_info);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(HttpStatus.OK.toString(), "Tạo hóa đơn thành công", transactionInfoResp));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject(HttpStatus.BAD_REQUEST.toString(), "Tạo hóa đơn thất bại", null));
    }

}
