package com.api.eventos.entity;


import com.api.eventos.entity.Event;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique = true)
    private Long id;

    private String name;
    private String lastname;
    private String dni;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "appointment_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Appointment appointment;

    private String eventName;
    private String organizationName;
    private Date date;
    private String alphanumerickey;
    private Boolean active;

}
