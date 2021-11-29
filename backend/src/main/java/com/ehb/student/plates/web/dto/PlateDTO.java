package com.ehb.student.plates.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class PlateDTO implements Serializable {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime startPickupTime;

    private LocalDateTime endPickupTime;

    private Integer portionsAvailable;

    private UserDTO createdUser;
}
