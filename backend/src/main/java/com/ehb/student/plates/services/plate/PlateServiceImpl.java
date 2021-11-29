package com.ehb.student.plates.services.plate;

import com.ehb.student.plates.entities.Plate;
import com.ehb.student.plates.entities.PlateOrder;
import com.ehb.student.plates.exceptions.EntityNotFoundException;
import com.ehb.student.plates.exceptions.UnauthorizedActionException;
import com.ehb.student.plates.repositories.PlateOrderRepository;
import com.ehb.student.plates.repositories.PlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlateServiceImpl implements PlateService {

    private final PlateRepository plateRepository;

    private final PlateOrderRepository plateOrderRepository;

    @Autowired
    public PlateServiceImpl(PlateRepository plateRepository, PlateOrderRepository plateOrderRepository) {
        this.plateRepository = plateRepository;
        this.plateOrderRepository = plateOrderRepository;
    }

    @Override
    public Plate getPlateById(Long id) {
        return plateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Plate.class, id));
    }

    @Override
    public Page<Plate> getPlates(Pageable pageable) {
        return plateRepository.findAll(pageable);
    }

    @Override
    public Page<Plate> getPlatesByCreatedUserId(Long id, Pageable pageable) {
        return plateRepository.getPlatesByCreatedUserId(id, pageable);
    }

    @Override
    public Plate createPlate(Plate plate) {
        return plateRepository.save(plate);
    }

    @Override
    public Plate updatePlate(Plate plate) {
        Plate repoPlate = plateRepository.findById(plate.getId())
                .orElseThrow(() -> new EntityNotFoundException(Plate.class, plate.getId()));

        plate.setCreatedUser(repoPlate.getCreatedUser());
        if (isUsernameDifferentFromLoggedInUser(repoPlate.getCreatedUser().getUsername())) {
            throw new UnauthorizedActionException("Cannot modify a plate that was not made by the user");
        }

        return plateRepository.save(plate);
    }

    @Override
    public void deletePlate(Long id) {
        Plate plate = plateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Plate.class, id));

        if (isUsernameDifferentFromLoggedInUser(plate.getCreatedUser().getUsername())) {
            throw new UnauthorizedActionException("Cannot delete a plate that was not made by the user");
        }

        plateRepository.deleteById(id);
    }

    @Override
    public List<PlateOrder> getPlateOrdersByPlateId(Long plateId) {
        return plateOrderRepository.getPlateOrdersByPlateId(plateId);
    }

    @Override
    public PlateOrder createPlateOrder(PlateOrder plateOrder) {
        return plateOrderRepository.save(plateOrder);
    }

    @Override
    public PlateOrder updatePlateOrder(PlateOrder plateOrder) {
        PlateOrder repoOrder = plateOrderRepository.findById(plateOrder.getId())
                .orElseThrow(() -> new EntityNotFoundException(Plate.class, plateOrder.getId()));

        if (isUsernameDifferentFromLoggedInUser(repoOrder.getUser().getUsername())) {
            throw new UnauthorizedActionException("Cannot modify an order that was not made by the user");
        }

        return plateOrderRepository.save(plateOrder);
    }

    @Override
    public void deletePlateOrder(Long id) {
        PlateOrder plateOrder = plateOrderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Plate.class, id));

        if (isUsernameDifferentFromLoggedInUser(plateOrder.getUser().getUsername())) {
            throw new UnauthorizedActionException("Cannot delete an order that was not made by the user");
        }

        plateOrderRepository.deleteById(id);
    }

    private boolean isUsernameDifferentFromLoggedInUser(String username) {
        String authUsername = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return !username.equals(authUsername);
    }
}
