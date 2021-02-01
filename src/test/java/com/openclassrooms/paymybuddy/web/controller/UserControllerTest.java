package com.openclassrooms.paymybuddy.web.controller;

import com.openclassrooms.paymybuddy.service.UserAccountService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserAccountService userAccountService;

    @Disabled
    @Test
    void createAccountWithValidArgsAndEmailNotExistsTest() throws Exception {
        // TODO : arguments valides && adresse mail inexistante dans DB
        mockMvc.perform(post("/users"))
                .andExpect(status().isCreated());
    }

    @Disabled
    @Test
    void createAccountWithValidArgsAndEmailExistsTest() throws Exception {
        // TODO : arguments valides && adresse mail existante dans DB
        mockMvc.perform(post("/users"))
                .andExpect(status().isConflict());
    }

    @Disabled
    @Test
    void createAccountWithInvalidArgsAndEmailNotExistsTest() throws Exception {
        // TODO : arguments invalides && adresse mail inexistante dans DB
        mockMvc.perform(post("/users"))
                .andExpect(status().isBadRequest());
    }

    @Disabled
    @Test
    void getUserAccountInfoAsActualUserTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id
        int user_id = 0;
        mockMvc.perform(get("/users/{user_id}", user_id))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void getUserAccountInfoAsAdminTest() throws Exception {
        // TODO : Rôle ADMIN && USER.id ≠ user_id
        int user_id = 0;
        mockMvc.perform(get("/users/{user_id}", user_id))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void getUserAccountInfoAsDifferentUserTest() throws Exception {
        // TODO : Rôle USER && USER.id ≠ user_id
        int user_id = 0;
        mockMvc.perform(get("/users/{user_id}", user_id))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void getUserAccountInfoAsNotExistsUserTest() throws Exception {
        // TODO : user_id inexistant dans DB
        int user_id = 0;
        mockMvc.perform(get("/users/{user_id}", user_id))
                .andExpect(status().isNotFound());
    }

    @Disabled
    @Test
    void updateUserAccountInfoAsActualUserAndValidArgsTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id && arguments valides
        int user_id = 0;
        mockMvc.perform(put("/users/{user_id}", user_id))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void updateUserAccountInfoAsActualUserAndInvalidArgsTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id && arguments invalides
        int user_id = 0;
        mockMvc.perform(put("/users/{user_id}", user_id))
                .andExpect(status().isBadRequest());
    }

    @Disabled
    @Test
    void updateUserAccountInfoAsAdminAndValidArgsTest() throws Exception {
        // TODO : Rôle ADMIN && USER.id ≠ user_id && arguments valides
        int user_id = 0;
        mockMvc.perform(put("/users/{user_id}", user_id))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void updateUserAccountInfoAsDifferentUserAndValidArgsTest() throws Exception {
        // TODO : Rôle USER && USER.id ≠ user_id && arguments valides
        int user_id = 0;
        mockMvc.perform(put("/users/{user_id}", user_id))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void updateUserAccountInfoAsNotExistsUserAndValidArgsTest() throws Exception {
        // TODO : user_id inexistant dans DB && arguments valides
        int user_id = 0;
        mockMvc.perform(put("/users/{user_id}", user_id))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void deleteUserAccountAsActualUserTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id
        int user_id = 0;
        mockMvc.perform(delete("/users/{user_id}", user_id))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void deleteUserAccountAsAdminTest() throws Exception {
        // TODO : Rôle ADMIN && USER.id ≠ user_id
        int user_id = 0;
        mockMvc.perform(delete("/users/{user_id}", user_id))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void deleteUserAccountAsDifferentUserTest() throws Exception {
        // TODO : Rôle USER && USER.id ≠ user_id
        int user_id = 0;
        mockMvc.perform(delete("/users/{user_id}", user_id))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void deleteUserAccountAsNotExistsUserTest() throws Exception {
        // TODO : user_id inexistant dans DB
        int user_id = 0;
        mockMvc.perform(delete("/users/{user_id}", user_id))
                .andExpect(status().isNotFound());
    }

    @Disabled
    @Test
    void getAllUserConnectionsAsActualUserTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id
        int user_id = 0;
        mockMvc.perform(get("/users/{user_id}/connections", user_id))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void getAllUserConnectionsAsAdminTest() throws Exception {
        // TODO : Rôle ADMIN && USER.id ≠ user_id
        int user_id = 0;
        mockMvc.perform(get("/users/{user_id}/connections", user_id))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void getAllUserConnectionsAsDifferentUserTest() throws Exception {
        // TODO : Rôle USER && USER.id ≠ user_id
        int user_id = 0;
        mockMvc.perform(get("/users/{user_id}/connections", user_id))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void getAllUserConnectionsAsNotExistsUserTest() throws Exception {
        // TODO : user_id inexistant dans DB
        int user_id = 0;
        mockMvc.perform(get("/users/{user_id}/connections", user_id))
                .andExpect(status().isNotFound());
    }

    @Disabled
    @Test
    void updateToAddNewConnectionAsActualUserAndConnectionExistsTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id && connection_mail existant dans DB
        int user_id = 0;
        String email = "connection@mail.com";
        mockMvc.perform(put("/users/{user_id}/connections?email=" + email, user_id))
                .andExpect(status().isCreated());
    }

    @Disabled
    @Test
    void updateToAddNewConnectionAsActualUserAndConnectionNotExistsTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id && connection_mail inexistant dans DB
        int user_id = 0;
        String email = "connection@mail.com";
        mockMvc.perform(put("/users/{user_id}/connections?email=" + email, user_id))
                .andExpect(status().isNotFound());
    }

    @Disabled
    @Test
    void updateToAddNewConnectionAsAdminAndConnectionExistsTest() throws Exception {
        // TODO : Rôle ADMIN && USER.id ≠ user_id && connection_mail existant dans DB
        int user_id = 0;
        String email = "connection@mail.com";
        mockMvc.perform(put("/users/{user_id}/connections?email=" + email, user_id))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void updateToAddNewConnectionAsDifferentUserAndConnectionExistsTest() throws Exception {
        // TODO : Rôle USER && USER.id ≠ user_id && connection_mail existant dans DB
        int user_id = 0;
        String email = "connection@mail.com";
        mockMvc.perform(put("/users/{user_id}/connections?email=" + email, user_id))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void updateToAddNewConnectionAsNotExistsUserAndConnectionExistsTest() throws Exception {
        // TODO : user_id inexistant dans DB
        int user_id = 0;
        String email = "connection@mail.com";
        mockMvc.perform(put("/users/{user_id}/connections?email=" + email, user_id))
                .andExpect(status().isNotFound());
    }

    @Disabled
    @Test
    void updateToDeleteOldConnectionExistsAsActualUserTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id && connection_id existant dans network
        int user_id = 0;
        int connection_id = 1;
        mockMvc.perform(put("/user/{user_id}/connections/{connection_id}", user_id, connection_id))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void updateToDeleteOldConnectionNotExistsAsActualUserTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id && connection_id inexistant dans network
        int user_id = 0;
        int connection_id = 1;
        mockMvc.perform(put("/user/{user_id}/connections/{connection_id}", user_id, connection_id))
                .andExpect(status().isNotFound());
    }

    @Disabled
    @Test
    void updateToDeleteOldConnectionExistsAsAdminTest() throws Exception {
        // TODO : Rôle ADMIN && USER.id ≠ user_id && connection_id existant dans network
        int user_id = 0;
        int connection_id = 1;
        mockMvc.perform(put("/user/{user_id}/connections/{connection_id}", user_id, connection_id))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void updateToDeleteOldConnectionExistsAsDifferentUserTest() throws Exception {
        // TODO : Rôle USER && USER.id ≠ user_id && connection_id existant dans network
        int user_id = 0;
        int connection_id = 1;
        mockMvc.perform(put("/user/{user_id}/connections/{connection_id}", user_id, connection_id))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void updateToDeleteOldConnectionExistsAsNotExistsUserTest() throws Exception {
        // TODO : user_id inexistant dans DB
        int user_id = 0;
        int connection_id = 1;
        mockMvc.perform(put("/user/{user_id}/connections/{connection_id}", user_id, connection_id))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void getAllUserTransfersAsActualUser() throws Exception {
        // TODO : Rôle USER && USER.id = user_id
        int user_id = 0;
        mockMvc.perform(get("/users/{user_id}/transfers", user_id))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void getAllUserTransfersAsAdmin() throws Exception {
        // TODO : Rôle ADMIN && USER.id ≠ user_id
        int user_id = 0;
        mockMvc.perform(get("/users/{user_id}/transfers", user_id))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void getAllUserTransfersAsDifferentUser() throws Exception {
        // TODO : Rôle USER && USER.id ≠ user_id
        int user_id = 0;
        mockMvc.perform(get("/users/{user_id}/transfers", user_id))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void getAllUserTransfersAsNotExistsUser() throws Exception {
        // TODO : user_id inexistant dans DB
        int user_id = 0;
        mockMvc.perform(get("/users/{user_id}/transfers", user_id))
                .andExpect(status().isNotFound());
    }

}
