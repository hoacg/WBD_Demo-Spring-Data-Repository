package com.codegym.validators;

import com.codegym.models.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PhoneNumberValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Customer.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        String phoneNumber = customer.getPhoneNumber();

        if (phoneNumber == null) {
            errors.rejectValue("a", "phoneNumber.empty", "Số điện đang để trống!");
        } else {
            if (phoneNumber.isEmpty()) {
                errors.rejectValue("a", "phoneNumber.empty", "Số điện thoại đang để trống!");
            }

            if (!phoneNumber.startsWith("0")) {
                errors.rejectValue("a", "phoneNumber.startWithZero", "Số điện phải bắt đầu bằng 0!");
            }
        }

    }
}
