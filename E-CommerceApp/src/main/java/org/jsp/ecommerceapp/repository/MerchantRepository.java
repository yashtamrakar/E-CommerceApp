package org.jsp.ecommerceapp.repository;

import java.util.Optional;

import org.jsp.ecommerceapp.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MerchantRepository  extends JpaRepository<Merchant, Integer>{
	
	@Query("select m from Merchant m where m.email=?1 and m.password=?2")
	public Optional<Merchant> verifyByEmailPassword(String email ,String password);


	@Query("select m from Merchant m where m.phone=?1 and m.password=?2")
	public Optional<Merchant> verifyByPhonePasword(long phone, String password);
	
}
