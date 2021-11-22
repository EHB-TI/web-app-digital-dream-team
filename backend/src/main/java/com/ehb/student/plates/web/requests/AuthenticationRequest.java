package com.ehb.student.plates.web.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class AuthenticationRequest implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
