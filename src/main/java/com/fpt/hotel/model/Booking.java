package com.fpt.hotel.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Date create_date;

    private double deposit_price;

    private String full_name;

    private String email;

    private String phone;

    private double deposit;

    private int id_card;

    private String status;

    private double discount;

    private Long id_user;

    private Long id_voucher;

    @OneToMany(mappedBy = "booking")
    private List<Booking_checkin_checkout> checkinCheckouts;

    @OneToMany(mappedBy = "id_booking")
    private List<Transaction_Info> id_transaction_info;

    private Long id_hotel;

    private Double totalPrice;

    private Integer totalPeoples;

    @OneToMany(mappedBy = "booking")
    private List<BookingUtility> bookingUtilities;
}
