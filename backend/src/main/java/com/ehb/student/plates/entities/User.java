package com.ehb.student.plates.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends AbstractEntity {

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Embedded
    private Address address;

    @Column(name = "password")
    private String password;

    @Column(name = "resetPassword")
    private String resetPassword;

    @Column(name = "emailValidation")
    private String emailValidation;

    @Column(name = "loginAttempts")
    private int loginAttempts;

    @Column(name = "accountEnabled")
    private boolean accountEnabled;

/*
    @Column(name = "createdPlates")
    private List<Plate> createdPlates;

    @Column(name = "pickUpPlates")
    private List<Plate> pickUpPlates;
 */
}
