package com.bezkoder.springjwt.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.repository.ClientRepository;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/clients")
public class ClientControlleur {
	@Autowired
	  ClientRepository clientRepository;
	@Autowired
	  PasswordEncoder encoder;
	@RequestMapping(value="/all", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Client> getAllClients()
	{
		List<Client> list = new ArrayList<Client>();
		list = clientRepository.findAll();
		return list;
	}
	
	
	@RequestMapping(value="/deleteClient/{id}", method=RequestMethod.DELETE)
	@CrossOrigin
	public void delete(@PathVariable("id") Long id) {
		
		clientRepository.deleteClientById(id);
		System.out.println("client est supprimé");
		}

	
	@RequestMapping(value="/addClient", method=RequestMethod.POST)
	public Client addClient(@RequestBody Client client){
		Client fin = new Client(client.getUsername(),client.getEmail(),encoder.encode(
				client.getPassword()), client.getNom(),client.getCin(),client.getMatriculeFiscale(), client.getRegistreCommerciale());
		
		
		Client addCl=clientRepository.save(fin);
		return addCl ;
	}
	
	
	@RequestMapping(value="/findByClientId/{id}", method = RequestMethod.GET)
	public Optional<Client> getClient(@PathVariable("id") Long id){
		
		Optional<Client> client =clientRepository.findById(id);
		return client;
	}
	
	@RequestMapping(value="/updateClient/{id}", method=RequestMethod.PUT)
	public Client miseAjourClient(@RequestBody Client clientToUpdate) {
		Client addClient= clientRepository.save(clientToUpdate);
		return addClient ;

		
	}
}
