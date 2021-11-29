package com.ehb.student.plates.web.requests.plate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreatePlateRequest implements Serializable {

    @NotNull(message = "title must be provided")
    @NotBlank(message = "title must not be blank")
    private String title;

    private String description;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @NotNull(message = "startPickupTime must be provided")
    private LocalDateTime startPickupTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @NotNull(message = "endPickupTime must be provided")
    private LocalDateTime endPickupTime;

    @NotNull(message = "portionsAvailable must be provided")
    private Integer portionsAvailable;
}
