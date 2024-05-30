package com.example.petadopt.Dao.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data


public class Administrateur extends Utilisateur {

    @OneToOne(
            mappedBy = "administrateur"
    )
    private Utilisateur userAdmin;

}
