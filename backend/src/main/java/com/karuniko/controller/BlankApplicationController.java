package com.karuniko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.karuniko.domain.Person;
import com.karuniko.service.BlankApplicationService;

/**
 * Created by karuniko on 09.04.16.
 */
@RestController
public class BlankApplicationController {

    @Autowired
    BlankApplicationService service;

    @RequestMapping(value = "/unprotected/{personId}", method = RequestMethod.GET)
    public String getPerson(@PathVariable("personId") Long personId) {
        return service.getPerson(personId).getName();
    }
    
    @RequestMapping(value = "/protected/{personName}", method = RequestMethod.GET)
    public @ResponseBody Person getPerson(@PathVariable("personName") String personName) {
    	return service.getAdminPerson(personName);
    }
    
    @RequestMapping(value = "/protected/catalog", method = RequestMethod.GET)
    public @ResponseBody List<Person> getAllPersons() {
    	return service.getAllPersons();
    }
}
