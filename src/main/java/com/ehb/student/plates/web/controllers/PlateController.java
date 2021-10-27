package com.ehb.student.plates.web.controllers;

import com.ehb.student.plates.services.plate.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlateController {

    private PlateService plateService;

    @Autowired
    public PlateController(PlateService plateService) {
        this.plateService = plateService;
    }
}
