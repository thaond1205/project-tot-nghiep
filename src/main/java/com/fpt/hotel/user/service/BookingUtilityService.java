package com.fpt.hotel.user.service;

import com.fpt.hotel.payload.response.BookingUtilityResponse;
import com.fpt.hotel.user.dto.request.BookingUtilityRequest;

import java.util.List;

public interface BookingUtilityService {

    List<BookingUtilityResponse> createBookingUtility(BookingUtilityRequest bookingUtility);

    List<BookingUtilityResponse> findAll();
}
