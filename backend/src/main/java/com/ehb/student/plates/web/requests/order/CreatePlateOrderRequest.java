package com.ehb.student.plates.web.requests.order;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreatePlateOrderRequest implements Serializable {

    private Long plateId;

    @NotNull(message = "pickupTime must be provided")
    private LocalDateTime pickupTime;
}
