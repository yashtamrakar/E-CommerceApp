package org.jsp.ecommerceapp.repository;

import java.util.Optional;

import org.jsp.ecommerceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository  extends JpaRepository<User, Integer>{
	
	@Query("select m from User m where m.email=?1 and m.password=?2")
	public Optional<User> verifyByEmailPassword(String email ,String password);


	@Query("select m from User m where m.phone=?1 and m.password=?2")
	public Optional<User> verifyByPhonePasword(long phone, String password);

}
