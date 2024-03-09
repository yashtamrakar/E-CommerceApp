package org.jsp.ecommerceapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerceapp.model.User;
import org.jsp.ecommerceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User User) {
		return userRepository.save(User);
	}

	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

	public boolean deleteByid(int id) {
		Optional<User> recUser = userRepository.findById(id);
		if (recUser.isPresent()) {
			userRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> verifyByPhonePassword(long phone, String password) {
		return userRepository.verifyByPhonePasword(phone, password);
	}

	public Optional<User> verifyByEmailPassword(String email, String password) {
		return userRepository.verifyByEmailPassword(email, password);
	}

}
