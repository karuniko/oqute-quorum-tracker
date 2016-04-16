package com.oqute.service;

import javax.persistence.Inheritance;

import org.springframework.stereotype.Service;

import com.oqute.domain.Person;

/**
 * Created by karuniko on 09.04.16.
 */
@Service
@Inheritance
public interface OQuteApplicationService {
    Person getPerson();
}
