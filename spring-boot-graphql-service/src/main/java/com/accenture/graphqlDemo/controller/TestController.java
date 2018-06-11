package com.accenture.graphqlDemo.controller;

import com.accenture.graphqlDemo.model.Post;
import com.accenture.graphqlDemo.model.User;
import com.accenture.graphqlDemo.service.MyRestServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private final MyRestServiceClient myRestServiceClient;

    public TestController(MyRestServiceClient myRestServiceClient) {
        this.myRestServiceClient = myRestServiceClient;
    }

    @GetMapping("/posts")
    public List<Post> getPosts() { return this.myRestServiceClient.getPosts(); }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable String userId) { return this.myRestServiceClient.getUser(userId); }

    @GetMapping("/users")
    public List<User> getUsers() { return this.myRestServiceClient.getUsers(); }

    @GetMapping("/Hello")
    public String getWorld() {
        return "World";
    }
}
