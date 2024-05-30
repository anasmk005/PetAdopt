package com.example.petadopt.Web;

import com.example.petadopt.Dao.entities.Rendezvous;
import com.example.petadopt.Services.Manager.ManagerRendezvous;
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
public class ControllerRendezvous  {
    @Autowired
    private ManagerRendezvous managerRendezvous;
    @PostMapping(
            path = "/createRendezvous",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Rendezvous> createRendezvous(@RequestBody Rendezvous rendezvousToCreate){
        try {
            Optional<Rendezvous> optionalRendezvous= managerRendezvous.createRendez_vous(rendezvousToCreate);
            if (optionalRendezvous.isPresent()){
                return ResponseEntity.status(200).body(optionalRendezvous.get());
            }
            throw new Exception("Rendez_vous can not be created ");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).body(new Rendezvous());
        }
    }
    @GetMapping(
            path="/getAllRendezvous",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Rendezvous> getAllRendezvous() {
        List<Rendezvous> rendezvousList = null;
        try {
            rendezvousList = null;
            rendezvousList = managerRendezvous.Rendezvouss();
            if (rendezvousList != null) {
                return ResponseEntity.ok((Rendezvous) rendezvousList);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).body((Rendezvous) rendezvousList);
        }
    }
    @GetMapping(
            path="/getRendezvoousById",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Rendezvous> getRendezvousByid(@RequestParam long id){
        Rendezvous getRendezvousById =new Rendezvous();
        try {
            getRendezvousById=managerRendezvous.getRendez_vousById((Long) id);
            return ResponseEntity.status(200).body(getRendezvousById);
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }
    @DeleteMapping("deleteRendez_vous")
    public ResponseEntity<String> deleteRendez_vous(Long id){
        try {
            boolean deleted=deleteRendez_vous(id).hasBody();
            if (deleted){
                return ResponseEntity.ok("the rendez-vous is deleted");
            }else {
                return ResponseEntity.ok("the rendez-vous is not deleted");
            }
        }catch (Exception e){
            return ResponseEntity.ok("the rendez-vous is not deleted");
        }
    }
}







