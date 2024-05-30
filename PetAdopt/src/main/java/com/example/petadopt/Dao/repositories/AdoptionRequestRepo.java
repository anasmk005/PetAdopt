package com.example.petadopt.Dao.repositories;
import com.example.petadopt.Dao.entities.AdoptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AdoptionRequestRepo extends JpaRepository<AdoptionRequest,Long> {

}
