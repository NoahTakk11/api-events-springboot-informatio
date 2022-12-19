package com.api.eventos.repository;

import com.api.eventos.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrganizationDao extends JpaRepository<Organization, Long> {


    Optional<Organization> findByAccessToken(String token);

    @Modifying
    @Transactional
    @Query(value = "UPDATE organization SET active=false WHERE id= :id")
    void logicDeleted(@Param("id") Long id);


    @Query(value = "SELECT o FROM organization o WHERE active=true")
    List<Organization> customerGetAll();

    @Query(value = "SELECT o FROM organization o WHERE active=true AND cuit= :cuit")
    Optional<Organization> findByCuit(String cuit);

    @Query(value = "SELECT o FROM organization o WHERE active=true AND name= :name")
    Optional<Organization> findByName(String name);

}
