package com.example.Task.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String taskName;
	private String assignedDate;
	private String CreatedDate;
	public Task() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);
		//this.setDateandTime(formattedDateTime);
		this.setStatus("Created");
		this.setCreatedDate(formattedDateTime);
	}
	private String dueDate;
	private String assignedTo;
	private String assignedBy;
	private String mail;
	private String Status;
	
}
