package com.api.eventos.service;

import com.api.eventos.dto.CasualEventDto;
import com.api.eventos.entity.CasualEvent;

import java.util.List;
import java.util.Optional;

public interface ICasualEventService {

    public List<CasualEvent> getAll();

    public Optional<CasualEvent> findById(Long id);

    CasualEvent findByName(String name);


    public CasualEventDto create(CasualEventDto dto);

    public CasualEventDto update(CasualEventDto dto);

}
