package com.fpt.hotel.staff.impl;

import com.fpt.hotel.model.Transaction_Info;
import com.fpt.hotel.staff.dto.request.TransactionRequest;
import com.fpt.hotel.staff.service.StaffService;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    @Override
    public Transaction_Info confirmBooking(TransactionRequest transactionRequest) {
        return null;
    }
}
