package com.api.eventos.service;

import com.api.eventos.dto.PersonDto;
import com.api.eventos.entity.Person;
import com.api.eventos.repository.IPersonDao;
import com.api.eventos.wrapper.PersonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonService{

    @Autowired
    private IPersonDao dao;

    @Override
    public List<Person> getAll() {
        return dao.findAll();
    }


    @Override
    public Optional<Person> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Person findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public PersonDto create(PersonDto dto) {
        Person newEvent = dao.save(PersonWrapper.dtoToEntity(dto));
        return dto;
    }

    @Override
    public PersonDto update(PersonDto dto) {
        Person personExist = dao.findByName(dto.getName());

        if (personExist != null) {
            Person entityToPersist = new Person();
            entityToPersist.setId(personExist.getId());
            entityToPersist.setName(dto.getName());
            entityToPersist.setDate(dto.getDate());
            entityToPersist.setActive(dto.getActive());
            entityToPersist.setDni(dto.getDni());
            entityToPersist.setLastname(dto.getLastname());
            entityToPersist.setEventName(dto.getEventName());
            entityToPersist.setOrganizationName(dto.getOrganizationName());

            personExist = dao.save(entityToPersist);
            dto = PersonWrapper.entityToDto(personExist);
            return dto;

        }
        return null;
    }

    @Override
    public Boolean deleteById(Long id ) {
        try {
            dao.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
