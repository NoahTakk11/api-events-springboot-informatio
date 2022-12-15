package com.api.eventos.service;

import com.api.eventos.dto.CasualEventDto;
import com.api.eventos.entity.CasualEvent;
import com.api.eventos.repository.ICasualEventDao;
import com.api.eventos.wrapper.CasualEventWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasualEventServiceImpl implements ICasualEventService {

    @Autowired
    private ICasualEventDao dao;

    @Override
    public List<CasualEvent> getAll() {
        return dao.findAll();
    }


    @Override
    public Optional<CasualEvent> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public CasualEvent findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public CasualEventDto create(CasualEventDto dto) {
        CasualEvent newEvent = dao.save(CasualEventWrapper.dtoToEntity(dto));
        return dto;
    }

    @Override
    public CasualEventDto update(CasualEventDto dto) {
        CasualEvent eventExist = dao.findByName(dto.getName());

        if (eventExist != null) {
            CasualEvent entityToPersist = new CasualEvent();
            entityToPersist.setId(eventExist.getId());
            entityToPersist.setName(dto.getName());
            entityToPersist.setDate(dto.getDate());
            entityToPersist.setDescription(dto.getDescription());
            entityToPersist.setGenerationDate(dto.getGenerationDate());
            entityToPersist.setIsActive(dto.getIsActive());

            eventExist = dao.save(entityToPersist);
            dto = CasualEventWrapper.entityToDto(eventExist);
            return dto;

        }
        return null;
    }
}
