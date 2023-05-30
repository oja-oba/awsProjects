package com.ojaoba.springbootpostgres.service;

import com.ojaoba.springbootpostgres.model.Customer;
import com.ojaoba.springbootpostgres.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public List<Customer> getCustomers(){

        return customerRepository.findAll();


    }

    public void addCustomer(Customer customer) {

        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);

    }
}
