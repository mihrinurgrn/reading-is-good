package com.mng.bookorderproject.service.impl;

import com.mng.bookorderproject.BookorderprojectApplication;
import com.mng.bookorderproject.constant.StockUpdateType;
import com.mng.bookorderproject.dto.StockUpdateData;
import com.mng.bookorderproject.dto.req.BookRequestDto;
import com.mng.bookorderproject.model.Book;
import com.mng.bookorderproject.repository.BookRepository;
import com.mng.bookorderproject.service.BookService;
import com.mng.bookorderproject.validator.BookOrderValidationRule;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private static final Logger LOGGER = LogManager.getLogger(BookorderprojectApplication.class);
    private final BookRepository bookRepository;
    @Override
    public Book save(BookRequestDto book) {
        if(bookRepository.findBookByBookName(book.getBookName()) != null)
        {
            LOGGER.info("invalid book name");
            throw new RuntimeException(BookOrderValidationRule.ALREADY_EXIST_BOOK.getDescription());
        }
        Book newBook = new Book();
        newBook.setBookName(book.getBookName());
        newBook.setStock(book.getStock());
        newBook.setAmount(book.getAmount());
        LOGGER.info("new book" + newBook);
        return bookRepository.save(newBook);
    }

    @Override
    @Transactional
    public Book updateStock(StockUpdateData stockUpdateData) {
        Book book = bookRepository.findBookByBookId(stockUpdateData.getBookId());
        if(book==null)
        {
            LOGGER.info("invalid book Id");
            throw new RuntimeException(BookOrderValidationRule.INVALID_BOOK_ID.getDescription());
        }
        if(stockUpdateData.getStockUpdateType() == StockUpdateType.INCREASE) {
            book.setStock(book.getStock()+stockUpdateData.getBookCount());
        }
        else {
            if(book.getStock().compareTo(stockUpdateData.getBookCount())<0) {
                LOGGER.info("Insufficient stock");
                throw new RuntimeException(BookOrderValidationRule.INSUFFICIENT_STOCK_EXCEPTION.getDescription());
            }
            book.setStock(book.getStock()-stockUpdateData.getBookCount());
        }
        book = bookRepository.save(book);
        LOGGER.info("stock updated");
        return book;
    }
}
