package com.example.petadopt.Services.Manager;

import com.example.petadopt.Dao.entities.Rendezvous;

import java.util.List;
import java.util.Optional;

public interface ManagerRendezvous {
    Optional<Rendezvous> createRendez_vous(Rendezvous Rv);
    List<Rendezvous> getAllRendezvous();
    Rendezvous getRendez_vousById(Long id);
    boolean deleteRendez_vous(Long id);

    List<Rendezvous> Rendezvouss();
}
