package com.api.eventos.restcontroller;

/*import com.api.eventos.checker.AppointmentAssign;*/
import com.api.eventos.dto.AppointmentDto;
import com.api.eventos.entity.Appointment;
import com.api.eventos.entity.CasualEvent;
import com.api.eventos.service.AppointmentServiceImpl;
import com.api.eventos.service.CasualEventServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/appointment/")
public class AppointmentController {

    private static final Logger log = LoggerFactory.getLogger(AppointmentController.class);

    @Autowired
    private AppointmentServiceImpl service;

    @Autowired
    private CasualEventServiceImpl eventService;

    @PostMapping("/create")
    private ResponseEntity<Map<String, Object>> create(@RequestBody AppointmentDto dto) {

        Map<String, Object> response = new HashMap<>();
        Appointment appointment = service.create(dto);

        log.info("Appointment Id: " + appointment.getEvent().getId());
        CasualEvent casualEvent = eventService.findById(appointment.getEvent().getId()).orElseThrow();
        log.info("casual event: " + casualEvent);
        appointment.setDate(casualEvent.getDate());
        log.info("date del appointmetn: " + casualEvent.getDate());
        appointment.setOrganization(casualEvent.getOrganization());
        log.info("organización seteada: " +casualEvent.getOrganization());
        response.put("Appointment", appointment);

        /*response.put("Event", dto.getEvent().getName());
        response.put("Date", dto.getDate());
        response.put("Alphanumeric Key", dto.getAlphanumericToken());
        response.put("Active", dto.getActive());*/

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Map<String, Object>> getByName(@PathVariable(name = "id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Appointment appointment = service.findById(id);

        response.put("appointment", appointment);
        response.put("message", "Appointment is find.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }
}
