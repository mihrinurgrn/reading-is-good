package com.mng.bookorderproject.service.impl;

import com.mng.bookorderproject.BookorderprojectApplication;
import com.mng.bookorderproject.constant.OrderStatus;
import com.mng.bookorderproject.constant.StockUpdateType;
import com.mng.bookorderproject.dto.StockUpdateData;
import com.mng.bookorderproject.dto.req.OrderFilterRequestDto;
import com.mng.bookorderproject.dto.req.OrderRequestDto;
import com.mng.bookorderproject.model.Book;
import com.mng.bookorderproject.model.Customer;
import com.mng.bookorderproject.model.Order;
import com.mng.bookorderproject.repository.BookRepository;
import com.mng.bookorderproject.repository.CustomerRepository;
import com.mng.bookorderproject.repository.OrderRepository;
import com.mng.bookorderproject.service.BookService;
import com.mng.bookorderproject.service.OrderService;
import com.mng.bookorderproject.validator.BookOrderValidationRule;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = LogManager.getLogger(BookorderprojectApplication.class);
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;
    private final BookService bookService;
    @Override
    public List<Order> getCustomersOrders(long customerId) {
        return orderRepository.getOrdersByCustomer(validateCustomer(customerId));
    }

    @Override
    public Order save(Order order) {
        Order newOrder = orderRepository.save(order);
        LOGGER.info("new order saved"+newOrder);
        return newOrder;
    }

    @Override
    public Order getOrderByOrderId(long orderId) {
        return orderRepository.getOrderByOrderId(orderId);
    }

    @Override
    public List<Order> getOrdersInDateInterval(OrderFilterRequestDto requestDto) {
        return orderRepository.findByCreatedAtBetween(requestDto.getStartDate().atStartOfDay(), requestDto.getEndDate().atStartOfDay());
    }
    @Override
    @Transactional()
    public Order doOrder(OrderRequestDto order) {
        Book book = bookRepository.findBookByBookId(order.getBookId());
        Order newOrder = new Order();
        newOrder.setStatus(OrderStatus.ACTIVE);
        newOrder.setBook(book);
        newOrder.setBookCount(order.getBookCount());
        newOrder.setCustomer(validateCustomer(order.getCustomerId()));
        StockUpdateData stockUpdateData = new StockUpdateData(order.getBookId(),order.getBookCount(),
                StockUpdateType.DECREASE);
        bookService.updateStock(stockUpdateData);
        orderRepository.save(newOrder);
        LOGGER.info("order placed");
        return newOrder;

    }

    public Customer validateCustomer(long customerId)
    {
        Customer customer = customerRepository.findCustomerByCustomerId(customerId);
        if(customer == null)
        {
            throw new RuntimeException(BookOrderValidationRule.INVALID_CUSTOMER_ID.getDescription());
        }
        LOGGER.info("customer is invalid");
        return customer;
    }
}
