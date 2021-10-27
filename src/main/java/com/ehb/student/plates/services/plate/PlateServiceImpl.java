package com.ehb.student.plates.services.plate;

import com.ehb.student.plates.entities.Plate;
import com.ehb.student.plates.repositories.PlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlateServiceImpl implements PlateService {

    private PlateRepository plateRepository;

    @Autowired
    public PlateServiceImpl(PlateRepository plateRepository) {
        this.plateRepository = plateRepository;
    }

    @Override
    public Plate getPlateById(Long id) {
        return plateRepository.getById(id);
    }

    @Override
    public Page<Plate> getPlates(Pageable pageable) {
        return plateRepository.findAll(pageable);
    }
}
