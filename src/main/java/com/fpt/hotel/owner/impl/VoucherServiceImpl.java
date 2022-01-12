package com.fpt.hotel.owner.impl;

import com.fpt.hotel.model.Voucher;
import com.fpt.hotel.owner.dto.response.VoucherResponse;
import com.fpt.hotel.owner.service.IVoucherService;
import com.fpt.hotel.repository.VoucherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoucherServiceImpl implements IVoucherService {
    @Autowired
    VoucherRepository voucherRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<VoucherResponse> findAll() {

        return voucherRepository.findAll().stream().map(
                voucher -> modelMapper.map(voucher, VoucherResponse.class)).collect(Collectors.toList());
    }

    @Override
    public VoucherResponse save(Voucher voucher) {


        Voucher newVoucher = voucherRepository.save(voucher);
        return modelMapper.map(newVoucher, VoucherResponse.class);
    }

}
