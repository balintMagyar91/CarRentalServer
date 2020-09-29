package com.maba.carrentalserver.service;

import com.maba.carrentalserver.repository.RepositoryManager;
import com.maba.carrentalserver.entity.Car;
import com.maba.carrentalserver.entity.Client;
import com.maba.carrentalserver.entity.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CarRentalServiceImpl implements CarRentalService{

    @Autowired
    private RepositoryManager rm;

    @Override
    public List<Car> findAllCars() {
        return rm.getCarRepository().findAll();
    }

    @Override
    public List<Client> findAllClients() {
        return rm.getClientRepository().findAll();
    }

    @Override
    public List<Rent> findAllRents() {
        return rm.getRentRepository().findAll();
    }

    @Override
    public List<Rent> listActiveRents() {
        return rm.getRentRepository().findActiveRents();
    }

    @Override
    public List<Rent> listInActiveRents() {
        return rm.getRentRepository().findInActiveRents();
    }

    @Override
    public List<Rent> listByCarPlate(String carPlate) {
        return null;
    }

    @Override
    public List<Rent> listByClientId(long clientId) {
        return null;
    }

    @Override
    public Car addNewCar(Car car) {
        if(!rm.getCarRepository().existsByCarPlate(car.getCarPlate())) {
            return rm.getCarRepository().save(car);
        }else {
            throw new EntityExistsException();
        }
    }

    @Override
    public Car updateCar(Car car) {
        if(rm.getCarRepository().existsById(car.getCarId())) {
            return rm.getCarRepository().save(car);
        }else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Car deleteCar(int id) {
        if(rm.getCarRepository().existsById(id)) {
            Car car = rm.getCarRepository().findById(id).get();
            rm.getCarRepository().deleteById(id);
            return car;
        }else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Client addNewClient(Client client) {
        if(!rm.getClientRepository().existsByEmail(client.getEmail())) {
            return rm.getClientRepository().save(client);
        }else {
            throw new EntityExistsException();
        }
    }

    @Override
    public Client updateClient(Client client) {
        if(rm.getClientRepository().existsById(client.getClientId())) {
            return rm.getClientRepository().save(client);
        }else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Client deleteClient(int id) {
        if(rm.getClientRepository().existsById(id)) {
            Client client = rm.getClientRepository().findById(id).get();
            rm.getClientRepository().deleteById(id);
            return client;
        }else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Rent addNewRent(Rent rent) {
        if(!rm.getRentRepository().existsActiveRentByCarId(rent.getCarId())) {
            rm.getRentRepository().save(rent);
        }else {
            throw new EntityExistsException();
        }
        return null;
    }

    @Override
    public Rent updateRent(Rent rent) {
        return null;
    }

    @Override
    public Rent deleteRent(int id) {
        if(rm.getRentRepository().existsById(id)) {
            Rent rent = rm.getRentRepository().findById(id).get();
            rm.getRentRepository().deleteById(id);
            return rent;
        }else {
            throw new EntityNotFoundException();
        }
    }
}
