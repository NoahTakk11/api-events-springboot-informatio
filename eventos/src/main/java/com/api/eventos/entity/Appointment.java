package com.api.eventos.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "appointment")
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique = true)
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "casual_event_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CasualEvent event;


    @ManyToOne
    @JoinColumn(name = "organization_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Organization organization;


    private String alphanumericToken;


    private Boolean active;
}
