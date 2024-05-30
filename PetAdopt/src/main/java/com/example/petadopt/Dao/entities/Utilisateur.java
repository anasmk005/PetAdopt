package com.example.petadopt.Dao.entities;
import jakarta.persistence.*;
import lombok.*;


import java.util.Collection;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;


    private String email;


    private String motDePasse;
    private String username;
    @OneToOne
    private Address address;

    @OneToOne
    private Administrateur administrateur ;



    @ElementCollection(fetch = FetchType.EAGER)
    Collection<String> Roles;



}



