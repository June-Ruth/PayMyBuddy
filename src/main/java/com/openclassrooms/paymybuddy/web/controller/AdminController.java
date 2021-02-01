package com.openclassrooms.paymybuddy.web.controller;

import com.openclassrooms.paymybuddy.model.Transfer;
import com.openclassrooms.paymybuddy.model.UserAccount;
import com.openclassrooms.paymybuddy.model.dto.UserInfoDTO;
import com.openclassrooms.paymybuddy.service.TransferService;
import com.openclassrooms.paymybuddy.service.UserAccountService;
import com.openclassrooms.paymybuddy.util.DtoConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminController {
    /**
     * @see Logger
     */
    private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

    private UserAccountService userAccountService;
    private TransferService transferService;

    public AdminController(final UserAccountService pUserAccountService,
                           final TransferService pTransferService) {
        Objects.requireNonNull(pUserAccountService);
        userAccountService = pUserAccountService;
        transferService = pTransferService;
    }

    //TODO ; read all user (ADMIN ONLY)
    @GetMapping(value = "/admin/users")
    public List<UserInfoDTO> getAllUserAccounts() {
        List<UserAccount> userAccounts = userAccountService.findAllUserAccounts();

        List<UserInfoDTO> result = new ArrayList<>();
        for (UserAccount userAccount : userAccounts) {
            UserInfoDTO userDTO = DtoConverter.convertUserAccountToUserInfoDTO(userAccount);
            result.add(userDTO);
        }
        return result;
    }


    //TODO : see all transfer (ADMIN ONLY)
    @GetMapping(value = "/admin/transfers")
    public List<Transfer> getAllTransfers() {
        List<Transfer> transfers = transferService.findAllTransfers();
        return transfers;
    }
}
