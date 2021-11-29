package com.ehb.student.plates.services.plate;

import com.ehb.student.plates.entities.Plate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlateService {

    Plate getPlateById(Long id);

    Page<Plate> getPlates(Pageable pageable);

    Page<Plate> getPlatesByCreatedUserId(Long id, Pageable pageable);

    Plate createPlate(Plate plate);

    Plate updatePlate(Plate plate);

    void deletePlate(Long id);
}
