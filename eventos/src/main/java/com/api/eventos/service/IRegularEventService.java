package com.api.eventos.service;


import com.api.eventos.dto.RegularEventDto;
import com.api.eventos.entity.RegularEvent;

import java.util.List;
import java.util.Optional;

public interface IRegularEventService {

    public List<RegularEvent> getAll();

    public Optional<RegularEvent> findById(Long id);

    RegularEvent findByName(String name);


    public RegularEventDto create(RegularEventDto dto);

    public RegularEventDto update(RegularEventDto dto);
}
