package com.api.eventos.service;

import com.api.eventos.dto.EventDto;
import com.api.eventos.entity.Event;
import com.api.eventos.repository.IEventDao;
import com.api.eventos.wrapper.EventWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements IEventService {

    @Autowired
    private IEventDao dao;

    @Override
    public List<Event> getAll() {
        return dao.customerGetAll();
    }


    @Override
    public Optional<Event> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Event findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public EventDto create(EventDto dto) {
        Event newEvent = dao.save(EventWrapper.dtoToEntity(dto));
        return dto;
    }

    @Override
    public EventDto update(EventDto dto) {
        Event eventExist = dao.findByName(dto.getName());

        if (eventExist != null) {
            Event entityToPersist = new Event();
            entityToPersist.setId(eventExist.getId());
            entityToPersist.setName(dto.getName());
            entityToPersist.setDate(dto.getDate());
            entityToPersist.setDescription(dto.getDescription());
            entityToPersist.setGenerationDate(dto.getGenerationDate());
            entityToPersist.setActive(dto.getActive());

            eventExist = dao.save(entityToPersist);
            dto = EventWrapper.entityToDto(eventExist);
            return dto;

        }
        return null;
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
}
