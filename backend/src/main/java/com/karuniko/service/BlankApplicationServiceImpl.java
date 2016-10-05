package com.karuniko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karuniko.domain.Person;
import com.karuniko.repository.BlankApplicationRepository;

/**
 * Created by karuniko on 09.04.16.
 */
@Service
public class BlankApplicationServiceImpl implements BlankApplicationService {

    @Autowired
    private BlankApplicationRepository blankApplicationRepository;

    @Override
    public Person getPerson(Long id) {
        return blankApplicationRepository.getById(id);
    }

	@Override
	public Person getAdminPerson(String name) {
		return blankApplicationRepository.getByName(name);
	}

	@Override
	public List<Person> getAllPersons() {
		return blankApplicationRepository.findAll();
	}
    
}
