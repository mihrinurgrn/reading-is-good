package com.mng.bookorderproject.dto.req;

import com.mng.bookorderproject.constant.OrderStatus;
import com.mng.bookorderproject.model.Book;
import com.mng.bookorderproject.model.Customer;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Getter
@Builder
public class OrderRequestDto {

    @NotNull
    private Long customerId;

    @NotNull
    private Long bookId;

    @NotNull
    @Positive
    private Long bookCount;
}
