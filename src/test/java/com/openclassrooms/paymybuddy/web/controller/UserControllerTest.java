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
    // - avec des arguments valides
    // - avec une adresse mail déjà existante
    // - avec des arguments invalides

    //TODO : Test getAllUserAccounts
    // - quand est ADMIN et ok
    // - quand est ADMIN et nok
    // - quand n'est pas admin

    //TODO : Test getUserAccountInfo
    // - quand id = l'id de l'utilisateur de la session
    // - quand est ADMIN avec id de session différent de id
    // - quand l'id n'existe pas et ne trouve pas le profil
    // - quand il n'a pas les droits nécessaires (si n'est pas le user de la session ou admin)

    //TODO : Test updateUserAccountInfo
    // - quand id = id de l'utilisateur de la session et que les données sont valides
    // - quand l'id n'existe pas et ne trouve pas le profil
    // - quand les informations entrées ne sont pas valides
    // - quand il n'a pas les droits nécessaire (si n'est pas le user de la session)

    //TODO : Test deleteUserAccount
    // - quand id = id de l'utilisateur de la session
    // - quand est admin
    // - quand id n'existe pas

    //TODO : test getAllUserConnections

    //TODO : test updateToAddNewConnection

    //TODO : test updateToDeleteOldConnection

    //TODO : test getAllUserTransfers

}
