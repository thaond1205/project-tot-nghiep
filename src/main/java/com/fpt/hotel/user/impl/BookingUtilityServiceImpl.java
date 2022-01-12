package com.fpt.hotel.user.impl;

import com.fpt.hotel.model.*;
import com.fpt.hotel.payload.response.BookingUtilityResponse;
import com.fpt.hotel.repository.BookingRepository;
import com.fpt.hotel.repository.BookingUtilityRepository;
import com.fpt.hotel.repository.TransactionInfoRepository;
import com.fpt.hotel.repository.UtilityRepository;
import com.fpt.hotel.user.dto.request.BookingUtilityRequest;
import com.fpt.hotel.user.dto.request.UtilityRequest;
import com.fpt.hotel.user.service.BookingUtilityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingUtilityServiceImpl implements BookingUtilityService {

    @Autowired
    BookingUtilityRepository bookingUtilityRepository;

    @Autowired
    UtilityRepository utilityRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    TransactionInfoRepository transactionInfoRepository;

    @Override
    public List<BookingUtilityResponse> createBookingUtility(BookingUtilityRequest bookingUtilityRequest) {
        // lấy id từ request
        Long idBooking = bookingUtilityRequest.getIdBooking();
        Booking booking = bookingRepository.findById(idBooking).get();

        // tạo đối tượng transaction_info
        Transaction_Info transactionInfo = transactionInfoRepository.findByIdBooking(idBooking);
        double tongTien = transactionInfo.getTotal_price();
        List<UtilityRequest> utilityRequests = bookingUtilityRequest.getUtilityRequests();
        List<BookingUtility> bookingUtilities = new ArrayList<>();

        for (UtilityRequest utility : utilityRequests) {
            // tạo đối tượng BookingUtility và lưu vào db
            BookingUtility bookingUtility = new BookingUtility();
            bookingUtility.setDescription(bookingUtilityRequest.getDescription());
            bookingUtility.setBooking(booking);
            Utility newUtility = utilityRepository.findById(utility.getId()).get();
            bookingUtility.setUtility(newUtility);
            bookingUtilityRepository.save(bookingUtility);

            List<DetailUtility> detailUtilities = newUtility.getDetailUtilities();

            for (DetailUtility detailUtility : detailUtilities) {
                Integer quantity =  utility.getQuantity() == null ? 1 : utility.getQuantity();
                double tongTienDichVu = detailUtility.getPrice() * quantity;
                tongTien += tongTienDichVu;
            }
            bookingUtilities.add(bookingUtility);
        }

        transactionInfo.setTotal_price(tongTien);
        transactionInfoRepository.save(transactionInfo);

        return bookingUtilities.stream().map(
                item -> modelMapper.map(item, BookingUtilityResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookingUtilityResponse> findAll() {
        return bookingUtilityRepository.findAll().stream().map(
                bookingUtility -> modelMapper.map(bookingUtility, BookingUtilityResponse.class)).collect(Collectors.toList());
    }
}
