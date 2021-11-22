package com.ehb.student.plates.web.requests.plate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePlateRequest extends CreatePlateRequest {

    private Integer id;
}
