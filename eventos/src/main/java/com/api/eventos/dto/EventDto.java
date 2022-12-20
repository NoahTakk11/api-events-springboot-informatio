package com.api.eventos.dto;

import com.api.eventos.entity.Organization;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

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

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String generationDate = formato.format( new Date());


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "Date cannot be empty")
    private Date date;

    @NotEmpty(message = "There must be a description")
    private String description;

    private Organization organization;

    private Boolean Active = true;

}
