package com.openclassrooms.paymybuddy;

import com.openclassrooms.paymybuddy.web.controller.BankAccountController;
import com.openclassrooms.paymybuddy.web.controller.TransferController;
import com.openclassrooms.paymybuddy.web.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PaymybuddyApplicationTests {

	@Autowired
	private TransferController transferController;

	@Autowired
	private UserController userController;

	@Autowired
	private BankAccountController bankAccountController;

	@Test
	void contextLoads() {
		assertNotNull(transferController);
		assertNotNull(userController);
		assertNotNull(bankAccountController);
	}

}
