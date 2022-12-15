package com.api.eventos.dto;

import com.api.eventos.security.PasswordGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class PersonDto {

    private Long id;

    private String name;
    private String lastname;
    private String dni;
    private String eventName;
    private String organizationName;
    private Date date;
    private String alphanumerickey = PasswordGenerator.generatedAlphabeticKey(10);
    private Boolean active = true;
}
