package com.example.Task.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Task.DTO.TaskDTO;
import com.example.Task.Model.Task;
import com.example.Task.Service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@PostMapping("")
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		return service.addTask(task);
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateTask(@PathVariable("id") Long id,@RequestBody TaskDTO  dto){
		return service.updateTask(id, dto);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> checkStatus(@PathVariable("id")Long id){
		return service.checkStatus(id);
	}
	
	@GetMapping("/dueDate/{id}")
	public ResponseEntity<String> dueDate(@PathVariable("id")Long id){
		return service.checkDueDate(id);
	}
	
	@GetMapping("checkByEmail/{mail}")
	public ResponseEntity<List<Task>> getBymail(@PathVariable("mail")String mail){
		return service.getByEmail(mail);
	}
	

}
