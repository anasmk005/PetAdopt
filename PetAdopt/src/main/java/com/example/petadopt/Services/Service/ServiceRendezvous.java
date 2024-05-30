package com.example.petadopt.Services.Service;

import com.example.petadopt.Dao.entities.Rendezvous;
import com.example.petadopt.Dao.repositories.RendezvousRepo;
import com.example.petadopt.Services.Manager.ManagerRendezvous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class ServiceRendezvous implements ManagerRendezvous {
    @Autowired
    private RendezvousRepo rendezvousRepo;
    @Override
    public Optional<Rendezvous> createRendez_vous(Rendezvous Rv) {
        return null;
    }

    @Override
    public List<Rendezvous> getAllRendezvous() {
        return null;
    }

    @Override
    public Rendezvous getRendez_vousById(Long id) {
        return null;
    }

    @Override
    public boolean deleteRendez_vous(Long id) {
        return false;
    }

    @Override
    public List<Rendezvous> Rendezvouss() {
            return null;
    }
}
