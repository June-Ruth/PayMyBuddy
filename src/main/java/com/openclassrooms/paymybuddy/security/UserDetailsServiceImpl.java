package com.openclassrooms.paymybuddy.security;

import com.openclassrooms.paymybuddy.model.UserAccount;
import com.openclassrooms.paymybuddy.repository.UserAccountDAO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserAccountDAO userAccountDAO;

    public UserDetailsServiceImpl(UserAccountDAO pUserAccountDAO) {
        userAccountDAO = pUserAccountDAO;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) {
        UserAccount userAccount = userAccountDAO.findByEmail(email);
        assert userAccount != null;
        // TODO : créer usernameNotFountException
        return new CustomUserDetails(userAccount);
    }
}
