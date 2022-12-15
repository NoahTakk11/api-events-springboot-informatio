package com.api.eventos.repository;

import com.api.eventos.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IAppointmentDao extends JpaRepository<Appointment, Long> {

    /*@Query(value = "INSERT INTO appointment (organization_id) VALUES (:organization)")
    public void setOrganization(Organization organization);*/
}
