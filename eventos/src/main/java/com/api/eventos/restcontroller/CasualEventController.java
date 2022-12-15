package com.api.eventos.restcontroller;

import com.api.eventos.dto.CasualEventDto;
import com.api.eventos.entity.CasualEvent;
import com.api.eventos.entity.Organization;
import com.api.eventos.service.CasualEventServiceImpl;
import com.api.eventos.service.OrganizationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RequestMapping("api/v1/event/")
@RestController
public class CasualEventController {

    private static final Logger log = LoggerFactory.getLogger(CasualEventController.class);

    @Autowired
    private CasualEventServiceImpl service;

    @Autowired
    private OrganizationServiceImpl organizationService;


    @PostMapping("/create/access_token/{token}")
    public ResponseEntity<Object> newCasualEvent(@PathVariable(name = "token") String token,
                                                         @Valid @RequestBody CasualEventDto dto) {
        Map<String, Object> response = new HashMap<>();
        Organization organizationObjective = organizationService.findByAccessToken(token);

        if (organizationObjective == null || !token.equals(organizationObjective.getAccessToken())) {
            response.put("message", "Token incorrect");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        dto.setOrganization(organizationObjective);
        service.create(dto);

        response.put("Name", dto.getName());
        response.put("Description", dto.getDescription());
        response.put("Date", dto.getDate());
        response.put("Generation Date", dto.getGenerationDate());

        response.put("Casual Event", dto.getName());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody CasualEventDto dto){
        Map<String, Object> response = new HashMap<>();
        CasualEventDto updateEvent = service.update(dto);

        if(updateEvent == null) {
            response.put("message", "Updated is fail.");
        }

        response.put("event", updateEvent);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> response = new HashMap<>();
        List<CasualEvent> eventList = new ArrayList<>();
        eventList = service.getAll();
        response.put("events", eventList);

        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Map<String, Object>> getByName(@PathVariable(name = "id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<CasualEvent> event = service.findById(id);

        response.put("event", event);
        response.put("message", "Event is find.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    /*@GetMapping("/find/{name}")
    public ResponseEntity<Map<String, Object>> getByName(@PathVariable(name = "name") String name) {
        Map<String, Object> response = new HashMap<>();
        Optional<Event> event = Optional.ofNullable(service.findByName(name));

        response.put("event", event);
        response.put("message", "Event is find.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }*/
}
