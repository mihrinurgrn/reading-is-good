package com.mng.bookorderproject;

import com.mng.bookorderproject.constant.OrderStatus;
import com.mng.bookorderproject.dto.req.OrderRequestDto;
import com.mng.bookorderproject.model.Book;
import com.mng.bookorderproject.model.Customer;
import com.mng.bookorderproject.model.Order;
import com.mng.bookorderproject.repository.BookRepository;
import com.mng.bookorderproject.repository.CustomerRepository;
import com.mng.bookorderproject.repository.OrderRepository;
import com.mng.bookorderproject.service.impl.BookServiceImpl;
import com.mng.bookorderproject.service.impl.OrderServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private BookServiceImpl bookService;
    @InjectMocks
    private OrderServiceImpl orderService;
    @Captor
    private ArgumentCaptor<Long> longArgumentCaptor;
    private Order order;
    private Book book;
    private Customer customer;
    private OrderRequestDto orderRequestDto;

    @Before
    public void setup() {
        orderService = new OrderServiceImpl(orderRepository,bookRepository,customerRepository,bookService);
        orderRequestDto = OrderRequestDto.builder()
                .bookId(1L)
                .customerId(1L)
                .bookCount(10L)
                .build();
        order = new Order();
        order.setBookCount(10L);
        order.setStatus(OrderStatus.ACTIVE);
        book = new Book();
        customer = new Customer();
        order.setBook(book);
        order.setCustomer(customer);
        order.setBookCount(orderRequestDto.getBookCount());
    }

    @Test
    public void testGetCustomersOrdersWhenCustomerIsInvalid() {
        Mockito.when(customerRepository.findCustomerByCustomerId(longArgumentCaptor.capture())).thenReturn(null);

        RuntimeException exception = Assert.assertThrows(RuntimeException.class,
                () -> {
                    orderService.getCustomersOrders(1L);
                });

        Assert.assertEquals("There is no customer with this customer id", exception.getMessage());
    }


    @Test
    public void testDoOrdersWhenCustomerIsInvalid() {
        Mockito.when(customerRepository.findCustomerByCustomerId(longArgumentCaptor.capture())).thenReturn(null);

        RuntimeException exception = Assert.assertThrows(RuntimeException.class,
                () -> {
                    orderService.doOrder(orderRequestDto);
                });

        Assert.assertEquals("There is no customer with this customer id", exception.getMessage());
    }


    @Test
    public void testDoOrderSuccesfully() {
        Mockito.when(bookRepository.findBookByBookId(longArgumentCaptor.capture())).thenReturn(book);
        Mockito.when(customerRepository.findCustomerByCustomerId(longArgumentCaptor.capture())).thenReturn(customer);
        Mockito.when(bookRepository.save(any())).thenReturn(book);
        Mockito.when(orderRepository.save(any())).thenReturn(order);
        Order newOrder = orderService.doOrder(orderRequestDto);

        Assert.assertEquals(newOrder.getBookCount(),order.getBookCount());
        Assert.assertEquals(newOrder.getCustomer(),order.getCustomer());
        Assert.assertEquals(newOrder.getStatus(),order.getStatus());
    }

    @Test
    public void testOrdersOfCustomerSuccessfully() {
        List<Order> orders = new ArrayList<>();
        Mockito.when(customerRepository.findCustomerByCustomerId(longArgumentCaptor.capture())).thenReturn(customer);
        Mockito.when(orderRepository.getOrdersByCustomer(customer)).thenReturn(orders);

         orderService.getCustomersOrders(orderRequestDto.getCustomerId());

        Assert.assertNotNull(orders);
    }


}