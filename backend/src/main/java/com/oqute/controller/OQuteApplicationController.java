package com.oqute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.oqute.service.OQuteApplicationService;

/**
 * Created by karuniko on 09.04.16.
 */
@RestController
public class OQuteApplicationController {

    @Autowired
    OQuteApplicationService service;

    @RequestMapping("/person")
    public String handle() {
        return service.getPerson(1L).getName();
    }
}
