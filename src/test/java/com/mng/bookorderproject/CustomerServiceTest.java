package com.mng.bookorderproject;

import com.mng.bookorderproject.dto.req.CustomerRequestDto;
import com.mng.bookorderproject.model.Customer;
import com.mng.bookorderproject.repository.CustomerRepository;
import com.mng.bookorderproject.service.impl.CustomerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
    @InjectMocks
    private CustomerServiceImpl customerService;
    @Captor
    private ArgumentCaptor<String> stringArgumentCaptor;
    private Customer customer;
    private CustomerRequestDto customerRequestDto;

    @Before
    public void setup() {
        customerService = new CustomerServiceImpl(bCryptPasswordEncoder, customerRepository);
        customerRequestDto = CustomerRequestDto.builder()
                .customerName("test")
                .customerSurname("test surname")
                .username("test username")
                .build();
        customer = new Customer();
        customer.setUsername(customerRequestDto.getUsername());
        customer.setCustomerName(customerRequestDto.getCustomerName());
        customer.setCustomerSurname(customerRequestDto.getCustomerSurname());
    }

    @Test
    public void testRegisterNewCustomerIsAlreadyExist() {
        Mockito.when(customerRepository.existsCustomerByUsername(stringArgumentCaptor.capture())).thenReturn(true);

        RuntimeException exception = Assert.assertThrows(RuntimeException.class,
                () -> {
                    customerService.save(customerRequestDto);
                });

        Assert.assertEquals("This username already used", exception.getMessage());
    }



}