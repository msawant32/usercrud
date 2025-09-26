package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accountid")
    private long accountId;

    @Column(name="accountname")
    private String accountName;

    @Column(name="accounttype")
    private String accountType;

    @ManyToOne()
    @JoinColumn(name = "id")
    @JsonBackReference
    private UserInfo userinfo;
}
