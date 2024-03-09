package org.jsp.ecommerceapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerceapp.dao.MerchantDao;
import org.jsp.ecommerceapp.dto.ResponseStructure;
import org.jsp.ecommerceapp.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao dao;
	
	
	
	public ResponseStructure <Merchant> saveMerchant(Merchant merchant) {
		ResponseStructure<Merchant>structure= new ResponseStructure<>();
		structure.setMessage("Merchant Saved");
		structure.setData(dao.saveMerchant(merchant));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return structure;
	}
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant m) {
		Optional<Merchant> recMechant = dao.findById(m.getId());
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMechant.isPresent()) {
			Merchant dbMerchant = recMechant.get();
			dbMerchant.setName(m.getName());
			dbMerchant.setEmail(m.getEmail());
			dbMerchant.setGst_number(m.getGst_number());
			dbMerchant.setPhone(m.getPhone());
			dbMerchant.setPassword(m.getPassword());
			structure.setMessage("Merchant Updated");
			structure.setData(dao.saveMerchant(m));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
		}
		structure.setMessage("unable Updated");
		structure.setData(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}

	public List<Merchant> findAll() {
		List<Merchant> merchants = dao.findAll();
		ResponseStructure<List<Merchant>> structure = new ResponseStructure<>();
		structure.setData(merchants);
		structure.setMessage("merchand found ");
		structure.setStatusCode(HttpStatus.OK.value());
		return merchants;

	}

	public ResponseEntity<ResponseStructure<Merchant>> findById(int id) {
		Optional<Merchant> recMerChant = dao.findById(id);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerChant.isPresent()) {
			structure.setData(recMerChant.get());
			structure.setMessage("Merchant found with id " + id);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		structure.setData(null);
		structure.setMessage("unable to found with id " + id);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Merchant> recmerchant = dao.findById(id);
		if (recmerchant.isPresent()) {
			dao.deleteByid(id);
			structure.setMessage("Merchant found");
			structure.setData("merchant deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);

		}
		structure.setMessage("Unable to found");
		structure.setData("unable to  delete");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyByPhonePassword(long phone, String password) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = dao.verifyByPhonePassword(phone, password);

		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMessage("verified successfully ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		structure.setData(null);
		structure.setMessage("unable to verify ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyByEmailPassword(String email, String password) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = dao.verifyByEmailPassword(email, password);

		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMessage("verified successfully ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		structure.setData(null);
		structure.setMessage("unable to verify ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}


}

