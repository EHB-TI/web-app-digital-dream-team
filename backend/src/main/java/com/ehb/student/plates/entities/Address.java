package com.ehb.student.plates.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address extends AbstractEntity {

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "city")
    private String city;
}
