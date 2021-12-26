package com.ehb.student.plates.web.controllers.exceptionhandlers;

import com.ehb.student.plates.exceptions.EntityNotFoundException;
import com.ehb.student.plates.exceptions.InvalidParameterException;
import com.ehb.student.plates.exceptions.UnauthorizedActionException;
import com.ehb.student.plates.exceptions.VerificationTokenInvalidException;
import com.ehb.student.plates.web.dto.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Stream<String> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> String.format("%s: %s", e.getField(), e.getDefaultMessage()));

        Stream<String> globalErrors = ex.getBindingResult().getGlobalErrors().stream()
                .map(e -> String.format("%s: %s", e.getObjectName(), e.getDefaultMessage()));

        ErrorDTO errorDTO = new ErrorDTO(
                HttpStatus.BAD_REQUEST,
                Stream.concat(fieldErrors, globalErrors).collect(Collectors.toList())
        );

        return handleExceptionInternal(ex, errorDTO, headers, errorDTO.getStatus(), request);
    }

    @ExceptionHandler({InvalidParameterException.class, VerificationTokenInvalidException.class})
    public ResponseEntity<Object> handleInvalidParameterException(Exception ex) {
        return createResponseFromExceptionMessage(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        return createResponseFromExceptionMessage(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({UnauthorizedActionException.class})
    public ResponseEntity<Object> handleUnauthorizedActionException(UnauthorizedActionException ex) {
        return createResponseFromExceptionMessage(ex, HttpStatus.UNAUTHORIZED);
    }

    private ResponseEntity<Object> createResponseFromExceptionMessage(Exception ex, HttpStatus status) {
        ErrorDTO errorDTO = new ErrorDTO(status, ex.getMessage());
        return new ResponseEntity<>(errorDTO, null, status);
    }
}
