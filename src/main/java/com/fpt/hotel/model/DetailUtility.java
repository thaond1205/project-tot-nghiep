package com.fpt.hotel.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "detail_utilities")
public class DetailUtility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "id_utility")
    private Utility utility;

    @ManyToOne
    @JoinColumn(name = "id_type_room")
    private Type_room typeRoom;

    private Double price;

}
