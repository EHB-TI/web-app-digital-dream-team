package com.ehb.student.plates.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "plate_order")
public class PlateOrder extends AbstractEntity {

    @ManyToOne
    private User user;

    @ManyToOne
    private Plate plate;

    @Column(name = "pickup_time")
    private LocalDateTime pickupTime;
}
