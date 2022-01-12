package com.fpt.hotel.staff.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {

    private Integer id_creator;
    private Long id_hotel;
    private Long id_user;
}
