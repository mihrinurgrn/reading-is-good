package com.mng.bookorderproject.service;

import com.mng.bookorderproject.dto.StockUpdateData;
import com.mng.bookorderproject.dto.req.BookRequestDto;
import com.mng.bookorderproject.model.Book;


public interface BookService {
    Book save(BookRequestDto book);
    Book updateStock(StockUpdateData stockUpdateData);
}
