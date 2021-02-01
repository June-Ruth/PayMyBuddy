package com.openclassrooms.paymybuddy.web.controller;

import com.openclassrooms.paymybuddy.model.BankAccount;
import com.openclassrooms.paymybuddy.model.Transfer;
import com.openclassrooms.paymybuddy.model.TransferType;
import com.openclassrooms.paymybuddy.model.UserAccount;
import com.openclassrooms.paymybuddy.service.TransferService;
import com.openclassrooms.paymybuddy.service.UserAccountService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AdminController.class)
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserAccountService userAccountService;

    @MockBean
    private TransferService transferService;

    private static List<UserAccount> userAccounts = new ArrayList<>();

    private static List<Transfer> transfers = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        BankAccount bankAccount1 = new BankAccount(123, "bank1", "iban1", "bic1");
        BankAccount bankAccount2 = new BankAccount(456, "bank2", "iban2", "bic2");
        UserAccount userAccount1 = new UserAccount("firstName1", "lastName1", "user1@mail.com",  "password1", bankAccount1, 0, null, null);
        UserAccount userAccount2 = new UserAccount("firstName2", "lastName2", "user2@mail.com",  "password2", bankAccount2, 0, null, null);
        userAccounts.add(userAccount1);
        userAccounts.add(userAccount2);
        Transfer transfer1 = new Transfer(userAccount1, userAccount2, "description1", LocalDate.of(2020, 1, 1), 100, 1, TransferType.TRANSFER_BETWEEN_USER);
        Transfer transfer2 = new Transfer(userAccount1, userAccount1, "description2", LocalDate.of(2020, 2, 2), 100, 0, TransferType.TRANFER_WITH_BANK);
        transfers.add(transfer1);
        transfers.add(transfer2);
    }

    @Disabled
    @Test
    void getAllUserAccountsAsAdminTest() throws Exception {
        //TODO : Rôle ADMIN
        when(userAccountService.findAllUserAccounts()).thenReturn(userAccounts);
        mockMvc.perform(get("/admin/users"))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void getAllUserAccountsAsUserTest() throws Exception {
        //TODO : Rôle USER
        mockMvc.perform(get("/admin/users"))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void getAllTransfersAsAdminTest() throws Exception {
        // TODO : Rôle ADMIN
        when(transferService.findAllTransfers()).thenReturn(transfers);
        mockMvc.perform(get("/admin/transfers"))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void getAllTransfersAsUserTest() throws Exception {
        // TODO : Rôle USER
        mockMvc.perform(get("/admin/transfers"))
                .andExpect(status().isForbidden());
    }
}
