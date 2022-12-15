package com.api.eventos.wrapper;

import com.api.eventos.dto.RegularEventDto;
import com.api.eventos.entity.RegularEvent;

public class RegularEventWrapper {

    public static RegularEvent dtoToEntity(RegularEventDto dto) {
        if (dto == null) return new RegularEvent();
        RegularEvent entity = new RegularEvent();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setDescription(dto.getDescription());
        entity.setGenerationDate(dto.getGenerationDate());
        entity.setOrganization(dto.getOrganization());
        entity.setIsActive(dto.getIsActive());


        return entity;
    }

    public static RegularEventDto entityToDto(RegularEvent entity) {
        if (entity == null) return new RegularEventDto();
        RegularEventDto dto = new RegularEventDto();

        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());

        return dto;
    }
}
