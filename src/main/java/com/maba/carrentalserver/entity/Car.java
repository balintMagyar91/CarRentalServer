package com.maba.carrentalserver.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.awt.image.BufferedImage;
import java.time.LocalDate;

@Data
@Entity
@Table( name="car",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "carPlate")
        })
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @NotEmpty
    private String carPlate;

    @NotEmpty
    private String brand;

    @NotEmpty
    private String carType;

    @NotNull
    @Min(2000)
    private int vintage;

    private int dailyFee;

    private LocalDate lastServiceDate;

    private boolean isInService;

//    @Column(name = "PHOTO")
//    private BufferedImage photo = null;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getVintage() {
        return vintage;
    }

    public void setVintage(int vintage) {
        this.vintage = vintage;
    }

    public int getDailyFee() {
        return dailyFee;
    }

    public void setDailyFee(int dailyFee) {
        this.dailyFee = dailyFee;
    }

    public LocalDate getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(LocalDate lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public boolean isInService() {
        return isInService;
    }

    public void setInService(boolean inService) {
        isInService = inService;
    }

//    public BufferedImage getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(BufferedImage photo) {
//        this.photo = photo;
//    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carPlate='" + carPlate + '\'' +
                ", brand='" + brand + '\'' +
                ", carType='" + carType + '\'' +
                ", vintage=" + vintage +
                ", dailyFee=" + dailyFee +
                ", lastServiceDate=" + lastServiceDate +
                ", isInService=" + isInService +
//                ", photo=" + photo +
                '}';
    }
}
