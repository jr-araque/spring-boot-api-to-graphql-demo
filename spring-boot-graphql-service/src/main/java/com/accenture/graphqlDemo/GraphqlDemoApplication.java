package com.accenture.graphqlDemo;

import com.accenture.graphqlDemo.graphql.GraphQLErrorAdapter;
import com.accenture.graphqlDemo.model.Author;
import com.accenture.graphqlDemo.model.Book;
import com.accenture.graphqlDemo.repository.AuthorRepository;
import com.accenture.graphqlDemo.repository.BookRepository;
import com.accenture.graphqlDemo.resolver.*;
import com.accenture.graphqlDemo.service.MyRestServiceClient;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class GraphqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlDemoApplication.class, args);
	}

	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}

	@Bean
	public PostResolver userResolver(MyRestServiceClient myRestServiceClient) { return new PostResolver(myRestServiceClient); }

	@Bean
	public UserResolver postResolver(MyRestServiceClient myRestServiceClient) { return new UserResolver(myRestServiceClient); }

	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository, MyRestServiceClient myRestServiceClient) {
		return new Query(authorRepository, bookRepository, myRestServiceClient);
	}

	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Mutation(authorRepository, bookRepository);
	}

	@Bean
	public GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream()
						.filter(this::isClientError)
						.collect(Collectors.toList());

				List<GraphQLError> serverErrors = errors.stream()
						.filter(e -> !isClientError(e))
						.map(GraphQLErrorAdapter::new)
						.collect(Collectors.toList());

				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}

			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
	}

	@Bean
	public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
		return (args) -> {
			Author author = new Author("Herbert", "Schildt");
			authorRepository.save(author);

			bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));
		};
	}
}
