package com.ojaoba.springbootpostgres.controller;


import com.ojaoba.springbootpostgres.model.Customer;
import com.ojaoba.springbootpostgres.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }



     record NewCustomerRequest(
        String name,
         String email,
        Integer age
     ){
     }
     @PostMapping
    public void addCustomer(@RequestBody  NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerService.addCustomer(customer);

     }
     @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
         customerService.deleteCustomer(id);

     }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customer.setId(id);
        customerService.updateCustomer(customer);

    }

}
