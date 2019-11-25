package com.codegym.controllers;

import com.codegym.models.Customer;
import com.codegym.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "";
    }

    @PostMapping("/customers")
    public String createCustmer() {
        return "";
    }

}
