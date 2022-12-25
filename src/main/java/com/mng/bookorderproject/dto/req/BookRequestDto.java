package com.mng.bookorderproject.dto.req;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class BookRequestDto {

    @NotNull
    private String bookName;

    @NotNull
    @Min(value = 0, message = "Stock must be greater or equal than 0!")
    private long stock;

    @NotNull
    @Min(value = 20, message = "Price must be greater or equal than 10!")
    private BigDecimal amount;

}
