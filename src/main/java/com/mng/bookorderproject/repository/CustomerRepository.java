package com.mng.bookorderproject.repository;

import com.mng.bookorderproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);
    Customer findCustomerByCustomerId(Long id);
    boolean existsCustomerByUsername(String userName);
}
