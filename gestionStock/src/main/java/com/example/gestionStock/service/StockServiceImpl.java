package com.example.gestionStock.service;

import com.example.gestionStock.model.Stock;
import com.example.gestionStock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{
    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock stockFindById(int id) {
        return stockRepository.findById(id).get();
    }

    @Override
    public List<Stock> stockFindAll() {
        return (List<Stock>) stockRepository.findAll();
    }

    @Override
    public void stockSave(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public void stockDeleteById(int id) {
        stockRepository.deleteById(id);
    }
}
