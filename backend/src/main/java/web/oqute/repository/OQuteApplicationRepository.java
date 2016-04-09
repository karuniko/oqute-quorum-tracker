package web.oqute.repository;


import org.springframework.data.repository.Repository;
import web.oqute.domain.Person;

/**
 * Created by karuniko on 09.04.16.
 */
public interface OQuteApplicationRepository extends Repository<Person, Long> {
    public Person getById(Long id);
}
