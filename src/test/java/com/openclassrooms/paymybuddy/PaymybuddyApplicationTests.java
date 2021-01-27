package com.openclassrooms.paymybuddy;

import com.openclassrooms.paymybuddy.login.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class PaymybuddyApplicationTests {

	@Autowired
	private LoginController controller;

	@Test
	void contextLoads() throws Exception {
		assertNotNull(controller);
	}

}
