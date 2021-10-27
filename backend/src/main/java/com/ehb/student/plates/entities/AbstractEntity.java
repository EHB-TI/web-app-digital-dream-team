package com.ehb.student.plates.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "modified_at", nullable = false)
    private Date modifiedAt;
}
