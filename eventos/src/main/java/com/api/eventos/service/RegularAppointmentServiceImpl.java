package com.api.eventos.service;

import com.api.eventos.dto.CasualAppointmentDto;
import com.api.eventos.dto.RegularAppointmentDto;
import com.api.eventos.entity.Appointment;
import com.api.eventos.repository.IAppointmentDao;
import com.api.eventos.wrapper.AppointmentWrapper;
import com.api.eventos.wrapper.RegularAppointmentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegularAppointmentServiceImpl implements IRegularAppointmentService {

    @Autowired
    private IAppointmentDao dao;

    @Override
    public Appointment create(RegularAppointmentDto dto) {

        Appointment newAppointment = RegularAppointmentWrapper.dtoToEntity(dto);
        dao.save(newAppointment);
        return newAppointment;

    }

    @Override
    public Appointment findById(Long id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Appointment> getAll() {
        return dao.customerGetAll();
    }

    @Override
    public Boolean deleteById(Long id ) {
        try {
            dao.logicDeleted(id);
            return true;
        }catch (Exception err) {
            return false;
        }
    }

    @Override
    public List<Appointment> findByOrganization(String organization) {
        return dao.findByOrganization(organization);
    }

    @Override
    public List<Appointment> findByOrganizationAndEvent(String organization, String event) {
        return dao.findByOrganizationAndEvent(organization, event);
    }

}
