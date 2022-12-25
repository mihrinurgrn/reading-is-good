package com.mng.bookorderproject.repository;

import com.mng.bookorderproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Lock(LockModeType.PESSIMISTIC_READ)
    Book findBookByBookId(long bookId);
    Book findBookByBookName(String bookName);
}
