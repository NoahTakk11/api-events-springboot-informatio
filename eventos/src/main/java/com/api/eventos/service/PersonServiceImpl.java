package com.api.eventos.service;

import com.api.eventos.dto.OrganizationDto;
import com.api.eventos.dto.PersonDto;
import com.api.eventos.entity.Organization;
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
        return dao.customerGetAll();
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
        Person newPerson = dao.save(PersonWrapper.dtoToEntity(dto));
        return dto;
    }


    @Override
    public Boolean deleteById(Long id ) {
        try {
            dao.logicDeleted(id);
            return true;
        }catch (Exception err) {
            return false;
        }


    }

    @Override
    public Person findByDni(String dni) {
        return dao.findByDni(dni).orElseThrow();
    }

    @Override
    public Person findByLastname(String lastname) {
        return dao.findByLastname(lastname).orElseThrow();
    }

    @Override
    public void update(Long id, PersonDto dto) {
        Person personExist = dao.findById(id).orElseThrow();

        if (personExist != null) {
            personExist.setName(dto.getName());
            personExist.setLastname(dto.getLastname());
            personExist.setDni(dto.getDni());
            dao.save(personExist);
        }
    }

    @Override
    public Person findByAccessToken(String name) {
        return dao.findByAlphanumericKey(name).orElseThrow();
    }
}

