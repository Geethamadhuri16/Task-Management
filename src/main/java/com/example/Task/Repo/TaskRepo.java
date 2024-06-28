package com.example.Task.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Task.Model.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {
	public List<Task> findByMail(String mail);

}
