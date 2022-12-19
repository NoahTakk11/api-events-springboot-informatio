package com.api.eventos.dto;


import com.api.eventos.entity.Event;
import com.api.eventos.security.PasswordGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class OrganizationDto {

    private Long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String cuit;

    @NotEmpty
    private String phone;
    @NotEmpty
    private String email;
    @NotEmpty
    private String address;
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String generationDate = formato.format( new Date());

    private List<Event> events;

    private String accessToken = PasswordGenerator.generatedAlphanumericKey(40);

    private Boolean active = true;
}
