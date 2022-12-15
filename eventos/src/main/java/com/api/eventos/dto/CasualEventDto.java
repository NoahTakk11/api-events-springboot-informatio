package com.api.eventos.dto;

import com.api.eventos.entity.Organization;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class CasualEventDto {

    private Long id;

    @NotEmpty
    private String name;
    private Date generationDate = new Date();

    private LocalDate date;

    private String description;

    private Organization organization;

    private Boolean isActive = true;

}
