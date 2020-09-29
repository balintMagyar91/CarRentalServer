package com.maba.carrentalserver.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RENTID")
    private long rentId;

    @Column(name="CARID")
    private int carId;

    @Column(name="CLIENTID")
    private int clientId;

    @Column(name="STARTDATE")
    private LocalDate startDate;

    @Column(name="PLANNEDENDDATE")
    private LocalDate plannedEndDate;

    @Column(name="ENDDATE")
    private LocalDate endDate;

    public long getRentId() {
        return rentId;
    }

    public void setRentId(long rentId) {
        this.rentId = rentId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
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
