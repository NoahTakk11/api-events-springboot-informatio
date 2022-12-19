package com.api.eventos.wrapper;

import com.api.eventos.dto.EventDto;
import com.api.eventos.entity.Event;

public class EventWrapper {

    public static Event dtoToEntity(EventDto dto) {
        if (dto == null) return new Event();
        Event entity = new Event();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setDescription(dto.getDescription());
        entity.setGenerationDate(dto.getGenerationDate());
        entity.setOrganization(dto.getOrganization());
        entity.setActive(dto.getActive());


        return entity;
    }

    public static EventDto entityToDto(Event entity) {
        if (entity == null) return new EventDto();
        EventDto dto = new EventDto();

        dto.setName(entity.getName());
        dto.setDate(entity.getDate());
        dto.setDescription(entity.getDescription());
        dto.setGenerationDate(entity.getGenerationDate());
        dto.setOrganization(entity.getOrganization());
        dto.setActive(entity.getActive());


        return dto;
    }
}
