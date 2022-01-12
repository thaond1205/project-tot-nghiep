package com.fpt.hotel.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "vourcher_types")
public class VoucherType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private String description;

    @OneToMany(mappedBy = "voucherType")
    private List<Voucher> vouchers;
}
