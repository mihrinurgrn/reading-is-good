package com.mng.bookorderproject.service;

import com.mng.bookorderproject.dto.StockUpdateData;
import com.mng.bookorderproject.dto.req.OrderFilterRequestDto;
import com.mng.bookorderproject.dto.req.OrderRequestDto;
import com.mng.bookorderproject.model.Book;
import com.mng.bookorderproject.model.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    List<Order> getCustomersOrders(long customerId);
    Order save(Order order);
    Order getOrderByOrderId(long orderId);
    List<Order> getOrdersInDateInterval(OrderFilterRequestDto requestDto);
    Order doOrder(OrderRequestDto order);
}
