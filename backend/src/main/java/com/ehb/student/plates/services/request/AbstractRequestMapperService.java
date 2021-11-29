package com.ehb.student.plates.services.request;

import com.ehb.student.plates.entities.Plate;
import com.ehb.student.plates.web.dto.PlateDTO;
import com.ehb.student.plates.web.requests.plate.CreatePlateRequest;
import org.modelmapper.ModelMapper;

public abstract class AbstractRequestMapperService {

    private final ModelMapper modelMapper;

    protected AbstractRequestMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T, S> T basicMap(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }

    public abstract Plate mapToEntity(CreatePlateRequest request);

    public abstract PlateDTO mapToDTO(Plate plate);
}
