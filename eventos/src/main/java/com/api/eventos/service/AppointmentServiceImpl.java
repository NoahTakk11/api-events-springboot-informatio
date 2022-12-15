package com.api.eventos.service;

import com.api.eventos.dto.AppointmentDto;
import com.api.eventos.entity.Appointment;
import com.api.eventos.repository.IAppointmentDao;
import com.api.eventos.wrapper.AppointmentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    @Autowired
    private IAppointmentDao dao;

    @Override
    public Appointment create(AppointmentDto dto) {

        Appointment newAppointment = AppointmentWrapper.dtoToEntity(dto);
        dao.save(newAppointment);
        /*dto = AppointmentWrapper.entityToDto(newAppointment);*/
        return newAppointment;

    }

    @Override
    public Appointment findById(Long id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Appointment> getAll() {
        return dao.findAll();
    }



}
