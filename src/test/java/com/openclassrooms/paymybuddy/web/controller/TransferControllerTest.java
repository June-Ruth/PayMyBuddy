package com.openclassrooms.paymybuddy.web.controller;

import com.openclassrooms.paymybuddy.service.TransferService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TransferController.class)
public class TransferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransferService transferService;

    //TODO : test createTransfer
    // - Rôle USER && USER.id = user_id && arguments valides
    // - Rôle USER && USER.id = user_id && arguments invalides
    // - Rôle ADMIN && USER.id ≠ user_id && arguments valides
    // - Rôle USER && USER.id ≠ user_id && arguments valides

    //TODO : test getMyTransfersAsSender
    // - Rôle USER && USER.id = user_id
    // - Rôle USER && USER.id = user_id
    // - Rôle ADMIN && USER.id ≠ user_id
    // - Rôle USER && USER.id ≠ user_id

    //TODO : test getTransfer
    // - Rôle USER && USER.id = user_id && transfer_id existant dans DB
    // - Rôle USER && USER.id = user_id && transfer_id inexistant dans DB
    // - Rôle ADMIN && USER.id ≠ user_id && transfer_id existant dans DB
    // - Rôle USER && USER.id ≠ user_id && transfer_id existant dans DB

}
