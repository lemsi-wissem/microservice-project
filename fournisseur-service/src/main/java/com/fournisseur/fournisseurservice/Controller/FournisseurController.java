package com.fournisseur.fournisseurservice.Controller;

import com.fournisseur.fournisseurservice.Model.Fournisseur;
import com.fournisseur.fournisseurservice.Service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {

    @Autowired
    FournisseurService fournisseurService;

    @PostMapping("/add")
    public ResponseEntity<Fournisseur> saveFournisseur(@RequestBody Fournisseur fournisseur){
        return ResponseEntity.accepted().body(fournisseurService.save(fournisseur));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> findFournisseur(@PathVariable("id") int id){
        return ResponseEntity.accepted().body(fournisseurService.findById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Fournisseur>> findAllFournisseur(){
        return ResponseEntity.accepted().body(fournisseurService.findAll());
    }
    @DeleteMapping("/delete/{id}")
    public void deleteFournisseur(@PathVariable("id") int id){
        fournisseurService.deleteById(id);
    }
}
