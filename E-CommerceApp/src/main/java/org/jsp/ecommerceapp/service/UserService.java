package org.jsp.ecommerceapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerceapp.dao.UserDao;
import org.jsp.ecommerceapp.dto.ResponseStructure;
import org.jsp.ecommerceapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	
	
	
	public ResponseStructure <User> saveUser(User User) {
		ResponseStructure<User>structure= new ResponseStructure<>();
		structure.setMessage("User Saved");
		structure.setData(dao.saveUser(User));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return structure;
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(User m) {
		Optional<User> recMechant = dao.findById(m.getId());
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recMechant.isPresent()) {
			User dbUser = recMechant.get();
			dbUser.setName(m.getName());
			dbUser.setEmail(m.getEmail());
			dbUser.setPhone(m.getPhone());
			dbUser.setPassword(m.getPassword());
			structure.setMessage("User Updated");
			structure.setData(dao.saveUser(m));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
		}
		structure.setMessage("unable Updated");
		structure.setData(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
	}

	public List<User> findAll() {
		List<User> Users = dao.findAll();
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setData(Users);
		structure.setMessage("merchand found ");
		structure.setStatusCode(HttpStatus.OK.value());
		return Users;

	}

	public ResponseEntity<ResponseStructure<User>> findById(int id) {
		Optional<User> recUser = dao.findById(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("User found with id " + id);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		structure.setData(null);
		structure.setMessage("unable to found with id " + id);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<User> recUser = dao.findById(id);
		if (recUser.isPresent()) {
			dao.deleteByid(id);
			structure.setMessage("User found");
			structure.setData("User deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);

		}
		structure.setMessage("Unable to found");
		structure.setData("unable to  delete");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<ResponseStructure<User>> verifyByPhonePassword(long phone, String password) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = dao.verifyByPhonePassword(phone, password);

		if (recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("verified successfully ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		structure.setData(null);
		structure.setMessage("unable to verify ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<User>> verifyByEmailPassword(String email, String password) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = dao.verifyByEmailPassword(email, password);

		if (recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("verified successfully ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		structure.setData(null);
		structure.setMessage("unable to verify ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
	}


}
