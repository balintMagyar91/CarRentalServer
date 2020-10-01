package com.maba.carrentalserver.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table( name="rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rentId;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car carId;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client clientId;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate plannedEndDate;

    private LocalDate endDate;

    public long getRentId() {
        return rentId;
    }

    public void setRentId(long rentId) {
        this.rentId = rentId;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(LocalDate plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rentId=" + rentId +
                ", carId=" + carId +
                ", clientId=" + clientId +
                ", startDate=" + startDate +
                ", plannedEndDate=" + plannedEndDate +
                ", endDate=" + endDate +
                '}';
    }
}
