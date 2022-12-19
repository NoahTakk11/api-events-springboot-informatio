package com.api.eventos.restcontroller;

import com.api.eventos.dto.PersonDto;
import com.api.eventos.entity.Organization;
import com.api.eventos.entity.Person;
import com.api.eventos.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    @Autowired
    private PersonServiceImpl service;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> newPerson(@RequestBody @Valid PersonDto dto) {
        Map<String, Object> response = new HashMap<>();
        PersonDto newPerson = service.create(dto);

        response.put("person", newPerson);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> response = new HashMap<>();
        List<Person> personList = service.getAll();

        response.put("persons", personList);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Map<String, Object>> getByName(@PathVariable(name = "id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Person person = service.findById(id).orElseThrow();

        response.put("person", person);
        response.put("message", "Person is find.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @GetMapping("/find/{dni}")
    public ResponseEntity<Map<String, Object>> getByDni(@PathVariable(name = "dni") String dni) {
        Map<String, Object> response = new HashMap<>();
        Person person = service.findByDni(dni);

        response.put("person", person);
        response.put("message", "Person is find.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @GetMapping("/find/{lastname}")
    public ResponseEntity<Map<String, Object>> getByLastname(@PathVariable(name = "lastname") String lastname) {
        Map<String, Object> response = new HashMap<>();
        Person person = service.findByLastname(lastname);

        response.put("person", person);
        response.put("message", "Person is find.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}/access_token/{token}")
    public  ResponseEntity<Map<String, Object>> deleteById(@PathVariable(name = "id") Long id,
                                                           @PathVariable( "token") String token) {


        Person personId = service.findById(id).orElseThrow();
        Map<String, Object> response = new HashMap<>();
        List<String> accessToken = new ArrayList<>();
        accessToken.add(personId.getAlphanumerickey());

        ResponseEntity<Map<String, Object>> responseEntity = null;
        if (accessToken.contains(token)) {
            service.deleteById(id);
            response.put("person", "The person with name " + personId.getName().toUpperCase() + " has been deleted");
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Something has gone wrong");
            responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("/update/{id}/access_token/{token}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable(name = "id") Long id,
                                                      @PathVariable(name = "token") String token,
                                                      @RequestBody PersonDto dto) {

        Person perosonId = service.findById(id).orElseThrow();
        List<String> accessToken = new ArrayList<>();
        accessToken.add(perosonId.getAlphanumerickey());
        Map<String, Object> response = new HashMap<>();

        ResponseEntity<Map<String, Object>> responseEntity = null;

        if (accessToken.contains(token)) {
            dto.setId(perosonId.getId());
            dto.setAlphanumerickey(perosonId.getAlphanumerickey());
            PersonDto updatePerson = service.update(dto);
            response.put("person", updatePerson);
            response.put("message", "Person is updated.");
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        }else {
            response.put("message", "Something has gone wrong");
            responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;

    }

}
