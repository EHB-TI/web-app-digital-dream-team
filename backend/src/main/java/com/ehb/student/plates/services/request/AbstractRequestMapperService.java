package com.ehb.student.plates.services.request;

import org.modelmapper.ModelMapper;

public abstract class AbstractRequestMapperService {

    private final ModelMapper modelMapper;

    protected AbstractRequestMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T, S> T basicMap(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }
}
