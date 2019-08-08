package com.example.demo.config;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.config.ValidatingRepositoryEventListener;
import org.springframework.validation.Validator;

public class ValidatorEventRegister implements InitializingBean {

    @Autowired//creating instance of ValidatingRepositoryEventListener
    ValidatingRepositoryEventListener validatingRepositoryEventListener;

    @Autowired
    private Map<String, Validator> validators;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<String> events = Arrays.asList("beforeSave");//validate before save

        for (Map.Entry<String, Validator> entry : validators.entrySet()) {
            events.stream().filter(p -> entry.getKey().startsWith(p)).findFirst().ifPresent(p -> validatingRepositoryEventListener.addValidator(p, (javax.validation.Validator) entry.getValue()));
        }
    }
}