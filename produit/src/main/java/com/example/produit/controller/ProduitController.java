package com.example.produit.controller;

import com.example.produit.model.Produit;
import com.example.produit.service.ProduitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    ProduitServiceImpl produitService;

    @PostMapping("/save")
    public void saveProduit(@RequestBody Produit produit) {
        produitService.produitSave(produit);
    }
    @GetMapping("/find/{id}")
    public Produit findProduitById(@PathVariable int id) {
        return produitService.produitFindById(id);
    }

    @GetMapping("/findall")
    public Iterable<Produit> findAllProduit() {
        return produitService.produitFindAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduitById(@PathVariable int id) {
        produitService.produitDeleteById(id);
    }

    @PutMapping("/update")
    public void updateProduit(@RequestBody Produit produit) {
        produitService.produitSave(produit);
    }

}
