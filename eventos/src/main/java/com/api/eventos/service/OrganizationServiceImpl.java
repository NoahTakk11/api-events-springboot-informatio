package com.api.eventos.service;


import com.api.eventos.dto.EventDto;
import com.api.eventos.dto.OrganizationDto;
import com.api.eventos.entity.Event;
import com.api.eventos.entity.Organization;
import com.api.eventos.repository.IOrganizationDao;
import com.api.eventos.wrapper.OrganizationWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrganizationServiceImpl implements  IOrganizationService {

    @Autowired
    private IOrganizationDao dao;


    @Override
    public Organization findById(Long id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public OrganizationDto create(OrganizationDto dto) {
        dao.save(OrganizationWrapper.dtoToEntity(dto));
        return dto;
    }

    @Override
    public Organization findByName(String name) {
        return null;
    }


    @Override
    public Boolean deleteById(Long id ) {
        try {
            dao.logicDeleted(id);
            return true;
        }catch (Exception err) {
            return false;
        }


    }

    @Override
    public OrganizationDto update(OrganizationDto dto) {
        dao.save(OrganizationWrapper.dtoToEntity(dto));
        return dto;
    }

    @Override
    public Organization findByAccessToken(String name) {
        return dao.findByAccessToken(name).orElseThrow();
    }

    @Override
    public List<Organization> customerGetAll() {
        return dao.customerGetAll();
    }

    @Override
    public Organization findByCuit(String cuit) {
        return dao.findByCuit(cuit).orElseThrow();
    }

    @Override
    public void update(Long id, OrganizationDto dto) {
        Organization organizationExist = dao.findById(id).orElseThrow();

        if (organizationExist != null) {
            organizationExist.setName(dto.getName());
            organizationExist.setEmail(dto.getEmail());
            organizationExist.setAddress(dto.getAddress());
            organizationExist.setCuit(dto.getCuit());
            organizationExist.setPhone(dto.getPhone());
            dao.save(organizationExist);
        }
    }





}
