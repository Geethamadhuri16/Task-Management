package com.example.Task.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class TaskDTO {
	private String assignedDate;
	private String dueDate;
	private String assignedTo;
	private String mail;
	private String Status;
	private String taskname;

}
