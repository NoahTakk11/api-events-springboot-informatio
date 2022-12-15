package com.api.eventos.repository;

import com.api.eventos.entity.CasualEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICasualEventDao extends JpaRepository<CasualEvent, Long> {

    public CasualEvent findByName(String name);

    CasualEvent save(CasualEvent entityToPersist);

    Optional<CasualEvent> findById(Long id);

    List<CasualEvent> findAll();
}
