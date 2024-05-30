package com.example.petadopt.Dao.repositories;
import com.example.petadopt.Dao.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByNom(String username);
}
