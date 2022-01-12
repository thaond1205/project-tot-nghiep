package com.fpt.hotel.user.dto.response;

import com.fpt.hotel.payload.response.DetaiUtilityResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class    UtilityResponse {
    private String utilityName;

    private String image;

    private List<DetaiUtilityResponse> detailUtilities;
}
