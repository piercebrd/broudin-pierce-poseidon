package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.TradeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trade")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("trades", tradeService.findAll());
        return "trade/list";
    }

    @GetMapping("/add")
    public String showAddForm(Trade trade) {
        return "trade/add";
    }

    @PostMapping("/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "trade/add";
        }
        tradeService.save(trade);
        return "redirect:/trade/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Trade trade = tradeService.findById(id);
        if (trade == null) {
            return "redirect:/trade/list";
        }
        model.addAttribute("trade", trade);
        return "trade/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid Trade trade, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "trade/update";
        }
        trade.setTradeId(id);
        tradeService.save(trade);
        return "redirect:/trade/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        tradeService.delete(id);
        return "redirect:/trade/list";
    }
}
