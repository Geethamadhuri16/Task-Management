package com.example.Task.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Task.Model.User;




public interface UserRepo extends JpaRepository<User, Long> {
	public User findByEmailAndPassword(String mail,String pass);
	public User findByEmail(String email);

}

