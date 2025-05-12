package com.example.icecream.repository;

import com.example.icecream.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    public Optional<Customer> findById(UUID id);
    public List<Customer> findAll();
    public Optional<Customer> findByEmail(String email);
    public Optional<Customer> findByPhoneNumber(String phone);
}
