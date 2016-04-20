package com.oqute.repository;


import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.Repository;
import com.oqute.domain.Person;

/**
 * Created by karuniko on 09.04.16.
 */
@Cacheable("entities")
public interface OQuteApplicationRepository extends Repository<Person, Long> {
    public Person getById(Long id);
    public Person getByName(String name);
    public List<Person> findAll();
}
