package org.jsp.ecommerceapp.controller;

import java.util.List;

import org.jsp.ecommerceapp.dto.ResponseStructure;
import org.jsp.ecommerceapp.model.User;
import org.jsp.ecommerceapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseStructure<User> saveUser(@RequestBody User User){
		return service. saveUser(User);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User m) {
		return service.updateUser(m);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<User>> findById(@PathVariable(name = "id") int id) {
		return service.findById(id);
	}

	@GetMapping
	public List<User> findAll() {
		return service.findAll();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable(name = "id") int id) {
		return service.deleteById(id);
	}

	@PostMapping(value = "/verfy-by-phone")
	public ResponseEntity<ResponseStructure<User>> verifyByPhone(@RequestParam long phone,
			@RequestParam String password) {

		return service.verifyByPhonePassword(phone, password);

	}

	@PostMapping(value = "/verfy-by-email")
	public ResponseEntity<ResponseStructure<User>> verifyByEmail(@RequestParam String email,
			@RequestParam String password) {

		return service.verifyByEmailPassword(email, password);

	}

}