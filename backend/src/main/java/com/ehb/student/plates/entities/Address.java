package com.ehb.student.plates.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "city")
    private String city;
}
