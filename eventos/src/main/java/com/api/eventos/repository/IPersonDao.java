package com.api.eventos.repository;

import com.api.eventos.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonDao extends JpaRepository<Person, Long> {

    public Person findByName(String name);

    Optional<Person> findById(Long id);
}
