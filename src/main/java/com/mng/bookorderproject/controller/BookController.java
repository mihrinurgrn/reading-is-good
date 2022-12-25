package com.mng.bookorderproject.controller;

import com.mng.bookorderproject.dto.BaseResponse;
import com.mng.bookorderproject.dto.StockUpdateData;
import com.mng.bookorderproject.dto.req.BookRequestDto;
import com.mng.bookorderproject.dto.res.BookResponseDto;
import com.mng.bookorderproject.model.Book;
import com.mng.bookorderproject.model.Customer;
import com.mng.bookorderproject.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Api(value = "Book Api documentation")
public class BookController {
    private final BookService bookService;
    @ApiOperation(value = "New book adding method")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponse<BookResponseDto> addBook(@RequestBody BookRequestDto book) {
        return BaseResponse.fromData(BookResponseDto.fromBookEntity(bookService.save(book)));
    }

    @ApiOperation(value = "Increase book stock")
    @RequestMapping(value = "/stock", method = RequestMethod.PUT)
    public BaseResponse<BookResponseDto> addBook(@RequestBody StockUpdateData stockUpdateData) {
        return BaseResponse.fromData(BookResponseDto.fromBookEntity(bookService.updateStock(stockUpdateData)));
    }
}
