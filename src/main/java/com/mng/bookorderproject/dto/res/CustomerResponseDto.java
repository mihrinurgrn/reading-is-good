package com.mng.bookorderproject.dto.res;

import com.mng.bookorderproject.model.Book;
import com.mng.bookorderproject.model.Customer;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerResponseDto {
    private String customerName;

    private String customerSurname;

    private String username;

    public static CustomerResponseDto fromCustomerEntity(Customer customer)
    {
        return CustomerResponseDto.builder()
                .customerName(customer.getCustomerName())
                .customerSurname(customer.getCustomerSurname())
                .username(customer.getUsername())
                .build();
    }
}
