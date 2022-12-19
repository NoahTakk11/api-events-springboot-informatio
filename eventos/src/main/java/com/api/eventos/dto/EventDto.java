package com.api.eventos.dto;

import com.api.eventos.entity.Organization;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class EventDto {

    private Long id;

    @NotEmpty(message = "Name can be not empty")
    private String name;

    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String generationDate = formato.format( new Date());


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String description;

    private Organization organization;

    private Boolean Active = true;

}
