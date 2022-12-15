package com.api.eventos.dto;


import com.api.eventos.entity.CasualEvent;
import com.api.eventos.security.PasswordGenerator;

import java.util.Date;
import java.util.List;

public class OrganizationDto {

    private Long id;
    private String name;
    private Double cuit;


    private Double phone;
    private String email;
    private String address;
    private Date generationDate = new Date();

    private List<CasualEvent> events;

    private String accessToken = PasswordGenerator.generatedAlphanumericKey(40);

    private Boolean active = true;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCuit() {
        return cuit;
    }

    public void setCuit(Double cuit) {
        this.cuit = cuit;
    }

    public Double getPhone() {
        return phone;
    }

    public void setPhone(Double phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

    public List<CasualEvent> getEvents() {
        return events;
    }

    public void setEvents(List<CasualEvent> events) {
        this.events = events;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String personalKey) {
        this.accessToken = personalKey;
    }
}
