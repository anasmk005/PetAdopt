package com.example.petadopt.Services.Manager;

import com.example.petadopt.Dao.entities.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface    ManagerUser {
     Optional<Utilisateur> createUser(Utilisateur user);
   /*  List<User> createUsers(List<User> users);*/

     List<Utilisateur> getAllUser();
     Utilisateur getUserById(Long user_id);
     Optional<Utilisateur> findByUsername(String username);

     boolean deleteUser(Long id);

     List<Utilisateur> Users();
}
