package com.mng.bookorderproject.service;

import com.mng.bookorderproject.dto.req.CustomerRequestDto;
import com.mng.bookorderproject.model.Customer;
import com.mng.bookorderproject.model.Order;

import java.util.List;

public interface CustomerService {
    void save(CustomerRequestDto user);

}
