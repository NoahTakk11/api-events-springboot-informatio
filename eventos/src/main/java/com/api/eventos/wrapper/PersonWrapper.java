package com.api.eventos.wrapper;

import com.api.eventos.dto.PersonDto;
import com.api.eventos.entity.Person;

public class PersonWrapper {

    public static Person dtoToEntity(PersonDto dto) {
        if (dto == null) return new Person();
        Person entity = new Person();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setActive(dto.getActive());
        entity.setDate(dto.getDate());
        entity.setDni(dto.getDni());
        entity.setLastname(dto.getLastname());
        entity.setEventName(dto.getEventName());
        entity.setOrganizationName(dto.getOrganizationName());


        return entity;
    }

    public static PersonDto entityToDto(Person entity) {
        if (entity == null) return new PersonDto();
        PersonDto dto = new PersonDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDate(entity.getDate());
        dto.setActive(entity.getActive());
        dto.setDate(entity.getDate());
        dto.setDni(entity.getDni());
        dto.setLastname(entity.getLastname());
        dto.setEventName(entity.getEventName());
        dto.setOrganizationName(entity.getOrganizationName());


        return dto;
    }
}
