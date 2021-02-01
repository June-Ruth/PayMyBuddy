package com.openclassrooms.paymybuddy.web.controller;

import com.openclassrooms.paymybuddy.model.Transfer;
import com.openclassrooms.paymybuddy.service.TransferService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class TransferController {
    /**
     * @see Logger
     */
    private static final Logger LOGGER = LogManager.getLogger(TransferController.class);

    private TransferService transferService;

    public TransferController(final TransferService pTransferService){
        transferService = pTransferService;
    }

    //TODO : create a transfer
    @PostMapping(value = "/transfers")
    public Transfer createTransfer(@Valid @RequestBody final Transfer transfer) {

        transferService.saveTransfer(transfer);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{transfer_id}")
                .buildAndExpand(transfer.getId())
                .toUri();
        ResponseEntity.created(location).build();

        return null;
    }

    //TODO : see les derniers transferts que j'ai effectué en tant que user en version simplifié(voir maquette)
    @GetMapping(value = "/transfers")
    public List<Transfer> getMyTransfersAsSender() {
        int user_id = 0;
        transferService.findTransferBySender(user_id);
        return null;
    }

    //TODO : see a specific transfer as sender or receiver (users concerned only)
    @GetMapping(value = "/transfers/{transfer_id}")
    public Transfer getTransfer(@PathVariable final int transfer_id) {
        transferService.findTransferById(transfer_id);
        return null;
    }

}
