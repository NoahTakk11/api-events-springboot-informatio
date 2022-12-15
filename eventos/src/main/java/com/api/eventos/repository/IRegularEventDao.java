package com.api.eventos.repository;

import com.api.eventos.entity.RegularEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IRegularEventDao extends JpaRepository<RegularEvent, Long> {

    RegularEvent findByName(String name);

}
