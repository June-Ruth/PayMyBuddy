package com.openclassrooms.paymybuddy.security;

import com.openclassrooms.paymybuddy.model.BankAccount;
import com.openclassrooms.paymybuddy.model.Privilege;
import com.openclassrooms.paymybuddy.model.Role;
import com.openclassrooms.paymybuddy.model.UserAccount;
import com.openclassrooms.paymybuddy.repository.PrivilegeDAO;
import com.openclassrooms.paymybuddy.repository.RoleDAO;
import com.openclassrooms.paymybuddy.repository.UserAccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class SetUpDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserAccountDAO userAccountDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PrivilegeDAO privilegeDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(!alreadySetup) {
            Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
            Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

            List<Privilege> adminPrivileges = new ArrayList<>();
            adminPrivileges.add(readPrivilege);
            adminPrivileges.add(writePrivilege);
            List<Privilege> userPrivileges = new ArrayList<>();
            userPrivileges.add(readPrivilege);
            userPrivileges.add(writePrivilege);

            Role adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
            Role userRole = createRoleIfNotFound("ROLE_USER", userPrivileges);

            List<Role> roles = new ArrayList<>();
            roles.add(adminRole);
            roles.add(userRole);
            BankAccount bankAccount = new BankAccount("RIB", "Banque", "IBAN", "BIC");
            UserAccount userAccount = new UserAccount("FirstName", "LastName", "email@test.com", passwordEncoder.encode("password"), roles, bankAccount, 0, new ArrayList<>(), new ArrayList<>());

            if (!userAccountDAO.existsByEmail(userAccount.getEmail())) {
                userAccountDAO.save(userAccount);
            }
            alreadySetup = true;
        }
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {
        Privilege privilege = privilegeDAO.findByName(name);
        if(privilege == null) {
            privilege = new Privilege(name);
            privilegeDAO.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {
        Role role = roleDAO.findByName(name);
        if (role == null) {
            role = new Role(name, privileges);
            roleDAO.save(role);
        }
        return role;
    }
}
