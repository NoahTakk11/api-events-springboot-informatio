package com.api.eventos.dto;

import com.api.eventos.entity.Event;
import com.api.eventos.entity.Organization;
import com.api.eventos.entity.Person;
import com.api.eventos.security.PasswordGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
public class RegularAppointmentDto {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotNull
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
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
