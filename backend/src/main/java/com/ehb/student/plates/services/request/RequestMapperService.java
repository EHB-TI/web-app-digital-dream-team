package com.ehb.student.plates.services.request;

import com.ehb.student.plates.entities.Plate;
import com.ehb.student.plates.entities.PlateOrder;
import com.ehb.student.plates.services.auth.AuthenticationService;
import com.ehb.student.plates.services.plate.PlateService;
import com.ehb.student.plates.web.dto.PlateDTO;
import com.ehb.student.plates.web.dto.PlateOrderDTO;
import com.ehb.student.plates.web.dto.UserDTO;
import com.ehb.student.plates.web.requests.order.CreatePlateOrderRequest;
import com.ehb.student.plates.web.requests.plate.CreatePlateRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestMapperService extends AbstractRequestMapperService {

    private final AuthenticationService authService;
    private final PlateService plateService;

    @Autowired
    public RequestMapperService(ModelMapper modelMapper, AuthenticationService authService, PlateService plateService) {
        super(modelMapper);
        this.authService = authService;
        this.plateService = plateService;
    }

    @Override
    public Plate mapToEntity(CreatePlateRequest request) {
        Plate plate = basicMap(request, Plate.class);
        plate.setCreatedUser(authService.getLoggedInUser());
        return plate;
    }

    @Override
    public PlateOrder mapToEntity(CreatePlateOrderRequest request) {
        PlateOrder plateOrder = basicMap(request, PlateOrder.class);
        plateOrder.setPlate(plateService.getPlateById(request.getPlateId()));
        plateOrder.setUser(authService.getLoggedInUser());
        return plateOrder;
    }

    @Override
    public PlateDTO mapToDTO(Plate plate) {
        PlateDTO dto = basicMap(plate, PlateDTO.class);
        dto.setCreatedUser(basicMap(plate.getCreatedUser(), UserDTO.class));
        return dto;
    }

    @Override
    public PlateOrderDTO mapToDTO(PlateOrder plateOrder) {
        PlateOrderDTO dto = basicMap(plateOrder, PlateOrderDTO.class);
        dto.setUser(basicMap(plateOrder.getUser(), UserDTO.class));
        dto.setPlate(mapToDTO(plateOrder.getPlate()));
        return dto;
    }
}
