package com.openclassrooms.paymybuddy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_person_id" )
    private Person user;

    @Column(name = "balance")
    private double balance;

    private Set<UserAccount> network;

    @OneToMany(targetEntity = Transfer.class, mappedBy = "userAccount")
    private Set<Transfer> transferLog;
}
