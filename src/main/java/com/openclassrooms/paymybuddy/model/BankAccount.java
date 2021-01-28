package com.openclassrooms.paymybuddy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Bank account contact associated to french person.
 * Bank account should belong to person.
 */
@Entity
@Table(name = "bank_account")
public class BankAccount {
    /**
     * RIB of the person.
     * Use as primary key in DataBase.
     */
    @Positive(message = "RIB must be positive")
    @Id
    @Column(name = "rib")
    private long rib;

    /**
     * Bank name where the account is based.
     */
    @NotNull(message = "Bank name cannot be null")
    @Size(max = 40, message = "Bank name must be less than 40 characters")
    @Column(name = "bank")
    private String bank;

    /**
     * IBAN associated to the RIB.
     */
    @NotNull(message = "IBAN cannot be null")
    @Size(max = 40, message = "IBAN must be less than 40 characters")
    @Column(name = "iban")
    private String iban;

    /**
     * BIC associated to the RIB.
     */
    @NotNull(message = "BIC cannot be null")
    @Size(max = 15, message = "BIC must be less than 15 characters")
    @Column(name = "bic")
    private String bic;

    /**
     * Public constructor.
     * Parameters are all needed and non nullable.
     * @param pRib .
     * @param pBank .
     * @param pIban .
     * @param pBic .
     */
    public BankAccount(final long pRib,
                       final String pBank,
                       final String pIban,
                       final String pBic) {
        rib = pRib;
        bank = pBank;
        iban = pIban;
        bic = pBic;
    }

    /**
     * Getter RIB.
     * @return RIB
     */
    public long getRib() {
        return rib;
    }

    /**
     * Setter RIB.
     * @param pRib to set
     */
    public void setRib(final long pRib) {
        rib = pRib;
    }

    /**
     * Getter Bank name.
     * @return Bank name
     */
    public String getBank() {
        return bank;
    }

    /**
     * Setter Bank name.
     * @param pBank name to set
     */
    public void setBank(final String pBank) {
        bank = pBank;
    }

    /**
     * Getter IBAN.
     * @return IBAN
     */
    public String getIban() {
        return iban;
    }

    /**
     * Setter IBAN.
     * @param pIban to set
     */
    public void setIban(final String pIban) {
        iban = pIban;
    }

    /**
     * Getter BIC.
     * @return BIC
     */
    public String getBic() {
        return bic;
    }

    /**
     * Setter BIC.
     * @param pBic to set
     */
    public void setBic(final String pBic) {
        bic = pBic;
    }


}
