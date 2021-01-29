package com.openclassrooms.paymybuddy.web.controller;

import com.openclassrooms.paymybuddy.model.Transfer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    //TODO : create a transfer
    @PostMapping(value = "/transfers")
    public Transfer createTransfer(@Valid @RequestBody final Transfer transfer) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{transfer_id}")
                .buildAndExpand(transfer.getId())
                .toUri();
        return null;
    }

    //TODO : ? see les derniers transferts que j'ai effectué en tant que user et sender en version simplifié(voir maquette)


    //TODO : see a specific transfer (users concerned only)
    @GetMapping(value = "/transfers/{transfer_id}")
    public Transfer getTransfer(@PathVariable final int transfer_id) {
        return null;
    }

    //TODO : see all transfer (ADMIN ONLY)
    @GetMapping(value = "/transfers")
    public List<Transfer> getAllTransfers() {
        return null;
    }
}
