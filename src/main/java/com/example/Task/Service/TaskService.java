package com.example.Task.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.Task.DTO.TaskDTO;
import com.example.Task.Mapper.TaskMapper;
import com.example.Task.Model.Task;
import com.example.Task.Repo.TaskRepo;

import jakarta.mail.internet.MimeMessage;

@Service
public class TaskService {
	@Autowired
	private TaskRepo repo;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
    private String fromEmail;
	
	//addTask
	public ResponseEntity<Task> addTask(Task t) {
		try {
			repo.save(t);
			return new ResponseEntity<>(t,HttpStatus.ACCEPTED);
			
		}catch(Exception e){
			System.out.println(e);
			return new ResponseEntity<>(null,HttpStatus.ACCEPTED);
			
		}
	
		
	}
	
	// updatingTask
    public ResponseEntity<String> updateTask(Long id, TaskDTO dto) {
        try {
            Task existingTask = repo.findById(id).orElse(null);
            if (existingTask == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

            // Update the task details
            TaskMapper.TaskDTOToTask(dto, existingTask);
           
            repo.save(existingTask);

            // Send email
            System.out.println(existingTask.getTaskName());
            sendAssignmentEmail(existingTask);

            return new ResponseEntity<>("Updated successfully", HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void sendAssignmentEmail(Task task) {
    	try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(task.getMail());
            mimeMessageHelper.setSubject("Task assigned by: "+task.getAssignedBy());
            mimeMessageHelper.setText("The task assigned to uh is: "+task.getTaskName());

            
            javaMailSender.send(mimeMessage);

           

        } catch (Exception e) {
        	System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    
    //check Status
    public ResponseEntity<String> checkStatus(Long id) {
    	try {
    		Task t=repo.findById(id).orElse(null);
    		if(t!=null) {
    			return new ResponseEntity<>(t.getStatus(),HttpStatus.OK);
    			
    		}else {
    			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    		}
    	}catch(Exception e) {
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    //check due date
    public ResponseEntity<String> checkDueDate(Long id){
    	try {
    		Task t=repo.findById(id).orElse(null);
    		if(t!=null) {
    			return new ResponseEntity<>(t.getDueDate(),HttpStatus.OK);
    			
    		}else {
    			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    		}
    	}catch(Exception e) {
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    //get by mail
    public ResponseEntity<List<Task>> getByEmail(String mail){
    	
    	try {
    		List<Task> t=repo.findByMail(mail);
    		if(t!=null) {
    			return new ResponseEntity<>(t,HttpStatus.OK);
    			
    		}else {
    			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    		}
    	}catch(Exception e) {
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}

    	
    	
    }
    
    //del task
    public ResponseEntity<String> delById(Long id){
    	try {
    		Task t=repo.findById(id).orElse(null);
    		if(t!=null) {
    			repo.delete(t);
    			return new ResponseEntity<>("deleted",HttpStatus.OK);
    			
    		}else {
    			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    		}
    	}catch(Exception e) {
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    
    
    
    
    
	
	
	
	
	
	

}
