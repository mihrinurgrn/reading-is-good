package com.mng.bookorderproject.service.impl;

import com.mng.bookorderproject.BookorderprojectApplication;
import com.mng.bookorderproject.dto.req.CustomerRequestDto;
import com.mng.bookorderproject.model.Customer;
import com.mng.bookorderproject.repository.CustomerRepository;
import com.mng.bookorderproject.service.CustomerService;
import com.mng.bookorderproject.validator.BookOrderValidationRule;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LogManager.getLogger(BookorderprojectApplication.class);
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final CustomerRepository customerRepository;

    @Override
    public void save(CustomerRequestDto customerRequestDto) {
        Customer newCustomer = new Customer();
        validateCustomer(customerRequestDto);
        newCustomer.setCustomerName(customerRequestDto.getCustomerName());
        newCustomer.setCustomerSurname(customerRequestDto.getCustomerSurname());
        newCustomer.setUsername(customerRequestDto.getUsername());
        newCustomer.setPassword(bCryptPasswordEncoder.encode(customerRequestDto.getPassword()));
        customerRepository.save(newCustomer);
        LOGGER.info("customer added");
    }

    public void validateCustomer(CustomerRequestDto customer)
    {
        if(customerRepository.existsCustomerByUsername(customer.getUsername()))
        {
            LOGGER.info("customer is invalid");
            throw new RuntimeException(BookOrderValidationRule.ALREADY_USED_USERNAME.getDescription());
        }

    }


}
