package com.maba.carrentalserver.repository;

import com.maba.carrentalserver.entity.Client;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
    boolean existsByEmail(String email);
}
