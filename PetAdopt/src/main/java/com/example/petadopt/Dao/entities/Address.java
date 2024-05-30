package com.example.petadopt.Dao.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String postalCode;
    private String country;

    @OneToOne
    @JoinColumn(name = "rendezvous_id") // Ajout d'une colonne de jointure
    private Rendezvous rendezvousAdresse;
    @OneToOne(mappedBy = "address")
    private Utilisateur userAddress;


    public boolean isPresent() {
        return false;
    }
}
