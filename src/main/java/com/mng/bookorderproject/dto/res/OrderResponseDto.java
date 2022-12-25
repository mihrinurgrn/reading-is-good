package com.mng.bookorderproject.dto.res;

import com.mng.bookorderproject.constant.OrderStatus;
import com.mng.bookorderproject.model.Book;
import com.mng.bookorderproject.model.Customer;
import com.mng.bookorderproject.model.Order;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderResponseDto {
    private CustomerResponseDto customer;

    private BookResponseDto book;

    private OrderStatus status;

    private Long bookCount;

    public static OrderResponseDto fromOrderEntity(Order order)
    {
        return OrderResponseDto.builder()
                .customer(CustomerResponseDto.fromCustomerEntity(order.getCustomer()))
                .book(BookResponseDto.fromBookEntity(order.getBook()))
                .status(order.getStatus())
                .bookCount(order.getBookCount())
                .build();
    }
}
