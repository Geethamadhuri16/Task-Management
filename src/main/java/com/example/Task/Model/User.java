package com.example.Task.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType
	.IDENTITY)
	private Long id;
	
	private String email;
	
	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	


}