package com.openclassrooms.paymybuddy.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TransferServiceTest {

    @Mock
    private TransferService transferService;

    //TODO : test saveTransfer
    // - arguments valides
    // - arguments invalides

    //TODO : test findTransferById
    // - id existe
    // - id n'existe pas

    //TODO : test findTransferBySender
    // - sender existe
    // - sender n'existe pas

    //TODO : test findAllTransfers
    // - OK
}
