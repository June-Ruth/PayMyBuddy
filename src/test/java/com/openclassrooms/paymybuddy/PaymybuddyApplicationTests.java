package com.openclassrooms.paymybuddy;

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

	@Test
	void contextLoads() {
		assertNotNull(transferController);
		assertNotNull(userController);
	}

}
