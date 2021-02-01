package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.model.UserAccount;
import com.openclassrooms.paymybuddy.repository.UserAccountDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public UserAccount findUserAccountById(int id) {
        return null;
    }

    @Override
    public List<UserAccount> findAllUserAccounts() {
        return null;
    }

    @Override
    public UserAccount saveUserAccount(UserAccount userAccount) {
        return null;
    }

    @Override
    public UserAccount updateUserAccount(UserAccount userAccount) {
        return null;
    }

    @Override
    public void deleteUserAccountById(int id) {

    }

    @Override
    public List<UserAccount> findUserNetwork(int id) {
        return null;
    }

    @Override
    public UserAccount saveNewConnectionInUserNetwork(int user_id, String connection_email) {
        return null;
    }

    @Override
    public void saveDeleteConnectionInUserNetwork(int user_id, int connection_id) {

    }
}
