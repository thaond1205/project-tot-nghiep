package com.fpt.hotel.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "type_utilities")
public class TypeUtility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeUtilityName;

    @OneToMany(mappedBy = "typeUtility")
    private List<Utility> utilities;
}
