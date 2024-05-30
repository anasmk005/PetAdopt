package com.example.petadopt.Dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Utilisateur {
    @OneToMany(mappedBy = "client")
    private Collection<Animal> animal;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rendezvous RendezvousUser;

    @OneToOne
    private Address address;

}
