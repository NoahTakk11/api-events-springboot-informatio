package com.api.eventos.dto;

import com.api.eventos.entity.Appointment;
import com.api.eventos.entity.Event;
import com.api.eventos.security.PasswordGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class PersonDto {

    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotEmpty(message = "Lastname cannot be empty")
    private String lastname;
    @NotEmpty(message = "Dni cannot be empty")
    private String dni;

    private Appointment appointment;

    private String alphanumericKey = PasswordGenerator.generatedAlphabeticKey(10);
    private Boolean active = true;
}
