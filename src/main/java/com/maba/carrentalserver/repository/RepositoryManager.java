package com.maba.carrentalserver.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryManager {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RentRepository rentRepository;

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public RentRepository getRentRepository() {
        return rentRepository;
    }
}
