package com.bezkoder.springjwt.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.*;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	Optional<Client> findById(Long id);
	 @Transactional
	void deleteClientById(Long id);

}
