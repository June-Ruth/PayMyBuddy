package com.openclassrooms.paymybuddy.web.controller;

import com.openclassrooms.paymybuddy.service.UserAccountService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserAccountService userAccountService;

    //TODO : Test createUserAccount
    // - arguments valides && adresse mail inexistante dans DB
    // - arguments valides && adresse mail existante dans DB
    // - arguments invalides && adresse mail inexistante dans DB

    //TODO : Test getUserAccountInfo
    // - Rôle USER && USER.id = user_id
    // - Rôle ADMIN && USER.id ≠ user_id
    // - Rôle USER && USER.id ≠ user_id
    // - user_id inexistant dans DB

    //TODO : Test updateUserAccountInfo
    // - Rôle USER && USER.id = user_id && arguments valides
    // - Rôle USER && USER.id = user_id && arguments invalides
    // - Rôle ADMIN && USER.id ≠ user_id && arguments valides
    // - Rôle USER && USER.id ≠ user_id && arguments valides
    // - user_id inexistant dans DB && arguments valides

    //TODO : Test deleteUserAccount
    // - Rôle USER && USER.id = user_id
    // - Rôle ADMIN && USER.id ≠ user_id
    // - Rôle USER && USER.id ≠ user_id
    // - user_id inexistant dans DB

    //TODO : test getAllUserConnections
    // - Rôle USER && USER.id = user_id
    // - Rôle ADMIN && USER.id ≠ user_id
    // - Rôle USER && USER.id ≠ user_id
    // - user_id inexistant dans DB

    //TODO : test updateToAddNewConnection
    // - Rôle USER && USER.id = user_id && connection_id existant dans DB
    // - Rôle USER && USER.id = user_id && connection_id inexistant dans DB
    // - Rôle ADMIN && USER.id ≠ user_id && connection_id existant dans DB
    // - Rôle USER && USER.id ≠ user_id && connection_id existant dans DB
    // - user_id inexistant dans DB

    //TODO : test updateToDeleteOldConnection
    // - Rôle USER && USER.id = user_id && connection_id existant dans network
    // - Rôle USER && USER.id = user_id && connection_id inexistant dans network
    // - Rôle ADMIN && USER.id ≠ user_id && connection_id existant dans network
    // - Rôle USER && USER.id ≠ user_id && connection_id existant dans network
    // - user_id inexistant dans DB

    //TODO : test getAllUserTransfers
    // - Rôle USER && USER.id = user_id
    // - Rôle ADMIN && USER.id ≠ user_id
    // - Rôle USER && USER.id ≠ user_id
    // - user_id inexistant dans DB

}
