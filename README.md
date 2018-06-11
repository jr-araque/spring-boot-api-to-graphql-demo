## GraphQL Spring Boot Service

This repo demonstrates the implementation of an GraphQL Service, which consumes an external node API.

_Disclaimer: Is barebones._

### Requirements:

- Java 8 JDK.
- Gradle (Optional as the project has the wrapper)
- NodeJS

To Run:

```
# To Start the Nodejs API
cd nodejs-api-service
npm install
npm start
# the API will start on port 3000

# To start the spring service with the gradle Wrapper:
cd spring-boot-graphql-service
./gradlew bootRun
# the spring app will start on port 8080
```

Node API: [http://localhost:3000](http://localhost:3000/)

GraphQL Playground (GraphiQL): [http://localhost:8080/graphiql](http://localhost:8080/graphiql)

-
The API has the following EndPoints from which the data is fetched for the GraphQL Service:

/users
/users/{userId}
/posts
/posts/{postsId}
...
