package com.oqute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oqute.domain.Person;
import com.oqute.service.OQuteApplicationService;

/**
 * Created by karuniko on 09.04.16.
 */
@RestController
public class OQuteApplicationController {

    @Autowired
    OQuteApplicationService service;

    @RequestMapping("/unprotected")
    public String handle() {
        return service.getPerson(1L).getName();
    }
    
    @RequestMapping(name = "/protected/{personName}", method = RequestMethod.GET)
    public @ResponseBody Person person(@PathVariable("personName") String personName) {
    	return service.getAdminPerson(personName);
    }
}
