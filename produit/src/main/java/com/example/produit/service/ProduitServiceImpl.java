package com.example.produit.service;

import com.example.produit.model.Produit;
import com.example.produit.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    ProduitRepository produitRepository;
    @Override
    public Produit produitFindById(int id) {
        return produitRepository.findById(id).orElseThrow(()->new RuntimeException()) ;
    }

    @Override
    public List<Produit> produitFindAll() {
        return (List<Produit>) produitRepository.findAll();
    }

    @Override
    public void produitSave(Produit produit) {
        produitRepository.save(produit);
    }

    @Override
    public void produitDeleteById(int id) {
        produitRepository.deleteById(id);
    }
}
