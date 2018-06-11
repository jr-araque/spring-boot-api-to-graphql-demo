package com.accenture.graphqlDemo.resolver;

import com.accenture.graphqlDemo.model.Author;
import com.accenture.graphqlDemo.model.Book;
import com.accenture.graphqlDemo.model.Post;
import com.accenture.graphqlDemo.model.User;
import com.accenture.graphqlDemo.repository.AuthorRepository;
import com.accenture.graphqlDemo.repository.BookRepository;
import com.accenture.graphqlDemo.service.MyRestServiceClient;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private MyRestServiceClient myRestServiceClient;

    public Query(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            MyRestServiceClient myRestServiceClient
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.myRestServiceClient = myRestServiceClient;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }

    public Iterable<Post> posts() { return this.myRestServiceClient.getPosts(); }
    public Iterable<User> findAllUsers() { return this.myRestServiceClient.getUsers(); }
}
