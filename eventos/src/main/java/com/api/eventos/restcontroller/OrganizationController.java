package com.api.eventos.restcontroller;

import com.api.eventos.dto.OrganizationDto;
import com.api.eventos.entity.Organization;
import com.api.eventos.repository.IOrganizationDao;
import com.api.eventos.service.OrganizationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("api/v1/organization")
@RestController
public class OrganizationController {

    private static final Logger log = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationServiceImpl service;

    @Autowired
    private IOrganizationDao dao;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> newOrganization(@RequestBody OrganizationDto dto) {
        Map<String, Object> response = new HashMap<>();
        OrganizationDto newOrganization = service.create(dto);


        response.put("Name", newOrganization.getName());
        response.put("Cuit", newOrganization.getCuit());
        response.put("Phone", newOrganization.getPhone());
        response.put("Email", newOrganization.getEmail());
        response.put("Address", newOrganization.getAddress());
        response.put("Generation Date", newOrganization.getGenerationDate());
        response.put("Acceess Token", newOrganization.getAccessToken());
        response.put("Active", newOrganization.getActive());
        response.put("Alert", "Be sure to save your personal key as you will need it to use the api features!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> response = new HashMap<>();
        List<Organization> organizationList = service.getAll();

        response.put("organizations", organizationList);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Map<String, Object>> getByName(@PathVariable(name = "id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Organization organization = service.findById(id);

        response.put("organization", organization);
        response.put("message", "Organization is find.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}/access_token/{token}")
    public  ResponseEntity<Map<String, Object>> deleteById(@PathVariable(name = "id") Long id,
                                                             @PathVariable( "token") String token) {


        Organization organizationId = service.findById(id);
        Map<String, Object> response = new HashMap<>();
        List<String> accessToken = new ArrayList<>();
        accessToken.add(organizationId.getAccessToken());

        ResponseEntity<Map<String, Object>> responseEntity = null;
        if (accessToken.contains(token)) {
            service.deleteById(id);
            response.put("Organization", "The organization with name " + organizationId.getName().toUpperCase() + " has been deleted");
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
                                                      @RequestBody OrganizationDto dto) {

        Organization organizationId = service.findById(id);
        List<String> accessToken = new ArrayList<>();
        accessToken.add(organizationId.getAccessToken());
        Map<String, Object> response = new HashMap<>();

        ResponseEntity<Map<String, Object>> responseEntity = null;

        if (accessToken.contains(token)) {
            dto.setId(organizationId.getId());
            dto.setAccessToken(organizationId.getAccessToken());
            dto.setGenerationDate(organizationId.getGenerationDate());
            OrganizationDto updateOrganization = service.update(dto);
            response.put("organization", updateOrganization);
            response.put("message", "Organization is updated.");
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        }else {
            response.put("message", "Something has gone wrong");
            responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;

    }

    /*@PatchMapping("/partial_update/{id}")
    public ResponseEntity<Map<String, Object>> partialUpdate(@PathVariable(name = "id") Long id,
                                                             @RequestBody OrganizationDto dto) {
        Organization organizationId = service.findById(id);
        Map<String, Object> response = new HashMap<>();
        dto.setId(organizationId.getId());
        OrganizationDto updateOrganization = service.partialUpdate(dto);

        response.put("message", "The organizatin with name " + dto.getName() + " has been updated");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }*/



}
