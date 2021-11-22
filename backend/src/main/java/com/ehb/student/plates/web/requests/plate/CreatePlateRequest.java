package com.ehb.student.plates.web.requests.plate;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class CreatePlateRequest implements Serializable {

    @NotBlank(message = "title property missing or empty")
    private String title;

    private String description;

    @NotNull(message = "startPickupTime property missing")
    private Date startPickupTime;

    @NotNull(message = "endPickupTime property missing")
    private Date endPickupTime;

    @NotNull(message = "portionsAvailable property missing")
    private Integer portionsAvailable;
}
