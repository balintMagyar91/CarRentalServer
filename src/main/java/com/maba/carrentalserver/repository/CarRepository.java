package com.maba.carrentalserver.repository;

import com.maba.carrentalserver.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findByCarPlate(String carPlate);
    boolean existsByCarPlate(String carPlate);
}
