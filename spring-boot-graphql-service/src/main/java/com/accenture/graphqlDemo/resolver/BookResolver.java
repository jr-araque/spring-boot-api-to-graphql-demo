package com.accenture.graphqlDemo.resolver;

import com.accenture.graphqlDemo.model.Author;
import com.accenture.graphqlDemo.model.Book;
import com.accenture.graphqlDemo.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }
}
