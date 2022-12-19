package com.api.eventos.repository;

import com.api.eventos.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface IEventDao extends JpaRepository<Event, Long> {

    Event findByName(String name);


    @Modifying
    @Transactional
    @Query(value = "UPDATE event SET active=false WHERE id= :id")
    void logicDeleted(@Param("id") Long id);


    @Query(value = "SELECT e FROM event e WHERE active=true")
    List<Event> customerGetAll();
}
