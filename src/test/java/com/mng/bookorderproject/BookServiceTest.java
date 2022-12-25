package com.mng.bookorderproject;

import com.mng.bookorderproject.constant.StockUpdateType;
import com.mng.bookorderproject.dto.StockUpdateData;
import com.mng.bookorderproject.dto.req.BookRequestDto;
import com.mng.bookorderproject.model.Book;
import com.mng.bookorderproject.repository.BookRepository;
import com.mng.bookorderproject.service.impl.BookServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookServiceImpl bookService;
    @Captor
    private ArgumentCaptor<String> stringArgumentCaptor;
    private Book book;
    private BookRequestDto bookRequestDto;

    @Before
    public void setup() {
        bookService = new BookServiceImpl(bookRepository);
        bookRequestDto = BookRequestDto.builder()
                .stock(10L)
                .amount(BigDecimal.TEN)
                .bookName("Yuzyillik yalnizlik")
                .build();
        book = new Book();
        book.setStock(bookRequestDto.getStock());
        book.setBookName(bookRequestDto.getBookName());
        book.setAmount(bookRequestDto.getAmount());
    }

    @Test
    public void testRegisterNewBookIsAlreadyExist() {
        Mockito.when(bookRepository.findBookByBookName(stringArgumentCaptor.capture())).thenReturn(book);

        RuntimeException exception = Assert.assertThrows(RuntimeException.class,
                ()->{ bookService.save(bookRequestDto);});

        Assert.assertEquals("This book already exist",exception.getMessage());
    }


    @Test
    public void testStockIsInsufficientAndShouldThrowException () {
        StockUpdateData stockUpdateData = new StockUpdateData(1L,100L, StockUpdateType.DECREASE);

        Mockito.when(bookRepository.findBookByBookId(1L))
                .thenReturn(book);

        RuntimeException exception = Assert.assertThrows(RuntimeException.class,
                ()->{ bookService.updateStock(stockUpdateData);});

        Assert.assertEquals("insufficient book stock",exception.getMessage());

    }

    @Test
    public void testGivenInvalidBookIdForUpdateStockShouldThrowException() {
        StockUpdateData stockUpdateData = new StockUpdateData(1L,10L, StockUpdateType.INCREASE);

        Mockito.when(bookRepository.findBookByBookId(1L))
                .thenReturn(null);

        RuntimeException exception = Assert.assertThrows(RuntimeException.class,
                ()->{ bookService.updateStock(stockUpdateData);});

        Assert.assertEquals("There is no book with this book id",exception.getMessage());

    }




    /*@Test
    public void whenGivenValidIncreaseStockTypeForUpdateStock() {
        StockUpdateData stockUpdateData = new StockUpdateData(1L,10L, StockUpdateType.INCREASE);

        Book newBook = new Book();
        newBook.setStock();
        Mockito.when(bookRepository.findBookByBookId(1L))
                .thenReturn(book);

        Mockito.when(bookRepository.save(1L))
                .thenReturn(book);

        Book updatedBook = bookService.updateStock(stockUpdateData);
        Assert.assertEquals(Optional.of(book.getStock() + stockUpdateData.bookCount),updatedBook.getStock());

    }
    */




}
