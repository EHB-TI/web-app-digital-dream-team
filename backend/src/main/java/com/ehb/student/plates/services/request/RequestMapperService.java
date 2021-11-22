package com.ehb.student.plates.services.request;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RequestMapperService extends AbstractRequestMapperService {

    @Autowired
    public RequestMapperService(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
