package com.ehb.student.plates.exceptions;

public class VerificationTokenInvalidException extends RuntimeException {

    public VerificationTokenInvalidException(String msg) {
        super(msg);
    }
}
