package com.noxilaman.carcareshop;

import com.noxilaman.carcareshop.entity.User;
import com.noxilaman.carcareshop.exception.BaseException;
import com.noxilaman.carcareshop.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestUserService {

	@Autowired
	private UserService userService;

	@Order(1)
	@Test
	void testCreate() throws BaseException {
		User user = userService.create(TestData.email,TestData.password,TestData.name);

		Assertions.assertNotNull(user);
		Assertions.assertNotNull(user.getId());

		Assertions.assertEquals(TestData.email,user.getEmail());

		boolean isPassMatched = userService.matchPassword(TestData.password, user.getPassword());
		Assertions.assertTrue(isPassMatched);

		Assertions.assertEquals(TestData.name,user.getName());

		user = userService.create(TestData.email,TestData.password,TestData.name);

		Assertions.assertNotNull(user);

	}

	@Order(2)
	@Test
	void testUpdate() throws BaseException{
		User user = userService.updateName(1,TestData.name2);

		Assertions.assertEquals(TestData.name2,user.getName());

	}

	@Order(3)
	@Test
	void testDelete()  throws BaseException{
		boolean  result = userService.deleteByEmail(TestData.email);
	}

	interface TestData {
		String email = "ponghhh2@test.com";

		String password = "12345678";

		String name = "test1";

		String name2 = "test2";
	}
}
