package com.example.FirstSecurityApp.util;

import com.example.FirstSecurityApp.models.Person;
import com.example.FirstSecurityApp.services.PersonValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonValidService personValidService;

    @Autowired
    public PersonValidator(PersonValidService personValidService) {
        this.personValidService = personValidService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (personValidService.findUserWithSameUsername(person.getUsername())) {
            errors.rejectValue("username", "", "Человек с таким именем уже существует");
            System.out.println("Человек с таким именем уже существует"); // просто для визуализации
        }
    }
}