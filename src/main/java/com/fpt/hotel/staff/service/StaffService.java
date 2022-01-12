package com.fpt.hotel.staff.service;

import com.fpt.hotel.model.Transaction_Info;
import com.fpt.hotel.staff.dto.request.TransactionRequest;

public interface StaffService {

    Transaction_Info confirmBooking(TransactionRequest transactionRequest);
}
