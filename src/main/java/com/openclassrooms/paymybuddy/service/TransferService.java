package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.model.Transfer;
import com.openclassrooms.paymybuddy.model.UserAccount;

import java.util.List;

public interface TransferService {

    Transfer saveTransfer(Transfer transfer);

    Transfer findTransferById(int transfer_id);

    List<Transfer> findTransferBySender(UserAccount sender);

    List<Transfer> findAllTransfers();

}
