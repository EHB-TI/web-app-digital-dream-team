package com.ehb.student.plates.web.controllers;

import com.ehb.student.plates.entities.Plate;
import com.ehb.student.plates.entities.PlateOrder;
import com.ehb.student.plates.services.plate.PlateService;
import com.ehb.student.plates.services.request.AbstractRequestMapperService;
import com.ehb.student.plates.web.dto.PlateDTO;
import com.ehb.student.plates.web.dto.PlateOrderDTO;
import com.ehb.student.plates.web.requests.order.CreatePlateOrderRequest;
import com.ehb.student.plates.web.requests.plate.CreatePlateRequest;
import com.ehb.student.plates.web.requests.plate.UpdatePlateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class PlateController {

    private final PlateService plateService;

    private final AbstractRequestMapperService requestMapper;

    @Autowired
    public PlateController(PlateService plateService, AbstractRequestMapperService requestMapper) {
        this.plateService = plateService;
        this.requestMapper = requestMapper;
    }

    @GetMapping("/plates")
    public Page<PlateDTO> getPlates(Pageable pageable) {
        return plateService.getPlates(pageable).map(requestMapper::mapToDTO);
    }

    @GetMapping(path = "/plates/{id}")
    public PlateDTO getPlate(@PathVariable Long id) {
        return requestMapper.mapToDTO(plateService.getPlateById(id));
    }

    @GetMapping(path = "users/{id}/plates")
    public Page<PlateDTO> getPlatesByUserId(@PathVariable Long id, Pageable pageable) {
        return plateService.getPlatesByCreatedUserId(id, pageable).map(requestMapper::mapToDTO);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(path = "/plates")
    public PlateDTO createPlate(@RequestBody @Valid CreatePlateRequest request) {
        Plate plate = requestMapper.mapToEntity(request);
        return requestMapper.mapToDTO(plateService.createPlate(plate));
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping(path = "/plates/{id}")
    public PlateDTO updatePlate(@PathVariable Integer id, @RequestBody @Valid UpdatePlateRequest request) {
        Plate plate = requestMapper.mapToEntity(request);
        request.setId(id);
        return requestMapper.mapToDTO(plateService.updatePlate(plate));
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping(path = "/plates/{id}")
    public void deletePlate(@PathVariable Long id) {
        plateService.deletePlate(id);
    }

    @GetMapping(path = "plates/{plateId}/orders")
    public List<PlateOrderDTO> getPlateOrders(@PathVariable Long plateId) {
        return plateService.getPlateOrdersByPlateId(plateId).stream()
                .map(requestMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(path = "plates/{plateId}/orders")
    public PlateOrderDTO createPlateOrder(@PathVariable Long plateId, @Valid @RequestBody CreatePlateOrderRequest request) {
        request.setPlateId(plateId);
        PlateOrder plateOrder = requestMapper.mapToEntity(request);
        return requestMapper.mapToDTO(plateService.createPlateOrder(plateOrder));
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping(path = "plates/{plateId}/orders")
    public void deletePlateOrder(@PathVariable Long plateId) {
        plateService.deletePlateOrder(plateId);
    }
}
