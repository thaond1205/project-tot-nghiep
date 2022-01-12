package com.fpt.hotel.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Utilities")
public class Utility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String utilityName;

    private String image;

    @ManyToOne
    @JoinColumn(name = "typeUtility")
    private TypeUtility typeUtility;

    @OneToMany(mappedBy = "utility")
    private List<DetailUtility> detailUtilities;

    @OneToMany(mappedBy = "utility")
    private List<BookingUtility> bookingUtilities;

}
