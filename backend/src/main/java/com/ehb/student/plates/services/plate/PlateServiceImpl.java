package com.ehb.student.plates.services.plate;

import com.ehb.student.plates.entities.Plate;
import com.ehb.student.plates.exceptions.EntityNotFoundException;
import com.ehb.student.plates.repositories.PlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlateServiceImpl implements PlateService {

    private final PlateRepository plateRepository;

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

    @Override
    public Plate createPlate(Plate plate) {
        return plateRepository.save(plate);
    }

    @Override
    public Plate updatePlate(Plate plate) {
        return plateRepository.findById(plate.getId())
                .orElseThrow(() -> new EntityNotFoundException(Plate.class, plate.getId()));
    }

    @Override
    public void deletePlate(Long id) {
        plateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Plate.class, id));

        plateRepository.deleteById(id);
    }
}
