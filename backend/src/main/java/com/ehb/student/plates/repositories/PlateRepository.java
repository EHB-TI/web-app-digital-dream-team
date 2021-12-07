package com.ehb.student.plates.repositories;

import com.ehb.student.plates.entities.Plate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlateRepository extends JpaRepository<Plate, Long> {

    @Query("SELECT plate FROM Plate plate WHERE plate.createdUser.username=:username")
    List<Plate> getPlatesByCreatedUsername(String username);

    @Query(value = "SELECT plate FROM Plate plate WHERE plate.createdUser.id=:id",
            countQuery = "SELECT COUNT(plate) FROM Plate plate WHERE plate.createdUser.id=:id"
    )
    Page<Plate> getPlatesByCreatedUserId(Long id, Pageable pageable);
}
