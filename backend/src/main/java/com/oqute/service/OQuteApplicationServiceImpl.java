package com.oqute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oqute.domain.Person;
import com.oqute.repository.OQuteApplicationRepository;

/**
 * Created by karuniko on 09.04.16.
 */
@Service
public class OQuteApplicationServiceImpl implements OQuteApplicationService {

    @Autowired
    private OQuteApplicationRepository oQuteApplicationRepository;

    @Override
    public Person getPerson() {
        return oQuteApplicationRepository.getById(1L);
    }
}
