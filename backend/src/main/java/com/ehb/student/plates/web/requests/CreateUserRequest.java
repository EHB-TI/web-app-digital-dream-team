package com.ehb.student.plates.web.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class CreateUserRequest implements Serializable {

    @NotBlank(message = "username must not be blank")
    private String username;

    @NotBlank(message = "firstName must not be blank")
    private String firstName;

    @NotBlank(message = "lastName must not be blank")
    private String lastName;

    @Email(message = "email is not valid")
    private String email;

    @NotBlank(message = "password must not be blank")
    private String password;

    @NotBlank(message = "street must not be blank")
    private String street;

    @NotBlank(message = "number must not be blank")
    private String number;

    @NotBlank(message = "postalCode must not be blank")
    private String postalCode;

    @NotBlank(message = "city must not be blank")
    private String city;
}
