package com.api.eventos.restcontroller;

import com.api.eventos.dto.RegularEventDto;
import com.api.eventos.entity.Organization;
import com.api.eventos.entity.RegularEvent;
import com.api.eventos.service.OrganizationServiceImpl;
import com.api.eventos.service.RegularEventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RequestMapping("api/v1/regular_event/")
@RestController
public class RegularEventController {

    @Autowired
    private RegularEventServiceImpl service;

    @Autowired
    private OrganizationServiceImpl organizationService;


    @PostMapping("/create/access_token/{token}")
    public ResponseEntity<Object> newRegularEvent(@PathVariable(name = "token") String token,
                                                 @Valid @RequestBody RegularEventDto dto) {
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

        response.put("RegularEvent", dto.getName());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody RegularEventDto dto){
        Map<String, Object> response = new HashMap<>();
        RegularEventDto updateEvent = service.update(dto);

        if(updateEvent == null) {
            response.put("message", "Updated is fail.");
        }

        response.put("event", updateEvent);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> response = new HashMap<>();
        List<RegularEvent> eventList = new ArrayList<>();
        eventList = service.getAll();
        response.put("events", eventList);

        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Map<String, Object>> getByName(@PathVariable(name = "id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<RegularEvent> event = service.findById(id);

        response.put("event", event);
        response.put("message", "Event is find.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }
}
