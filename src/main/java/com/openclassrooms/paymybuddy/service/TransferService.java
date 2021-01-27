package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.repository.TransferDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransferService {
    /**
     * @see Logger
     */
    private static final Logger LOGGER = LogManager.getLogger(TransferService.class);

    /**
     * @see TransferDAO
     */
    private final TransferDAO transferDAO;

    /**
     * Public constructor for TransferService.
     * Require non null TransferDAO.
     * @param pTransferDAO not null
     */
    public TransferService(final TransferDAO pTransferDAO) {
        Objects.requireNonNull(pTransferDAO);
        transferDAO = pTransferDAO;
    }
}
