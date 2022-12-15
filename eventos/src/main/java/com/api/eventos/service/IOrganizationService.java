package com.api.eventos.service;

import com.api.eventos.dto.OrganizationDto;
import com.api.eventos.entity.Organization;

import java.util.List;

public interface IOrganizationService {

    public List<Organization> getAll();

    public Organization findById(Long id);

    public OrganizationDto create(OrganizationDto dto);

    Organization findByName(String name);

    public Boolean deleteById(Long id);

    public OrganizationDto update(OrganizationDto dto);

    Organization findByAccessToken(String name);

    public List<Organization> customerGetAll();

    /*public OrganizationDto partialUpdate(OrganizationDto dto);*/



}
