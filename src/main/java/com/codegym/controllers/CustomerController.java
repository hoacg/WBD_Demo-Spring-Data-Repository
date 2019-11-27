package com.codegym.controllers;

import com.codegym.models.Customer;
import com.codegym.services.ICustomerService;
import com.codegym.validators.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView getCustomerForm() {
        return new ModelAndView("customer-form", "customer", new Customer());
    }

    @PostMapping("/customers")
    public ModelAndView createCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult) {
        PhoneNumberValidator validator = new PhoneNumberValidator();
        validator.validate(customer, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("customer-form");
        } else {
            Customer newCustomer = customerService.save(customer);
            return new ModelAndView("customer", "customer", newCustomer);
        }

    }

    @GetMapping("/customers/{customer}")
    public String getCustomerDetail(Customer customer, Model model) {
        model.addAttribute("customer", customer);

        return "customer";
    }

}
