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

    private String name;
    private String lastname;
    private String dni;

    private Appointment appointment;

    private String eventName;
    private String organizationName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String alphanumerickey = PasswordGenerator.generatedAlphabeticKey(10);
    private Boolean active = true;
}
