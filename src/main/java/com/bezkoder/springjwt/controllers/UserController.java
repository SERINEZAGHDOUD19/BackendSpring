package com.bezkoder.springjwt.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.repository.UserRepository;

import com.bezkoder.springjwt.models.User;


@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/users")
public class UserController {	
	
	
	@Autowired
	  UserRepository userRepository;
	@Autowired
	  PasswordEncoder encoder;
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/all", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<User> getAllUsers()
	{
		List<User> list = new ArrayList<User>();
		list = userRepository.findAll();
		return list;
	}
	
	
	@RequestMapping(value="/deleteUser/{id}", method=RequestMethod.DELETE)
	@CrossOrigin
	public void delete(@PathVariable("id") Long id) {
		
		userRepository.deleteUserById(id);
		System.out.println("user est supprimé");
		}

	@RequestMapping(value="/findByUserId/{id}", method = RequestMethod.GET)
	public Optional<User> getUser(@PathVariable("id") Long id){
		
		Optional<User> user =userRepository.findById(id);
		return user;
	}
	@RequestMapping(value="/updateUser/{id}", method=RequestMethod.PUT)
	public User miseAjourUser(@RequestBody User userToUpdate) {
		
		User fin = new User(userToUpdate.getUsername(),userToUpdate.getEmail(),encoder.encode(
				userToUpdate.getPassword()));
		User addUser=userRepository.save(fin);
		return addUser ;

		
	}
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public User addUser(@RequestBody User user){
		User fin = new User(user.getUsername(),user.getEmail(),encoder.encode(
				user.getPassword()));
		
		
		User addUser=userRepository.save(fin);
		return addUser ;
	}
	
}
