package com.api.eventos.checker;

import com.api.eventos.entity.Appointment;
import com.api.eventos.repository.IAppointmentDao;
import com.api.eventos.wrapper.AppointmentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AppointmentDisabler {

    @Autowired
    private IAppointmentDao appointmentDao;

    private final long SECOND = 1000;
    private final long MINUTE = SECOND * 60;
    private final long HOUR = MINUTE * 60;

    @Scheduled(fixedDelay = MINUTE, initialDelay = SECOND)
    public void eventDisabler() {
        List<Appointment> appointments = appointmentDao.findAll();
        Date today = new Date();

        if (appointments.size() > 0) {

            appointments.stream().forEach((e) -> e.setActive(true && today.before(e.getDate()) || false));
            appointments.stream().forEach((e) -> appointmentDao.save(e));
            appointments.stream().forEach((e) -> AppointmentWrapper.entityToDto(e));

        }
    }
}
