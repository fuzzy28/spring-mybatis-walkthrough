package org.jrue.persistence;

import org.jrue.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/springConfig.xml"})
public class UserServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void getAllEmployeesFromDatabase() {
		
		for (User user : userService.getAllUser()) {
			 System.out.println(user.getName());
		}
	}
}
