package com.api.eventos.service;

import com.api.eventos.dto.CasualAppointmentDto;
import com.api.eventos.entity.Appointment;
import com.api.eventos.entity.Event;

import java.util.List;

public interface IAppointmentService {

    Appointment create(CasualAppointmentDto dto);

    Appointment findById(Long id);

    List<Appointment> getAll();

    Boolean deleteById(Long id);

    List<Appointment> findByOrganization(String organization);

    List<Appointment> findByOrganizationAndEvent(String organization, String event);




}
