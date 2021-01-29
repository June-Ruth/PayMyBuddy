package com.openclassrooms.paymybuddy.web.controller;

import com.openclassrooms.paymybuddy.model.Transfer;
import com.openclassrooms.paymybuddy.model.UserAccount;
import com.openclassrooms.paymybuddy.model.dto.UserInfoDTO;
import com.openclassrooms.paymybuddy.model.dto.UserRestrictedInfoDTO;
import com.openclassrooms.paymybuddy.service.UserAccountService;
import com.openclassrooms.paymybuddy.util.DtoConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class UserController {
    /**
     * @see Logger
     */
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    private UserAccountService userAccountService;

    public UserController(final UserAccountService pUserAccountService) {
        Objects.requireNonNull(pUserAccountService);
        userAccountService = pUserAccountService;
    }

    //TODO : create user account (and bank account => ok avec Cascade)
    @PostMapping(value = "/users")
    public UserAccount createUserAccount(@Valid @RequestBody final UserInfoDTO userInfoDTO) {
        UserAccount userAccount = DtoConverter.convertUserInfoDTOtoUserAccount(userInfoDTO);

        UserAccount result = userAccountService.saveUserAccount(userAccount);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{user_id}")
                .buildAndExpand(userAccount.getId())
                .toUri();
        ResponseEntity.created(location).build();

        return result;
    }

    //TODO ; read all user (ADMIN ONLY)
    @GetMapping(value = "/users")
    public List<UserInfoDTO> getAllUserAccounts() {
        List<UserAccount> userAccounts = userAccountService.findAllUserAccounts();
        List<UserInfoDTO> result = new ArrayList<>();
        for (UserAccount userAccount : userAccounts) {
            UserInfoDTO userDTO = DtoConverter.convertUserAccountToUserInfoDTO(userAccount);
            result.add(userDTO);
        }
        return result;
    }

    //TODO : read my own user information
    @GetMapping(value = "/users/{user_id}")
    public UserInfoDTO getUserAccountInfo(@PathVariable final int user_id) {
        UserAccount userAccount =userAccountService.findUserAccountById(user_id);
        UserInfoDTO result = DtoConverter.convertUserAccountToUserInfoDTO(userAccount);
        return result;
    }

    //TODO : update my own user information (except transfer log and network)
    @PutMapping(value = "/users/{user_id}")
    public UserAccount updateUserAccountInfo(@PathVariable final int user_id,
                                             @Valid @RequestBody final UserInfoDTO userInfoDTO) {
        UserAccount userAccount = DtoConverter.convertUserInfoDTOtoUserAccount(userInfoDTO); //voir si pas nécessaire de différencier un existant d'un new
        UserAccount result = userAccountService.updateUserAccount(userAccount);
        return result;
    }

    //TODO : delete my own user account (and bank account = OK avec Cascade)
    @DeleteMapping(value = "/users/{user_id}")
    public void deleteUserAccount(@PathVariable final int user_id) {
        userAccountService.deleteUserAccountById(user_id);
    }

    //TODO : read only my connections
    @GetMapping(value = "/users/{user_id}/connections")
    public List<UserRestrictedInfoDTO> getAllUserConnections(@PathVariable final int user_id) {
        List<UserRestrictedInfoDTO> result = new ArrayList<>();
        List<UserAccount> userAccounts = userAccountService.findUserAccountNetwork(user_id);
        for (UserAccount userAccount : userAccounts) {
            UserRestrictedInfoDTO userDTO = DtoConverter.convertUserAccountToUserRestrictedInfoDTO(userAccount);
            result.add(userDTO);
        }
        return result;
    }

    //TODO : ajouter des connections à son network à partir de l'adresse email
    @PutMapping(value = "/users/{user_id}/connections")
    public List<UserRestrictedInfoDTO> updateToAddNewConnection(@PathVariable final int user_id,
                                                                @RequestParam(name = "email") final String connection_email) {
        UserAccount connection = userAccountService.saveNewConnectionInUserAccountNetwork(user_id, connection_email);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{connection_id}")
                .buildAndExpand(connection.getId())
                .toUri();
        ResponseEntity.created(location).build();

        List<UserRestrictedInfoDTO> network = new ArrayList<>(); //à compléter

        return network;
    }

    //TODO : supprimer une connections à son network
    @PutMapping(value = "/users/{user_id}/connections/{connection_id}")
    public List<UserRestrictedInfoDTO> updateToDeleteOldConnection(@PathVariable final int user_id,
                                                                   @PathVariable final int connection_id) {
        userAccountService.saveDeleteConnectionInUserAccountNetwork(user_id, connection_id);

        List<UserRestrictedInfoDTO> network = new ArrayList<>(); //à compléter
        return network;
    }

    //TODO : read only my transferlog
    @GetMapping(value = "/users/{user_id}/transfers")
    public List<Transfer> getAllUserTransfers(@PathVariable final int user_id) {
        return null;
    }
    // peut trier par date et paginer pour plus de facilité de lecture (voir cours API OC)

}
