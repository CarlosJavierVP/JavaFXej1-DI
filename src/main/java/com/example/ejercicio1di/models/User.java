package com.example.ejercicio1di.models;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;


    public User(){}
    public User(long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
