package com.ehb.student.plates.web.controllers;

import com.ehb.student.plates.entities.Plate;
import com.ehb.student.plates.services.plate.PlateService;
import com.ehb.student.plates.services.request.AbstractRequestMapperService;
import com.ehb.student.plates.web.requests.plate.CreatePlateRequest;
import com.ehb.student.plates.web.requests.plate.UpdatePlateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/plates")
public class PlateController {

    private final PlateService plateService;

    private final AbstractRequestMapperService requestMapper;

    @Autowired
    public PlateController(PlateService plateService, AbstractRequestMapperService requestMapper) {
        this.plateService = plateService;
        this.requestMapper = requestMapper;
    }

    @GetMapping
    public Page<Plate> getPlates(Pageable pageable) {
        return plateService.getPlates(pageable);
    }

    @GetMapping(path = "/{id}")
    public Plate getPlate(@PathVariable Long id) {
        return plateService.getPlateById(id);
    }

    @PostMapping
    public Plate createPlate(@RequestBody @Valid CreatePlateRequest request) {
        return plateService.createPlate(requestMapper.basicMap(request, Plate.class));
    }

    @PutMapping(path = "/{id}")
    public Plate updatePlate(@PathVariable Integer id, @RequestBody @Valid UpdatePlateRequest request) {
        request.setId(id);
        return plateService.updatePlate(requestMapper.basicMap(request, Plate.class));
    }

    @DeleteMapping(path = "/{id}")
    public void deletePlate(@PathVariable Long id) {
        plateService.deletePlate(id);
    }
}
