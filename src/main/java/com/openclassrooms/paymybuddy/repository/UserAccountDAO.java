package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountDAO extends JpaRepository<UserAccount, Integer> {

    UserAccount findById(int id);

    boolean existsByEmail (String email);

    List<UserAccount> findAll();

    UserAccount save(UserAccount userAccount);

    boolean deleteById (int id);

    UserAccount findByEmail(String email);

    boolean existsById(int id);
}
