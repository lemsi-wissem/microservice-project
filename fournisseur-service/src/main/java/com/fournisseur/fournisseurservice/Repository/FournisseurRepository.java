package com.fournisseur.fournisseurservice.Repository;

import com.fournisseur.fournisseurservice.Model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {
}
