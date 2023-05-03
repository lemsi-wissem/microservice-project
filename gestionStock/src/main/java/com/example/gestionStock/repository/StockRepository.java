package com.example.gestionStock.repository;

import com.example.gestionStock.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock,Integer> {
}
