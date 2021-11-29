package com.ehb.student.plates.web.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class CreateUserRequest implements Serializable {

    @NotNull(message = "username must be provided")
    @NotBlank(message = "username must not be blank")
    private String username;

    @NotNull(message = "firstName must be provided")
    @NotBlank(message = "firstName must not be blank")
    private String firstName;

    @NotNull(message = "lastName must be provided")
    @NotBlank(message = "lastName must not be blank")
    private String lastName;

    @Email(message = "email is not valid")
    private String email;

    @NotNull(message = "password must be provided")
    @NotBlank(message = "password must not be blank")
    private String password;

    @NotNull(message = "street must be provided")
    @NotBlank(message = "street must not be blank")
    private String street;

    @NotNull(message = "number must be provided")
    @NotBlank(message = "number must not be blank")
    private String number;

    @NotNull(message = "postalCode must be provided")
    @NotBlank(message = "postalCode must not be blank")
    private String postalCode;

    @NotNull(message = "city must be provided")
    @NotBlank(message = "city must not be blank")
    private String city;
}
