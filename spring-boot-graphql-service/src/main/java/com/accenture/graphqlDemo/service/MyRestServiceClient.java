package com.accenture.graphqlDemo.service;

import com.accenture.graphqlDemo.model.Post;
import com.accenture.graphqlDemo.model.User;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyRestServiceClient {
    private final RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(MyRestServiceClient.class);


    public MyRestServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Post> getPosts() {
        ResponseEntity<Post[]> responseEntity = restTemplate.getForEntity(
                "http://localhost:3000/posts",
                Post[].class
        );
        return Arrays.asList(responseEntity.getBody());
    }

    public List<Post> getUserPosts(String authorId) {
        ResponseEntity<Post[]> responseEntity = restTemplate.getForEntity(
                "http://localhost:3000/posts",
                Post[].class
        );
        List<Post> posts = Arrays.asList(responseEntity.getBody());

        return posts.stream().filter(post -> post.getAuthorId().equals(authorId)).collect(Collectors.toList());
    }

    public List<User> getUsers() {
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(
                "http://localhost:3000/users",
                User[].class
        );
        return Arrays.asList(responseEntity.getBody());
    }

    public User getUser(String userId) {
        ResponseEntity<User> responseEntity = restTemplate
                .getForEntity("http://localhost:3000/users/{userId}", User.class, userId);
        return responseEntity.getBody();
    }
}
