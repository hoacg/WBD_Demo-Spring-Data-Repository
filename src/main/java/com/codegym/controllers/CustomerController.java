package com.codegym.controllers;

import com.codegym.models.Customer;
import com.codegym.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("/customers")
    public String getCustomerList(Model model) {

        List<Customer> customerList = customerService.getAll();
        model.addAttribute("customers", customerList);
        return "customer-list";
    }

    @GetMapping("/customers/get-form")
    public String getCustomerForm() {
        return "customer-form";
    }

    @PostMapping("/customers")
    public String createCustomer(@ModelAttribute Customer customer, Model model) {

        Customer newCustomer = customerService.save(customer);

        model.addAttribute("customer", newCustomer);
        return "customer";
    }

    @GetMapping("/customers/{customer}")
    public String getCustomerDetail(Customer customer, Model model) {
        model.addAttribute("customer", customer);

        return "customer";
    }

}
