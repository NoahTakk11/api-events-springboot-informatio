package com.api.eventos.wrapper;

import com.api.eventos.dto.CasualAppointmentDto;
import com.api.eventos.entity.Appointment;


public class AppointmentWrapper {

    public static Appointment dtoToEntity(CasualAppointmentDto dto) {
        if (dto == null) return new Appointment();
        Appointment entity = new Appointment();

        entity.setId(dto.getId());
        entity.setEvent(dto.getEvent());
        entity.setOrganization(dto.getOrganization());
        entity.setActive(dto.getActive());
        entity.setDate(dto.getDate());
        entity.setAlphanumericToken(dto.getAlphanumericToken());
        entity.setPerson(dto.getPerson());

        return entity;
    }

    public static CasualAppointmentDto entityToDto(Appointment entity) {
        if (entity == null) return new CasualAppointmentDto();
        CasualAppointmentDto dto = new CasualAppointmentDto();

        dto.setId(entity.getId());
        dto.setEvent(entity.getEvent());

        return dto;
    }
}

