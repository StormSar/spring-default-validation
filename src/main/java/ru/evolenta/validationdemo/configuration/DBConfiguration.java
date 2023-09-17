package ru.evolenta.validationdemo.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.evolenta.validationdemo.model.Person;
import ru.evolenta.validationdemo.repository.PersonRepository;

@Component
public class DBConfiguration {
    private final PersonRepository personRepository;

    public DBConfiguration(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void initDB() {
        Person person = new Person();
        person.setName("Миша");
        person.setAge(19);
        personRepository.save(person);

        person = new Person();
        person.setName("Лена");
        person.setAge(23);
        personRepository.save(person);

        person = new Person();
        person.setName("Саша");
        person.setAge(20);
        personRepository.save(person);
    }
}
