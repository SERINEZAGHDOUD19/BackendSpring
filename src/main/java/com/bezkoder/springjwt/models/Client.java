package com.bezkoder.springjwt.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "clients", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;
	
	@Size(max = 60)
	private String nom;
	
	
	private Long cin;
	

	private Long matriculeFiscale;
	
	
	private Long registreCommerciale;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getCin() {
		return cin;
	}

	public void setCin(Long cin) {
		this.cin = cin;
	}

	public Long getMatriculeFiscale() {
		return matriculeFiscale;
	}

	public void setMatriculeFiscale(Long matriculeFiscale) {
		this.matriculeFiscale = matriculeFiscale;
	}

	public Client( String username,  String email,
			String password,  String nom,  Long cin) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.cin = cin;
	}

	public Client( ) {
		super();
		
	}

	public Client( String username,  String email,
			String password, String nom,
			 Long matriculeFiscale,  Long registreCommerciale) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.matriculeFiscale = matriculeFiscale;
		this.registreCommerciale = registreCommerciale;
	}
	public Client( String username,  String email,
			String password, String nom,Long cin,
			 Long matriculeFiscale,  Long registreCommerciale) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.matriculeFiscale = matriculeFiscale;
		this.registreCommerciale = registreCommerciale;
	}

	public Long getRegistreCommerciale() {
		return registreCommerciale;
	}

	public void setRegistreCommerciale(Long registreCommerciale) {
		this.registreCommerciale = registreCommerciale;
	}

	

}
