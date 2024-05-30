package com.example.petadopt.Web;

import com.example.petadopt.Dao.entities.Utilisateur;
import com.example.petadopt.Dao.repositories.UserRepo;
import com.example.petadopt.Services.Manager.ManagerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller



public class ControllerUser {
    @Autowired
    private ManagerUser managerUser;
    @Autowired
    private UserRepo userRepo;
    @GetMapping(
            path="/getAllUser",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String getAllUsers() {

        try {
            List<Utilisateur> userList = null;
            userList = managerUser.Users();
            if (userList != null) {
                return "getAllUsers";
            } else {
                return "error";
            }
        } catch (Exception e) {
            return "getAllUsers";
        }
    }



}
