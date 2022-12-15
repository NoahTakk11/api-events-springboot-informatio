package com.api.eventos.service;

import com.api.eventos.dto.AppointmentDto;
import com.api.eventos.entity.Appointment;

import java.util.List;

public interface IAppointmentService {

    public Appointment create(AppointmentDto dto);

    public Appointment findById(Long id);

    public List<Appointment> getAll();


}
