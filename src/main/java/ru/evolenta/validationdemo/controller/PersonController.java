package ru.evolenta.validationdemo.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.validationdemo.model.Person;
import ru.evolenta.validationdemo.repository.PersonRepository;
import ru.evolenta.validationdemo.dto.PersonDto;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(personRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable Long id) {
        return ResponseEntity.ok(personRepository.getReferenceById(id));
    }

    @PostMapping()
    public ResponseEntity<Person> create(@RequestBody @Valid PersonDto personDto) {
        Person person = new Person(null, personDto.getName(), personDto.getAge());
        return ResponseEntity.ok(personRepository.save(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody @Valid PersonDto personDto) {
        Person person = new Person(id, personDto.getName(), personDto.getAge());
        return ResponseEntity.ok(personRepository.save(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id) {
        Person person = personRepository.getReferenceById(id);
        personRepository.delete(person);
        return ResponseEntity.ok(person);
    }
}
