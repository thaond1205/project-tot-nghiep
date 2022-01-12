package com.fpt.hotel.payload.response;

import com.fpt.hotel.user.dto.response.UtilityResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingUtilityResponse {
    private Long id;

    private String description;

    private Long idBooking;

    private UtilityResponse utility;
}
