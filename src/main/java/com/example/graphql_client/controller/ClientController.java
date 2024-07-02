package com.example.graphql_client.controller;

import com.example.graphql_client.client.Client;
import com.example.graphql_client.dto.Author;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClientController {

    private final Client client;

    public ClientController(Client client) {
        this.client = client;
    }

    @GetMapping
    public List<Author> getAuthorList() {
        return client.getAuthors();
    }

    @PatchMapping
    public Author update(@RequestBody Author author) {
        return client.update(author);
    }
}
