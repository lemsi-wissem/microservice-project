package com.example.gestionStock.controller;

import com.example.gestionStock.model.Stock;
import com.example.gestionStock.service.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockServiceImpl stockService;

    @PostMapping("/save")
    public String saveStock(@RequestBody Stock stock){
        stockService.stockSave(stock);
        return "Stock saved";
    }

    @GetMapping("/find/{id}")
    public Stock findStockById(@PathVariable int id){
        return stockService.stockFindById(id);
    }

    @GetMapping("/findall")
    public Iterable<Stock> findAllStock(){
        return stockService.stockFindAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStockById(@PathVariable int id){
        stockService.stockDeleteById(id);
        return "Stock deleted";
    }
}
