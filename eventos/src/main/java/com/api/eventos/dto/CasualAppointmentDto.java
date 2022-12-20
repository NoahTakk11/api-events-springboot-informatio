package com.api.eventos.dto;

import com.api.eventos.entity.Event;
import com.api.eventos.entity.Organization;
import com.api.eventos.entity.Person;
import com.api.eventos.security.PasswordGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
public class CasualAppointmentDto {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    @NotNull
    private Event event;

    @Getter
    @Setter
    private Organization organization;

    @Getter
    @Setter
    private Person person;

    @Getter
    private String alphanumericToken = PasswordGenerator.generatedAlphabeticKey(20);

    @Getter
    private Boolean active = true;
}
