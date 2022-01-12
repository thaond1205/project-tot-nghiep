package com.fpt.hotel.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "vouchers")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    @CreationTimestamp
    private Date startTime;

    private Date endTime;

    private String description;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "id_voucher_type")
    private VoucherType voucherType;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
