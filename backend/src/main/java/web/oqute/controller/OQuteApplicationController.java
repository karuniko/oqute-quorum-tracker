package web.oqute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.oqute.service.OQuteApplicationService;

/**
 * Created by karuniko on 09.04.16.
 */
@RestController
public class OQuteApplicationController {

    @Autowired
    OQuteApplicationService service;

    @RequestMapping("/")
    public String handle() {
        return service.getPerson().getName();
    }
}
