package com.openclassrooms.paymybuddy.web.controller;

import com.openclassrooms.paymybuddy.service.TransferService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TransferController.class)
public class TransferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransferService transferService;

    @Disabled
    @Test
    void createTransferAsActualUserAndValidArgsTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id && arguments valides
        mockMvc.perform(post("/transfers"))
                .andExpect(status().isCreated());
    }

    @Disabled
    @Test
    void createTransferAsActualUserAndInvalidArgsTest() throws Exception {
        // TODO :  Rôle USER && USER.id = user_id && arguments invalides
        mockMvc.perform(post("/transfers"))
                .andExpect(status().isBadRequest());
    }

    @Disabled
    @Test
    void createTransferAsAdminAndValidArgsTest() throws Exception {
        // TODO : Rôle ADMIN && USER.id ≠ user_id && arguments valides
        mockMvc.perform(post("/transfers"))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void createTransferAsDifferentUserAndValidArgsTest() throws Exception {
        // TODO : Rôle USER && USER.id ≠ user_id && arguments valides
        mockMvc.perform(post("/transfers"))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void getMyTransfersAsSenderAsActualUserTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id
        mockMvc.perform(get("/transfers"))
                .andExpect(status().isOk());

    }

    @Disabled
    @Test
    void getMyTransfersAsSenderAsAdminTest() throws Exception {
        // TODO : Rôle ADMIN && USER.id ≠ user_id
        mockMvc.perform(get("/transfers"))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void getMyTransfersAsSenderAsDifferentUserTest() throws Exception {
        // TODO : Rôle USER && USER.id ≠ user_id
        mockMvc.perform(get("/transfers"))
                .andExpect(status().isForbidden());
    }

    @Disabled
    @Test
    void getTransferAsActualUserAndTransferExistsTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id (sender or receiver) && transfer_id existant dans DB
        int transfer_id = 0;
        mockMvc.perform(get("/transfers/{transfer_id}", transfer_id))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void getTransferAsActualUserAndTransferNotExistsTest() throws Exception {
        // TODO : Rôle USER && USER.id = user_id (sender or receiver) && transfer_id inexistant dans DB
        int transfer_id = 0;
        mockMvc.perform(get("/transfers/{transfer_id}", transfer_id))
                .andExpect(status().isNotFound());

    }

    @Disabled
    @Test
    void getTransferAsAdminAndTransferExistsTest() throws Exception {
        // TODO : Rôle ADMIN && USER.id ≠ user_id (sender or receiver) && transfer_id existant dans DB
        int transfer_id = 0;
        mockMvc.perform(get("/transfers/{transfer_id}", transfer_id))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    void getTransferAsDifferentUserAndTransferExistsTest() throws Exception {
        // TODO : Rôle USER && USER.id ≠ user_id (sender or receiver) && transfer_id existant dans DB
        int transfer_id = 0;
        mockMvc.perform(get("/transfers/{transfer_id}", transfer_id))
                .andExpect(status().isForbidden());
    }


}
