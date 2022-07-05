package com.op;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface UserRepository extends JpaRepositoryImplementation<User, Long> {

	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email);
	
}
