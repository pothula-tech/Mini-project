package com.example.demo.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.model.User;

public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    } 
    @Override
    public void validate(Object obj, Errors errors) {

        User user = (User) obj;
        if (checkInputString(user.getUsername())) {
            errors.rejectValue("username", "username.empty");
        }
        if (checkInputString(user.getFirstname())) {
            errors.rejectValue("firstname", "firstname.empty");
        }
        if (checkInputString(user.getLastname())) {
            errors.rejectValue("lastname", "lastname.empty");
        }
    }

    private boolean checkInputString(String string) {
        return (string == null || string.trim().length() == 0);//return true if value is null
        
        
    }
}
