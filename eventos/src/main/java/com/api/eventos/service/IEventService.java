package com.api.eventos.service;

import com.api.eventos.dto.EventDto;
import com.api.eventos.entity.Event;

import java.util.List;
import java.util.Optional;

public interface IEventService {

    public List<Event> getAll();

    public Optional<Event> findById(Long id);

    Event findByName(String name);

    public EventDto create(EventDto dto);

    public EventDto update(EventDto dto);

    public Boolean deleteById(Long id);

}
