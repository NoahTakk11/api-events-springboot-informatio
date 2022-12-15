package com.api.eventos.dto;

import com.api.eventos.entity.CasualEvent;
import com.api.eventos.entity.Organization;
import com.api.eventos.security.PasswordGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
public class AppointmentDto {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private LocalDate date;

    @Getter
    @Setter
    private CasualEvent event;

    @Getter
    @Setter
    private Organization organization;

    @Getter
    private String alphanumericToken = PasswordGenerator.generatedAlphabeticKey(20);

    @Getter
    private Boolean active = true;
}
