package com.example.petadopt.Web;

import com.example.petadopt.Dao.entities.Animal;
import com.example.petadopt.Dao.repositories.AnimalRepo;
import com.example.petadopt.Services.Manager.ManagerAnimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1")
@CrossOrigin(value = "localhost://8090")
public class ControllerAnimal {
    @Autowired
    private ManagerAnimal managerAnimal;
    @Autowired
    private AnimalRepo animalRepo;

    //List<Animal> AnimalList;


    @PostMapping(
    path= "createAnimal",
    consumes= {MediaType.APPLICATION_JSON_VALUE},
    produces= {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animalToCreate){
        try {
            Optional<Animal> optionalAnimal= Optional.ofNullable(managerAnimal.createAnimal(animalToCreate));
            if (optionalAnimal.isPresent()){
                    return ResponseEntity.status(200).body(optionalAnimal.get());
        }
            throw  new Exception("Animal can not be created");
    }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).body(new Animal());
        }
    }
    @PostMapping(
            path="createAnimals",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<Animal>> createAnimals(@RequestBody List<Animal> AnimlasToCreate){
        List<Animal> animalsResponse =null;
                try {
                    List<Animal> animals = null;
                    animalsResponse=managerAnimal.creatAnimals(animals);
                    return ResponseEntity.status(200).body(animalsResponse);
                }catch (Exception e){
                    return ResponseEntity.status(400).body(animalsResponse);
                }
    }
    @GetMapping(
            path="getAllAnimal",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> animalList = null;
        try {
            animalList = managerAnimal.Animals();
            if (animalList != null) {
                return ResponseEntity.ok(animalList);
            } else  {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).body(animalList);
        }
    }
    @GetMapping(
            path = "getAnimalById",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Animal> getAnimalByID(@RequestParam Long id){
        Animal getAnimalById =new Animal();
        try {
            getAnimalById=managerAnimal.getAniamlById((Long) id);
            return ResponseEntity.status(200).body(getAnimalById);
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }

    @DeleteMapping(
            path="deleteAnimal",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<String> deleteAnimal(@RequestParam Long id) {
        try {
            boolean deleted = deleteAnimal(id).hasBody();
            if (deleted) {
                return ResponseEntity.ok("this animal was deleted");
            } else ResponseEntity.ok("this animal is not deleted ");
        } catch (Exception e) {
            return ResponseEntity.ok("this animal is not deleted ");
        }
        return null;
    }
}


