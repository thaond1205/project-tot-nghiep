package com.fpt.hotel.controllers;

import com.fpt.hotel.model.Utility;
import com.fpt.hotel.payload.response.ResponseObject;
import com.fpt.hotel.payload.response.UtilityResponse;
import com.fpt.hotel.repository.UtilityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/utilities")
public class UtilityController {

    @Autowired
    UtilityRepository utilityRepository;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getAll(@PathVariable("id") Long id) {

//         List<UtilityDTO>  utilityDTOS = utilityRepository.findAll().stream().map(
//                utility -> modelMapper.map(utility , UtilityDTO.class)).collect(Collectors.toList());
        Utility utility = utilityRepository.findById(id).get();
        UtilityResponse utilityDTO = modelMapper.map(utility, UtilityResponse.class);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("ok", "Trả về dữ liệu tiện ích thành công", utilityDTO));
    }
}
