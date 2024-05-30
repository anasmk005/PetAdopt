package com.example.petadopt.Services.Service;
import com.example.petadopt.Dao.entities.Address;
import com.example.petadopt.Dao.repositories.AdresseRepo;
import com.example.petadopt.Services.Manager.ManagerAdresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAdresse implements ManagerAdresse{

    @Autowired
    public AdresseRepo adresseRepo;

    @Override
    public Address createAdress(Address adress) {

            return adresseRepo.save(adress) ;
    }

    @Override
    public List<Address> createAdresses(List<Address> addresses) {

        return adresseRepo.saveAll(addresses);
    }

    @Override
    public List<Address> getAllAdresss() {

        return adresseRepo.findAll();
    }

    @Override
    public Address getAdresseById(Long Adress_id) {
        return adresseRepo.findById(Adress_id).get();
    }

    @Override
    public boolean deleteAdress(Long id) {
       Address a= adresseRepo.findById(id).get();
       adresseRepo.delete(a);
        return false;
    }
}
