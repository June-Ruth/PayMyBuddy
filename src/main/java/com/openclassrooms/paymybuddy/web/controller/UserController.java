package com.openclassrooms.paymybuddy.web.controller;

import com.openclassrooms.paymybuddy.model.UserAccount;
import com.openclassrooms.paymybuddy.model.dto.UserInfoDTO;
import com.openclassrooms.paymybuddy.model.dto.UserRestrictedInfoDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    /**
     * @see Logger
     */
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    //TODO : create user account (and bank account)
    @PostMapping(value = "/users")
    public UserAccount createUserAccount(@Valid @RequestBody final UserAccount userAccount) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{user_id}")
                .buildAndExpand(userAccount.getId())
                .toUri();

        return null;
    }

    //TODO ; read all user (ADMIN ONLY)
    @GetMapping(value = "/users")
    public List<UserInfoDTO> getAllUserAccounts() {
        return null;
    }

    //TODO : read my own user information
    @GetMapping(value = "/users/{user_id}")
    public UserInfoDTO getUserAccountInfo(@PathVariable final int user_id) {
        return null;
    }

    //TODO : update my own user information (except transfer log and network)
    @PutMapping(value = "/users/{user_id}")
    public void updateUserAccountInfo(@PathVariable final int user_id,
                                      @Valid @RequestBody final UserInfoDTO userInfoDTO) { }

    //TODO : delete my own user account (and bank account)
    @DeleteMapping(value = "/users/{user_id}")
    public void deleteUserAccount(@PathVariable final int user_id) {}

    //TODO : read only my connections
    @GetMapping(value = "/users/{user_id}/connections")
    public List<UserRestrictedInfoDTO> getAllUserConnections(@PathVariable final int user_id) {
        return null;
    }

    //TODO : ajouter des connections à son network à partir de l'adresse email
    @PutMapping(value = "/users/{user_id}/connections")
    public void updateToAddNewConnection(@PathVariable final int user_id,
                                         @RequestParam(name = "email") final String email) { }

    //TODO : supprimer une connections à son network
    @PutMapping(value = "/users/{user_id}/connections/{connection_id}")
    public void updateToDeleteOldConnection(@PathVariable final int user_id,
                                            @PathVariable final int connection_id) { }

    //TODO : read only my transferlog

    // "/users/{id}/transfer-log"
    // peut trier par date et paginer pour plus de facilité de lecture (voir cours API OC)

}
