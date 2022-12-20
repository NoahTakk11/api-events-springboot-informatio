package com.api.eventos.service;

import com.api.eventos.dto.EventDto;
import com.api.eventos.entity.Event;

import java.util.List;
import java.util.Optional;

public interface IEventService {

    List<Event> getAll();

    Optional<Event> findById(Long id);

    Event findByName(String name);

    EventDto create(EventDto dto);

    void update(Long id, EventDto dto);

    Boolean deleteById(Long id);

}
