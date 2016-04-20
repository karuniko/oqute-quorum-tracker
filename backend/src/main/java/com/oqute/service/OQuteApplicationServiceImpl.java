package com.oqute.service;

import java.util.List;

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
    public Person getPerson(Long id) {
        return oQuteApplicationRepository.getById(id);
    }

	@Override
	public Person getAdminPerson(String name) {
		return oQuteApplicationRepository.getByName(name);
	}

	@Override
	public List<Person> getAllPersons() {
		return oQuteApplicationRepository.findAll();
	}
    
}
