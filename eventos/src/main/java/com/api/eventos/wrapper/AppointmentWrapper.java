package com.api.eventos.wrapper;

import com.api.eventos.dto.AppointmentDto;
import com.api.eventos.entity.Appointment;


public class AppointmentWrapper {

    public static Appointment dtoToEntity(AppointmentDto dto) {
        if (dto == null) return new Appointment();
        Appointment entity = new Appointment();

        entity.setId(dto.getId());
        entity.setEvent(dto.getEvent());
        entity.setOrganization(dto.getOrganization());
        entity.setActive(dto.getActive());
        entity.setDate(dto.getDate());
        entity.setAlphanumericToken(dto.getAlphanumericToken());

        return entity;
    }

    public static AppointmentDto entityToDto(Appointment entity) {
        if (entity == null) return new AppointmentDto();
        AppointmentDto dto = new AppointmentDto();

        dto.setId(entity.getId());
        dto.setEvent(entity.getEvent());

        return dto;
    }
}

