package com.fpt.hotel.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String numberRoom;

    private String status;

    private Boolean enabled;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id_type_room")
    private Type_room typeRoom;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;
}
