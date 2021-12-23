package com.ehb.student.plates.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "plate_order")
@EntityListeners(AuditingEntityListener.class)
public class PlateOrder extends AbstractEntity {

    @ManyToOne
    private User user;

    @ManyToOne
    private Plate plate;

    @Column(name = "pickup_time")
    private LocalDateTime pickupTime;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Date modifiedAt;
}
