package com.ehb.student.plates.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    private final Class<?> entityClass;

    private final Number id;

    public EntityNotFoundException(Class<?> entityClass, Number id) {
        this.entityClass = entityClass;
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("Can't find %s with ID %d", entityClass.getSimpleName(), id.longValue());
    }
}
