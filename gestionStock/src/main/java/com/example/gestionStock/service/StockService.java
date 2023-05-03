package com.example.gestionStock.service;

import com.example.gestionStock.model.Stock;

import java.util.List;

public interface StockService {
    public Stock stockFindById(int id);
    public List<Stock> stockFindAll();
    public void stockSave(Stock stock);
    public void stockDeleteById(int id);
}
