package com.example.demo.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.services.UserService;


@Controller
public class ApplicationController {
	
    @Autowired//instance of UserService is now available in ApplicationController class
    UserService userService;
	
    @RequestMapping("/welcome")
    public String Welcome(HttpServletRequest request)
    {   request.setAttribute("mode","MODE_HOME");
    	return "welcomepage";
    }
    @RequestMapping("/register")
    public String registration(HttpServletRequest request)
    
    {
    	request.setAttribute("mode","MODE_REGISTER");
    	return "welcomepage";
    }
    @PostMapping("/save-user")
    public String registerUser(@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request)
   // public ResponseEntity<Object> registerUser(@Valid @ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request)
    {
    	userService.saveMyUser(user);//to save the user details by calling userservice.java package
    	//request.setAttribute("mode","MODE_SUCCESS");//temp not working
    	request.setAttribute("mode","MODE_HOME");//To come back to home page
    	return "welcomepage";
    	
    }
    
  //will be called for showing user
    @RequestMapping("/show-users")
    public String showAllUsers(HttpServletRequest request) 
    
    {
    	request.setAttribute("users",userService.showAllUsers());//call show alluser to show the details of the users
    	request.setAttribute("mode","ALL_USERS");
    	return "welcomepage";
    }
    
    //will be called for login
    @RequestMapping("/login")
    public String login(HttpServletRequest request) 
    {
    	request.setAttribute("mode","MODE_LOGIN");
    	return "welcomepage";
    	
    }
    //validation database level
    
    @RequestMapping ("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
			return "homepage";
		}
		else {
			//this will show error if the user enters wrong combination of username and password
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
			
		}
	}
}