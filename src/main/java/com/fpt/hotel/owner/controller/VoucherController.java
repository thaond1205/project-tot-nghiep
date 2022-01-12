package com.fpt.hotel.owner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.hotel.model.Voucher;
import com.fpt.hotel.owner.dto.response.VoucherResponse;
import com.fpt.hotel.owner.service.IVoucherService;
import com.fpt.hotel.payload.response.ResponseObject;

@RestController
@RequestMapping("/api/owner/vouchers")
@PreAuthorize("hasRole('ADMIN')")
@CrossOrigin("*")
public class VoucherController {
	@Autowired
    IVoucherService voucherService;
	
	@GetMapping
	public ResponseEntity<ResponseObject> findAllVoucher(){
		List<VoucherResponse> voucherDTOList =voucherService.findAll();
		if(voucherDTOList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject(HttpStatus.NOT_FOUND.toString(),"Không có voucher nào", voucherDTOList)
					);
			 
		}
		return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(HttpStatus.OK.toString(), "Hiển thi tất cả các voucher!", voucherDTOList)
        );
	}
	
	@PostMapping
    public ResponseEntity<ResponseObject> create(@RequestBody Voucher voucher) {
		VoucherResponse voucherDTO = voucherService.save(voucher);
		if(voucherDTO ==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					 new ResponseObject(HttpStatus.BAD_REQUEST.toString(), "Đã có tên số phòng này!", voucherDTO)
					);
		}
		  return ResponseEntity.status(HttpStatus.OK).body(
	                new ResponseObject(HttpStatus.OK.toString(), "Thêm phòng thành công!", voucherDTO)
	        );
	}
	
	

}
