package com.ehb.student.plates.services.plate;

import com.ehb.student.plates.entities.Plate;
import com.ehb.student.plates.entities.PlateOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlateService {

    Plate getPlateById(Long id);

    Page<Plate> getPlates(Pageable pageable);

    Page<Plate> getPlatesByCreatedUserId(Long id, Pageable pageable);

    Plate createPlate(Plate plate);

    Plate updatePlate(Plate plate);

    Plate updatePlatesLeft(Plate plate);

    void deletePlate(Long id);

    List<PlateOrder> getPlateOrdersByPlateId(Long plateId);

    PlateOrder createPlateOrder(PlateOrder plateOrder);

    PlateOrder updatePlateOrder(PlateOrder plateOrder);

    void deletePlateOrder(Long id);
}
