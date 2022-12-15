package com.api.eventos.wrapper;

import com.api.eventos.dto.OrganizationDto;
import com.api.eventos.entity.Organization;

public class OrganizationWrapper {

    public static Organization dtoToEntity(OrganizationDto dto) {
        if (dto == null) return new Organization();
        Organization entity = new Organization();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCuit(dto.getCuit());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setEvents(dto.getEvents());
        entity.setGenerationDate(dto.getGenerationDate());
        entity.setAccessToken(dto.getAccessToken());
        entity.setActive(dto.getActive());

        return entity;
    }

    public static OrganizationDto entityToDto(Organization entity) {
        if (entity == null) return new OrganizationDto();
        OrganizationDto dto = new OrganizationDto();

        dto.setName(entity.getName());
        dto.setCuit(entity.getCuit());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setAddress(entity.getAddress());
        dto.setEvents(entity.getEvents());
        dto.setGenerationDate(entity.getGenerationDate());
        //dto.setActive(entity.getActive());
//        dto.setAccessToken(entity.getAccessToken());

        return dto;
    }
}
