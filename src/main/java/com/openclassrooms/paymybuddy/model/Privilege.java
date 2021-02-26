package com.openclassrooms.paymybuddy.model;

import javax.persistence.*;

@Entity
@Table(name = "privilege")
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "privilege_id")
    private int id;

    @Column(name = "privilege_name")
    private String name;
}
