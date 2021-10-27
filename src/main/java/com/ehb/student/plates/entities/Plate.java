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

    // String te verplaatsen met User entity wanneer aangemaakt
    private String createdBy;

    // Verwijder @Transient wanneer de User entity is gemaakt, verplaats dan met ManyToMany
    @Transient
    private List<String> pickupUsers;
}
