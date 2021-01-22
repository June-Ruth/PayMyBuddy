package com.openclassrooms.paymybuddy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Transfer object between user or with their bank account.
 */
@Entity
@Table(name = "transfer")
public class Transfer {
    /**
     * ID, generated by DataBase.
     * Use as primary key in DataBase.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transfer_id")
    private int id;

    /**
     * User account which sends the transfer.
     * @see UserAccount
     */
    @ManyToOne
    @JoinColumn(name = "sender_user_account_id")
    private UserAccount sender;

    /**
     * User account which receives the transfer.
     * @see UserAccount
     */
    @ManyToOne
    @JoinColumn(name = "receiver_user_account_id")
    private UserAccount receiver;

    /**
     * Description by sender of the transfer.
     */
    @Column(name = "description")
    private String description;

    /**
     * Date of transfer.
     */
    @Column(name = "transfer_date")
    private LocalDate date;

    /**
     * Amount of transfer without fee.
     */
    @Column(name = "amout")
    private double amount;

    /**
     * Associated fee of the transfer.
     */
    @Column(name = "fee")
    private double fee;

    /**
     * Type of transfer.
     * @see TransferType
     */
    @Column(name = "transfer_type")
    private TransferType transferType;

    /**
     * Public constructor.
     * Parameters are all needed and non nullable.
     * @param pSender .
     * @param pReceiver .
     * @param pDescription .
     * @param pDate .
     * @param pAmount .
     * @param pFee .
     * @param pTransferType .
     */
    public Transfer(final UserAccount pSender,
                    final UserAccount pReceiver,
                    final String pDescription,
                    final LocalDate pDate,
                    final double pAmount,
                    final double pFee,
                    final TransferType pTransferType) {
        sender = pSender;
        receiver = pReceiver;
        description = pDescription;
        date = pDate;
        amount = pAmount;
        fee = pFee;
        transferType = pTransferType;
    }

    /**
     * Getter ID.
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * Setter ID.
     * ID is auto-generated, should not be accessible.
     * @param pId to set
     */
    private void setId(final int pId) {
        id = pId;
    }

    /**
     * Getter sender.
     * @return sender
     */
    public UserAccount getSender() {
        return sender;
    }

    /**
     * Setter sender.
     * @param pSender to set
     */
    public void setSender(final UserAccount pSender) {
        this.sender = pSender;
    }

    /**
     * Getter receiver.
     * @return receiver
     */
    public UserAccount getReceiver() {
        return receiver;
    }

    /**
     * Setter receiver.
     * @param pReceiver to set
     */
    public void setReceiver(final UserAccount pReceiver) {
        receiver = pReceiver;
    }

    /**
     * Getter description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter description.
     * @param pDescription to set
     */
    public void setDescription(final String pDescription) {
        description = pDescription;
    }

    /**
     * Getter date.
     * @return date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Setter date.
     * @param pDate to set
     */
    public void setDate(final LocalDate pDate) {
        date = pDate;
    }

    /**
     * Getter amount.
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter amount.
     * @param pAmount to set
     */
    public void setAmount(final double pAmount) {
        amount = pAmount;
    }

    /**
     * Getter fee.
     * @return fee
     */
    public double getFee() {
        return fee;
    }

    /**
     * Setter fee.
     * @param pFee
     */
    public void setFee(final double pFee) {
        fee = pFee;
    }

    /**
     * Getter transfer type.
     * @return transfer type
     */
    public TransferType getTransferType() {
        return transferType;
    }

    /**
     * Setter transfer type.
     * @param pTransferType to set
     */
    public void setTransferType(final TransferType pTransferType) {
        transferType = pTransferType;
    }
}
