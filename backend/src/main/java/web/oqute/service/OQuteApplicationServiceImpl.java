package web.oqute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.oqute.domain.Person;
import web.oqute.repository.OQuteApplicationRepository;

/**
 * Created by karuniko on 09.04.16.
 */
@Service("service")
public class OQuteApplicationServiceImpl implements OQuteApplicationService {

    @Autowired
    private OQuteApplicationRepository oQuteApplicationRepository;

    @Override
    public Person getPerson() {
        return oQuteApplicationRepository.getById(1L);
    }
}
