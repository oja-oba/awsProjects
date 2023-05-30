package com.ojaoba.springbootpostgres.repository;

import com.ojaoba.springbootpostgres.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
