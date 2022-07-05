package com.op;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		
		User user=new User();
		user.setEmail("suraj2@gmail.com");
		user.setPassword("Suraj123");
		user.setFirstName("Suraj");
		user.setLastName("Ratna");
		
		User savedUser = repo.save(user);
		
		User exitUser = entityManager.find(User.class, savedUser.getId());
		assertThat(exitUser.getEmail()).isEqualTo(user.getEmail());
	}
	
	@Test
	public void testFindUserByEmail() {
		String email="op@gmail.com";
		
		User user=repo.findByEmail(email);
		assertThat(user).isNotNull();
	}
}
