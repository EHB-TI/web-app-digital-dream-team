package com.ehb.student.plates.web.requests;

import com.ehb.student.plates.annotations.validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class CreateUserRequest implements Serializable {

    @NotBlank(message = "Username must not be blank")
    private String username;

    @NotBlank(message = "First Name must not be blank")
    private String firstName;

    @NotBlank(message = "Last Name must not be blank")
    private String lastName;

    @Email(message = "Email Address is not valid")
    private String email;

    @ValidPassword
    private String password;

    @NotBlank(message = "Street must not be blank")
    private String street;

    @NotBlank(message = "House Number must not be blank")
    private String number;

    @NotBlank(message = "Postal Code must not be blank")
    private String postalCode;

    @NotBlank(message = "City must not be blank")
    private String city;
}
