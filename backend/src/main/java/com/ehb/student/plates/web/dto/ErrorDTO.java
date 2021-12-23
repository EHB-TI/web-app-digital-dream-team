package com.ehb.student.plates.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ErrorDTO implements Serializable {

    private HttpStatus status;

    private List<String> errors;

    public ErrorDTO(HttpStatus status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public ErrorDTO(HttpStatus status, String error) {
        this.status = status;
        this.errors = Arrays.asList(error);
    }
}
