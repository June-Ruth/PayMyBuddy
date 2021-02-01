package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.model.Transfer;
import com.openclassrooms.paymybuddy.repository.TransferDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
//TODO : @Transactionnal : permet le rollback
public class TransferServiceImpl implements TransferService {
    /**
     * @see Logger
     */
    private static final Logger LOGGER = LogManager.getLogger(TransferServiceImpl.class);

    /**
     * @see TransferDAO
     */
    private final TransferDAO transferDAO;

    /**
     * Public constructor for TransferService.
     * Require non null TransferDAO.
     * @param pTransferDAO not null
     */
    public TransferServiceImpl(final TransferDAO pTransferDAO) {
        Objects.requireNonNull(pTransferDAO);
        transferDAO = pTransferDAO;
    }

    @Override
    public Transfer saveTransfer(Transfer transfer) {
        return null;
    }

    @Override
    public Transfer findTransferById(int transfer_id) {
        return null;
    }

    @Override
    public List<Transfer> findTransferBySender(int sender_id) {
        return null;
    }
}
