package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.repository.UserAccountDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    /**
     * @see Logger
     */
    private static final Logger LOGGER = LogManager.getLogger(UserAccountServiceImpl.class);

    /**
     * @see UserAccountDAO
     */
    private final UserAccountDAO userAccountDAO;

    /**
     * Public constructor for UserAccountService.
     * Require non null UserAccountDAO.
     * @param pUserAccountDAO not null
     */
    public UserAccountServiceImpl(final UserAccountDAO pUserAccountDAO) {
        Objects.requireNonNull(pUserAccountDAO);
        userAccountDAO = pUserAccountDAO;
    }
}
