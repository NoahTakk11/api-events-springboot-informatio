package com.api.eventos.wrapper;

import com.api.eventos.dto.PersonDto;
import com.api.eventos.entity.Person;

public class PersonWrapper {

    public static Person dtoToEntity(PersonDto dto) {
        if (dto == null) return new Person();
        Person entity = new Person();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setActive(dto.getActive());
        entity.setDni(dto.getDni());
        entity.setLastname(dto.getLastname());
        entity.setAlphanumericKey(dto.getAlphanumericKey());
        entity.setAppointment(dto.getAppointment());

        return entity;
    }

    public static PersonDto entityToDto(Person entity) {
        if (entity == null) return new PersonDto();
        PersonDto dto = new PersonDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setActive(entity.getActive());
        dto.setDni(entity.getDni());
        dto.setLastname(entity.getLastname());

        return dto;
    }
}
