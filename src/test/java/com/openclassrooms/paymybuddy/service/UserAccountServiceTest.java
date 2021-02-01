package com.openclassrooms.paymybuddy.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class UserAccountServiceTest {

    @Mock
    private UserAccountService userAccountService;

    //TODO : test findUserAccountById
    // - id existe
    // - id n'existe pas

    //TODO : test findAllUserAccounts
    // - OK

    //TODO : test saveUserAccount
    // - arguments valides && mail inexistant
    // - arguments valides && mail existant
    // - arguments invalides && mail inexistant

    //TODO : test updateUserAccount
    // - id existe && arguments valides
    // - id existe && arguments invalides
    // - id n'existe pas && arguments valides

    //TODO : test deleteUserAccountById
    // - id existe
    // - id n'existe pas

    //TODO : test findUserNetwork
    // - id existe
    // - id n'existe pas

    //TODO : test  saveNewConnectionInUserNetwork
    // - id existe && connection_mail existant
    // - id existe && connection_mail inexistant
    // - id n'existe pas && connection_mail existant

    //TODO : test  saveDeleteConnectionInUserNetwork
    // - id existe && connection_id existant
    // - id existe && connection_id inexistant
    // - id n'existe pas

    //TODO : test  findUserTransfers
    // - id existe
    // - id n'existe pas
}
