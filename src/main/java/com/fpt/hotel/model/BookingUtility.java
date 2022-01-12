package com.fpt.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "booking_utilities")
public class BookingUtility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_booking")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "id_utility")
    private Utility utility;

    private String description;

}
