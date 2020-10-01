package com.maba.carrentalserver.repository;

import com.maba.carrentalserver.entity.Car;
import com.maba.carrentalserver.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Integer> {

    @Query("SELECT r FROM Rent r WHERE r.carId = :carId and r.endDate = null")
    Rent findActiveRentByCarId(@Param("carId") Integer carId);

    @Query("SELECT r FROM Rent r WHERE r.carId = :carId and r.endDate = null")
    boolean existsActiveRentByCarId(@Param("carId") Car carId);

    @Query("SELECT r FROM Rent r WHERE r.endDate = null")
    List<Rent> findActiveRents();

    @Query("SELECT r FROM Rent r WHERE r.endDate != null")
    List<Rent> findInActiveRents();

}
