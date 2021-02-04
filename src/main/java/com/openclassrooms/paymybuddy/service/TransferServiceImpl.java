package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.model.Transfer;
import com.openclassrooms.paymybuddy.model.UserAccount;
import com.openclassrooms.paymybuddy.repository.TransferDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
//TODO : @Transactionnal : permet le rollback + test rollback et commit
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
        return transferDAO.save(transfer);
    }

    @Override
    public Transfer findTransferById(int transfer_id) {
        return transferDAO.findById(transfer_id);
    }

    @Override
    public List<Transfer> findTransferBySender(UserAccount sender) {
        return transferDAO.findAllBySender(sender);
    }

    @Override
    public List<Transfer> findAllTransfers() {
        return transferDAO.findAll();
    }
}
