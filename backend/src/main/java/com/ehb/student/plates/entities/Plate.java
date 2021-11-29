package com.ehb.student.plates.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "plates")
@Getter
@Setter
public class Plate extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_pickup_time")
    private Date startPickupTime;

    @Column(name = "end_pickup_time")
    private Date endPickupTime;

    @Column(name = "portions_available")
    private int portionsAvailable;

    @OneToOne
    private User createdUser;

    @OneToMany(mappedBy = "plate")
    private List<PlateOrder> orders;
}
