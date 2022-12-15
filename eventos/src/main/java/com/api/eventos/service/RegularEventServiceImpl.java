package com.api.eventos.service;

import com.api.eventos.dto.RegularEventDto;
import com.api.eventos.entity.RegularEvent;
import com.api.eventos.repository.IRegularEventDao;
import com.api.eventos.wrapper.RegularEventWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegularEventServiceImpl implements IRegularEventService {

    @Autowired
    private IRegularEventDao dao;



    @Override
    public List<RegularEvent> getAll() {
        return dao.findAll();
    }


    @Override
    public Optional<RegularEvent> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public RegularEvent findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public RegularEventDto create(RegularEventDto dto) {
        RegularEvent newEvent = dao.save(RegularEventWrapper.dtoToEntity(dto));
        return dto;
    }

    @Override
    public RegularEventDto update(RegularEventDto dto) {
        RegularEvent eventExist = dao.findByName(dto.getName());

        if (eventExist != null) {
            RegularEvent entityToPersist = new RegularEvent();
            entityToPersist.setId(eventExist.getId());
            entityToPersist.setName(dto.getName());
            entityToPersist.setDate(dto.getDate());
            entityToPersist.setDescription(dto.getDescription());
            entityToPersist.setGenerationDate(dto.getGenerationDate());
            entityToPersist.setIsActive(dto.getIsActive());

            eventExist = dao.save(entityToPersist);
            dto = RegularEventWrapper.entityToDto(eventExist);
            return dto;

        }
        return null;
    }
}
