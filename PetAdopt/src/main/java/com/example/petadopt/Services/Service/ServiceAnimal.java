package com.example.petadopt.Services.Service;

import com.example.petadopt.Dao.entities.Animal;
import com.example.petadopt.Dao.repositories.AnimalRepo;
import com.example.petadopt.Services.Manager.ManagerAnimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAnimal implements ManagerAnimal {

    @Autowired
    AnimalRepo animalRepo;
    @Override
    public Animal createAnimal(Animal animal) {

        return animalRepo.save(animal);
    }

    @Override
    public List<Animal> creatAnimals(List<Animal> animals) {

        return animalRepo.saveAll(animals);
    }

    @Override
    public List<Animal> getAllAnimal() {

        return animalRepo.findAll();
    }

    @Override
    public Animal getAniamlById(Long Id) {
        return animalRepo.findById(Id).get();
    }

    @Override
    public boolean deleteAnimal(Long animal_Id) {
        Animal a= animalRepo.findById(animal_Id).get();
        animalRepo.delete(a);
        return true;
    }

    @Override
    public List<Animal> Animals() {
        return null;
    }
}