package com.example.produit.service;

import com.example.produit.model.Produit;

import java.util.List;

public interface ProduitService {
    public Produit produitFindById(int id);
    public List<Produit> produitFindAll();
    public void produitSave(Produit produit);

    void produitDeleteById(int id);
}
