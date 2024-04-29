package com.example.FirstSecurityApp.services;

import com.example.FirstSecurityApp.models.Person;
import com.example.FirstSecurityApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonValidService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonValidService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public boolean findUserWithSameUsername(String username) {
        Optional<Person> person = peopleRepository.findByUsername(username);
        return person.isPresent();
    }
}
