package com.api.eventos.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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
    private String cuit;
    private String phone;

    private String email;
    private String address;
    private String generationDate;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    private List<Event> events;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    List<Appointment> apointments;

    @Column(name = "token")
    private String accessToken;

    private Boolean active;

}

