package com.example.petadopt.Dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String espece;
    private String race;
    private int age;
    private String sexe;
    private String description;
    private String photoUrl;
   @ManyToOne
    private Client client;
}

