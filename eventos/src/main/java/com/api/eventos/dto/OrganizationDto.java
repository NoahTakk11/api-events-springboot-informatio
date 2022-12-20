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

    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotEmpty(message = "Cuit cannot be empty")
    private String cuit;

    @NotEmpty(message = "Phone cannot be empty")
    private String phone;
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @NotEmpty(message = "Address cannot be empty")
    private String address;
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String generationDate = formato.format( new Date());

    private List<Event> events;

    private String accessToken = PasswordGenerator.generatedAlphanumericKey(40);

    private Boolean active = true;
}
