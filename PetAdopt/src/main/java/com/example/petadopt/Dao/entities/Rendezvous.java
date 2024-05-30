package com.example.petadopt.Dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Rendezvous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private Date date_meeting;
    private String lieu;

    @OneToMany(
            mappedBy = "RendezvousUser"
    )
    private Collection<Client> clients;

    @OneToOne(mappedBy = "rendezvousAdresse")
    private Address adresse; // Correction ici




}
