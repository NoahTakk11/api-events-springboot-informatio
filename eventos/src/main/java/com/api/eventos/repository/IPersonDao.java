package com.api.eventos.repository;

import com.api.eventos.entity.Organization;
import com.api.eventos.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPersonDao extends JpaRepository<Person, Long> {

    public Person findByName(String name);
    Optional<Person> findById(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE person SET active=false WHERE id= :id")
    void logicDeleted(@Param("id") Long id);


    @Query(value = "SELECT p FROM person p WHERE active=true")
    List<Person> customerGetAll();

    @Query(value = "SELECT p FROM person p WHERE active=true AND lastname= :lastname")
    Optional<Person> findByLastname(String lastname);

    @Query(value = "SELECT p FROM person p WHERE active=true AND dni= :dni")
    Optional<Person> findByDni(String dni);

    Optional<Person> findByAlphanumericKey(String token);
}
