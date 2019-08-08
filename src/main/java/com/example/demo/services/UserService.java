package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service  //UserService act as @Service class for User class
@Transactional  //as we are dealing with database 
public class UserService {              //to insert/fetch data into/from database
	
	public final UserRepository userRepository;//creating instance of UserRepository
	
	public UserService(UserRepository userRepository)//Creating constructor
	{
		this.userRepository=userRepository;
	}
	
	public void saveMyUser(User user)
	{
		userRepository.save(user);
		
	}
	//sourabh list to store the user details
  public List<User> showAllUsers ()
  {
	  List<User> users = new ArrayList<User>();
	  for(User user:userRepository.findAll() )//fetch user details from crude repository which will store in users
	  {
		  users.add(user);//add users one by one to user list
	  }
	  return users;//return the array list
  }
  public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
}