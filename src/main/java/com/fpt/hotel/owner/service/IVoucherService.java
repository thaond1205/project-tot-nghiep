package com.fpt.hotel.owner.service;

import java.util.List;

import com.fpt.hotel.model.Voucher;
import com.fpt.hotel.owner.dto.response.VoucherResponse;


public interface IVoucherService {
	  List<VoucherResponse> findAll();
	  VoucherResponse save(Voucher voucher);
}
