package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.model.Transfer;

import java.util.List;

public interface TransferService {

    Transfer saveTransfer(Transfer transfer);

    Transfer findTransferById(int transfer_id);

    List<Transfer> findTransferBySender(int sender_id);

    List<Transfer> findAllTransfers();

}
