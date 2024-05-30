package com.example.petadopt.Services.Manager;
import  java.util.List;
import com.example.petadopt.Dao.entities.Address;


public interface ManagerAdresse{
   Address  createAdress(Address adress);
    List<Address> createAdresses(List<Address> addresses);

    List<Address> getAllAdresss();
    Address getAdresseById(Long Adress_id);

    boolean deleteAdress(Long id);
}
