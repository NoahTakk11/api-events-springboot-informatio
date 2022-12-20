package com.api.eventos.wrapper;

import com.api.eventos.dto.CasualAppointmentDto;
import com.api.eventos.dto.RegularAppointmentDto;
import com.api.eventos.entity.Appointment;


public class RegularAppointmentWrapper {

    public static Appointment dtoToEntity(RegularAppointmentDto dto) {
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

    public static RegularAppointmentDto entityToDto(Appointment entity) {
        if (entity == null) return new RegularAppointmentDto();
        RegularAppointmentDto dto = new RegularAppointmentDto();

        dto.setId(entity.getId());
        dto.setEvent(entity.getEvent());

        return dto;
    }
}

