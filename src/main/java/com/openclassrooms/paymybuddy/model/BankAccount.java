package com.openclassrooms.paymybuddy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_account")
public class BankAccount {
    @Id
    private long rib;

    @Column(name = "bank")
    private String bank;

    @Column(name = "iban")
    private String iban;

    @Column(name = "bic")
    private String bic;
}
