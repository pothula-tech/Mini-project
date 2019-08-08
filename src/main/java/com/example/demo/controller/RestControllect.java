package com.example.demo.controller;

//temp controller for testing
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.services.UserService;

@RestController
public class RestControllect {
	
	@Autowired//instance of UserService is now available in RestControllect class
	private UserService userService;
	 //http://localhost:8080/
	//working fine
	
     @GetMapping("/")
	public String hello()
	{
		return "This is home page";
	}
  //http://localhost:8080/saveuser?username=sourabh&firstname=sourav&lastname=pothula&age=24&password=1234
     //working fine
     @GetMapping("/saveuser")//take parameter from user
     public String saveUser(@RequestParam String username,@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password)
     {
    	 User user = new User(username,firstname,lastname,age,password);
    	 userService.saveMyUser(user);
    	 return "User is saved";
     }
}