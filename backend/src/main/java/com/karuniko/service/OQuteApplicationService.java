package com.karuniko.service;

import java.util.List;

import javax.persistence.Inheritance;

import org.springframework.stereotype.Service;

import com.karuniko.domain.Person;

/**
 * Created by karuniko on 09.04.16.
 */
@Service
@Inheritance
public interface OQuteApplicationService {
    Person getPerson(Long id);
    Person getAdminPerson(String name);
    List<Person> getAllPersons();
}
