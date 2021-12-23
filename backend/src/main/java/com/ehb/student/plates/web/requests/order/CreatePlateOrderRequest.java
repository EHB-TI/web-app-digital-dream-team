package com.ehb.student.plates.web.requests.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreatePlateOrderRequest implements Serializable {

    private Long plateId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @NotNull(message = "pickupTime must be provided")
    private LocalDateTime pickupTime;
}
