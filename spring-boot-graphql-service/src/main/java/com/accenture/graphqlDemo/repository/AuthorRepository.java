package com.accenture.graphqlDemo.repository;

import com.accenture.graphqlDemo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
