package com.example.petadopt.Services.Service;

import com.example.petadopt.Dao.entities.AdoptionRequest;
import com.example.petadopt.Dao.repositories.AdoptionRequestRepo;
import com.example.petadopt.Services.Manager.ManagerAdoptionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceAdoptionRequest implements ManagerAdoptionRequest {
    @Autowired
     public AdoptionRequestRepo adoptionRequestRepo;


    @Override
    public AdoptionRequest createAdoptionRequest(AdoptionRequest adoptionRequest) {

        return adoptionRequestRepo.save(adoptionRequest);
    }

    @Override
    public List<AdoptionRequest> getAllAdoptionRequests() {
        return adoptionRequestRepo.findAll();
    }

    @Override
    public AdoptionRequest getAdoptionRequestById(Long AdoptionRequest_id) {

        return adoptionRequestRepo.findById(AdoptionRequest_id).get();
    }


    @Override
    public boolean deleteAdoptionRequest(Long id) {
        AdoptionRequest s = adoptionRequestRepo.findById(id).get();
        adoptionRequestRepo.delete(s);
        return true;
    }
}


