package com.openclassrooms.paymybuddy.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transfer")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JoinColumn(name = "sender_user_account_id")
    private UserAccount sender;

    @JoinColumn(name = "receiver_user_account_id")
    private UserAccount receiver;

    @Column(name = "description")
    private String description;

    @Column(name = "transfer_date")
    private LocalDate date;

    @Column(name = "amout")
    private double amount;

    @Column(name = "fee")
    private double fee;

    @Column(name = "transfer_type")
    private TransferType transferType;

}
