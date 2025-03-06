package com.grantapp.repository.cars.lookup;

import com.grantapp.model.cars.lookup.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}