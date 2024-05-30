package com.example.petadopt.Services.Manager;

import com.example.petadopt.Dao.entities.Administrateur;

import java.util.List;
import java.util.Optional;

public interface ManagerAdministrateur {

    Optional<Administrateur> createAdmin(Administrateur administrateur);
    
    List<Administrateur> getAllAdministrateurs();
    public Administrateur getAdmById(Long admin_id);

    boolean deleteAdmin(Long id);

    List<Administrateur> AdministrateurList();
}
