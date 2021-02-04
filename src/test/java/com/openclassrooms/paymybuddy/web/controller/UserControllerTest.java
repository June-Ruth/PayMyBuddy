package com.openclassrooms.paymybuddy.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.paymybuddy.model.BankAccount;
import com.openclassrooms.paymybuddy.model.Transfer;
import com.openclassrooms.paymybuddy.model.TransferType;
import com.openclassrooms.paymybuddy.model.UserAccount;
import com.openclassrooms.paymybuddy.model.dto.UserInfoWithoutBalanceDTO;
import com.openclassrooms.paymybuddy.service.UserAccountService;
 import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserAccountService userAccountService;

    private static Transfer transfer1;
    private static Transfer transfer2;
    private static UserAccount userAccount1;
    private static UserAccount userAccount2;
    private static UserInfoWithoutBalanceDTO userInfoWithoutBalanceDTO;

    private static List<Transfer> transfers = new ArrayList<>();
    private static List<UserAccount> connections = new ArrayList<>();


    @BeforeAll
    static void beforeAll() {
        BankAccount bankAccount1 = new BankAccount(123, "bank1", "iban1", "bic1");
        BankAccount bankAccount2 = new BankAccount(456, "bank2", "iban2", "bic2");
        userAccount1 = new UserAccount("firstName1", "lastName1", "user1@mail.com",  "password1", bankAccount1, 0, connections, transfers);
        userAccount2 = new UserAccount("firstName2", "lastName2", "user2@mail.com",  "password2", bankAccount2, 0, null, null);
        transfer1 = new Transfer(userAccount1, userAccount2, "description1", LocalDate.of(2020, 1, 1), 100, 1, TransferType.TRANSFER_BETWEEN_USER);
        transfer2 = new Transfer(userAccount1, userAccount1, "description2", LocalDate.of(2020, 2, 2), 100, 0, TransferType.TRANFER_WITH_BANK);
        transfers.add(transfer1);
        transfers.add(transfer2);
        connections.add(userAccount2);
        userInfoWithoutBalanceDTO = new UserInfoWithoutBalanceDTO();
        userInfoWithoutBalanceDTO.setFirstName(userAccount1.getFirstName());
        userInfoWithoutBalanceDTO.setLastName(userAccount1.getLastName());
        userInfoWithoutBalanceDTO.setEmail(userAccount1.getEmail());
        userInfoWithoutBalanceDTO.setPassword(userAccount1.getPassword());
        userInfoWithoutBalanceDTO.setBankAccount(userAccount1.getBankAccount());
    }

    @Test
    void createAccountWithValidArgsAndEmailNotExistsTest() throws Exception {
        // TODO : arguments valides && adresse mail inexistante dans DB
        when(userAccountService.findIfUserAccountExistsByEmail(any(String.class))).thenReturn(false);
        when(userAccountService.saveUserAccount(any(UserAccount.class))).thenReturn(userAccount1);
        mockMvc.perform(post("/users")
                .content(new ObjectMapper().writeValueAsString(userInfoWithoutBalanceDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void createAccountWithInvalidArgsAndEmailNotExistsTest() throws Exception {
        //TODO : argement invalides
        UserInfoWithoutBalanceDTO userInfoWithoutBalanceDTO1 = new UserInfoWithoutBalanceDTO();
        userInfoWithoutBalanceDTO1.setFirstName(null);
        userInfoWithoutBalanceDTO1.setLastName(userAccount1.getLastName());
        userInfoWithoutBalanceDTO1.setEmail(userAccount1.getEmail());
        userInfoWithoutBalanceDTO1.setPassword(userAccount1.getPassword());
        userInfoWithoutBalanceDTO1.setBankAccount(userAccount1.getBankAccount());
        mockMvc.perform(post("/users")
                .content(new ObjectMapper().writeValueAsString(userInfoWithoutBalanceDTO1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getUserAccountInfoAsActualUserTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id
        int user_id = 0;
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(userAccount1);
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

    @Test
    void getUserAccountInfoAsNotExistsUserTest() throws Exception {
        // TODO : user_id inexistant dans DB
        int user_id = 0;
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(null);
        mockMvc.perform(get("/users/{user_id}", user_id))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateUserAccountInfoAsActualUserAndValidArgsTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id && arguments valides
        int user_id = 0;
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(userAccount1);
        when(userAccountService.updateUserAccount(any(UserAccount.class))).thenReturn(userAccount1);
        mockMvc.perform(put("/users/{user_id}", user_id)
                .content(new ObjectMapper().writeValueAsString(userInfoWithoutBalanceDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateUserAccountInfoAsActualUserAndInvalidArgsTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id && arguments invalides
        int user_id = 0;
        UserInfoWithoutBalanceDTO userInfoWithoutBalanceDTO1 = new UserInfoWithoutBalanceDTO();
        userInfoWithoutBalanceDTO1.setFirstName(null);
        userInfoWithoutBalanceDTO1.setLastName(userAccount1.getLastName());
        userInfoWithoutBalanceDTO1.setEmail(userAccount1.getEmail());
        userInfoWithoutBalanceDTO1.setPassword(userAccount1.getPassword());
        userInfoWithoutBalanceDTO1.setBankAccount(userAccount1.getBankAccount());
        mockMvc.perform(put("/users/{user_id}", user_id)
                .content(new ObjectMapper().writeValueAsString(userInfoWithoutBalanceDTO1))
                .contentType(MediaType.APPLICATION_JSON))
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

    @Test
    void updateUserAccountInfoAsNotExistsUserAndValidArgsTest() throws Exception {
        // TODO : user_id inexistant dans DB && arguments valides
        int user_id = 0;
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(null);
        mockMvc.perform(put("/users/{user_id}", user_id)
                .content(new ObjectMapper().writeValueAsString(userInfoWithoutBalanceDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteUserAccountAsActualUserTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id
        int user_id = 0;
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(userAccount1);
        when(userAccountService.deleteUserAccountById(any(Integer.class))).thenReturn(true);
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

    @Test
    void deleteUserAccountAsNotExistsUserTest() throws Exception {
        // TODO : user_id inexistant dans DB
        int user_id = 0;
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(null);
        mockMvc.perform(delete("/users/{user_id}", user_id))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllUserConnectionsAsActualUserTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id
        int user_id = 0;
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(userAccount1);
        when(userAccountService.findUserNetwork(any(Integer.class))).thenReturn(connections);
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

    @Test
    void getAllUserConnectionsAsNotExistsUserTest() throws Exception {
        // TODO : user_id inexistant dans DB
        int user_id = 0;
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(null);
        when(userAccountService.findUserNetwork(any(Integer.class))).thenReturn(connections);
        mockMvc.perform(get("/users/{user_id}/connections", user_id))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateToAddNewConnectionAsActualUserAndConnectionExistsTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id && connection_mail existant dans DB
        int user_id = 0;
        String email = "connection@mail.com";
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(userAccount1);
        when(userAccountService.findIfUserAccountExistsByEmail(any(String.class))).thenReturn(true);
        when(userAccountService.saveNewConnectionInUserNetwork(any(Integer.class), any(String.class))).thenReturn(userAccount1);
        mockMvc.perform(put("/users/{user_id}/connections?email=" + email, user_id))
                .andExpect(status().isCreated());
    }

    @Test
    void updateToAddNewConnectionAsActualUserAndConnectionNotExistsTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id && connection_mail inexistant dans DB
        int user_id = 0;
        String email = "connection@mail.com";
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(userAccount1);
        when(userAccountService.findIfUserAccountExistsByEmail(any(String.class))).thenReturn(false);
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

    @Test
    void updateToAddNewConnectionAsNotExistsUserAndConnectionExistsTest() throws Exception {
        // TODO : user_id inexistant dans DB
        int user_id = 0;
        String email = "connection@mail.com";
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(null);
        mockMvc.perform(put("/users/{user_id}/connections?email=" + email, user_id))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateToDeleteOldConnectionExistsAsActualUserTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id && connection_id existant dans network
        int user_id = 0;
        int connection_id = 1;
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(userAccount1);
        when(userAccountService.findConnectionById(any(Integer.class))).thenReturn(userAccount2);
        when(userAccountService.saveDeleteConnectionInUserNetwork(any(Integer.class), any(Integer.class))).thenReturn(userAccount1);
        mockMvc.perform(put("/users/{user_id}/connections/{connection_id}", user_id, connection_id))
                .andExpect(status().isOk());
    }

    @Test
    void updateToDeleteOldConnectionNotExistsAsActualUserTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id && connection_id inexistant dans network
        int user_id = 0;
        int connection_id = 1;
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(userAccount1);
        when(userAccountService.findConnectionById(any(Integer.class))).thenReturn(null);
        mockMvc.perform(put("/users/{user_id}/connections/{connection_id}", user_id, connection_id))
                .andExpect(status().isNotFound());
    }

    @Disabled
    @Test
    void updateToDeleteOldConnectionExistsAsAdminTest() throws Exception {
        // TODO : Rôle ADMIN && USER.id ≠ user_id && connection_id existant dans network
        int user_id = 0;
        int connection_id = 1;
        mockMvc.perform(put("/users/{user_id}/connections/{connection_id}", user_id, connection_id))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void updateToDeleteOldConnectionExistsAsDifferentUserTest() throws Exception {
        // TODO : Rôle USER && USER.id ≠ user_id && connection_id existant dans network
        int user_id = 0;
        int connection_id = 1;
        mockMvc.perform(put("/users/{user_id}/connections/{connection_id}", user_id, connection_id))
                .andExpect(status().isForbidden());
    }

    @Test
    void updateToDeleteOldConnectionExistsAsNotExistsUserTest() throws Exception {
        // TODO : user_id inexistant dans DB
        int user_id = 0;
        int connection_id = 1;
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(null);
        when(userAccountService.findConnectionById(any(Integer.class))).thenReturn(userAccount2);
        mockMvc.perform(put("/users/{user_id}/connections/{connection_id}", user_id, connection_id))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllUserTransfersAsActualUser() throws Exception {
        // TODO : Rôle USER && USER.id = user_id
        int user_id = 0;
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(userAccount1);
        when(userAccountService.findUserTransfers(any(Integer.class))).thenReturn(transfers);
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

    @Test
    void getAllUserTransfersAsNotExistsUser() throws Exception {
        // TODO : user_id inexistant dans DB
        int user_id = 0;
        when(userAccountService.findUserAccountById(any(Integer.class))).thenReturn(null);
        mockMvc.perform(get("/users/{user_id}/transfers", user_id))
                .andExpect(status().isNotFound());
    }

}
