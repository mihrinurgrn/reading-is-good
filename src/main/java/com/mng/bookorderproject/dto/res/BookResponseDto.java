package com.mng.bookorderproject.dto.res;

import com.mng.bookorderproject.model.Book;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class BookResponseDto {
    private String bookName;

    private Long stock;

    private BigDecimal amount;

    public static BookResponseDto fromBookEntity(Book book)
    {
        return BookResponseDto.builder()
                .bookName(book.getBookName())
                .stock(book.getStock())
                .amount(book.getAmount())
                .build();
    }
}
