package com.accenture.graphqlDemo.repository;

import com.accenture.graphqlDemo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
