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

    @NotNull(message = "title must be provided")
    @NotBlank(message = "title must not be blank")
    private String title;

    private String description;

    @NotNull(message = "startPickupTime must be provided")
    private Date startPickupTime;

    @NotNull(message = "endPickupTime must be provided")
    private Date endPickupTime;

    @NotNull(message = "portionsAvailable must be provided")
    private Integer portionsAvailable;
}
