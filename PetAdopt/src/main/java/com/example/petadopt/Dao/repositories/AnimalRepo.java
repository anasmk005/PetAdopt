package com.example.petadopt.Dao.repositories;
import com.example.petadopt.Dao.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepo extends JpaRepository<Animal,Long> {

}
