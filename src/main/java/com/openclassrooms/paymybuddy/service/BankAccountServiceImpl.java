package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.repository.BankAccountDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    /**
     * @see Logger
     */
    private static final Logger LOGGER = LogManager.getLogger(BankAccountServiceImpl.class);

    /**
     * @see BankAccountDAO
     */
    private final BankAccountDAO bankAccountDAO;

    /**
     * Public constructor for BankAccountService.
     * Require non null BankAccountDAO.
     * @param pBankAccountDAO not null
     */
    public BankAccountServiceImpl(final BankAccountDAO pBankAccountDAO) {
        Objects.requireNonNull(pBankAccountDAO);
        bankAccountDAO = pBankAccountDAO;
    }
}
