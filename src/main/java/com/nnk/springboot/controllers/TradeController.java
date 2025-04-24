package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.TradeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @GetMapping
    public List<Trade> getAllTrades() {
        return tradeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trade> getTradeById(@PathVariable Integer id) {
        Trade trade = tradeService.findById(id);
        return trade != null ? ResponseEntity.ok(trade) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Trade> createTrade(@Valid @RequestBody Trade trade) {
        return ResponseEntity.ok(tradeService.save(trade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trade> updateTrade(@PathVariable Integer id, @Valid @RequestBody Trade trade) {
        trade.setId(id);
        return ResponseEntity.ok(tradeService.save(trade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrade(@PathVariable Integer id) {
        tradeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
