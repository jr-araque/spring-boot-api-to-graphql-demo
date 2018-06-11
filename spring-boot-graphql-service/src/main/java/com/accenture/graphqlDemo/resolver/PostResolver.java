package com.accenture.graphqlDemo.resolver;

import com.accenture.graphqlDemo.model.Post;
import com.accenture.graphqlDemo.model.User;
import com.accenture.graphqlDemo.service.MyRestServiceClient;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class PostResolver implements GraphQLResolver<Post> {

    private final MyRestServiceClient myRestServiceClient;
    public PostResolver(MyRestServiceClient myRestServiceClient) {
        this.myRestServiceClient = myRestServiceClient;
    }

    public User getAuthor(Post post) {
        return myRestServiceClient.getUser(post.getAuthorId());
    }

}
