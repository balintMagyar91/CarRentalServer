package com.maba.carrentalserver.controller;

import com.maba.carrentalserver.entity.Car;
import com.maba.carrentalserver.entity.Client;
import com.maba.carrentalserver.entity.Rent;
import com.maba.carrentalserver.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRentalRestController {

    @Autowired
    private CarRentalService carRentalService;

    @GetMapping("/cars")
    public List<Car> listCars() {
        return carRentalService.findAllCars();
    }

    @PostMapping("/cars")
    public Car saveCar(@Valid @RequestBody Car car){
        try {
            return carRentalService.addNewCar(car);
        }catch (EntityExistsException exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car already exists");
        }
    }

    @PutMapping("/cars")
    public Car updateCar(@Valid @RequestBody Car car) {
        try {
            return carRentalService.updateCar(car);
        }catch (EntityNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car Not Found");
        }
    }

    @DeleteMapping("/cars/{id}")
    public Car deleteCar(@PathVariable("id") int id) {
        try {
            return carRentalService.deleteCar(id);
        } catch (EntityNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car Not Found");
        }
    }

    @GetMapping("/clients")
    public List<Client> listClients() {
        return carRentalService.findAllClients();
    }

    @PostMapping("/clients")
    public Client saveClient(@Valid @RequestBody Client client) {
        try {
            return carRentalService.addNewClient(client);
        }catch (EntityExistsException exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client already exists");
        }
    }

    @PutMapping("/clients")
    public Client updateClient(@Valid @RequestBody Client client) {
        try {
            return carRentalService.updateClient(client);
        }catch (EntityNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client Not Found");
        }
    }

    @DeleteMapping("/clients/{id}")
    public Client deleteClient(@PathVariable("id") int id) {
        try {
            return carRentalService.deleteClient(id);
        } catch (EntityNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client Not Found");
        }
    }

    @GetMapping("/rents")
    public List<Rent> listRents() {
        return carRentalService.findAllRents();
    }

    @PostMapping("/rents")
    public Rent saveRent(@Valid @RequestBody Rent rent) {
        try {
            return carRentalService.addNewRent(rent);
        }catch (EntityExistsException exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car is not available");
        }
    }

    @PutMapping("/rents")
    public Rent updateRent(@Valid @RequestBody Rent rent) {
        try {
            return carRentalService.updateRent(rent);
        } catch (EntityNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rent Not Found");
        }
    }

    @DeleteMapping("/rents/{id}")
    public Rent deleteRent(@PathVariable("id") int id) {
        try {
            return carRentalService.deleteRent(id);
        } catch (EntityNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rent Not Found");
        }
    }

    @GetMapping("/rents/active")
    public List<Rent> listActiveRents() {
        return carRentalService.listActiveRents();
    }

    @GetMapping("/rents/inactive")
    public List<Rent> listInActiveRents() {
        return carRentalService.listInActiveRents();
    }

    @GetMapping
    public String api(OAuth2Authentication authentication) {
        User user = (User) authentication.getUserAuthentication().getPrincipal();
//        StringBuilder sb = new StringBuilder();
//        sb.append("Username: " + user.getUsername() + "\n");
//        sb.append("Password: " + user.getPassword() + "\n");
//        sb.append("Username: " + user.getAuthorities() + "\n");
        return "You can access the api\n" + user.toString();
    }
}
