package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.model.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount findUserAccountById(int id);

    List<UserAccount> findAllUserAccounts();

    UserAccount saveUserAccount(UserAccount userAccount);

    UserAccount updateUserAccount(UserAccount userAccount);

    void deleteUserAccountById(int id);

    List<UserAccount> findUserAccountNetwork(int id);

    UserAccount saveNewConnectionInUserAccountNetwork(int user_id, String connection_email);

    void saveDeleteConnectionInUserAccountNetwork(int user_id, int connection_id);

}
