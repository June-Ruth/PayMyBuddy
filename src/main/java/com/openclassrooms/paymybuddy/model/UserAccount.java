package com.openclassrooms.paymybuddy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

/**
 * User account used for application.
 */
@Entity
@Table(name = "user_account")
public class UserAccount {

    /**
     * ID, generated by DataBase.
     * Use as primary key in DataBase.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    /**
     * First name.
     */
    @NotNull(message = "First name cannot be null")
    @Size(max = 15, message = "First name must be less than 15 characters")
    @Column(name = "first_name")
    private String firstName;

    /**
     * Last name.
     */
    @NotNull(message = "Last name cannot be null")
    @Size(max = 15, message = "Last name must be less than 15 characters")
    @Column(name = "last_name")
    private String lastName;

    /**
     * Email.
     * Must be unique.
     */
    @Email(message = "Email should be valid")
    @Size(max = 60, message = "Email must be less than 60 characters")
    @Column(name = "email", unique = true)
    private String email;

    /**
     * Password.
     */
    @NotNull(message = "Password cannot be null")
    @Column(name = "password")
    private String password;

    /**
     * Security role : User / User and Admin.
     * @see RoleProfile
     */
    @NotNull
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn( name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private List<RoleProfile> roles;

    /**
     * Associated bank account.
     * @see BankAccount
     */
    @Valid
    @NotNull(message = "Bank account cannot be null")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_account_id", nullable = false)
    private BankAccount bankAccount;

    /**
     * Balance available on user account.
     */
    @PositiveOrZero(message = "Balance cannot be negative")
    @Max(value = 100000, message = "Balance should not be greater than 1000 000€")
    @Column(name = "balance")
    private double balance;

    /**
     * Set of all established connection with other user account.
     * They will be necessary for transfer.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "connection", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "connection_id", referencedColumnName = "user_id"))
    private List<UserAccount> connection;

    /**
     * Historic log off all transfer send and receive.
     * @see Transfer
     */
    @JsonBackReference
    @OneToMany(targetEntity = Transfer.class, mappedBy = "sender")
    private List<Transfer> transferLog;

    /**
     * Public constructor.
     * Parameters are all needed and non nullable.
     * @param pFirstName .
     * @param pLastName .
     * @param pEmail .
     * @param pPassword .
     * @param pRoles .
     * @param pBankAccount .
     * @param pBalance .
     * @param pConnection .
     * @param pTransferLog .
     */
    public UserAccount(final String pFirstName,
                       final String pLastName,
                       final String pEmail,
                       final String pPassword,
                       final List<RoleProfile> pRoles,
                       final BankAccount pBankAccount,
                       final double pBalance,
                       final List<UserAccount> pConnection,
                       final List<Transfer> pTransferLog) {
        firstName = pFirstName;
        lastName = pLastName;
        email = pEmail;
        password = pPassword;
        roles = pRoles;
        bankAccount = pBankAccount;
        balance = pBalance;
        connection = pConnection;
        transferLog = pTransferLog;
    }

    private UserAccount() { }

    /**
     * Getter ID.
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * Setter ID.
     * ID is auto-generated, should not be accessible. //TODO
     * @param pId to set
     */
    private void setId(final int pId) {
        id = pId;
    }

    /**
     * Getter first name.
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter first name.
     * @param pFirstName to set.
     */
    public void setFirstName(final String pFirstName) {
        firstName = pFirstName;
    }

    /**
     * Getter last name.
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter last name.
     * @param pLastName to set
     */
    public void setLastName(final String pLastName) {
        lastName = pLastName;
    }

    /**
     * Getter email.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter email.
     * @param pEmail to set
     */
    public void setEmail(final String pEmail) {
        email = pEmail;
    }

    /**
     * Getter password.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter password.
     * @param pPassword to set
     */
    public void setPassword(final String pPassword) {
        password = pPassword;
    }

    /**
     * Getter roles.
     * @return list of roleProfile
     */
    public List<RoleProfile> getRoles() {
        return roles;
    }

    /**
     * Setter roles.
     * @param pRoles to set
     */
    public void setRoles(List<RoleProfile> pRoles) {
        roles = pRoles;
    }

    /**
     * Getter Bank Account.
     * @return bank account
     */
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    /**
     * Setter Bank Account.
     * @param pBankAccount to set
     */
    public void setBankAccount(final BankAccount pBankAccount) {
        bankAccount = pBankAccount;
    }

    /**
     * Getter balance.
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Setter balance.
     * @param pBalance to set
     */
    public void setBalance(final double pBalance) {
        balance = pBalance;
    }

    /**
     * Getter connection.
     * @return connection as Set of user account
     */
    public List<UserAccount> getConnection() {
        return connection;
    }

    /**
     * Setter connection.
     * @param pConnection as Set of user account to set
     */
    public void setConnection(final List<UserAccount> pConnection) {
        connection = pConnection;
    }

    /**
     * Getter transfer log.
     * @return transfer log as Set of transfer.
     */
    public List<Transfer> getTransferLog() {
        return transferLog;
    }

    /**
     * Setter transfer log.
     * @param pTransferLog as Set pf transfer to set
     */
    public void setTransferLog(final List<Transfer> pTransferLog) {
        transferLog = pTransferLog;
    }
}
