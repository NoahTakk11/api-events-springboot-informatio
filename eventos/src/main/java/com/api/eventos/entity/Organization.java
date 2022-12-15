package com.api.eventos.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity(name="organization")
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique = true)
    private Long id;

    private String name;
    private Double cuit;
    private Double phone;

    private String email;
    private String address;
    private Date generationDate;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    private List<CasualEvent> events;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    private List<RegularEvent> regularEvents;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    List<Appointment> apointments;

    @Column(name = "token")
    private String accessToken;

    private Boolean active;

}

