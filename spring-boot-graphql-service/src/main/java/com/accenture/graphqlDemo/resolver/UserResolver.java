package com.accenture.graphqlDemo.resolver;

import com.accenture.graphqlDemo.model.Post;
import com.accenture.graphqlDemo.model.User;
import com.accenture.graphqlDemo.service.MyRestServiceClient;
import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.List;

public class UserResolver implements GraphQLResolver<User> {
    private final MyRestServiceClient myRestServiceClient;
    public UserResolver(MyRestServiceClient myRestServiceClient) {
        this.myRestServiceClient = myRestServiceClient;
    }

    public List<Post> getPosts(User author) {
        return myRestServiceClient.getUserPosts(author.getId());
    }
}
