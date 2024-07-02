package com.example.graphql_client.client;

import com.example.graphql_client.dto.Author;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Client {

    private final HttpGraphQlClient httpGraphQlClient;

    public Client(HttpGraphQlClient httpGraphQlClient) {
        this.httpGraphQlClient = httpGraphQlClient;
    }

    public List<Author> getAuthors() {
        String query = """
                query AllAuthors {
                    allAuthors {
                        id
                        firstName
                        lastName
                    }
                }
                """;

        return httpGraphQlClient.document(query)
                .retrieve("allAuthors")
                .toEntityList(Author.class)
                .block();
    }

    public Author update(Author author) {
        String query = """
                mutation UpdateAuthor2 {
                    updateAuthor(id: "%s", firstName: "%s", lastName: "%s") {
                        id
                        firstName
                        lastName
                    }
                }
                """.formatted(author.id(), author.firstName(), author.lastName());

        return httpGraphQlClient.document(query)
                .retrieve("updateAuthor")
                .toEntity(Author.class)
                .block();

    }


}
