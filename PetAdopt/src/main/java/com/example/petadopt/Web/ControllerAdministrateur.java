package com.example.petadopt.Web;

import com.example.petadopt.Dao.entities.Administrateur;
import com.example.petadopt.Dao.repositories.AdministrateurRepo;
import com.example.petadopt.Services.Manager.ManagerAdministrateur;
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
public class ControllerAdministrateur {
    @Autowired
    private ManagerAdministrateur managerAdministrateur;

    //private List<Administrateur> AdministrateurList;
    @Autowired
    AdministrateurRepo administrateurRepo;
    @PostMapping(
            path="/createAdmin",
            produces ={MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Administrateur> createAdmin(@RequestBody Administrateur admintocreate){
        try {
            Optional<Administrateur> optionalAdministrateur = managerAdministrateur.createAdmin(admintocreate);
            if (optionalAdministrateur.isPresent()) {
                return ResponseEntity.status(200).body(optionalAdministrateur.get());
            }
            throw new Exception("User can not be created");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).body(new Administrateur());
        }
    }
}
   /* @GetMapping(
            path="/GetAllAdministrateurs",
            produces ={MediaType.APPLICATION_JSON_VALUE}
    )
    public  ResponseEntity<List<Administrateur>> getAllAdministrateurs(){
        try {
            List<Administrateur> administrateurList = null;
            ServiceAdministrateur managerAdministrateur = null;
            administrateurList = managerAdministrateur.Administrateurs();
            if (administrateurList != null){
                return ResponseEntity.ok(administrateurList);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(404).body(administrateurList);
        }
    }*/
      /*  @GetMapping(
                path="/getAdmById",
                produces = {MediaType.APPLICATION_JSON_VALUE}
        )
            public ResponseEntity<Object> getAdmById(@RequestParam Long admin_id) {
            Administrateur getAdmById = new Administrateur();
            try {
                getAdmById = ManagerAdministrateur.getAdmById((Long) admin_id);
                ResponseEntity.status(200).body(getAdmById);
            } catch (Exception e) {
                return ResponseEntity.status(404).body(null);
            }
        }*/
/*  @DeleteMapping ("/administrateurs/{adminId}")

public ResponseEntity<String> deleteAdmin(@RequestParam("adminId") Long id) {
    try{
        boolean deleted= deleteAdmin(adminId).hasBody();
        if (deleted){
            return ResponseEntity.ok("User deleted successfully");
        }
        else {
            return ResponseEntity.ok("User is not deleted");
        }
    }catch (Exception e){
        return ResponseEntity.ok("User is not deleted");
    }
}*/










