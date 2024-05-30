package com.example.petadopt.Services.Service;

import com.example.petadopt.Dao.entities.Administrateur;
import com.example.petadopt.Dao.repositories.AdministrateurRepo;
import com.example.petadopt.Services.Manager.ManagerAdministrateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAdministrateur implements ManagerAdministrateur {
    @Autowired
    AdministrateurRepo administrateurRepo;
    @Override
    public Optional<Administrateur> createAdmin(Administrateur administrateur) {
        try {
            administrateurRepo.save(administrateur);
            return Optional.of(administrateur);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }



    @Override
    public List<Administrateur> getAllAdministrateurs() {
        try {
            return administrateurRepo.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Administrateur getAdmById(Long admin_id) {
        return administrateurRepo.findById(admin_id).get();
    }

    @Override
    public boolean deleteAdmin(Long id) {
        Administrateur a =administrateurRepo.findById(id).get();
        administrateurRepo.delete(a);
        return true;
    }

    @Override
    public List<Administrateur> AdministrateurList() {
        return null;
    }

}