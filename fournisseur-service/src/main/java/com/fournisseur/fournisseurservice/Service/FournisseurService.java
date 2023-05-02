package com.fournisseur.fournisseurservice.Service;

import com.fournisseur.fournisseurservice.Model.Fournisseur;
import com.fournisseur.fournisseurservice.Repository.FournisseurRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    public Fournisseur save(Fournisseur fournisseur){
        return fournisseurRepository.save(fournisseur);
    }
    public Fournisseur findById(int id){
        return fournisseurRepository.findById(id).orElseThrow(()->new NotFoundException());
    }
    public List<Fournisseur> findAll(){
        return fournisseurRepository.findAll();
    }
    public void deleteById(int id){
         fournisseurRepository.deleteById(id);
    }

}
