package com.api.eventos.service;

import com.api.eventos.dto.EventDto;
import com.api.eventos.dto.OrganizationDto;
import com.api.eventos.entity.Organization;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IOrganizationService {


    Organization findById(Long id);

    OrganizationDto create(OrganizationDto dto);

    Organization findByName(String name);

    Boolean deleteById(Long id);

    OrganizationDto update(OrganizationDto dto);

    Organization findByAccessToken(String name);

    List<Organization> customerGetAll();

    Organization findByCuit(String cuit);

    void update(Long id, OrganizationDto dto);


}
