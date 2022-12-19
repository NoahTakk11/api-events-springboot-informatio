package com.api.eventos.service;

import com.api.eventos.dto.CasualAppointmentDto;
import com.api.eventos.entity.Appointment;

import java.util.List;

public interface IAppointmentService {

    public Appointment create(CasualAppointmentDto dto);

    public Appointment findById(Long id);

    public List<Appointment> getAll();

    public Boolean deleteById(Long id);

    List<Appointment> findByOrganization(String organization);

    List<Appointment> findByOrganizationAndEvent(String organization, String event);


}
