package com.ehb.student.plates.repositories;

import com.ehb.student.plates.entities.Plate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlateRepository extends JpaRepository<Plate, Long> {
}
