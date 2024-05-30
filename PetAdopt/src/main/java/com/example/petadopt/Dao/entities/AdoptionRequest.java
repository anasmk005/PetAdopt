package com.example.petadopt.Dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdoptionRequest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Utilisateur user;

    @ManyToOne
    private Animal animal;

    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;

    private String status;


    }
