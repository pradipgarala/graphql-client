package com.example.graphql_client.dto;

public record Author(Integer id,
                     String firstName,
                     String lastName) {

    public String fullName() {
        return firstName + " " + lastName;
    }

}