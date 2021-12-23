package com.ehb.student.plates.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    private final Class<?> entityClass;

    private final String id;

    public EntityNotFoundException(Class<?> entityClass, String id) {
        this.entityClass = entityClass;
        this.id = id;
    }

    public EntityNotFoundException(Class<?> entityClass, Number id) {
        this.entityClass = entityClass;
        this.id = String.valueOf(id);
    }

    @Override
    public String getMessage() {
        return String.format("Can't find %s with identifier %s", entityClass.getSimpleName(), id);
    }
}
