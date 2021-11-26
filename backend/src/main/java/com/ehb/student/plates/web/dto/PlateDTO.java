package com.ehb.student.plates.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class PlateDTO implements Serializable {

    private Long id;

    private String title;

    private String description;

    private Date startPickupTime;

    private Date endPickupTime;

    private Integer portionsAvailable;

    private UserDTO createdUser;
}
