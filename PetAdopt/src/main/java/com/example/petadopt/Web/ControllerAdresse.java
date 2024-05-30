package com.example.petadopt.Web;

import com.example.petadopt.Dao.entities.Address;
import com.example.petadopt.Dao.repositories.AdresseRepo;
import com.example.petadopt.Services.Manager.ManagerAdresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/api/v1")
@CrossOrigin(value = "localhost://4200")
public class ControllerAdresse {
    @Autowired
    private ManagerAdresse managerAdresse;
    @Autowired
    private AdresseRepo adresseRepo;

    List<Address> adresseList;

    @PostMapping(
            path = "createAdrasse",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> createAdrasse(@RequestBody Address adresseToCreate) {
        try {
            Optional<Address> optionalAdresse = Optional.ofNullable(managerAdresse.createAdress(adresseToCreate));
            if (optionalAdresse.isPresent()) {
                return ResponseEntity.status(200).body(optionalAdresse.get());

            }
            throw new Exception("this adresse can not be  created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(
            path = "createAdresses",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public <Adress> ResponseEntity<List<Adress>> createadresses(@RequestBody List<Adress> AdressesToCreate) {
        List<Adress> adressesResponse = null;
        try {
            adressesResponse = (List<Adress>) managerAdresse.createAdresses(adresseList);
            return ResponseEntity.status(200).body(adressesResponse);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(adressesResponse);
        }
    }

    @GetMapping(
            path = "/getAllAdresses",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<Address>> getaAllAdresss() {
        try {
            List<Address> adresseList = null;
            adresseList = managerAdresse.getAllAdresss();
            if (adresseList != null) {
                return ResponseEntity.ok(adresseList);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).body(adresseList);
        }
    }

    @GetMapping(
            path = "/getAdresseById",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )

    public ResponseEntity<Address> getAddressById(@RequestParam Long address_id) {
        Address getAdressById = new Address();
        try {
            Address getAdresseById = managerAdresse.getAdresseById((Long) address_id);
            return ResponseEntity.status(200).body(getAdressById);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @DeleteMapping(
            path = "deleteAdress",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<String> deleteAdress(@RequestParam Long Adress_id) {
        try {
                boolean deleted= deleteAdress(Adress_id).hasBody();
                if (deleted){
                    return ResponseEntity.ok("address deleted succesfully ");
                }else {
                    return ResponseEntity.ok("adress is not deleted");
                }
        }catch (Exception e){
            return ResponseEntity.ok("User is not deleted");
        }
    }

}




















