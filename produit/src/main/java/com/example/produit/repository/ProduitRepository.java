package com.example.produit.repository;

import com.example.produit.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {
}
