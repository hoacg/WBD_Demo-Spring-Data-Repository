package com.codegym.services;

import com.codegym.models.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getAll();
    Customer save(Customer customer);
    Customer getCustomerById(Long id);

}
