package com.ehb.student.plates.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "plates")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Plate extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_pickup_time")
    private LocalDateTime startPickupTime;

    @Column(name = "end_pickup_time")
    private LocalDateTime endPickupTime;

    @Column(name = "portions_available")
    private int portionsAvailable;

    @OneToOne
    @JoinColumn(name = "created_user_id")
    private User createdUser;

    @OneToMany(mappedBy = "plate")
    private List<PlateOrder> orders;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Date modifiedAt;
}
