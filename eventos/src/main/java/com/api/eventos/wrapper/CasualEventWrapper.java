package com.api.eventos.wrapper;

import com.api.eventos.dto.CasualEventDto;
import com.api.eventos.entity.CasualEvent;

public class CasualEventWrapper {

    public static CasualEvent dtoToEntity(CasualEventDto dto) {
        if (dto == null) return new CasualEvent();
        CasualEvent entity = new CasualEvent();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setDescription(dto.getDescription());
        entity.setGenerationDate(dto.getGenerationDate());
        entity.setOrganization(dto.getOrganization());
        entity.setIsActive(dto.getIsActive());


        return entity;
    }

    public static CasualEventDto entityToDto(CasualEvent entity) {
        if (entity == null) return new CasualEventDto();
        CasualEventDto dto = new CasualEventDto();

        dto.setName(entity.getName());
        dto.setDate(entity.getDate());
        dto.setDescription(entity.getDescription());
        dto.setGenerationDate(entity.getGenerationDate());
        dto.setOrganization(entity.getOrganization());
        dto.setIsActive(entity.getIsActive());


        return dto;
    }
}
