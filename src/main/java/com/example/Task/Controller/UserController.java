package com.example.Task.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Task.Model.User;
import com.example.Task.Service.UserService;
@CrossOrigin(origins="http://localhost:3000")
@RestController	
	
public class UserController {
  @Autowired
	    private UserService userService;

	    @PostMapping("/register")
	    public ResponseEntity<String> registerUser(@RequestBody User user) {
	        return userService.register(user);
	    }

	    @PostMapping("/login")
	    public ResponseEntity<String> loginUser(@RequestParam String mail, @RequestParam String pass) {
	        return userService.login(mail, pass);
	    }

	    @DeleteMapping("/deleteUser")
	    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
	        return userService.del(id);
	    }


}
