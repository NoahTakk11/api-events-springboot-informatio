package com.api.eventos.service;

import com.api.eventos.dto.PersonDto;
import com.api.eventos.entity.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService {

    public List<Person> getAll();

    public Optional<Person> findById(Long id);

    Person findByName(String name);


    public PersonDto create(PersonDto dto);

    public PersonDto update(PersonDto dto);

    public Boolean deleteById(Long id);

}
