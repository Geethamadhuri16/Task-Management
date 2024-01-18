package com.example.Task.Mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.Task.DTO.TaskDTO;
import com.example.Task.Model.Task;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class TaskMapper {
	@AfterMapping
	public static void TaskDTOToTask(TaskDTO dto,@MappingTarget Task task) {
		if(dto.getAssignedTo()!=null) {
			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedDateTime = currentDateTime.format(formatter);
			task.setAssignedDate(formattedDateTime);
			task.setAssignedTo(dto.getAssignedTo());
			task.setStatus("assigned");
		}
		if(dto.getDueDate()!=null) {
			task.setDueDate(dto.getDueDate());
		}
		if(dto.getMail()!=null) {
			task.setMail(dto.getMail());
		}
		
		if(dto.getStatus()!=null) {
			task.setStatus(dto.getStatus());
		}
		if(dto.getTaskname()!=null) {
			task.setTaskName(dto.getTaskname());
			
		}
	
		
		
		
	}

}
