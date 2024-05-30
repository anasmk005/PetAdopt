package com.example.petadopt.Services.Manager;

import com.example.petadopt.Dao.entities.Animal;

import java.util.List;

public interface ManagerAnimal {
    Animal createAnimal(Animal animal);

    List<Animal> creatAnimals(List<Animal> animals);
    List<Animal> getAllAnimal();
    Animal getAniamlById(Long Id);
    boolean deleteAnimal(Long Id);


    List<Animal> Animals();
}
