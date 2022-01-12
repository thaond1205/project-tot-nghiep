package com.fpt.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "transaction_infos")
public class Transaction_Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Date date_release;

    private double total_price;

    @ManyToOne
    @JoinColumn(name = "id_booking")
    private Booking id_booking;

    @ManyToOne
    @JoinColumn(name = "id_creator")
    private User id_creator;

    private String status;

    private String description;
}
