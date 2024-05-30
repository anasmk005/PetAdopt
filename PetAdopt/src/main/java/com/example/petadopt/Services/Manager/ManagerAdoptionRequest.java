package com.example.petadopt.Services.Manager;

import com.example.petadopt.Dao.entities.AdoptionRequest;

import java.util.List;

public interface ManagerAdoptionRequest {
    AdoptionRequest createAdoptionRequest(AdoptionRequest adoptionRequest);
    List<AdoptionRequest> getAllAdoptionRequests();

    AdoptionRequest getAdoptionRequestById(Long Id);

    boolean deleteAdoptionRequest(Long id);
}
