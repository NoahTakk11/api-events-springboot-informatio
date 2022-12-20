package com.api.eventos.restcontroller;

/*import com.api.eventos.checker.AppointmentAssign;*/
import com.api.eventos.dto.CasualAppointmentDto;
import com.api.eventos.dto.RegularAppointmentDto;
import com.api.eventos.entity.Appointment;
import com.api.eventos.entity.Event;
import com.api.eventos.service.AppointmentServiceImpl;
import com.api.eventos.service.EventServiceImpl;
import com.api.eventos.service.RegularAppointmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/regular_appointment/")
public class RegularAppointmentController {

    private static final Logger log = LoggerFactory.getLogger(RegularAppointmentController.class);

    @Autowired
    private RegularAppointmentServiceImpl service;

    @Autowired
    private EventServiceImpl eventService;

    @PostMapping("/create")
    private ResponseEntity<Map<String, Object>> create(@RequestBody @Valid RegularAppointmentDto dto) {

        Map<String, Object> response = new HashMap<>();
        Event event = eventService.findById(dto.getEvent().getId()).orElseThrow();
        dto.setOrganization(event.getOrganization());

        service.create(dto);

        response.put("Appointment", dto);

        response.put("Event", dto.getEvent().getName());
        response.put("Date", dto.getDate());
        response.put("Alphanumeric Key", dto.getAlphanumericToken());
        response.put("Active", dto.getActive());

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

    @GetMapping("/find/organization/{organization}")
    public ResponseEntity<Map<String, Object>> getByName(@PathVariable(name = "organization") String organization) {
        Map<String, Object> response = new HashMap<>();
        List<Appointment> appointment = service.findByOrganization(organization);

        response.put("appointment", appointment);
        response.put("message", "Appointment is find.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @GetMapping("/find/organization_and_event/{organization}/{event}")
    public ResponseEntity<Map<String, Object>> getByName(@PathVariable(name = "organization") String organization,
                                                         @PathVariable(name = "event") String event) {
        Map<String, Object> response = new HashMap<>();
        List<Appointment> appointment = service.findByOrganizationAndEvent(organization, event);

        response.put("appointment", appointment);
        response.put("message", "Appointment is find.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}/access_token/{token}")
    public  ResponseEntity<Map<String, Object>> deleteById(@PathVariable(name = "id") Long id,
                                                           @PathVariable( "token") String token) {


        Appointment appointmentId = service.findById(id);
        Map<String, Object> response = new HashMap<>();
        List<String> accessToken = new ArrayList<>();
        accessToken.add(appointmentId.getAlphanumericToken());

        ResponseEntity<Map<String, Object>> responseEntity = null;
        if (accessToken.contains(token)) {
            service.deleteById(id);
            response.put("Appointment", "The appointment with token " + appointmentId.getAlphanumericToken().toUpperCase() + " has been deleted");
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Something has gone wrong");
            responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
