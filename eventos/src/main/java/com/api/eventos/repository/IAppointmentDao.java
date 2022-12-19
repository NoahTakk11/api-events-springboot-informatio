package com.api.eventos.repository;

import com.api.eventos.entity.Appointment;
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
public interface IAppointmentDao extends JpaRepository<Appointment, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE appointment SET active=false WHERE id= :id")
    void logicDeleted(@Param("id") Long id);


    @Query(value = "SELECT a FROM appointment a WHERE active=true")
    List<Appointment> customerGetAll();

    @Query(value = "SELECT a FROM appointment a WHERE active=true AND organization_id= :organization")
    List<Appointment> findByOrganization(String organization);

    @Query(value = "SELECT a FROM appointment a WHERE active=true AND organization_id= :organization AND event_id= :event")
    List<Appointment> findByOrganizationAndEvent(String organization, String event);
}
