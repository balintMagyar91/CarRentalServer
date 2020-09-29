package com.maba.carrentalserver.service;

import com.maba.carrentalserver.entity.Car;
import com.maba.carrentalserver.entity.Client;
import com.maba.carrentalserver.entity.Rent;

import java.util.List;

public interface CarRentalService {

    List<Car> findAllCars();
    List<Client> findAllClients();
    List<Rent> findAllRents();
    List<Rent> listActiveRents();
    List<Rent> listInActiveRents();
    List<Rent> listByCarPlate(String carPlate);
    List<Rent> listByClientId(long clientId);

    Car addNewCar(Car car);
    Car updateCar(Car car);
    Car deleteCar(int id);

    Client addNewClient(Client client);
    Client updateClient(Client client);
    Client deleteClient(int id);

    Rent addNewRent(Rent rent);
    Rent updateRent(Rent rent);
    Rent deleteRent(int id);
}
