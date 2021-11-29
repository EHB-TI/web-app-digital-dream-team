package com.ehb.student.plates.repositories;

import com.ehb.student.plates.entities.PlateOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlateOrderRepository extends JpaRepository<PlateOrder, Long> {

    List<PlateOrder> getPlateOrdersByPlateId(Long plateId);
}
