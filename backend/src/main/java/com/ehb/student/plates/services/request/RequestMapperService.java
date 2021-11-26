package com.ehb.student.plates.services.request;

import com.ehb.student.plates.entities.Plate;
import com.ehb.student.plates.entities.User;
import com.ehb.student.plates.services.user.UserService;
import com.ehb.student.plates.web.dto.PlateDTO;
import com.ehb.student.plates.web.dto.UserDTO;
import com.ehb.student.plates.web.requests.plate.CreatePlateRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class RequestMapperService extends AbstractRequestMapperService {

    private final UserService userService;

    @Autowired
    public RequestMapperService(ModelMapper modelMapper, UserService userService) {
        super(modelMapper);
        this.userService = userService;
    }

    @Override
    public Plate mapToEntity(CreatePlateRequest request) {
        Plate plate = basicMap(request, Plate.class);
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        plate.setCreatedUser((User) userService.loadUserByUsername(username));
        return plate;
    }

    @Override
    public PlateDTO mapToDTO(Plate plate) {
        PlateDTO dto = basicMap(plate, PlateDTO.class);
        dto.setCreatedUser(basicMap(plate.getCreatedUser(), UserDTO.class));
        return dto;
    }

}
