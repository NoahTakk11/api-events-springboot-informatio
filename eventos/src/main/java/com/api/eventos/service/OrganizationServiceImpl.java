package com.api.eventos.service;


import com.api.eventos.dto.OrganizationDto;
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


   /* @Override
    public OrganizationDto partialUpdate(OrganizationDto dto, Long id) {
        Organization organizationExist = dao.findById(dto.getId()).orElseThrow();

        if (organizationExist != null) {
            Organization entityToPersist = new Organization();
            //entityToPersist.setId(dto.getId());
            entityToPersist.setName(dto.getName());
            entityToPersist.setPhone(dto.getPhone());
            entityToPersist.setEmail(dto.getEmail());
            entityToPersist.setAddress(dto.getAddress());
            entityToPersist.setCuit(dto.getCuit());
            entityToPersist.setActive(dto.getActive());
            entityToPersist.setAccessToken(organizationExist.getAccessToken());
            entityToPersist.setGenerationDate(organizationExist.getGenerationDate());

            organizationExist = dao.save(entityToPersist);
            dto = OrganizationWrapper.entityToDto(organizationExist);
            return dto;

        }
        return null;
    }*/




}
