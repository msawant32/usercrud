package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="userinfo")
@Data
public class UserInfo {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @OneToMany(mappedBy = "userinfo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Account> accountList;


    public UserInfo(){

    }

    public UserInfo(String firstname, String lastname, long id) {
        this.lastName = lastname;
        this.firstName = firstname;
        this.id = id;
    }

}
