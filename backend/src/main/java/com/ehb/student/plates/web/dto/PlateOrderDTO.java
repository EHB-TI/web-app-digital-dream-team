package com.ehb.student.plates.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class PlateOrderDTO implements Serializable {

    private Long id;

    private UserDTO user;

    private PlateDTO plate;

    private LocalDateTime pickupTime;
}
