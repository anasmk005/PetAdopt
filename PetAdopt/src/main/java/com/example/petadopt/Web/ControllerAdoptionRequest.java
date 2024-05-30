package com.example.petadopt.Web;

import com.example.petadopt.Dao.entities.AdoptionRequest;
import com.example.petadopt.Dao.repositories.AdoptionRequestRepo;
import com.example.petadopt.Services.Manager.ManagerAdoptionRequest;
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
public class ControllerAdoptionRequest {
    @Autowired
    private ManagerAdoptionRequest managerAdoptionRequest;
    @Autowired
    private AdoptionRequestRepo adoptionRequestRepo;

   //private List<AdoptionRequest> adoptionRequestList;
    private String path;

    @PostMapping(
            path = "/createAdoptionRequest",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<AdoptionRequest> createAdoptionRequest(@RequestBody AdoptionRequest adoptionRequest){
        try {
            Optional<AdoptionRequest> optionalAdoptionRequest = Optional.ofNullable(managerAdoptionRequest.createAdoptionRequest(adoptionRequest));
         if(optionalAdoptionRequest.isPresent()){
             return ResponseEntity.status(200).body(optionalAdoptionRequest.get());
         }
             throw new Exception("request can't be created ");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).body(new AdoptionRequest());
        }
    }
    @GetMapping(
            path="/getAllAdoptionRequests",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<AdoptionRequest> getAllAdoptionRequests() {
        List<AdoptionRequest> adoptionRequests = null;
        try {
            adoptionRequests = null;
            adoptionRequests = managerAdoptionRequest.getAllAdoptionRequests();
            if (adoptionRequests != null) {
                return ResponseEntity.ok((AdoptionRequest) adoptionRequests);
            } else {
                return ResponseEntity.notFound().build();

            }
        } catch (Exception e) {
            return ResponseEntity.status(400).body((AdoptionRequest) adoptionRequests);
        }
    }
    @GetMapping(
            path="/getAdoptionRequestById",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<AdoptionRequest>  getAdoptionRequestById(@RequestParam Long id){
            AdoptionRequest getAdoptionRequestById= new AdoptionRequest();
            try {
                getAdoptionRequestById= managerAdoptionRequest.getAdoptionRequestById((Long) id);
                return ResponseEntity.status(200).body(getAdoptionRequestById);
            }catch (Exception e){
                return ResponseEntity.status(400).body(null);
            }
    }
    @DeleteMapping(
                    path="deleteAdoptionRequest",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<String> deleteAdoptionRequest(@RequestParam Long id){
        try {
            boolean  deleted =deleteAdoptionRequest(id).hasBody();
            if (deleted){
                return ResponseEntity.ok("Request deleted  succefully");
            }else {
                return ResponseEntity.ok("Request is not deleted");
            }
        }catch (Exception e){
            return ResponseEntity.ok("Request is not deleted");
        }
    }
}
