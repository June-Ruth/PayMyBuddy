package com.openclassrooms.paymybuddy.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "bank_account_rib")
    private BankAccount bankAccount;
}
