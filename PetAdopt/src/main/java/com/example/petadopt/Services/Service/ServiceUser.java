package com.example.petadopt.Services.Service;

import com.example.petadopt.Dao.entities.Utilisateur;
import com.example.petadopt.Dao.repositories.UserRepo;
import com.example.petadopt.Services.Manager.ManagerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUser implements ManagerUser {

    @Autowired
    public UserRepo userRepo;

    @Override
    public Optional<Utilisateur> createUser(Utilisateur user) {
        try {
            userRepo.save(user);
            return Optional.of(user) ;
        }catch (Exception e){   
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    /*@Override
    public List<User> createUsers(List<User> users) {
        try {
            userRepo.saveAll(users);
            return users;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
*/
    @Override
    public List<Utilisateur> getAllUser() {
        try {
            return userRepo.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Utilisateur getUserById(Long user_id) {

            return userRepo.findById(user_id).get();
    }

    @Override
    public Optional<Utilisateur> findByUsername(String username) {
        return userRepo.findByNom(username);
    }

    @Override
    public boolean deleteUser(Long user_id) {
        Utilisateur u =userRepo.findById(user_id).get();
        userRepo.delete(u);
        return true;
    }

    @Override
    public List<Utilisateur> Users() {
        return null;
    }


}
