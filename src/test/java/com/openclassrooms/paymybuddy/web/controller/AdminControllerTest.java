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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserAccountService userAccountService;

    @Disabled
    @Test
    void getAllUserAccountsAsAdminTest() throws Exception {
        //TODO : Rôle ADMIN
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
