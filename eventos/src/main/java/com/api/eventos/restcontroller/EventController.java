package com.api.eventos.restcontroller;

import com.api.eventos.dto.EventDto;
import com.api.eventos.entity.Event;
import com.api.eventos.entity.Organization;
import com.api.eventos.service.EventServiceImpl;
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
public class EventController {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventServiceImpl service;

    @Autowired
    private OrganizationServiceImpl organizationService;


    @PostMapping("/create/access_token/{token}")
    public ResponseEntity<Object> newCasualEvent(@PathVariable(name = "token") String token,
                                                         @Valid @RequestBody EventDto dto) {
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


    @PutMapping("/update/{id}/access_token/{token}")
    public ResponseEntity<String> update(@PathVariable(name = "id") Long id,
                                                      @PathVariable(name = "token") String token,
                                                      @RequestBody EventDto dto){

        Organization organizationObjective = organizationService.findByAccessToken(token);

        if (organizationObjective == null || !token.equals(organizationObjective.getAccessToken())) {

            return ResponseEntity.badRequest().build();
        }

        if (service.findById(id) == null) {

            return ResponseEntity.badRequest().build();
        }

        service.update(id, dto);

        return ResponseEntity.ok("Update successful");
    }

    /*@PutMapping("/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody EventDto userDto){
        Map<String, Object> response = new HashMap<>();
        EventDto updateUser = service.create(userDto);

        if(updateUser == null) {
            response.put("mensaje", "No se pudo actualizar la informacion del usuario.");
        }

        response.put("user", updateUser);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }*/



    @GetMapping("/find/all")
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> response = new HashMap<>();
        List<Event> eventList = new ArrayList<>();
        eventList = service.getAll();
        response.put("events", eventList);

        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Map<String, Object>> getByName(@PathVariable(name = "id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Event> event = service.findById(id);

        response.put("event", event);
        response.put("message", "Event is find.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}/access_token/{token}")
    public  ResponseEntity<Map<String, Object>> deleteById(@PathVariable(name = "id") Long id,
                                                           @PathVariable( "token") String token) {


        Organization organizationId = organizationService.findById(id);
        Map<String, Object> response = new HashMap<>();
        List<String> accessToken = new ArrayList<>();
        accessToken.add(organizationId.getAccessToken());

        ResponseEntity<Map<String, Object>> responseEntity = null;
        if (accessToken.contains(token)) {
            service.deleteById(id);
            response.put("Event", "The event with id " + id + " has been deleted");
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Something has gone wrong");
            responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
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
